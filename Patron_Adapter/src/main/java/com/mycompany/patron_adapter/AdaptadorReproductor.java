/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.patron_adapter;

/**
 *
 * @author nvara
 */
public class AdaptadorReproductor implements ReproductorNuevo {
    
    private ReproductorViejo reproductorViejo; 

    public AdaptadorReproductor(ReproductorViejo reproductorViejo) {
        this.reproductorViejo = reproductorViejo;
    }
    @Override
    public void reproducir(String nombreArchivo) {
        reproductorViejo.reproducirArchivos(nombreArchivo);
}

    
}