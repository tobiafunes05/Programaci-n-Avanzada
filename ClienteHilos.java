/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.hilos;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.util.Scanner;

public class ClienteHilos extends Thread {
    
    private DataInputStream entrada; 
    private DataOutputStream salida;

    public ClienteHilos(DataInputStream entrada, DataOutputStream salida) {
        this.entrada = entrada;
        this.salida = salida;
    }
    
  
    @Override
    public void run() {
        try {
            while (true) {
              
                String mensajeCliente = entrada.readUTF();
                System.out.println("\n[MENSAJE RECIBIDO]: " + mensajeCliente);
                System.out.print("Opción: "); 
            }
        } catch (Exception e) {
            System.out.println("Conexión cerrada con el servidor.");
        }
    }

    
    public void ejecutarMenu() {
        Scanner sn = new Scanner(System.in); 
        int opc; 
         
        do {
            System.out.println("\n--- MENU ---");
            System.out.println("1. Fecha y hora");
            System.out.println("2. Multiplicación (Local)");
            System.out.println("3. Usuarios conectados");
            System.out.println("4. Enviar mensaje (1, 2 o TODOS)");
            System.out.println("5. Salir");
            System.out.print("Opción: ");
    
            opc = sn.nextInt(); 
            sn.nextLine(); // Limpiar buffer

            try {
                salida.writeInt(opc);
                salida.flush();

                switch (opc) {
                    case 2:
                        System.out.print("Num1: "); int n1 = sn.nextInt();
                        System.out.print("Num2: "); int n2 = sn.nextInt();
                        System.out.print("Num3: "); int n3 = sn.nextInt();
                        salida.writeInt(n1);
                        salida.writeInt(n2);
                        salida.writeInt(n3);
                        salida.flush();
                        break;
            
                    case 4:
                        System.out.println("Destinatario (Nombre, Nombre o TODOS): ");
                        String destino = sn.nextLine();
                        System.out.println("Mensaje: ");
                        String msj = sn.nextLine();
                        
                        salida.writeUTF(destino);
                        salida.writeUTF(msj);
                        salida.flush();
                        break;
        
                    case 5:
                        System.out.println("Saliendo...");
                        System.exit(0);
                        break;
                }

            } catch (Exception e) {
                e.printStackTrace();
            }

        } while (opc != 5); 
    }
}