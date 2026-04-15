/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.patron_command;

/**
 *
 * @author nvara
 */
public class Patron_Command {

    public static void main(String[] args) {
       
        Luz luz= new Luz();
        
        Comando prender = new PrenderLuz(luz);
        Comando apagar  = new ApagarLuz(luz);
        
        Control c = new Control();
        
        c.setComando(prender);
        c.pulsarBoton();
        
        c.setComando(apagar);
        c.pulsarBoton();
    }
}
