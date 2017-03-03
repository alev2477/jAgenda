
package Calendario;

/**
 *
 * @author alev2477
 */
public class Cita {

    private Horario Hora;
    private String tarea;
    private String fecha;
    private  long Id;
    
    
    public Cita(){
        Hora = new Horario();
    
    }

    public void agregar_strTarea(String task, String time) {
        this.Hora.asignar_strHora(time);
        this.tarea= task;
        
    }
    
    public void asignar_longId(final long Id){
        this.Id = Id;
    }
    
    public  String asignar_strHora(){
         
        return this.Hora.obtener_strHora();
    }
    
    public String obtener_strTarea(){
    
        return this.tarea;
    }
    
    public  void asignar_strFecha(String Fecha){
    fecha = Fecha;
    }
    public String obtener_strFecha(){
    return this.fecha;
    }
}
