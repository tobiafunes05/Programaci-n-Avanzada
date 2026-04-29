/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package formulario;

import VISTA.*;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author franc
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // 1. Creamos el marco (la ventana física)
        javax.swing.JFrame frame = new javax.swing.JFrame("VENTANA");

        // 2. Instanciamos tu panel
        VENTANA v = new VENTANA();

        // 3. Agregamos el panel al marco
        frame.add(v);

        GridLayout gl = new GridLayout(2, 2);
        gl.setHgap(2);
        gl.setVgap(2);
        frame.setLayout(gl);
        JTextField cuadroTxt = new JTextField(20);
        JLabel Msj = new JLabel();
        JButton botonPulsar = new JButton("Toca el boton");
        frame.add(cuadroTxt);
        frame.add(Msj);

        botonPulsar.addActionListener(new PulsarBTN(cuadroTxt));

        frame.add(botonPulsar);

        // 4. Configuraciones esenciales
        frame.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE); // Para que el programa cierre al tocar la X
        frame.pack(); // Ajusta el tamaño de la ventana al contenido del panel
        frame.setLocationRelativeTo(null); // Centra la ventana en la pantalla
        frame.setVisible(true); // ¡Ahora sí se verá!

    }

}
