
package Calendario;

import java.util.Date;

/**
 *
 * @author alev2477
 */
public class Horario {

    private String hora;

    public Horario() {

    }

    public Horario(String time) {

    }

    public Horario(Date time) {

    }

    public void asignar_strHora(String time) {
        this.hora = time;
    }

    public String obtener_strHora() {
        return this.hora;
    }

}
