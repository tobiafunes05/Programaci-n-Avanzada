/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

public class Persona {

    private String nombre;
    private String apellido;
    private String dni;
    private String pasaporte;
    private String telefono;
    private String codigoPostal;
    private String domicilio;

    public Persona(String nombre, String apellido, String dni, String pasaporte,
                   String telefono, String codigoPostal, String domicilio) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.pasaporte = pasaporte;
        this.telefono = telefono;
        this.codigoPostal = codigoPostal;
        this.domicilio = domicilio;
    }

    // Getters
    public String getNombre() { return nombre; }
    public String getApellido() { return apellido; }
    public String getDni() { return dni; }
    public String getPasaporte() { return pasaporte; }
    public String getTelefono() { return telefono; }
    public String getCodigoPostal() { return codigoPostal; }
    public String getDomicilio() { return domicilio; }

    // Setters
    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setApellido(String apellido) { this.apellido = apellido; }
    public void setDni(String dni) { this.dni = dni; }
    public void setPasaporte(String pasaporte) { this.pasaporte = pasaporte; }
    public void setTelefono(String telefono) { this.telefono = telefono; }
    public void setCodigoPostal(String codigoPostal) { this.codigoPostal = codigoPostal; }
    public void setDomicilio(String domicilio) { this.domicilio = domicilio; }

    @Override
    public String toString() {
        return apellido + ", " + nombre + " (DNI: " + dni + ")";
    }
}