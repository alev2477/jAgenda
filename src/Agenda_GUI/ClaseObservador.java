package Agenda_GUI;

import java.util.Observable;


/**
 * Clase observador donde se establece el eje central del patron
 * @author chenao
 *
 */
public class ClaseObservador extends Observable{
	
	private int colorSeleccionado;
	private String color;
	private String Tarea;
	public ClaseObservador(){
		
	}
		
	public void setColorSeleccionado(int i) {
		this.colorSeleccionado = i;
		setChanged();
	    notifyObservers();
	}

	public int getColorSeleccionado() {
		return colorSeleccionado;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getColor() {
		return color;
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
