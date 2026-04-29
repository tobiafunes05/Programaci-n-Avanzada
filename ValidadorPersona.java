/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author juanjorge
 */
package model;


public class ValidadorPersona {

    // Nombre y Apellido: solo letras y espacios, máximo 20 caracteres
    public static String validarNombre(String nombre) {
        if (nombre == null || nombre.trim().isEmpty())
            return "El nombre no puede estar vacío.";
        if (nombre.length() > 20)
            return "El nombre no puede superar los 20 caracteres.";
        if (!nombre.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+"))
            return "El nombre solo puede contener letras.";
        return null; // null = válido
    }

    public static String validarApellido(String apellido) {
        if (apellido == null || apellido.trim().isEmpty())
            return "El apellido no puede estar vacío.";
        if (apellido.length() > 20)
            return "El apellido no puede superar los 20 caracteres.";
        if (!apellido.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+"))
            return "El apellido solo puede contener letras.";
        return null;
    }

    // DNI: exactamente 8 dígitos, entre 10.000.000 y 60.000.000
    public static String validarDni(String dni) {
        if (dni == null || dni.trim().isEmpty())
            return "El DNI no puede estar vacío.";
        if (!dni.matches("\\d{8}"))
            return "El DNI debe tener exactamente 8 dígitos numéricos.";
        int numero = Integer.parseInt(dni);
        if (numero < 10000000 || numero > 60000000)
            return "El DNI debe estar entre 10.000.000 y 60.000.000.";
        return null;
    }

    // Pasaporte: 1 letra A-Z seguida de 8 dígitos entre 10.000.000 y 60.000.000
    public static String validarPasaporte(String pasaporte) {
        if (pasaporte == null || pasaporte.trim().isEmpty())
            return "El pasaporte no puede estar vacío.";
        if (!pasaporte.matches("[A-Z]\\d{8}"))
            return "El pasaporte debe tener 1 letra mayúscula seguida de 8 dígitos.";
        int numero = Integer.parseInt(pasaporte.substring(1));
        if (numero < 10000000 || numero > 60000000)
            return "Los dígitos del pasaporte deben estar entre 10.000.000 y 60.000.000.";
        return null;
    }

    // Teléfono: más de 6 dígitos, puede contener +, (, ), -, espacios
    public static String validarTelefono(String telefono) {
        if (telefono == null || telefono.trim().isEmpty())
            return "El teléfono no puede estar vacío.";
        if (!telefono.matches("[+()\\-\\d ]+"))
            return "El teléfono solo puede contener dígitos, +, (, ), - y espacios.";
        String soloDigitos = telefono.replaceAll("[^\\d]", "");
        if (soloDigitos.length() <= 6)
            return "El teléfono debe tener más de 6 dígitos numéricos.";
        return null;
    }

    // Código postal: exactamente 4 dígitos numéricos
    public static String validarCodigoPostal(String cp) {
        if (cp == null || cp.trim().isEmpty())
            return "El código postal no puede estar vacío.";
        if (!cp.matches("\\d{4}"))
            return "El código postal debe tener exactamente 4 dígitos.";
        return null;
    }

    // Domicilio: máximo 50 caracteres
    public static String validarDomicilio(String domicilio) {
        if (domicilio == null || domicilio.trim().isEmpty())
            return "El domicilio no puede estar vacío.";
        if (domicilio.length() > 50)
            return "El domicilio no puede superar los 50 caracteres.";
        return null;
    }
    
    // DNI y Pasaporte son mutuamente excluyentes
public static String validarDniOPasaporte(String dni, String pasaporte) {
    boolean tieneDni = dni != null && !dni.trim().isEmpty();
    boolean tienePasaporte = pasaporte != null && !pasaporte.trim().isEmpty();

    if (tieneDni && tienePasaporte)
        return "Solo puede ingresar DNI o Pasaporte, no ambos.";
    if (!tieneDni && !tienePasaporte)
        return "Debe ingresar DNI o Pasaporte.";
    return null;
}
}
