package Agenda_GUI;

import Calendario.Calendario;
import Calendario.Cita;
import Calendario.UtilFuntions;
import com.sun.corba.se.spi.logging.CORBALogDomains;
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
import java.util.Observable;
import java.util.Observer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author alev2477 (Alejandro Villalobos)
 * @version 0.1
 * @since 2016
 * @email alev2477@gmail.com
 */
public class Agenda extends  JPanel implements Observer{

    public Object creador;
    static private JPanel panelcalendario;
    public Calendario CalendarioAgenda;
    private javax.swing.JLabel labelTareas;
   private String TareaSeleccionada;
    private final DiaPanel[] panelday = new DiaPanel[42];
    static int ALTO = 400, ANCHO = 750;
    protected Locale locale;
    protected final String[] diasdelasemana;
    protected ClaseObservador miObservador;
    protected Observer miObserver;

    /**
     * Constructor de Clase Agenda
     */
    public Agenda() {
        CalendarioAgenda = new Calendario();
        locale = Locale.getDefault();
        DateFormatSymbols dateFormatSymbols = new DateFormatSymbols(locale);
        diasdelasemana = dateFormatSymbols.
                getShortWeekdays();
        CalendarioAgenda.setCalendario();
        CalendarioAgenda.printcalendar();
        this.crearGUI();
        panelcalendario.setPreferredSize(new Dimension(ANCHO, ALTO));
//        addComponentListener(new java.awt.event.ComponentAdapter() {
//            @Override
//            public void componentResized(java.awt.event.ComponentEvent evt) {
//                    ANCHO = getWidth();
//                    ALTO = getHeight();
//                    setSize(ANCHO, ALTO);
//                    System.out.println("Se cambia ALTURA" + Integer.toString(ALTO)
//                            + " " + "ANCHO " + Integer.toString(ANCHO));
//                    panelcalendario.setPreferredSize(new Dimension(ALTO, ANCHO));
//            }
//        });
    }
    
    public void addSujetoAgenda(ClaseObservador arg){
    miObservador= arg;
    }
    
    public void Init(Observer arg){
    miObserver = arg;
    miObservador = new ClaseObservador();
    miObservador.addObserver(miObserver);
    }
    
  /**
     * Metodo para iniciar la interfaz grafica desde un frame, recibe la
     * referencia del jFrame asociado a presentar el calendario
     *
     * @param refjFramebase
     */
    public void initIU(Object refjFramebase) {
        creador = refjFramebase;
    }
    /**
     * Actualiza el Calendario actual segun una fecha determinada
     *
     * @param Fecha
     */
    public void actualizarCalendario(String Fecha) {
        
        ocultarTareasxmes(null);
        try {
            CalendarioAgenda.setCalendario(Fecha);
        } catch (ParseException ex) {
            Logger.getLogger(Agenda.class.getName()).
                    log(Level.SEVERE, null, ex);
        }
        
        
        for (int i = 0; i <= CalendarioAgenda.getdiaenmes(); i++) {
            if (i < 7) {
                panelday[i].setdaylabel(diasdelasemana[i + 1] + "  "
                        + Integer.toString(CalendarioAgenda.cMensual[i].
                                getintdia()));
            } else {
                panelday[i].setdaylabel(Integer.
                        toString(CalendarioAgenda.cMensual[i].getintdia()));
            }
        }
        updateUI();
    }

    private void limpiar() {
        this.removeAll();
    }

    /**
     * Metodo que determina la interfaz grafica el panel calendario
     */
    private void crearGUI() {
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
                panelday[i].setdaylabel(diasdelasemana[i + 1] + "  "
                        + Integer.toString(CalendarioAgenda.cMensual[i].
                                getintdia()));
            } else {
                panelday[i].setdaylabel(Integer.
                        toString(CalendarioAgenda.cMensual[i].getintdia()));
            }
            panelcalendario.add(panelday[i]);
        }
        /*Agregal el panel al JPanel que sirve de marco*/
        this.add(panelcalendario);
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

    public String getTareaString(){
    return TareaSeleccionada;
    }
    /**
     * Muestra las tareas programadas en esa fecha, para cada tarea asigna una
     * etiqueta y la agrega al panel del dia.
     *
     * @param Fecha
     */
    public void MostrarTareasxDia(String Fecha) {
        final int indice = CalendarioAgenda.buscarfecha(Fecha);
        ArrayList<Cita> Lista;
        if (indice > 0) {
            Lista = CalendarioAgenda.ListaTareasxDia(Fecha);
            for (final Cita Lista1 : Lista) {
                labelTareas = new javax.swing.JLabel();
                labelTareas.addMouseListener(new java.awt.event.MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                    TareaSeleccionada = CalendarioAgenda.cMensual[indice].getFechaString() + " "
                        + Lista1.getTarea() + " " + Lista1.getHora();
                    miObservador.clickonTarea(TareaSeleccionada);
                    }
                });
                
                labelTareas.setFont(new Font(null,
                        Font.LAYOUT_LEFT_TO_RIGHT, 10));
                labelTareas.setForeground(Color.red);
                labelTareas.setHorizontalAlignment(JLabel.LEFT);
                TareaSeleccionada =Lista1.getHora() + " " + Lista1.getTarea();
                labelTareas.setText(TareaSeleccionada);
                panelday[indice].add(labelTareas);
                panelday[indice].updateUI();
                System.out.print(CalendarioAgenda.cMensual[indice].getFechaString() + " "
                        + Lista1.getTarea() + " " + Lista1.getHora() + "\n");
            }
        }
    }

    /**
     * ocultarTareasxmes, quita todas las tareas del calendario
     *
     * @param Fecha
     */
    public void ocultarTareasxmes(String Fecha) {
        int count = 0;
        for (int indice = 0; indice <= CalendarioAgenda.getdiaenmes();
                indice++) {
            count = panelday[indice].getComponentCount();
            if (count > 1) {
                panelday[indice].removeAll();
                panelday[indice].resetdaylabel();
                if (indice < 7) {
                    panelday[indice].setdaylabel(diasdelasemana[indice + 1]
                            + "  " + Integer.
                            toString(CalendarioAgenda.cMensual[indice].
                                    getintdia()));
                } else {
                    panelday[indice].setdaylabel(Integer.
                            toString(CalendarioAgenda.cMensual[indice].
                                    getintdia()));
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
        if (indice > 0) {
            int count = panelday[indice].getComponentCount();
            if (count > 1) {
                panelday[indice].removeAll();
                panelday[indice].resetdaylabel();
                if (indice < 7) {
                    panelday[indice].setdaylabel(diasdelasemana[indice + 1] + "  "
                            + Integer.toString(CalendarioAgenda.cMensual[indice].
                                    getintdia()));
                } else {
                    panelday[indice].setdaylabel(Integer.
                            toString(CalendarioAgenda.cMensual[indice].
                                    getintdia()));
                }
                panelday[indice].repaint();
            }
        }
    }

    
    
    public void incrementarUnMes(){
     
        
        Date fecha = CalendarioAgenda.getMesSiguiente();
        CalendarioAgenda.setCalendario(fecha);
        actualizarCalendario(UtilFuntions.Convertostring(fecha));
        
    }
    
    public void decrementarUnMes(){
     
        
        Date fecha = CalendarioAgenda.getMesAnterior();
        CalendarioAgenda.setCalendario(fecha);
        actualizarCalendario(UtilFuntions.Convertostring(fecha));
        
    }
    
    
    @Override
    public void update(Observable o, Object arg) {
        System.out.print("Bueno aquivamos ");
    }
    
  
    
    
}

 
