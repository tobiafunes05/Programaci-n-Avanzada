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
       
        Luz luz = new Luz();
        
        Comando prender = new PrenderLuz(luz);
        Comando apagar  = new ApagarLuz(luz);
        
        Control c = new Control();
        
        c.setComando(prender);
        c.pulsarBoton();
        
        c.setComando(apagar);
        c.pulsarBoton();
    }
}

// 🔽 Interface
interface Comando {
    void ejecutar();
}

// 🔽 Invoker
class Control {
    private Comando comando; 

    public void setComando(Comando comando) {
        this.comando = comando;
    }
    
    public void pulsarBoton(){
        comando.ejecutar();
    }
}

// 🔽 Receiver
class Luz {
    
    void prender(){
        System.out.println("Luz Prendida"); 
    }
    
    void apagar(){
        System.out.println("Luz Apagada");
    }
}

// 🔽 Command concreto
class PrenderLuz implements Comando {
    
    private Luz luz; 

    public PrenderLuz(Luz luz) {
        this.luz = luz;
    }
    
    @Override
    public void ejecutar() {
        luz.prender();
    }
}

// 🔽 Command concreto
class ApagarLuz implements Comando {
    
    private Luz luz; 

    public ApagarLuz(Luz luz) {
        this.luz = luz;
    }
    
    @Override
    public void ejecutar() {
        luz.apagar();
    }
}