/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.patron_adapter;

/**
 *
 * @author nvara
 */
public class Patron_Adapter {

    public static void main(String[] args) {
        ReproductorViejo viejo = new ReproductorViejo();
        
        ReproductorNuevo reproductor = new AdaptadorReproductor(viejo); 
        
        reproductor.reproducir("Hola Don Pepito");
    }
}
