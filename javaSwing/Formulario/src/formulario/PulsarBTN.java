/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package formulario;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author franc
 */
public class PulsarBTN implements ActionListener {

    private JTextField cuadroTexto;

    public PulsarBTN(JTextField cuadroTexto) {
        this.cuadroTexto = cuadroTexto;
    }

    public void actionPerformed(ActionEvent e) {
        JOptionPane.showMessageDialog(null, "¡Te fuiste a la B, "
                + cuadroTexto.getText() + "!!!!!");
    }

}
