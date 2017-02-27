package Agenda_GUI;

/**
 * Clase observador donde se establece el eje central del patron
 *
 * @author alev2477
 *
 */
public class EventosdeAgenda extends GeneradorEventos {

    private String Tarea;
    private int evento;

    public int getevento() {
        return evento;
    }

    public void setevento(int evento) {
        this.evento = evento;
    }
      public String getTarea() {
        return Tarea;
    }

    public void EventoClickonTarea(String tarea) {
        this.Tarea = tarea;
        setevento(1);
        setChanged();
        notifyObservers();
    }

  

    public void EventoClickenPanelDia(String tarea) {
        this.Tarea = tarea;
        setevento(2);
        setChanged();
        notifyObservers();
    }
    /**
     * Evento que sucede luego de decrementar un mes
     */
    public void EventoDecrementarMes(){
        
        setevento(3);
        setChanged();
        notifyObservers();
    }
     /**
     * Evento que sucede luego de incrementar un mes
     */
    public void EventoIncrementarMes(){
        
        setevento(4);
        setChanged();
        notifyObservers();
    }

    public void EventoActualizarFecha(){
        setevento(5);
        setChanged();
        notifyObservers();
    }
}
