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

