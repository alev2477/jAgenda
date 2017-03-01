/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Agenda_GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * 
 * @author alev2477
 */
public class PaneldeControl extends JPanel implements ActionListener,DetectorEventosAgenda{
    private JButton jBoton_decrementarMes, jBoton_IncrementarMes;
    private JPanel panel_up, panel_down;
    private static JTextField jTextoMes, jTextoAnno;
   // private EventosdeAgenda Eventos;

    private EventosdeAgenda eventos;
    protected  static Agenda jagenda;

    /**
     * Get the value of eventos
     *
     * @return the value of eventos
     */
    public EventosdeAgenda getEventos() {
        return eventos;
    }

    /**
     * Set the value of eventos
     *
     * @param eventos new value of eventos
     */
    public void setEventos(EventosdeAgenda eventos) {
        this.eventos = eventos;
    }

    public void setAgenda(Agenda a){
        this.jagenda = a;
    }
 
    
    public PaneldeControl() {
        crearGUI();
 
   }
    public void enlazar(Agenda agenda){
    jagenda = agenda;
    jTextoMes.setText(jagenda.MostrarMesActual());
         jTextoAnno.setText(jagenda.MostrarAnnoActual());
    }
    
    public PaneldeControl(Agenda agenda){
    
        agenda.EscucharEventosDeAgenda(this);
        jagenda=agenda;
     
         jTextoMes.setText(jagenda.MostrarMesActual());
         jTextoAnno.setText(jagenda.MostrarAnnoActual());
    }
    
    private void crearGUI(){
        this.setPreferredSize(new Dimension(170,70));
        this.setBackground(Color.red);
        this.setLayout(new GridLayout(2,3));
        panel_up = new JPanel();
        panel_down = new JPanel();
        
        
        jTextoMes = new JTextField(7);
        jTextoAnno = new JTextField(7);
        jTextoMes.setEditable(false);
        jTextoAnno.setEditable(false);
        
        jBoton_IncrementarMes =  new JButton(">");
        jBoton_IncrementarMes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBotonIncMesActionPerformed(evt);
            }
        });
          
        jBoton_decrementarMes = new JButton("<");
   
        
        jBoton_decrementarMes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBotonDecMesActionPerformed(evt);
            }
        });
        panel_up.add(jTextoAnno);
        panel_down.add(jBoton_decrementarMes);
        panel_down.add(jTextoMes);
        panel_down.add(jBoton_IncrementarMes);
        this.add(panel_up);
        this.add(panel_down);
     
        this.setVisible(true);
    }
    
    public void jBotonIncMesActionPerformed(java.awt.event.ActionEvent evt){
        this.jagenda.IncrementarUnMes();
        this.jTextoMes.setText(PaneldeControl.jagenda.MostrarMesActual());
        this.jTextoAnno.setText(jagenda.MostrarAnnoActual());
        
    }
    
     public void jBotonDecMesActionPerformed(java.awt.event.ActionEvent evt){
         this.jagenda.decrementarUnMes();
          this.jTextoMes.setText(PaneldeControl.jagenda.MostrarMesActual());
        this.jTextoAnno.setText(jagenda.MostrarAnnoActual());
        
    }

   

    @Override
    public void EventoAgendaActuando(GeneradorEventos o, Object arg) {
        if(jagenda.get_EventoAgenda()==jagenda.ACTFECHA)
        {
               jTextoMes.setText(jagenda.MostrarMesActual());
               jTextoAnno.setText(jagenda.MostrarAnnoActual());
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
    }
    
    
    
}
