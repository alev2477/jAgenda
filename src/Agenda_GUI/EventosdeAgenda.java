package Agenda_GUI;


/**
 * Clase observador donde se establece el eje central del patron
 * @author chenao
 *
 */
public class EventosdeAgenda extends GeneradorEventos{
	

	private String Tarea;
	public EventosdeAgenda(){
		
	}

        public void clickonTarea(String tarea){
        this.Tarea = tarea;
        setChanged();
        notifyObservers();
        }
        public String getTarea(){
        return Tarea;
        }

}
