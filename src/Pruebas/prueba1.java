/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pruebas;

import Calendario.Calendario;
import Calendario.UtilFuntions;
import java.text.ParseException;
import java.util.Date;

/**
 *
 * @author alev2477
 */
public class prueba1 {

    
    public  static void main(String args[]) throws ParseException{
        String strFecha = "24/05/2016";
        Date fecha ;
        fecha = UtilFuntions.Convertodate(strFecha);
        System.out.println(fecha);
        Calendario Mensual = new Calendario();
       
        Mensual.setCalendario(fecha);
        Mensual.printcalendar();
        Mensual.Hacercita("25/05/2016", "Lavar", "08:00 AM");
        Mensual.Hacercita("25/05/2016", "cocinar", "11:00 AM");
        Mensual.Hacercita("10/05/2016", "Lavar", "08:00 AM");
        Mensual.Hacercita("15/05/2016", "cocinar", "11:00 AM");
        Mensual.Hacercita("25/05/2016", "cocinar", "11:00 AM");
        Mensual.Hacercita("10/05/2016", "Lavar", "08:00 AM");
        Mensual.Hacercita("15/06/2016", "cocinar", "11:00 AM");
        
        Mensual.imprimirTareas("10/05/2016");
        
        Mensual.imprimirTareasMes("25/05/2016");
        strFecha = "12/01/2017";
        fecha = UtilFuntions.Convertodate(strFecha);
        
        
        
        Mensual.setCalendario(fecha);
        Mensual.Hacercita(strFecha, "Cantar","18:00" );
        Mensual.Hacercita(strFecha, "Correr","15:00" );
        
        Mensual.printcalendar();
        Mensual.imprimirTareasMes("25/01/2017");
        
        
        
    
    }
    
}
