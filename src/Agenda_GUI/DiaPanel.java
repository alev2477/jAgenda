/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Agenda_GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseEvent;
import javax.swing.BoxLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author alev2477
 */
public class DiaPanel extends JPanel {

    private JLabel daylabel;
    
     int HIGHT = 10,
                WIDTH = 10;

    public DiaPanel() {

        makeHMI();
    }

    private void setDia() {

    }

    private void makeHMI() {
       
        daylabel = new JLabel();
        setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
        /*Esto es para realizar prueba*/
//        daylabel.addMouseListener(new java.awt.event.MouseAdapter() {
//            @Override
//            public void mouseClicked(MouseEvent e) {
//              //  daylabel.setText("CLick");
//            }
//        });
        this.setBackground(Color.white);
        //this.setPreferredSize(new Dimension(HIGHT, WIDTH));
        //daylabel.setForeground(new java.awt.Color(255, 255, 255));
        daylabel.setForeground(Color.blue);
        this.add(daylabel);
    }

    public void resetdaylabel(){
       makeHMI();
    
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
    
    
}
