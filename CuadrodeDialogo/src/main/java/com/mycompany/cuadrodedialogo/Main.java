package com.mycompany.cuadrodedialogo;
 
import Controlador.Controlador;
import Model.Modelo;
import vista.Vista;
 
public class Main {
    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(() -> {
            Modelo modelo = new Modelo();
            Vista vista = new Vista(modelo);
            new Controlador(modelo, vista);
            vista.setVisible(true);
        });
    }
}
 