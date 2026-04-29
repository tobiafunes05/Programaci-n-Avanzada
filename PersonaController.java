/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import model.Persona;
import model.ValidadorPersona;
import view.FormularioView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class PersonaController {

    private FormularioView vista;
    private List<Persona> listaPersonas;

    public PersonaController(FormularioView vista) {
        this.vista = vista;
        this.listaPersonas = new ArrayList<>();

        initEventos();
    }

    private void initEventos() {

        // Botón Validar
        vista.btnValidar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                validarFormulario();
            }
        });

        // Botón Guardar
        vista.btnGuardar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (validarFormulario()) {
                    guardarPersona();
                }
            }
        });

        // Botón Limpiar
        vista.btnLimpiar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                vista.limpiarCampos();
            }
        });

        // Botón Cerrar
        vista.btnCerrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }

    // Valida todos los campos y muestra errores en la vista
    // Devuelve true si todo es válido, false si hay algún error
    private boolean validarFormulario() {
        boolean valido = true;

        // Nombre
        String errorNombre = ValidadorPersona.validarNombre(vista.txtNombre.getText());
        vista.mostrarError(vista.lblErrorNombre, errorNombre);
        if (errorNombre != null) valido = false;

        // Apellido
        String errorApellido = ValidadorPersona.validarApellido(vista.txtApellido.getText());
        vista.mostrarError(vista.lblErrorApellido, errorApellido);
        if (errorApellido != null) valido = false;

        // DNI y Pasaporte (exclusividad)
        String errorDniPasaporte = ValidadorPersona.validarDniOPasaporte(
                vista.txtDni.getText(), vista.txtPasaporte.getText());
        vista.mostrarError(vista.lblErrorDniPasaporte, errorDniPasaporte);
        if (errorDniPasaporte != null) valido = false;

        // DNI (solo si tiene contenido)
        if (!vista.txtDni.getText().trim().isEmpty()) {
            String errorDni = ValidadorPersona.validarDni(vista.txtDni.getText());
            vista.mostrarError(vista.lblErrorDni, errorDni);
            if (errorDni != null) valido = false;
        } else {
            vista.mostrarError(vista.lblErrorDni, null);
        }

        // Pasaporte (solo si tiene contenido)
        if (!vista.txtPasaporte.getText().trim().isEmpty()) {
            String errorPasaporte = ValidadorPersona.validarPasaporte(vista.txtPasaporte.getText());
            vista.mostrarError(vista.lblErrorPasaporte, errorPasaporte);
            if (errorPasaporte != null) valido = false;
        } else {
            vista.mostrarError(vista.lblErrorPasaporte, null);
        }

        // Teléfono
        String errorTelefono = ValidadorPersona.validarTelefono(vista.txtTelefono.getText());
        vista.mostrarError(vista.lblErrorTelefono, errorTelefono);
        if (errorTelefono != null) valido = false;

        // Código Postal
        String errorCp = ValidadorPersona.validarCodigoPostal(vista.txtCodigoPostal.getText());
        vista.mostrarError(vista.lblErrorCodigoPostal, errorCp);
        if (errorCp != null) valido = false;

        // Domicilio
        String errorDomicilio = ValidadorPersona.validarDomicilio(vista.txtDomicilio.getText());
        vista.mostrarError(vista.lblErrorDomicilio, errorDomicilio);
        if (errorDomicilio != null) valido = false;

        return valido;
    }

    private void guardarPersona() {
        Persona persona = new Persona(
                vista.txtNombre.getText().trim(),
                vista.txtApellido.getText().trim(),
                vista.txtDni.getText().trim(),
                vista.txtPasaporte.getText().trim(),
                vista.txtTelefono.getText().trim(),
                vista.txtCodigoPostal.getText().trim(),
                vista.txtDomicilio.getText().trim()
        );

        listaPersonas.add(persona);
        vista.mostrarMensaje("✓ Persona guardada correctamente.\nTotal en memoria: "
                + listaPersonas.size());
        vista.limpiarCampos();
    }

    // Por si necesitás acceder a la lista desde otro lado
    public List<Persona> getListaPersonas() {
        return listaPersonas;
    }
}