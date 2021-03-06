
package Pruebas;
import Agenda_GUI.GeneradorEventos;
import Agenda_GUI.DetectorEventosAgenda;
import Calendario.Cita;
import java.util.ArrayList;




/**
 *
 * @author alev2477
 */
public class Prueba2 extends javax.swing.JFrame implements DetectorEventosAgenda {
    private ArrayList<Cita> ListadodeTareas;
    
  
    /**
     * Creates new form Prueba1
     */
    public Prueba2() {
        
        
        initComponents();
        
        
     
        paneldeControl1.enlazar(agenda1);
        agenda1.EscucharEventosDeAgenda(this);
        
    }
    
    /**
     * ListarTareas armar una lista de objetos cita, para pasarlos a agenda
     * Esos objetos pueden estar ordenados o no.
     * de entrada no tiene nada, porque este metodo es solo para pruebas
     * 
     * @return una lista de tipo cita
     * 
     */
    
    public ArrayList<Cita> ListarTareas(){
        ListadodeTareas = new ArrayList<>();
        for(int j=0;j<10;j++){
            for (int i= 1; i<32;i++){
                Cita cita = new Cita();
                if(i < 10) cita.asignar_strFecha("0"+String.valueOf(i)+"/0"+ String.valueOf(j)+"/2017");
                else
                    cita.asignar_strFecha(String.valueOf(i)+"/0"+ String.valueOf(j)+"/2017");
                cita.agregar_strTarea("Comer", "12:00");
                ListadodeTareas.add(cita);
            }
        }
        return ListadodeTareas;
    
    
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTexto1 = new javax.swing.JTextField();
        jBoton1 = new javax.swing.JButton();
        jBoton2 = new javax.swing.JButton();
        agenda1 = new Agenda_GUI.Agenda();
        jBoton3 = new javax.swing.JButton();
        jTexto2 = new javax.swing.JTextField();
        jTexto3 = new javax.swing.JTextField();
        jTexto4 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        paneldeControl1 = new Agenda_GUI.PaneldeControl();
        jScrollPane1 = new javax.swing.JScrollPane();
        jRegistrodeEventos = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        BotonLimpiarAgenda = new javax.swing.JButton();
        BotonLimpiarDia = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jBoton1.setText("Agregar tarea");
        jBoton1.setToolTipText("");
        jBoton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBoton1ActionPerformed(evt);
            }
        });

        jBoton2.setText("Mostrar tarea x dia");
        jBoton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBoton2ActionPerformed(evt);
            }
        });

        jBoton3.setText("Ocultar Tarea");
        jBoton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBoton3ActionPerformed(evt);
            }
        });

        jTexto3.setText("Comer");

        jTexto4.setText("12:00");
        jTexto4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTexto4ActionPerformed(evt);
            }
        });

        jLabel1.setText("Fecha Seleccionada");

        jLabel2.setText("Tarea");

        jLabel3.setText("Hora");

        jRegistrodeEventos.setColumns(20);
        jRegistrodeEventos.setRows(5);
        jScrollPane1.setViewportView(jRegistrodeEventos);

        jButton1.setText("Simular creacion tareas");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("agregar lista a la agenda");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Mostrar tarea mes");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        BotonLimpiarAgenda.setText("Limpiar Agenda");
        BotonLimpiarAgenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonLimpiarAgendaActionPerformed(evt);
            }
        });

        BotonLimpiarDia.setText("Limpiar Dia");
        BotonLimpiarDia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonLimpiarDiaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton2))
                        .addGap(60, 60, 60)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel2)
                                .addGap(76, 76, 76)
                                .addComponent(jLabel3))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jTexto1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jTexto3, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jTexto4, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jBoton1))
                                    .addComponent(jTexto2, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(74, 74, 74)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(agenda1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jBoton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jBoton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(BotonLimpiarDia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(BotonLimpiarAgenda, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(286, 286, 286)
                        .addComponent(paneldeControl1, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(378, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton2)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jTexto1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jTexto3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jTexto4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jBoton1)))
                        .addGap(18, 18, 18)
                        .addComponent(jTexto2, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(77, 77, 77)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jBoton2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jBoton3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(BotonLimpiarDia)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(BotonLimpiarAgenda))
                            .addComponent(agenda1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(paneldeControl1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(24, 24, 24))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBoton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBoton1ActionPerformed
        agenda1.HacerCita(jTexto1.getText(), jTexto3.getText(),jTexto4.getText());
        agenda1.MostrarTareasxDia(jTexto1.getText());
    }//GEN-LAST:event_jBoton1ActionPerformed

    private void jBoton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBoton2ActionPerformed
        agenda1.MostrarTareasxDia(jTexto1.getText());
    }//GEN-LAST:event_jBoton2ActionPerformed

    private void jBoton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBoton3ActionPerformed
        agenda1.ocultarTareasxDia(jTexto1.getText());
        
       
    }//GEN-LAST:event_jBoton3ActionPerformed

    private void jTexto4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTexto4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTexto4ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       ListarTareas();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        agenda1.aceptarListadeTareas(ListadodeTareas);
        agenda1.leer_lista_meses();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        
    }//GEN-LAST:event_jButton3ActionPerformed

    private void BotonLimpiarAgendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonLimpiarAgendaActionPerformed
         agenda1.Limpiar_Agenda();
    }//GEN-LAST:event_BotonLimpiarAgendaActionPerformed

    private void BotonLimpiarDiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonLimpiarDiaActionPerformed
        agenda1.Limpiar_Dia();
    }//GEN-LAST:event_BotonLimpiarDiaActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
          //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Prueba2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Prueba2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Prueba2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Prueba2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Prueba2().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BotonLimpiarAgenda;
    private javax.swing.JButton BotonLimpiarDia;
    private Agenda_GUI.Agenda agenda1;
    private javax.swing.JButton jBoton1;
    private javax.swing.JButton jBoton2;
    private javax.swing.JButton jBoton3;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextArea jRegistrodeEventos;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTexto1;
    private javax.swing.JTextField jTexto2;
    private javax.swing.JTextField jTexto3;
    private javax.swing.JTextField jTexto4;
    private Agenda_GUI.PaneldeControl paneldeControl1;
    // End of variables declaration//GEN-END:variables

  
    @Override
    public void EventoAgendaActuando(GeneradorEventos o, Object arg) {
        if (agenda1.get_EventoAgenda() == agenda1.ClICKPANEL) {
            jTexto1.setText(agenda1.obtener_strFechaSeleccionada());
        }
        if (agenda1.get_EventoAgenda() == agenda1.CLICKTAREA) {
            jTexto2.setText(agenda1.obtener_strTarea());
            jTexto1.setText(agenda1.obtener_strFechaSeleccionada());
        }
        if (agenda1.get_EventoAgenda() == agenda1.ACTFECHA)
            System.out.println("agenda -> actualizando");
        if (agenda1.get_EventoAgenda() == agenda1.DECMES)
            System.out.println("agenda -> Boton Decrementar mes");
        if (agenda1.get_EventoAgenda() == agenda1.INCMES)
            System.out.println("agenda -> Boton Incrementar mes");
        
        

    }

}
