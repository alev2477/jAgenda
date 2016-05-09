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
public class Espacio {
    private String NombreSalon;
    private Horario HorarioSalon;
    private ArrayList <Evento> AgendaSalon;
    
    public Espacio(){
        HorarioSalon = new Horario();
        AgendaSalon = new ArrayList<Evento>();
    
    }
    
    public void setNombreSalon(String nombre){
    NombreSalon=nombre;
    }
    
    public String getNombreSalon(){
    return NombreSalon;
    }
    public void setHorarioSalon(Horario horario){
    HorarioSalon=horario;
    }
    public Horario getHorarioSalon(){
    return HorarioSalon;
    }
    
    
}
