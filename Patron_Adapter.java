/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.patron_adapter;

public class Patron_Adapter {

    public static void main(String[] args) {
        ReproductorViejo viejo = new ReproductorViejo();
        
        ReproductorNuevo reproductor = new AdaptadorReproductor(viejo); 
        
        reproductor.reproducir("Hola Don Pepito");
    }
}


class AdaptadorReproductor implements ReproductorNuevo {
    
    private ReproductorViejo reproductorViejo; 

    public AdaptadorReproductor(ReproductorViejo reproductorViejo) {
        this.reproductorViejo = reproductorViejo;
    }

    @Override
    public void reproducir(String nombreArchivo) {
        reproductorViejo.reproducirArchivos(nombreArchivo);
    }
}


interface ReproductorNuevo {
    void reproducir(String nombreArchivo);
}


class ReproductorViejo {
    
    public void reproducirArchivos(String nombreArchivo) {
        System.out.println("Reproducir Archivo: " + nombreArchivo);
    }
}