//  
//  java1103.java
//  Copyright (c) 1997, Agustin Froufe
//  Todos los derechos reservados.
//  
//  No se asume ninguna  responsabilidad por el  uso o  alteracion  de este
//  software.  Este software se proporciona COMO ES, sin garantia de ningun
//  tipo de su funcionamiento y en ningun caso sera el autor responsable de
//  daños o perjuicios que se deriven del mal uso del software,  aun cuando
//  este haya sido notificado de la posibilidad de dicho daño.
// 
//   Compilador: javac 1.1.3
//        Autor: Agustin Froufe
//     Creacion: 01-Oct-1997  15:10:27
// 
//--------------------------------------------------------------------------
//  Esta informacion no es necesariamente definitiva y esta sujeta a cambios
//  que pueden ser incorporados en cualquier momento, sin avisar.
//--------------------------------------------------------------------------


/**
 * Este ejemplo muestra como se comparte un solo objeto receptor entre dos
 * componentes visuales del mismo tipo. El programa detecta los eventos
 * del raton que se producen en cualquierea de los dos objetos Frame.
 * Distingue entre un objeto y otro, en funcion del nombre del componente,
 * y presenta las coordenadas en que se encuentra el cursor, en el
 * objeto en que se haya picado
 *
 * NOTA:
 * Cuando se arranca el programa, los dos componenetes visuales se encuentran
 * superpuestos, por lo que sera necesario mover uno respecto del otro para
 * poder acceder a los dos con el raton
 */

import java.awt.*;
import java.awt.event.*;

public class java1103 {
    public static void main( String args[] ) {
        // Aqui se instancia un objeto de tipo Interfaz Hombre-Maquina
        IHM ihm = new IHM();
        }
    }


// Subclase de Frame para poder sobreescribir el metodo paint()
class MiFrame extends Frame {
    int ratonX;
    int ratonY;

    MiFrame( String nombre ) {
        setTitle( "Tutorial de Java, Eventos" );
        setSize( 300,200 );
        // Se asigna un nombre para distinguir entre los dos objetos
        setName( nombre );
        }
  
    public void paint( Graphics g ) {
        // Presenta en pantalla las coordenadas del cursos
        g.drawString( ""+ratonX+", "+ratonY,ratonX,ratonY );
        }
    }


// Esta clase se utiliza para instaciar un objeto de tipo interfaz de
// usuario
class IHM {
    public IHM() {
        // Se crean dos objetos visuales de tipo Frame, se le hace
        // visibles y se les asignan los nombres Frame1 y Frame2
        MiFrame miFrame1 = new MiFrame( "Frame1" );
        miFrame1.setVisible( true );
    
        MiFrame miFrame2 = new MiFrame( "Frame2" );
        miFrame2.setVisible( true );    
    
        // Se instancia y registra un objeto Receptor que hara que
        // concluya la ejecucion del programa cuando el usuario cierre
        // la ventana
        Proceso1 procesoVentana1 = new Proceso1();
        miFrame1.addWindowListener( procesoVentana1 );
        miFrame2.addWindowListener( procesoVentana1 );    
    
        // Se instancia y registra un objeto Receptor que procesara los
        // eventos del raton que se generen en el objeto MiFrame
        ProcesoRaton procesoRaton = new ProcesoRaton( miFrame1,miFrame2 );
        miFrame1.addMouseListener( procesoRaton );
        miFrame2.addMouseListener( procesoRaton );    
        }
    }


// Esta clase Receptor, monitoriza los eventos de pulsacion del
// raton y presenta en pantalla las coordenadas en donde se
// encuentra el cursor cuando el raton es pulsado. El objeto
// receptor distingue entre los dos objetos visuales en base a
// sus nombres como componentes y presenta las coordenadas sobre
// el objeto visual que ha generado el evento del raton
class ProcesoRaton extends MouseAdapter{
    // Variables para guardar referencias a los objetos
    MiFrame frameRef1,frameRef2; 
  
    // Constructor
    ProcesoRaton( MiFrame frame1,MiFrame frame2 ) {
        frameRef1 = frame1;
        frameRef2 = frame2;
        }

    // Se sobrescribe el metodo mousePressed() para controlar la
    // respuesta cuando el raton se pulse sobre uno de los dos
    // objetos Frame
    public void mousePressed( MouseEvent evt ) {
        if( evt.getComponent().getName().compareTo( "Frame1" ) == 0 ) {
            // Recoge las coordenadas X e Y de la posicion del cursor
            // y las almacena en el objeto Frame
            frameRef1.ratonX = evt.getX();
            frameRef1.ratonY = evt.getY();
            frameRef1.repaint();
            }
        else {
            // Recoge las coordenadas X e Y de la posicion del cursor
            // y las almacena en el objeto Frame
            frameRef2.ratonX = evt.getX();
            frameRef2.ratonY = evt.getY();
            frameRef2.repaint();
            }
        }
    }


// Este repector de eventos de la ventana se utiliza para concluir
// la ejecucion del programa cuando el usuario pulsa sobre el boton
// de cierre del Frame
class Proceso1 extends WindowAdapter {
    public void windowClosing( WindowEvent evt ) {
        System.exit( 0 );
        }
    }

//------------------------------------------ Final del fichero java1103.java
