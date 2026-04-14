/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.ejercicio_socket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author nvara
 */
public class Servidor {

    public static void main(String[] args) throws IOException {
       try{
          ServerSocket servidor = new ServerSocket(9000);  
           System.out.println("Servidor Inciado");
          Socket cliente= servidor.accept();
          
           System.out.println("Cliente Conectado");
          DataInputStream entrada = new DataInputStream (cliente.getInputStream()); 
          DataOutputStream  salida = new  DataOutputStream  (cliente.getOutputStream()); 
          
          String mensaje = entrada.readUTF(); 
          int numero1 = entrada.readInt();
          int numero2 = entrada.readInt();
          int numero3 = entrada.readInt();
           System.out.println(mensaje);
           
           salida.writeUTF(" Hola desde el Servidor ");
           salida.writeInt(numero1*numero2*numero3);
             cliente.close();
            servidor.close();
           System.out.println("Cliente desconectado");  
            
       }catch (IOException e){
            e.printStackTrace();
       }
             
    }
}
