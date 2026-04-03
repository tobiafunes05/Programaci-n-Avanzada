/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tp_progamacion_avanzada;

/**
 *
 * @author nvara
 */
class Libro {
   
    
    String titulo;
    String autor;
    boolean disponible;

    public Libro(String titulo, String autor) {
        this.titulo = titulo;
        this.autor = autor;
        this.disponible = true;
    }
    
    @Override
    public String toString(){
        return "Titulo: " + titulo + ", Autor: " + autor;
    }
    
    
    public String estado() {
    if (disponible) {
        return " Disponible";
    } else {
        return " No disponible";
    }
}
    public void DevolverLibro(){
        if (disponible == false){
            disponible=true;
            System.out.println("Se devolvio el libro correctamente ");
            
        }else{
            System.out.println("El libro no fue devuelto");
        }
    }
    
    public void PedirLibro(){
        if (disponible){
        disponible=false;
        System.out.println("Libro prestado correctamente");
        } else{
            System.out.println("El libro ya esta prestado ");        
        }           
    }
}
