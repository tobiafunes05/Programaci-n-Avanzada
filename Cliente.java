/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.hilos;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Cliente {
    
   public static void main(String[] args) {
    try {
        Socket socket = new Socket("localhost", 9923);
        DataInputStream entrada = new DataInputStream(socket.getInputStream());
        DataOutputStream salida = new DataOutputStream(socket.getOutputStream());
        Scanner sn = new Scanner(System.in);

       
        System.out.println(entrada.readUTF()); 
        
       
        String nombre = sn.nextLine();
        salida.writeUTF(nombre);

     
        ClienteHilos clienteHilos = new ClienteHilos(entrada, salida);

       
        clienteHilos.start();

       
        clienteHilos.ejecutarMenu();

    } catch (IOException e) {
        e.printStackTrace();
    }
}
}