package AdminEventos;

import java.util.ArrayList;

/**
 *
 * @author alev2477
 */
public class Usuario  {
private String IdUsuario;
private String NombreUsuario;
private String EstatusUsuario;
private ArrayList<Evento> AgendaEventos;
private Horario Disponibilidad;


public Usuario(){
AgendaEventos = new ArrayList<Evento>();
}

public void AsignarEvento(Evento c){
AgendaEventos.add(c);

}

public void setIdUsuario(String id){
IdUsuario=id;
}
public String getIdUsuario(){
return IdUsuario;
}

public void setNombreUsuario(String nombre){
NombreUsuario = nombre;
}
public String getNombreUsuario(){
return NombreUsuario;

}

public void setEstatusUsuario(String status){
EstatusUsuario = status;
}

public ArrayList consultarAgendaUsuario(){
    return AgendaEventos;
            

}

}
