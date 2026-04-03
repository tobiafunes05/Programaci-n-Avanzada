/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.tp_progamacion_avanzada;
import java.util.Scanner;
/**
 *
 * @author nvara
 */
public class Tp_Progamacion_Avanzada {

    public static void main(String[] args) {
        int opc=0; 
        Scanner teclado = new Scanner(System.in);
        
        
         Libro libro1= new Libro ("El Principito","Saint-Exupéry");
        Libro libro2= new Libro ("Don Quijote de la Mancha","Miguel de Cervantes");
        Libro libro3= new Libro ("Martin Fierro", "Hernandez"); 
   
     while (opc!=4){   
         System.out.println("----------------------------------------------"); 
        System.out.println("Bienvenido al menu de opciones de la Biblioteca");
        System.out.println("1-Ver libros");
        System.out.println("2-Pedir Libro");
        System.out.println("3-Devolver Libro");
        System.out.println("4-Salir");
         System.out.println("----------------------------------------------");
        opc=teclado.nextInt(); 
        
   
        int opcion=0;        
        int libro=0;        
        switch (opc){
            case 1:
                System.out.println("Usted eligio ver libros ");
                System.out.println(libro1 + "," + libro1.estado() );
                System.out.println(libro2 + "," + libro2.estado());
                System.out.println(libro3 + "," + libro3.estado());
                break;
            case 2: 
                System.out.println("Usted eligio pedir un libro ");
                System.out.println("Eliga el libro que usted quiere pedir");
                libro=teclado.nextInt();
                
                if(libro==1){
                    libro1.PedirLibro();
                    System.out.println("El libro " + libro1 + "es tuyo");
               
                }else if (libro==2){
                    
                    libro2.PedirLibro();
                    System.out.println("El libro " + libro2 + "es tuyo");
                }else if (libro==3){
                    libro3.PedirLibro();
                    System.out.println("El libro " + libro3 + "es tuyo");
                }
                break; 
            case 3: 
             
                System.out.println("Usted eligio devolver un libro");
                System.out.println("Usted eligio pedir un libro ");
                System.out.println("Eliga el libro que usted quiere pedir");
                 opcion=teclado.nextInt();
                
                if(opcion==1){
                    libro1.DevolverLibro();
                    System.out.println("El libro " + libro1 + "es tuyo");
               
                }else if (opcion==2){
                    
                    libro2.DevolverLibro();
                    System.out.println("El libro " + libro2 + "es tuyo");
                }else if (opcion==3){
                    libro3.DevolverLibro();
                    System.out.println("El libro " + libro3 + "es tuyo");
                }
               
                break;
            case 4: 
                
                break; 
            default: 
                System.out.println("El numero elegido es incorrecto");
        }
        
     }
        
    }
}

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
