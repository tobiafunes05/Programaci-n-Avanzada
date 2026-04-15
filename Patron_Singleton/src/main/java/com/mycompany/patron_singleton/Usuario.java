/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.patron_singleton;

/**
 *
 * @author nvara
 */
public class Usuario {
    
    private static Usuario instancia; 
    
    private String nombre;
    
    private int edad; 

    private Usuario(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }
    
    public static Usuario obtenerInstancia (String nombre,int edad){
     
        if (instancia == null){
            
            instancia = new Usuario (nombre,edad);
        
        }
        
    return instancia;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
    
}
