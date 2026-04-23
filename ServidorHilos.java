/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.hilos;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
 
public class ServidorHilos extends Thread {
 
    private DataInputStream entrada;
    private DataOutputStream salida;
    private String nombreCliente;
 
    public ServidorHilos(DataInputStream entrada, DataOutputStream salida, String nombreCliente) {
        this.entrada = entrada;
        this.salida = salida;
        this.nombreCliente = nombreCliente;
    }
 
    public String getNombreCliente() {
        return nombreCliente;
    }
 
   
    public void enviarMensaje(String msg) throws IOException {
        salida.writeUTF(msg);
        salida.flush();
    }
 
    @Override
    public void run() {
       
        Servidor.listaNombres.add(this.nombreCliente);
        Servidor.clientes.add(this);
 
        System.out.println("Lista actualizada: " + Servidor.listaNombres);
 
        int opc;
 
        while (true) {
            try {
                opc = entrada.readInt();
 
                switch (opc) {
                    case 1:
                        enviarMensaje(obtenerFechaHora());
                        break;
 
                    case 2:
                        int n1 = entrada.readInt();
                        int n2 = entrada.readInt();
                        int n3 = entrada.readInt();
                        int resultado = n1 * n2 * n3;
 
                        enviarMensaje("Resultado de la multiplicación: " + resultado);
                        break;
 
                    case 3:
                        enviarMensaje("Conectados: " + Servidor.listaNombres);
                        break;
 
                    case 4:
                        String destinatarioInput = entrada.readUTF();
                        String mensajeAEnviar = entrada.readUTF();
 
                        String formatoMensaje = "[" + nombreCliente + " dice]: " + mensajeAEnviar;
 
                        if (destinatarioInput.equalsIgnoreCase("TODOS")) {
                            for (int i = 0; i < Servidor.clientes.size(); i++) {
                                Servidor.clientes.get(i).enviarMensaje(formatoMensaje);
                            }
                        } else {
                            String[] nombres = destinatarioInput.split(",");
 
                            for (int i = 0; i < nombres.length; i++) {
                                String nombreLimpio = nombres[i].trim();
                                boolean encontrado = false;
 
                                for (int j = 0; j < Servidor.clientes.size(); j++) {
                                    ServidorHilos cliente = Servidor.clientes.get(j);
                                    if (cliente.getNombreCliente().equalsIgnoreCase(nombreLimpio)) {
                                        cliente.enviarMensaje(formatoMensaje);
                                        encontrado = true;
                                        break;
                                    }
                                }
 
                                if (!encontrado) {
                                    this.enviarMensaje("SISTEMA: El usuario '" + nombreLimpio + "' no existe o está desconectado.");
                                }
                            }
                        }
                        this.enviarMensaje("MENSAJE ENVIADO");
                        break;
 
                    case 5:
                        System.out.println("Cliente desconectado: " + nombreCliente);
                        Servidor.eliminarCliente(this);
                        return;
 
                    default:
                        System.out.println("Opción inválida");
                }
 
            } catch (IOException ex) {
                System.out.println("Cliente desconectado por error: " + nombreCliente);
                Servidor.eliminarCliente(this);
                break;
            }
        }
    }
 
    public static String obtenerFechaHora() {
        LocalDateTime ahora = LocalDateTime.now();
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        return ahora.format(formato);
    }
}