/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AdminEventos;

import java.util.ArrayList;

/**
 *
 * @author alev2477
 */
public class Instructor {

    private String NombreInstructor;
    private String EspecialidadInstructor;
    private String idInstructor;
    private Horario HorarioInstructor;
    private ArrayList <Evento> AgendaInstructor;
    
    public Instructor() {
        AgendaInstructor = new ArrayList<Evento>();
        HorarioInstructor = new Horario();
    }
    
    public void setHorarioInstructor(Horario horario){
    HorarioInstructor = horario;
    }
    public Horario getHorarioiInstructor(){
    return HorarioInstructor;
    }

    public String getNombreInstructor() {
        return NombreInstructor;
    }

    public void setNombreInstructor(String NombreInstructor) {
        this.NombreInstructor = NombreInstructor;
    }

    public String getEspecialidadInstructor() {
        return EspecialidadInstructor;
    }

    public void setEspecialidadInstructor(String EspecialidadInstructor) {
        this.EspecialidadInstructor = EspecialidadInstructor;
    }

    public String getIdInstructor() {
        return idInstructor;
    }

    public void setIdInstructor(String idInstructor) {
        this.idInstructor = idInstructor;
    }

    public ArrayList<Evento> getAgendaInstructor() {
        return AgendaInstructor;
    }

    public void setAgendaInstructor(ArrayList<Evento> AgendaInstructor) {
        this.AgendaInstructor = AgendaInstructor;
    }
    
    
}
