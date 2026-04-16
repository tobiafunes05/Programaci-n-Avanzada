/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.patron_singleton;

/**
 *
 * @author nvara
 */
public class Patron_Singleton {

    public static void main(String[] args) {
         Usuario us = Usuario.obtenerInstancia("Tobias", 20); 
         
         System.out.println("Nombre: " + us.getNombre());
         System.out.println("Edad: " + us.getEdad());
         
         
         us.setNombre("Carlos");
         us.setEdad(30);
    
        System.out.println("Nombre: " + us.getNombre());
        System.out.println("Edad: " + us.getEdad());
}     
    }

 class Usuario {
    
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

