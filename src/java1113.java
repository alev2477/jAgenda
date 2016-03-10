//
//  java1113.java
//  Copyright (c) 1997, Agustin Froufe
//  Todos los derechos reservados.
//
//  No se asume ninguna  responsabilidad por el  uso o  alteracion  de este
//  software.  Este software se proporciona COMO ES, sin garantia de ningun
//  tipo de su funcionamiento y en ningun caso sera el autor responsable de
//  daños o perjuicios que se deriven del mal uso del software,  aun cuando
//  este haya sido notificado de la posibilidad de dicho daño.
//
//   Compilador: javac 1.1.4
//        Autor: Agustin Froufe
//     Creacion: 02-Oct-1997  13:06:15
//
//--------------------------------------------------------------------------
//  Esta informacion no es necesariamente definitiva y esta sujeta a cambios
//  que pueden ser incorporados en cualquier momento, sin avisar.
//--------------------------------------------------------------------------

/**
  * Este ejemplo muestra una forma sencilla de crear, capturar y
  * procesar eventos propios creados por el programador
  */

import java.awt.*;
import java.awt.event.*;
import java.util.EventListener;
import java.util.EventObject;


public class java1113 {
    public static void main(String[] args){
        // Se intancia un objeto de este tipo
        new java1113();
        }

    // Constructor de la clase
    public java1113(){
        System.out.println( "Tutorial de Java, Eventos" );
        NoVisual primerObjNoVisual = new NoVisual( "Primer ObjetoNoVisual" );
        primerObjNoVisual.addMiEventoListener( new MiClaseEventListener() );
        // Crea un evento
        primerObjNoVisual.generarMiEvento();

        NoVisual segundoObjNoVisual = new NoVisual( "Segundo ObjetoNoVisual" );
        segundoObjNoVisual.addMiEventoListener( new MiClaseEventListener() );

        // La siguiente sentencia hace que el programa termine con el
        // mensaje "No se soportan multiples Receptores" porque se
        // viola la restriccion que establece este programa de que solamente
        // haya un objeto receptor registrado para recoger sus eventos.
        // La sentencia esta deshabilitada mediante un comentario y se 
        // muestra solo a efectos de informacion
        //
        // segundoObjNoVisual.addMiEventoListener(new MiClaseEventListener());
	// Crea un evento
        segundoObjNoVisual.generarMiEvento();    
        }
    }


// Clase para definir un nuevo tipo de evento
class MiEvento extends EventObject {
    // Variable de instancia para diferencia a cada objeto de este tipo
    String id;

    // Constructor parametrizado
    MiEvento( Object obj,String id ) {
        // Se le pasa el objeto como parametro a la superclase
        super( obj );
        // Se guarda el identificador del objeto
        this.id = id;
        }

    // Metodo para recuperar el identificador del objeto
    String getEventoID() {
        return( id );
        }
    }


// Define el interfaz para el nuevo tipo de receptor de eventos
interface MiEventoListener extends EventListener {
    void capturarMiEvento( MiEvento evt );
    }


// Clase Receptor para responder a los eventos que se crean
class MiClaseEventListener implements MiEventoListener {
    public void capturarMiEvento( MiEvento evt ) {
        System.out.println(
            "Metodo capturarMiEvento() invocado sobre " + 
            evt.getEventoID() );
        System.out.println(
            "El origen del evento fue " + evt.getSource() );
        }
    }


// Clase para crear eventos de nuestro tipo. Esta es una version
// muy sencilla que solo permite que se registre un Receptor
// para el tipo de evento que hemos creado
class NoVisual extends Component {
    // El identificador de este objeto
    String ID; 
    // Referencia al receptor unico
    MiClaseEventListener miReceptor;

    // Construye un objeto NoVisual
    public NoVisual( String ID ) {
        this.ID = ID;
        }

    public void addMiEventoListener( MiClaseEventListener receptor ) {
        // No se permite que intente incorporar mas de un receptor
        if( miReceptor == null ) 
            miReceptor = receptor;
        else {
            System.out.println( "No se soportan multiples Receptores" );
            // Se sale, si se intentan registrar varios objetos Receptor
            System.exit( 0 );
            }
        }

    public void generarMiEvento() {
        miReceptor.capturarMiEvento( new MiEvento( this,ID ) );
        }
    }

//------------------------------------------ Final del fichero java1113.java