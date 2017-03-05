package Agenda_GUI;

import java.awt.Color;
import javax.swing.BorderFactory;
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

    public final int DOMINGONORMAL = 4;
    public int DOMINGOSELECCIONADO = 5;


     
     
     /*Dia panel debe tener una lista mas eficiente que contenga las tareas y las
     etiquetas asociadas al esas tareas
     
     */
     
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
            //setBackground(Color.PINK);
            setBackground(new Color(17,191,234));
             setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(
                             Color.red, 3), BorderFactory.createBevelBorder(1, Color.green, Color.BLUE)));
        } else {
            if (conf == HOY) {
                setBackground(new Color(17,191,234));
                setBorder(BorderFactory.createEmptyBorder());
            } else {
                if (conf == SELECCIONADO) {

                    //setBackground(Color.lightGray);
                    setBackground(COLORBACKGROUND);
                   // setBorder(BorderFactory.createMatteBorder(5,5,5,5,Color.red));
                    //setBorder(BorderFactory.createBevelBorder(1, Color.red, Color.DARK_GRAY));
                     setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(
                             Color.red, 3), BorderFactory.createBevelBorder(1, Color.green, Color.BLUE)));

                    
                } else {
                    if (conf == NORMAL) {
                        
                        setBackground(Color.white);
                        setBorder(BorderFactory.createEmptyBorder());
                       
                    }else
                        if (conf == DOMINGONORMAL){
                            setBackground(Color.lightGray);
                        setBorder(BorderFactory.createEmptyBorder());}
                        else 
                        if(conf == DOMINGOSELECCIONADO){
                            setBackground(Color.lightGray);
                            setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(
                             Color.red, 3), BorderFactory.createBevelBorder(1, Color.green, Color.BLUE)));
                            
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
