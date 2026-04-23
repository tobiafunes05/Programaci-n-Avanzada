/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.hilos;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Servidor {
    public static void main(String[] args) {
        try { 
            ServerSocket server = new ServerSocket(9923);
            System.out.println("Servidor iniciado...");

            while (true) {
                Socket cliente = server.accept(); 
                System.out.println("Nueva conexión");

                DataInputStream entrada = new DataInputStream(cliente.getInputStream());
                DataOutputStream salida = new DataOutputStream(cliente.getOutputStream());

                salida.writeUTF("Indica tu nombre:");
                String nombreCliente = entrada.readUTF();

                ServidorHilos hilo = new ServidorHilos(entrada, salida, nombreCliente);
                hilo.start();

                System.out.println("Cliente conectado: " + nombreCliente);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
       public static ArrayList<String> listaNombres = new ArrayList<>();
    public static ArrayList<ServidorHilos> clientes = new ArrayList<>();

    
    public static void eliminarCliente(ServidorHilos cliente) {
        listaNombres.remove(cliente.getNombreCliente());
        clientes.remove(cliente);
        
        System.out.println("Cliente eliminado: " + cliente.getNombreCliente());
        System.out.println("Lista actualizada: " + listaNombres);
    }

}