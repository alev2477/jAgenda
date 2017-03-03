package Agenda_GUI;

import Calendario.Calendario;
import Calendario.Cita;
import Calendario.UtilFuntions;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.text.DateFormatSymbols;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/**
 *
 * @author alev2477 (Alejandro Villalobos)
 * @version 0.1
 * @since 2016
 * email alev2477@gmail.com
 */
public class Agenda extends JPanel {
    private static final long serialVersionUID = 1L;
    static private JPanel panelcalendario;
    private int dia_seleccionado;
    private int dia_seleccionadoPrevio;
    private String FechaSeleccionada;
    /**
     *Calendario de la Agenda, procesa y devuelve el mes en formato calendario
     */
    public static Calendario CalendarioAgenda;
    private javax.swing.JLabel labelTareas;
    private String TareaSeleccionada;
    private final DiaPanel[] panelday = new DiaPanel[42];
    static int ALTO = 400, ANCHO = 750;

    /**
     *
     */
    protected Locale locale;

    /**
     *
     */
    protected final String[] diasdelasemana;

    /**
     *
     */
    protected final String[] mesesdelanno;

    /**
     *
     */
    protected EventosdeAgenda miObservado;

    /**
     *
     */
    protected DetectorEventosAgenda miObserver;

    /**
     *
     */
    public JScrollPane scroll;

    /**
     *
     */
    public final int CLICKTAREA = 1;

    /**
     *
     */
    public final int ClICKPANEL = 2;

    /**
     *
     */
    public final int DECMES    = 3;

    /**
     *
     */
    public final int INCMES      = 4;

    /**
     *
     */
    public final int ACTFECHA   = 5;
    
    private ArrayList<Cita> ListadodeTareas; 
    private ArrayList<ArrayList<Cita>> ListadoMeses;
    private ArrayList<Cita> ListadeTareas_x_Mes;
    
    /**
     * Metodo constructor de clase Agenda
     * Instancia el calendario con el cual se obtendrá las matrices de los dia del 
     * mes que se esté trabajando
     * Crea la interfaz grafica
     */
    public Agenda() {
        dia_seleccionado = -1;
        dia_seleccionadoPrevio =-1 ;
        FechaSeleccionada = "";
        CalendarioAgenda = new Calendario();
        locale = Locale.getDefault();
        DateFormatSymbols dateFormatSymbols = new DateFormatSymbols(locale);
        diasdelasemana = dateFormatSymbols.getShortWeekdays();
        mesesdelanno = dateFormatSymbols.getMonths();
        CalendarioAgenda.setCalendario();
        crear_IGU();
        panelcalendario.setPreferredSize(new Dimension(ANCHO, ALTO));
        ListadodeTareas =  new ArrayList<Cita>();
        ListadoMeses = new ArrayList<ArrayList <Cita>>();
        ListadeTareas_x_Mes = new ArrayList<Cita>();
    }
    private void iniciar_lista_meses(){
    	Cita nuevacita = new Cita();
    	nuevacita.agregar_strTarea("Correr", "12:00");
    	nuevacita.asignar_strFecha("12/03/2017");
    	
    	ListadeTareas_x_Mes.add(nuevacita);
    	ListadoMeses.add(ListadeTareas_x_Mes);
    	
    	nuevacita.agregar_strTarea("saltar", "15:00");
    	nuevacita.asignar_strFecha("12/03/2017");
    	ListadeTareas_x_Mes.add(nuevacita);
    	
    	nuevacita.agregar_strTarea("Comer", "12:00");
    	nuevacita.asignar_strFecha("13/03/2017");
    	ListadeTareas_x_Mes.add(nuevacita);
    	ListadoMeses.add(ListadeTareas_x_Mes);
    	
    	
    }
    
    public void leer_lista_meses(){
    	iniciar_lista_meses();
    	int indice=0;
    	int i = 0;
    	for(ArrayList<Cita> listatareas : ListadoMeses){
    		System.out.println("mes: " + Integer.toString(indice)+"\n");
    		for(Cita tareas : ListadeTareas_x_Mes){
    			System.out.println(tareas.obtener_strFecha()+ " " + tareas.obtener_strTarea());
    		}indice++;
    		
    	}
    	
    }
    
    private int obtener_intDiaSeleccionado(){
    return dia_seleccionado;
    }
    public String obtener_strFechaSeleccionada(){
    return FechaSeleccionada;
    }

    /**
     * public int get_EventoAgenda()
     *      Método get para obtener el evento que ha sucedido en agenda
     * @return EventosdeAgenda
     */
    public int get_EventoAgenda() {
        return miObservado.getevento();
    }


    /**
     * public void EscucharEventosDeAgenda()
     * Método que agrega al observador en listado de observadores de los 
     * eventos de agenda.
     * Recibe DetectorEventosAgenda arg: Interfaz que implementa el metodo para
     * procesar los eventos de agenda.
     * @param  arg
     **/
    public void EscucharEventosDeAgenda(DetectorEventosAgenda arg) {
        miObserver = arg;
         if (miObservado == null)
             miObservado = new EventosdeAgenda();
        miObservado.addObserver(miObserver);
    }


    /**
     * Actualiza el Calendario actual segun una fecha determinada
     *
     * @param Fecha
     */
    public void actualizarCalendario(String Fecha) {
        ocultarTareasxmes();
        try {
            CalendarioAgenda.setCalendario(Fecha);
        } catch (ParseException ex) {
            Logger.getLogger(Agenda.class.getName()).log(Level.SEVERE, null, ex);
        }
        for (int i = 0; i <= CalendarioAgenda.getdiaenmes(); i++) {
            if (i < 7) {
                panelday[i].setdaylabel(diasdelasemana[i + 1] + "  "+ Integer.toString(CalendarioAgenda.get_DiaenCalMensual(i)));
            } else {
                panelday[i].setdaylabel(Integer.toString(CalendarioAgenda.get_DiaenCalMensual(i)));
            }
        }
        updateUI();
    }

    /**
     * Metodo que determina la interfaz grafica el panel calendario
     */
    private void crear_IGU() {
        panelcalendario = new JPanel();
        if (CalendarioAgenda.getdiaenmes() > 35) {
            panelcalendario.setLayout(new GridLayout(6, 7, 1, 1));
        } else {
            panelcalendario.setLayout(new GridLayout(5, 7, 1, 1));
        }
        panelcalendario.setSize(new Dimension(ANCHO, ALTO));
        panelcalendario.setBackground(Color.BLUE);
        for (int i = 0; i <= CalendarioAgenda.getdiaenmes(); i++) {
            panelday[i] = new DiaPanel();
            if (i < 7) {
                panelday[i].setdaylabel(diasdelasemana[i + 1] + "  "+ Integer.toString(CalendarioAgenda.get_DiaenCalMensual(i)));
                
            } 
            else {
                panelday[i].setdaylabel(Integer.toString(CalendarioAgenda.get_DiaenCalMensual(i)));
            }
//            if(i == CalendarioAgenda.obtener_intIndiceHoy())
//                    panelday[i].asignar_ColorPanel(panelday[i].HOY);
            resaltar_Dia(i);
            panelday[i].addMouseListener(new java.awt.event.MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    for (int i = 0; i <= CalendarioAgenda.getdiaenmes(); i++) {
                        if (e.getSource() == panelday[i]) {
                            FechaSeleccionada = CalendarioAgenda.get_FechaenCalMensual(i);
                            miObservado.EventoClickenPanelDia(FechaSeleccionada);
                            dia_seleccionado = i;
                            resaltar_Dia(i);
                        }
                    }
                }
            });
            scroll = new JScrollPane(panelday[i]);
            scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
            panelcalendario.add(scroll);
        }
        this.add(panelcalendario);
    }

    public void resaltar_Dia(int indice) {
        
            if(dia_seleccionadoPrevio != -1)
                panelday[dia_seleccionadoPrevio].asignar_ColorPanel(panelday[dia_seleccionadoPrevio].NORMAL);
            if (indice == CalendarioAgenda.obtener_intIndiceHoy()) {
                panelday[indice].asignar_ColorPanel(panelday[indice].HOY);
            } else if (indice == dia_seleccionado) {
                panelday[indice].asignar_ColorPanel(panelday[indice].SELECCIONADO);
                dia_seleccionadoPrevio = indice;
            } 
            
        
    }
    
    /**
     * Retorna referencia al panelcalendario
     *
     * @return
     */
    public JPanel getPanelCalendario() {
        return (JPanel) panelcalendario;
    }

    /**
     * Retorna referencia del paneldia
     *
     * @return
     */
    public DiaPanel[] getPaneldia() {
        return panelday;
    }

    /**
     *
     * @return
     */
    public String obtener_strTarea() {
        return TareaSeleccionada;
    }


    /**
     * MostrarMesActual()
     *
     * @return Mes actual del calendario
     */
    public String MostrarMesActual(){
       return  mesesdelanno[CalendarioAgenda.getMesActual()];
    }

    /**
     * MostrarAnnoActual()
     *
     * @return CalendarioAgenda.getAnnoActual()
     */
    public String MostrarAnnoActual(){
        return String.valueOf(CalendarioAgenda.getAnnoActual());
    }
 
    /**
     * Muestra las tareas programadas en esa fecha, para cada tarea asigna una
     * etiqueta y la agrega al panel del dia.
     *
     * @param Fecha
     */
    public void MostrarTareasxDia(String Fecha) {
        final int indice = CalendarioAgenda.buscarfecha(Fecha);
        ocultarTareasxDia(Fecha);
        ArrayList<Cita> Lista;
        if (indice >= 0) {
            Lista = CalendarioAgenda.ListaTareasxDia(Fecha);
            for (final Cita Lista1 : Lista) {
                labelTareas = new javax.swing.JLabel();
                resaltar_Dia(indice);
                labelTareas.addMouseListener(new java.awt.event.MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        TareaSeleccionada = CalendarioAgenda.get_FechaenCalMensual(indice) + " "
                                + Lista1.obtener_strTarea() + " " + Lista1.asignar_strHora();
                        FechaSeleccionada = CalendarioAgenda.get_FechaenCalMensual(indice);
                        miObservado.EventoClickonTarea(TareaSeleccionada);
                        dia_seleccionado = indice;
                        resaltar_Dia(indice);
                    }
                });
                labelTareas.setFont(new Font(null,Font.LAYOUT_LEFT_TO_RIGHT, 10));
                labelTareas.setForeground(Color.green);
                labelTareas.setHorizontalAlignment(JLabel.LEFT);
                TareaSeleccionada = Lista1.asignar_strHora() + " " + Lista1.obtener_strTarea();
                labelTareas.setText(TareaSeleccionada);
                panelday[indice].add(labelTareas);
                panelday[indice].updateUI();
            }
        }
    }

/**
 * 
 */
    public void Limpiar_Agenda(){
    	
    	ocultarTareasxmes();
    	LimpiarTareasCalendario();
    	ListadeTareas_x_Mes.clear();
    	ListadodeTareas.clear();
    	ListadoMeses.clear();
    }
   
    /*
     * Para limpiar el dia, se debe determinar que dia esta seleccionado
     */
    public void Limpiar_Dia(){
        if(dia_seleccionado >= 0){
            ocultarTareasxDia(FechaSeleccionada);
            LimpiarTareasPorDia(dia_seleccionado);
            
        }
    }
    
    private void LimpiarTareasPorDia(int indice){
        CalendarioAgenda.limpiarListasTareasCalendarioPorDia(indice);
    }
    private void LimpiarTareasCalendario(){
    	CalendarioAgenda.limpiarListasTareasCalendario();
    }

    /**
     * ocultarTareasxmes, quita todas las tareas del calendario
     *
     *
     */
    public void ocultarTareasxmes() {
        int count = 0;
        for (int indice = 0; indice <= CalendarioAgenda.getdiaenmes();indice++) {
            count = panelday[indice].getComponentCount();
            if (count > 1) {
                panelday[indice].removeAll();
                panelday[indice].resetdaylabel();
                if (indice < 7) {
                    panelday[indice].setdaylabel(diasdelasemana[indice + 1]
                            + "  " + Integer.
                            toString(CalendarioAgenda.get_DiaenCalMensual(indice)));
                } else {
                    panelday[indice].setdaylabel(Integer.
                            toString(CalendarioAgenda.get_DiaenCalMensual(indice)));
                }
                panelday[indice].repaint();
            }
        }
    }

    /**
     * Oculta tareas por dia, busca el indice en el calendario. ubica el dia,
     * revisa si tiene tareas, si tiene elimina las etiquetas a partir del
     * segundo elemento, ya que el primero es la etiqueta que muestra el dia o
     * el nombre del dia
     *
     * @param Fecha
     */
    public void ocultarTareasxDia(String Fecha) {
        final int indice = CalendarioAgenda.buscarfecha(Fecha);
        if (indice >=0) {
            int count = panelday[indice].getComponentCount();
            if (count > 1) {
                panelday[indice].removeAll();
                panelday[indice].resetdaylabel();
                if (indice < 7) {
                    panelday[indice].setdaylabel(diasdelasemana[indice + 1] + "  "+ Integer.toString(CalendarioAgenda.get_DiaenCalMensual(indice)));
                } else {
                    panelday[indice].setdaylabel(Integer.toString(CalendarioAgenda.get_DiaenCalMensual(indice)));
                }
                panelday[indice].repaint();
                resaltar_Dia(indice);
            }
        }
    }

    /**
     *IncrementarUnMes actualiza la fecha con el mes siguiente
     * actualiza el calendario con el nuevo mes
     * Dispara evento de agenda para incrementar mes
     */
    public void IncrementarUnMes() {
        Date fecha = CalendarioAgenda.getMesSiguiente();
        actualizarCalendario(fecha);
        miObservado.EventoIncrementarMes();
    }

    /**
     * DecrementarUnMes actualiza la fecha con el mes anterior
     * actualiza el calendario con el nuevo mes
     * Dispara evento de agenda para Decrementar mes
     */
    public void decrementarUnMes() {
        Date fecha = CalendarioAgenda.getMesAnterior();
        actualizarCalendario(fecha);
        miObservado.EventoDecrementarMes();
    }
    
    /**
     *
     * @param fecha
     */
    public void actualizarCalendario(Date fecha){
        CalendarioAgenda.setCalendario(fecha);
        actualizarCalendario(UtilFuntions.Convertostring(fecha));
        miObservado.EventoActualizarFecha();
    }

    /**
     *
     * @param fecha
     * @param tarea
     * @param hora
     */
    public void HacerCita(String fecha, String tarea, String hora){
        CalendarioAgenda.Hacercita(fecha, tarea, hora);
    
    }

    /**
     *
     * @param ListadodeTareas
     */
    public void aceptarListadeTareas(ArrayList<Cita> ListadodeTareas) {
        this.ListadodeTareas = ListadodeTareas;
        asignarCitas();
    }
    
    private void asignarCitas()
    {
        for (Cita cita : ListadodeTareas){
            HacerCita(cita.obtener_strFecha(), cita.obtener_strTarea(), cita.asignar_strHora());
            MostrarTareasxDia(cita.obtener_strFecha());
        }
    }
    
    
    
    
}
