package AdminEventos;

import java.util.ArrayList;

/**
 *
 * @author alev2477
 * @email alev2477@gmail.com
 * @date 14 abril 2016
 * @version 0.1
 * 
 */
public class Evento {

    private String NombreEvento;
    private String IdEvento;
    private Espacio salonEvento;
    private Instructor InstructorEvento;
    private Horario HorariodeEvento;
    private ArrayList<Usuario> UsuariosEvento;

    public Evento(){
    salonEvento = new Espacio();
    InstructorEvento = new Instructor();
    HorariodeEvento = new Horario();
    UsuariosEvento = new ArrayList<Usuario>();
    }
    
    public void setNombreEvento(String nombre) {
        NombreEvento = nombre;
    }
    
   public void setIdEvento(String id){
   IdEvento=id;
   }
   public String getIdEvento(){
   return IdEvento;
   }

    public void crearEvento() {

    }

    public void setEspacioEvento(Espacio salon) {
        salonEvento = salon;
    }
    public Espacio getEspacioEvento(){
    return salonEvento;
    }

    public void cambiarEspacioEvento() {
    }

    public boolean solicitarEspacioEvento() {
        return false;
    }

    public void setInstructorEvento(Instructor instructor) {
        InstructorEvento = instructor;
    }
    public Instructor getInstructorEvento(){
    return InstructorEvento;
    }

    public boolean solicitarInstructorEvento(Instructor instructor) {
        return false;
    }
    
    public void cambiarInstructorEvento(){}

    public void setHorarioEvento(Horario horario) {
        HorariodeEvento = horario;
    }
    
    public Horario getHorarioEvento(){
    return HorariodeEvento;
    }

}
