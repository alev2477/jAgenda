/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Calendario;

/**
 *
 * @author alev2477
 */
public class Cita {

    private Horario Hora;
    private String tarea;
    private String fecha;
    
    
    public Cita(){
        Hora = new Horario();
    
    }

    public void addtarea(String task, String time) {
        this.Hora.setHora(time);
        this.tarea= task;
        
    }
    public  String getHora(){
         
        return this.Hora.getHora();
    }
    
    public String getTarea(){
    
        return this.tarea;
    }
    
    public  void setFecha(String Fecha){
    fecha = Fecha;
    }
    public String getFecha(){
    return this.fecha;
    }
}
