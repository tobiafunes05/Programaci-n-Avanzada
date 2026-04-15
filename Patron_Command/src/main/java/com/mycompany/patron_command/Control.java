/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.patron_command;

/**
 *
 * @author nvara
 */
public class Control {
    private Comando comando; 

    public void setComando(Comando comando) {
        this.comando = comando;
    }
    
    public void pulsarBoton(){
        comando.ejecutar();
    }
}
