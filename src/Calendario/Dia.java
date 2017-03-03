/**
 *
 */
package Calendario;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author alev2477
 */
public final class Dia {

    private Date Fecha;
    private ArrayList<Cita> ListaTareas;
    private int intDia;

    /**
     * Constructor sin parametro para hora actual
     */
    public Dia() {
        /*Sin parametro fecha actual del sistema*/
        this.actualfecha();
        ListaTareas = new ArrayList<Cita>();

    }

    /**
     * Dia(Date date) Con parametro date, se emplea metodos de conversion fecha
     * actual del sistema
     *
     * @param date
     */
    public Dia(Date date) {

        Fecha = date;
        ListaTareas = new ArrayList<Cita>();

    }

    /**
     * Dia(Date date) Con parametro date, se emplea metodos de conversion fecha
     * actual del sistema
     *
     * @param date
     */
    public Dia(String date) {
        /*Parametro String*/

    }

    public void setintdia(int dia) {
        intDia = dia;
    }

    public int getintdia() {
        return intDia;
    }

    /**
     * agregarNuevaTareaLista(String Tarea, String Hora)
     *
     * @param Tarea
     * @param Hora
     */
    public void agregarNuevaTareaLista(String Tarea, String Hora) {
        Cita NuevaTarea = new Cita();
        NuevaTarea.agregar_strTarea(Tarea, Hora);
        ListaTareas.add(NuevaTarea);
    }

    public ArrayList<Cita> getTareas() {
        return ListaTareas;

    }

    public int setfechaString(String fecha) throws ParseException {

        Fecha = Convertodate(fecha);

        return 0;
    }

    public int Citar() {

        return 0;
    }

    public int setfecha(Date fecha) {
        this.Fecha = fecha;
        return 0;

    }

    public Date getFecha() {
        return this.Fecha;
    }

    public String getFechaString() {
        return Convertostring(Fecha);
    }

    public static String Convertostring(Date fecha) {
        DateFormat df;
        String datestring = null;
        df = new SimpleDateFormat("dd/MM/YYYY");
        datestring = df.format(fecha);
        return datestring;
    }

    public static Date Convertodate(String fecha) throws ParseException {
        DateFormat df;
        Date Fecha = new Date();
        df = new SimpleDateFormat("dd/MM/YYYY");
        Fecha = df.parse(fecha);
        return Fecha;

    }

    /**
     * *****************************************************************************
     * actualfecha(): carga fecha actual del sistema en el objeto DiaVector
     * ***************************************************************************
     */
    public void actualfecha() {

        Fecha = new Date();

    }

	public void LimpiarListaTareasporDia() {
		ListaTareas.clear();
		
	}

}
