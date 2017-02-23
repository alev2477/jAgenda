package Agenda_GUI;


/**
 * Clase observador donde se establece el eje central del patron
 * @author chenao
 *
 */
public class EventosdeAgenda extends GeneradorEventos{
	
	private String Tarea;
    private int evento;
	
    
    
	public int getevento(){
		return evento;
	}
	
	public void setevento(int evento){
		this.evento = evento;
    }

	public void clickonTarea(String tarea){
		this.Tarea = tarea;
        setevento(1);
        setChanged();
        notifyObservers();
    }
	
    public String getTarea(){
        return Tarea;
    }
        
    public void clickonPanelDia(String tarea){
        this.Tarea = tarea;
        setevento(2);
        setChanged();
        notifyObservers();
    }

}
