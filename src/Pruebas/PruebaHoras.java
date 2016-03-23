/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pruebas;

import ClasesAdmin.Horario;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 *
 * @author alev2477
 */
public class PruebaHoras {

   

    public static void main(String args[]) {
      Date fechaInicio = null;
        Date fechaLlegada = null;
        Date ahora = new Date();
        
SimpleDateFormat formato = new SimpleDateFormat("HH:mm:ss");

 try {
            // aca realizamos el parse, para obtener objetos de tipo Date de 
            // las Strings
            fechaInicio = formato.parse("12:22:1");
            fechaLlegada = formato.parse("12:22:11");

        } catch (ParseException e) {
           // Log.e(TAG, "Funcion diferenciaFechas: Error Parse " + e);
        } catch (Exception e){
            // Log.e(TAG, "Funcion diferenciaFechas: Error " + e);
        }

        
        
        Horario horario = new Horario(fechaInicio,fechaLlegada); 
        
        
        
    }
}
