package AdminEventos;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author alev2477
 */
public class Horario {

    private Date horaInicio;
    private Date horaFin;

    public Horario(Date horaInicio, Date horaFin) {
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
    }

    public Horario(String horainicio, String horafin){
    horaInicio = HoraStringtoDate(horainicio);
    horaFin = HoraStringtoDate(horafin);
    }
    
    
    public Horario() {
    }

    public void sethoraInicio(Date hora) {
        horaInicio = hora;
    }

    public void sethorafin(Date hora) {
        horaInicio = hora;
    }

    public void setHoraInicioString(String hora) {
        sethoraInicio(HoraStringtoDate(hora));
    }

    public void setHoraFinString(String hora) {
        sethorafin(HoraStringtoDate(hora));
    }

    public final Date HoraStringtoDate(String hora) {
        Date Hora;
        SimpleDateFormat formato = new SimpleDateFormat("HH:mm:ss");
        try {
            Hora = formato.parse(hora);
        } catch (ParseException ex) {
            Logger.getLogger(Horario.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        return Hora;
    }

    public String HoraDatetoString(Date hora) {
        SimpleDateFormat formateador = new SimpleDateFormat("hh:mm:ss");
        return formateador.format(hora);
    }
}
