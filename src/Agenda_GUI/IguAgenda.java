package Agenda_GUI;

import Calendario.Calendario;
import Calendario.Cita;
import Pruebas.NewJFrame;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author alev2477
 */
public class IguAgenda extends JPanel implements MouseListener {

    public NewJFrame creador;
    static private JPanel panelcalendario;
    public Calendario Agenda;
    private javax.swing.JLabel labelTareas;//no debe estar en esta clase debe estar en diapanel, se debe cosntruir todo el panel del dia.
    public String TareaSeleccionada;

    private final DiaPanel[] panelday = new DiaPanel[42];

    static int ALTO = 500, ANCHO = 500;

    private static final String[] diasdelasemana = new String[]{
        "dom",
        "lun",
        "mar",
        "mie",
        "jue",
        "vie",
        "sab"};

    /**
     * Metodo para iniciar la interfaz grafica desde un frame, recibe la
     * referencia del jFrame asociado a presentar el calendario
     *
     * @param refjFramebase
     */
    public void initIU(NewJFrame refjFramebase) {
        creador = refjFramebase;
    }

    public IguAgenda() {
        Agenda = new Calendario();

//        try {
//            Agenda.setCalendario("20/12/2016");
//        } catch (ParseException ex) {
//            Logger.getLogger(CalendarioGUI.class.getName()).log(Level.SEVERE, null, ex);
//        }
        Agenda.setCalendario();
        Agenda.printcalendar();
        this.crearGUI();
        panelcalendario.setPreferredSize(new Dimension(ALTO, ANCHO));

        /**
         * cuando la ventana cambie de tama;o en tiempo de dise;o para ajustar
         * el panel calendario adecuadamente
         */
//        addComponentListener(new java.awt.event.ComponentAdapter() {
//
//            @Override
//            public void componentResized(java.awt.event.ComponentEvent evt) {
//               
//                    ANCHO = getWidth();
//                    ALTO = getHeight();
//                    setSize(ANCHO, ALTO);
//                    System.out.println("Se cambia ALTURA" + Integer.toString(ALTO)
//                            + " " + "ANCHO " + Integer.toString(ANCHO));
//                    panelcalendario.setPreferredSize(new Dimension(ALTO, ANCHO));
//                    
//                
//            }
//        });
    }

    public void actualizarCalendarioGUI(String Fecha) {

        try {
            Agenda.setCalendario(Fecha);
        } catch (ParseException ex) {
            Logger.getLogger(IguAgenda.class.getName()).log(Level.SEVERE, null, ex);
        }
        Agenda.printcalendar();
        for (int i = 0; i <= Agenda.getdiaenmes(); i++) {

            if (i < 7) {
                panelday[i].setdaylabel(diasdelasemana[i] + "  "
                        + Integer.toString(Agenda.CalendarioMensual[i].getintdia()));
            } else {
                panelday[i].setdaylabel(Integer.toString(Agenda.CalendarioMensual[i].getintdia()));

            }
        }
        updateUI();
    }

    private void limpiar() {
        this.removeAll();
        //this.repaint();
    }

    /**
     * Metodo que determina la interfaz grafica
     */
    private void crearGUI() {
        /*
         Configuracion del Panel que contiene al calendario
         ***********************************************************/
        panelcalendario = new JPanel();
        if (Agenda.getdiaenmes() > 35) {
            panelcalendario.setLayout(new GridLayout(6, 7, 1, 1));
        } else {
            panelcalendario.setLayout(new GridLayout(5, 7, 1, 1));
        }
        panelcalendario.setSize(new Dimension(ANCHO, ALTO));
        panelcalendario.setBackground(Color.BLUE);
//***********************************************************************

        for (int i = 0; i <= Agenda.getdiaenmes(); i++) {

            panelday[i] = new DiaPanel();

            panelday[i].addMouseListener(this);

            /**
             * Para los primeros siete dias se asigna texto de diasdelasemana
             */
            if (i < 7) {
                panelday[i].setdaylabel(diasdelasemana[i] + "  "
                        + Integer.toString(Agenda.CalendarioMensual[i].getintdia()));
            } else {
                panelday[i].setdaylabel(Integer.toString(Agenda.CalendarioMensual[i].getintdia()));

            }
            panelcalendario.add(panelday[i]);

        }
        /*Agregal el panel al JPanel que sirve de marco*/
        this.add(panelcalendario);

    }

    public void MostrarTareasxDia(String Fecha) {
        final int indice = Agenda.buscarfecha(Fecha);//indice en matriz calendario
        ArrayList<Cita> Lista;

        if (indice > 0) {
            Lista = Agenda.ListaTareasxDia(Fecha);//lista de tareas para el dia
            // Lista = Agenda.CalendarioMensual[indice].getTareas();

            /**
             * Esto se debe hacer dentro de la clase panel
             *
             */
            for (final Cita Lista1 : Lista) {
                labelTareas = new javax.swing.JLabel();
                labelTareas.setFont(new Font(null, Font.LAYOUT_LEFT_TO_RIGHT, 10));
                labelTareas.setForeground(Color.red);
                labelTareas.setHorizontalAlignment(JLabel.LEFT);

                labelTareas.addMouseListener(new java.awt.event.MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        //labelTareas.setText(Lista1.getTarea());

                        System.out.print(Agenda.CalendarioMensual[indice].getFechaString() + " "
                                + Lista1.getTarea() + " " + Lista1.getHora() + "\n");
                        TareaSeleccionada = Agenda.CalendarioMensual[indice].getFechaString() + " "
                                + Lista1.getTarea() + " " + Lista1.getHora();
                        creador.mostrarcliking(TareaSeleccionada);
                    }
                });
                labelTareas.setText(Lista1.getHora() + " " + Lista1.getTarea());
                //labelTareas.setText( Lista1.getTarea());
                //panelday[indice].add(labelTareas, BorderLayout.LINE_END);
                panelday[indice].add(labelTareas);

                panelday[indice].updateUI();

                // System.out.print("\n");
                System.out.print(Agenda.CalendarioMensual[indice].getFechaString() + " "
                        + Lista1.getTarea() + " " + Lista1.getHora() + "\n");
            }
        }

    }

    /**
     * *****************Metodos de Eventos*******************************
     */
    /**
     *
     * @param e
     */
    @Override
    public void mouseClicked(MouseEvent e) {

        for (int i = 0; i <= Agenda.getdiaenmes(); i++) {

            if (e.getSource() == panelday[i]) {

                // panelday[i].setdaylabel("Press " + Integer.toString(i));
            }
            // if  (e.getSource() == 1)
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseExited(MouseEvent e) {
        // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
