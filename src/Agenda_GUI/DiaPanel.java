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

    private JLabel daylabel;
    
     int HIGHT = 10,WIDTH = 10;
     public final int HOY = 1;
     public final int SELECCIONADO = 2;
    public final int NORMAL = 0;

    public DiaPanel() {

        crear_IGU();
    }

    

    private void crear_IGU() {
       
        daylabel = new JLabel();
        setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
  
        this.setBackground(Color.white);
        //this.setPreferredSize(new Dimension(HIGHT, WIDTH));
        daylabel.setForeground(new java.awt.Color(255, 255, 255));
        daylabel.setForeground(Color.blue);
        this.add(daylabel);
    }

    public void resetdaylabel(){
       crear_IGU();
    
    }
    public void setdaylabel(String day) {
        daylabel.setText(day);
    }

    public String getdaylabel() {
        return daylabel.getText();
    }
    
    public DiaPanel getPanelDiaobj(){
    return this;
    }
    
    public void asignar_ColorPanel(int conf){
        if (conf == HOY)
            setBackground(Color.yellow);
        else 
            if(conf == SELECCIONADO)
                setBackground(Color.gray);
            else 
                if(conf == NORMAL)
                        setBackground(Color.white);
                    
    
    }
    public void actualizar_PanelDia(){
        
    }
    
    
}
