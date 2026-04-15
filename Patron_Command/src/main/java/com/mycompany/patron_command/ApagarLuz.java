/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.patron_command;

/**
 *
 * @author nvara
 */
public class ApagarLuz implements Comando {
    private Luz luz; 

    public ApagarLuz(Luz luz) {
        this.luz = luz;
    }
    
    @Override
    public void ejecutar() {
        luz.apagar();
    }
}
