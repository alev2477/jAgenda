package Agenda_GUI;

import java.util.Observable;


/**
 * Clase observador donde se establece el eje central del patron
 * @author chenao
 *
 */
public class ClaseObservador extends Observable{
	

	private String Tarea;
	public ClaseObservador(){
		
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
