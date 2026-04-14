/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ejercicio_socket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author nvara
 */
public class Cliente {
    public static void main(String[] args) throws IOException {
    Scanner sc = new Scanner(System.in); 
    int numero1; 
    int numero2; 
    int numero3;


        try{
        Socket socket = new Socket ("localhost",9000);
        
          DataOutputStream salida = new DataOutputStream(socket.getOutputStream());
          DataInputStream entrada = new DataInputStream(socket.getInputStream());
          
          salida.writeUTF("Hola Servidor");
          
          
        System.out.println("Ingrese el numero ");
        numero1=sc.nextInt();
        
        System.out.println("Ingrese el numero ");
        numero2=sc.nextInt();    
        
        System.out.println("Ingrese el numero ");
        numero3=sc.nextInt();
          
        
          salida.writeInt(numero1);
          salida.writeInt(numero2);
          salida.writeInt(numero3);
          
          
      
          String respuesta = entrada.readUTF();
          System.out.println( respuesta);
          
          int respuesta2 = entrada.readInt() ;
          
            System.out.println(respuesta2);
          socket.close();
    } catch (IOException e) {
            e.printStackTrace();
        }
}

    }