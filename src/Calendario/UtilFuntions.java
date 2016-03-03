/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Calendario;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Alejandro
 */
public class UtilFuntions {

    public static String Convertostring(Date fecha) {
        DateFormat df;
        String datestring = null;
        df = new SimpleDateFormat("dd/MM/yyyy");
        datestring = df.format(fecha);
        return datestring;
    }

    public static Date Convertodate(String fecha) throws ParseException {
        DateFormat df;
        Date date = new Date();
        df = new SimpleDateFormat("dd/MM/yyyy");
        try {
            date = df.parse(fecha);
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
        return date;

    }

}
