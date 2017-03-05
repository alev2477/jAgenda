package Agenda_GUI;

import java.awt.Color;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author alev2477
 */
public class DiaPanel extends JPanel {

    private JLabel EtiquetaTareaDia;
    private int IndiceTareaSeleccionada;
    private JLabel EtiquetaSeleccionada;

    int HIGHT = 10, WIDTH = 10;
    public final int HOY = 1;
    public final int SELECCIONADO = 2;
    public final int NORMAL = 0;
    public final int HOYSELECCIONADO = 3;
     public final Color COLORBACKGROUND = Color.WHITE;

    public DiaPanel() {

        crear_IGU();
    }

    public int obtener_IndiceTareaSeleccionada(){
    return IndiceTareaSeleccionada;
    }
    
    public void asignar_IndiceTareaSeleccionada(int indice){
        IndiceTareaSeleccionada =  indice;
    }

    private void crear_IGU() {
       
        EtiquetaTareaDia = new JLabel();
        setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
  
        this.setBackground(COLORBACKGROUND);
        //this.setPreferredSize(new Dimension(HIGHT, WIDTH));
        EtiquetaTareaDia.setForeground(new java.awt.Color(255, 255, 255));
        EtiquetaTareaDia.setForeground(Color.blue);
        this.add(EtiquetaTareaDia);
    }
    
    public JLabel obtener_jlabelEtiquetaTareaDia(){
    return EtiquetaTareaDia;
    }
    
    public JLabel obtener_EtiquetaSeleccionada(){
        return EtiquetaSeleccionada;
    }
    public void asignar_EtiquetaSeleccionada(JLabel etiqueta){
        EtiquetaSeleccionada = etiqueta;
    }

    public void resetdaylabel(){
       crear_IGU();
    
    }
    public void setdaylabel(String day) {
        EtiquetaTareaDia.setText(day);
    }

    public String getdaylabel() {
        return EtiquetaTareaDia.getText();
    }
    
    public DiaPanel getPanelDiaobj(){
    return this;
    }
    
    public void asignar_ColorPanel(int conf){
        if (conf == HOYSELECCIONADO) {
            setBackground(Color.PINK);
        } else {
            if (conf == HOY) {
                setBackground(Color.yellow);
            } else {
                if (conf == SELECCIONADO) {
                    setBackground(Color.lightGray);
                    //setBackground(COLORBACKGROUND);
                    
                } else {
                    if (conf == NORMAL) {
                        setBackground(Color.white);
                    }
                }
            }
        }

    }
    public void actualizar_PanelDia(){
        
    }

    void asignar_EtiquetaTareaDia(JLabel labelTareas) {
        this.EtiquetaTareaDia = labelTareas;
    }
    
    
}
