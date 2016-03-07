/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Calendario;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 *
 * @author Alejandro Villalobos email: alev2477@gmail.com fecha: 27-04-2015
 */
public class Calendario {

    private GregorianCalendar calendario;
    private int mesactual;
    private int diaactual;
    private int annoactual;
    private int primerdiadelmes;
    private int diadelasemana;
    public Dia[] cMensual;
    private int DiasEnMes;

    private int[] intVectorCalMes;
    private final int Tamano_Matriz = 43;
    private static final String[] diasdelasemana = new String[]{
        "dom",
        "lun",
        "mar",
        "mie",
        "jue",
        "vie",
        "sab"};

    /**
     *
     */
    public Calendario() {
        actualizarfecha();
        setCalendario();

    }

    public void setdiaenmes(int dia) {
        DiasEnMes = dia;
    }

    public int getdiaenmes() {
        return DiasEnMes;
    }

    public Calendario(int y) {
    }

    public int getDiaSemana() {
        return this.diadelasemana;
    }

    public void setDiaSemana(int dia) {
        this.diadelasemana = dia;
    }

    public int getPrimerDiadelmes() {
        return this.primerdiadelmes;
    }

    public void setPrimerDiadelmes(int dia) {
        this.primerdiadelmes = dia;
    }

    public void setDiaActual(int dia) {
        this.diaactual = dia;
    }

    public void setMesActual(int mes) {
        this.mesactual = mes;
    }

    public void setAnnoActual(int anno) {
        this.annoactual = anno;
    }

    public int getDiaActual() {
        return this.diaactual;
    }

    public int getMesActual() {
        return this.mesactual;
    }

    public int getAnnoActual() {
        return this.annoactual;
    }

    public void printmatrizcalendar() {
        int valorDia = 0;

        for (int i = 0; i < 7; i++) {
            System.out.print(diasdelasemana[i] + "  ");
        }
        System.out.print("\n");

        for (int i = 0; i <= intVectorCalMes[43]; i++) {

            if (i == 7 || i == 14 || i == 21 || i == 28 || i == 35) {
                System.out.print("\n");
            }
            valorDia = intVectorCalMes[i];
            if (valorDia < 10) {

                System.out.print("0" + Integer.toString(intVectorCalMes[i]) + "   ");
            } else {

                System.out.print(Integer.toString(intVectorCalMes[i]) + "   ");
            }
        }
    }

    public void printcalendar() {
        int valorDia = 0;
        System.out.print("\n");
        System.out.print("\n");

        for (int i = 0; i < 7; i++) {
            System.out.print(diasdelasemana[i] + "  ");
        }
        System.out.print("\n");

        for (int i = 0; i <= DiasEnMes; i++) {

            if (i == 7 || i == 14 || i == 21 || i == 28 || i == 35) {
                System.out.print("\n");
            }
            valorDia = cMensual[i].getintdia();
            if (valorDia < 10) {

                System.out.print("0" + Integer.toString(cMensual[i].getintdia()) + "   ");
            } else {

                System.out.print(Integer.toString(cMensual[i].getintdia()) + "   ");
            }
        }
    }

    /**
     * ***************************************************************************
     */
    /**
     * DiaVector Primerodelmes(DiaVector dia) Este metodo determina el dia de la
     * semana que toca el primer dia del mes
     *
     * @param dia
     * @return Retorna un Objeto DiaVector (Un dia de la semana)
     */
    public Date primerodelmes(Date dia) {
        /*Seteamos el dia primero del mes de la fecha dada */

        calendario.setTime(dia);
        calendario.set(Calendar.DATE, 1);
        /*Se almacena el dia actual en dia*/
        this.setDiaActual(calendario.get(Calendar.DATE));
        this.setMesActual(calendario.get(Calendar.MONTH));
        this.setAnnoActual(calendario.get(Calendar.YEAR));
        this.setPrimerDiadelmes(this.getDiaActual());
        /*Se invoca metodo que determina que dia de la semana*/
        this.setdiadelasemana(dia);
        return dia;

    }

    /**
     * *************** FIN DE PRIMEDELMES
     * ****************************************
     */
    /**
     * ***************************************************************************
     */
    /**
     * serdiadelasemana determina que dia de la semana es de una fecha dada
     *
     * @param dia
     * @return int.
     */
    public int setdiadelasemana(Date dia) {
        calendario.set(Calendar.DATE, this.getDiaActual());
        calendario.set(Calendar.MONTH, this.getMesActual());
        calendario.set(Calendar.YEAR, this.getAnnoActual());
        int diasemana = calendario.get(Calendar.DAY_OF_WEEK);
        this.setDiaSemana(diasemana);
        return diasemana;
    }

    /**
     * ***********************Fin de
     * setdiadelasemana*****************************
     */
    /**
     * ultimodiames
     *
     * @param dia
     * @return
     */
    public Date ultimodiames(Date dia) {
        calendario.setTime(dia);
        calendario.set(Calendar.DATE, this.diaactual);
        calendario.set(Calendar.MONTH, this.mesactual);
        calendario.set(Calendar.YEAR, this.annoactual);
        this.diaactual = calendario.getActualMaximum(Calendar.DATE);
        this.mesactual = calendario.get(Calendar.MONTH);
        this.annoactual = calendario.get(Calendar.YEAR);
        dia = calendario.getTime();
        return dia;
    }

    /**
     * getdiaanterior obtiene el dia anterior a una fecha
     *
     * @param dia tipo DiaVector
     * @return dia tipo DiaVector
     */
    public Date getdiaanterior(Date dia) {
        calendario.set(Calendar.DATE, this.getDiaActual());
        calendario.set(Calendar.MONTH, this.getMesActual());
        calendario.set(Calendar.YEAR, this.getAnnoActual());
        calendario.add(Calendar.DATE, -1);
        this.setDiaActual(calendario.get(Calendar.DATE));
        this.setMesActual(calendario.get(Calendar.MONTH));
        this.setAnnoActual(calendario.get(Calendar.YEAR));
        setdiadelasemana(dia);
        return dia;
    }

    /**
     * *********************FIN getdiaanterior********************************
     */
    /**
     * getdiasiguiente obtiene el dia siguiente a una fecha dada
     *
     * @param dia tipo DiaVector
     * @return dia tipo DiaVector
     */
    public Date getdiasiguiente(Date dia) {
        calendario.set(Calendar.DATE, this.getDiaActual());
        calendario.set(Calendar.MONTH, this.getMesActual());
        calendario.set(Calendar.YEAR, this.getAnnoActual());
        calendario.add(Calendar.DATE, +1);
        this.setDiaActual(calendario.get(Calendar.DATE));
        this.setMesActual(calendario.get(Calendar.MONTH));
        this.setAnnoActual(calendario.get(Calendar.YEAR));
        setdiadelasemana(dia);
        return dia;
    }

    public Date getmessiguiente(Date dia) {
        calendario.set(Calendar.DATE, this.getDiaActual());
        calendario.set(Calendar.MONTH, this.getMesActual());
        calendario.set(Calendar.YEAR, this.getAnnoActual());
        calendario.add(Calendar.MONTH, +1);
        this.setDiaActual(calendario.get(Calendar.DATE));
        this.setMesActual(calendario.get(Calendar.MONTH));
        this.setAnnoActual(calendario.get(Calendar.YEAR));
        return dia;
    }

    public Date getmesanterior(Date dia) {
        calendario.set(Calendar.DATE, this.getDiaActual());
        calendario.set(Calendar.MONTH, this.getMesActual());
        calendario.set(Calendar.YEAR, this.getAnnoActual());
        calendario.add(Calendar.MONTH, -1);
        this.setDiaActual(calendario.get(Calendar.DATE));
        this.setMesActual(calendario.get(Calendar.MONTH));
        this.setAnnoActual(calendario.get(Calendar.YEAR));
        return dia;
    }

    public Date getannosiguiente(Date dia) {
        calendario.set(Calendar.DATE, this.getDiaActual());
        calendario.set(Calendar.MONTH, this.getMesActual());
        calendario.set(Calendar.YEAR, this.getAnnoActual());
        calendario.add(Calendar.YEAR, +1);
        this.setDiaActual(calendario.get(Calendar.DATE));
        this.setMesActual(calendario.get(Calendar.MONTH));
        this.setAnnoActual(calendario.get(Calendar.YEAR));
        return dia;
    }

    /**
     * getannoanterior nos devuelve el anno anterior a una fecha determinada
     *
     * @param dia
     * @return dia
     */
    public Date getannoanterior(Date dia) {
        calendario.set(Calendar.DATE, this.getDiaActual());
        calendario.set(Calendar.MONTH, this.getMesActual());
        calendario.set(Calendar.YEAR, this.getAnnoActual());
        calendario.add(Calendar.YEAR, -1);
        this.setDiaActual(calendario.get(Calendar.DATE));
        this.setMesActual(calendario.get(Calendar.MONTH));
        this.setAnnoActual(calendario.get(Calendar.YEAR));
        return dia;
    }

    /**
     * *****************************************************************************
     * actualizarfecha(): carga fecha actual del sistema en el objeto DiaVector
     * ***************************************************************************
     */
    public void actualizarfecha() {
        calendario = new GregorianCalendar();

        this.setDiaActual(calendario.get(Calendar.DATE));
        this.setMesActual(calendario.get(Calendar.MONTH));
        this.setAnnoActual(calendario.get(Calendar.YEAR));

        setdiadelasemana(calendario.getTime());
    }

    public void setCalendario() {
        Date fecha;
        calendario = new GregorianCalendar();
        fecha = calendario.getTime();
        setCalendario(fecha);

    }

    public void setCalendario(String fecha) throws ParseException {
        Date Fecha;
        Fecha = UtilFuntions.Convertodate(fecha);
        setCalendario(Fecha);

    }

    /**
     * setMatrizCalendario : crea un vector que contiene el calendario, con los
     * dias validos para el mes y los dias de mes anterior y posterior que se
     * encuentren a partir del domingo de las semana del mes actual
     *
     * @param fecha
     */
    public void setCalendario(Date fecha) {
        calendario.setTime(fecha);
        this.setDiaActual(calendario.get(Calendar.DATE));
        this.setMesActual(calendario.get(Calendar.MONTH));
        this.setAnnoActual(calendario.get(Calendar.YEAR));

        int dia = this.getDiaActual();
        int mes = this.getMesActual();
        int anno = this.getAnnoActual();

        cMensual = new Dia[46];
        intVectorCalMes = new int[46];

        /*Se Obtiene la fecha del primero del mes dado*/
        fecha = primerodelmes(fecha);
        /*dia de la semana*/
        int diasemana = this.getDiaSemana();
        /* Se obtendra el dia primero de la matriz
         se busca hasta sea domingo, ya que el calendario comenzara con domingo
         */
        while (diasemana != 1) {
            fecha = this.getdiaanterior(fecha);
            diasemana = this.getDiaSemana();
        }
        /*Una vez obtenido el domingo se tiene una fecha que no es mes de la fecha
         a buscar */
        /*
         * Ya obtenido el primer dia de la matriz calendario se asigna (No 
         necesariamente es un dia perteneciente al mes a consultar)
         */

        for (int j = 0; j < Tamano_Matriz - 1; j++) {
            cMensual[j] = new Dia();
            /**
             * **********************************************************************
             */
            calendario.set(Calendar.DATE, this.getDiaActual());
            calendario.set(Calendar.MONTH, this.getMesActual());
            calendario.set(Calendar.YEAR, this.getAnnoActual());

            /**
             * **********************************************************************
             */
            cMensual[j].setfecha(calendario.getTime());
            cMensual[j].setintdia(this.getDiaActual());
            intVectorCalMes[j] = (this.getDiaActual());

            this.getdiasiguiente(fecha);
            intVectorCalMes[Tamano_Matriz] = j;
            DiasEnMes = j;

            /**
             * Se busca que sea un mes posterior y que sea domingo para terminar
             */
            //se le mejoro el asunto de cuando se cambia de a;o
            //if (this.getMesActual() > mes && this.getDiaSemana() == 1 || this.getAnnoActual() > anno ) {
             if (j==42 ) {// lo puse asi para luego acomodarlo, aqui se calculan siempre 42 dias del mes
// si estoy en el mes siguiente y en el primer dìa de la semana finalizo el llenado de dias en la agenda.
                /**
                 * en la posicion 43 de la matriz se almacena la longitud de de
                 * la matriz
                 */
                intVectorCalMes[Tamano_Matriz] = j;
                DiasEnMes = j;

                /**
                 * Se le asigna un valor fuera de rango a J pero se puede usar c
                 * ualquier otro metodo para salir del for
                 */
                break;

            }
        }

        this.setDiaActual(dia);
        this.setMesActual(mes);
        this.setAnnoActual(anno);
    }

    public int getTamanoMatrizactual() {
        return this.intVectorCalMes[Tamano_Matriz];

    }

    public void Hacercita(String Fecha, String Tarea, String Hora) {
        int indice = buscarfecha(Fecha);
        if (indice > 0) {
            cMensual[indice].agregarNuevaTareaLista(Tarea, Hora);
            System.out.println("Listo ya se registro la tarea\n");
        }

    }

    public int buscarfecha(String fecha) {

        String fechaAux;
        for (int i = 0; i <= DiasEnMes; i++) {
            fechaAux = cMensual[i].getFechaString();
            if (fechaAux.compareTo(fecha) == 0) {
                return i;//i es el indice del vector que corresponde con la fecha
            }

        }

        System.out.println("Fecha No existe en calendario actual\n");
        return -1;
    }
/**
 * public ArrayList<Cita> ListaTareasxDia(String Fecha)
 * Es empleada para tener la lista de tares por dia y sea empleada por
 * GUI
 * @param Fecha
 * @return Un arreglo de citas para ese dia
 */
    public ArrayList<Cita> ListaTareasxDia(String Fecha) {
        int indice = buscarfecha(Fecha);
        return cMensual[indice].getTareas();
   
    }

    public void imprimirTareas(String fecha) {
        int indice = buscarfecha(fecha);
        ArrayList<Cita> Lista;

        if (indice > 0) {
            Lista = cMensual[indice].getTareas();
            for (Cita Lista1 : Lista) {
                System.out.print("\n");
                System.out.print(cMensual[indice].getFechaString() + " "
                        + Lista1.getTarea() + " " + Lista1.getHora() + "\n");
            }
        }

    }

    public void imprimirTareasMes(String fecha) {

        for (int i = 0; i <= DiasEnMes; i++) {
            imprimirTareas(cMensual[i].getFechaString());

        }
    }

}
