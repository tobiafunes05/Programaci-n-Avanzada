/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.*;

public class FormularioView extends JFrame {

    // Campos del formulario
    public JTextField txtNombre;
    public JTextField txtApellido;
    public JTextField txtDni;
    public JTextField txtPasaporte;
    public JTextField txtTelefono;
    public JTextField txtCodigoPostal;
    public JTextField txtDomicilio;

    // Labels de error
    public JLabel lblErrorNombre;
    public JLabel lblErrorApellido;
    public JLabel lblErrorDni;
    public JLabel lblErrorPasaporte;
    public JLabel lblErrorDniPasaporte;
    public JLabel lblErrorTelefono;
    public JLabel lblErrorCodigoPostal;
    public JLabel lblErrorDomicilio;

    // Botones
    public JButton btnGuardar;
    public JButton btnValidar;
    public JButton btnLimpiar;
    public JButton btnCerrar;

    public FormularioView() {
        setTitle("Formulario de Persona");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(480, 680);
        setLocationRelativeTo(null);
        setResizable(false);

        initComponentes();
        initValidacionesEnCampo();
    }

    private void initComponentes() {
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(20, 30, 20, 30));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(2, 5, 0, 5);
        gbc.weightx = 1.0;

        // ── Título ───────────────────────────────────────────────────
        JLabel lblTitulo = new JLabel("Carga de Contacto", SwingConstants.CENTER);
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 18));
        lblTitulo.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));

        gbc.gridx = 0; gbc.gridy = 0; gbc.gridwidth = 2;
        gbc.insets = new Insets(0, 5, 15, 5);
        panel.add(lblTitulo, gbc);

        // Resetear para las filas de campos
        gbc.gridwidth = 1;

        // Inicializar campos
        txtNombre       = new JTextField(20);
        txtApellido     = new JTextField(20);
        txtDni          = new JTextField(20);
        txtPasaporte    = new JTextField(20);
        txtTelefono     = new JTextField(20);
        txtCodigoPostal = new JTextField(20);
        txtDomicilio    = new JTextField(20);

        // Inicializar labels de error
        lblErrorNombre       = crearLabelError();
        lblErrorApellido     = crearLabelError();
        lblErrorDni          = crearLabelError();
        lblErrorPasaporte    = crearLabelError();
        lblErrorDniPasaporte = crearLabelError();
        lblErrorTelefono     = crearLabelError();
        lblErrorCodigoPostal = crearLabelError();
        lblErrorDomicilio    = crearLabelError();

        // Botones
        btnGuardar = new JButton("Guardar");
        btnValidar = new JButton("Validar");
        btnLimpiar = new JButton("Limpiar");
        btnCerrar  = new JButton("Cerrar");

        // Agregar filas (empezamos en 1 porque el título ocupa la 0)
        int fila = 1;
        fila = agregarFila(panel, gbc, fila, "Nombre:",        txtNombre,       lblErrorNombre);
        fila = agregarFila(panel, gbc, fila, "Apellido:",      txtApellido,     lblErrorApellido);
        fila = agregarFila(panel, gbc, fila, "DNI:",           txtDni,          lblErrorDni);
        fila = agregarFila(panel, gbc, fila, "Pasaporte:",     txtPasaporte,    lblErrorPasaporte);

        // Error compartido DNI/Pasaporte
        gbc.gridx = 0; gbc.gridy = fila; gbc.gridwidth = 2;
        gbc.insets = new Insets(0, 5, 0, 5);
        panel.add(lblErrorDniPasaporte, gbc);
        fila++;

        fila = agregarFila(panel, gbc, fila, "Teléfono:",      txtTelefono,     lblErrorTelefono);
        fila = agregarFila(panel, gbc, fila, "Código Postal:", txtCodigoPostal, lblErrorCodigoPostal);
        fila = agregarFila(panel, gbc, fila, "Domicilio:",     txtDomicilio,    lblErrorDomicilio);

        // Panel de botones
        JPanel panelBotones = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 0));
        panelBotones.add(btnGuardar);
        panelBotones.add(btnValidar);
        panelBotones.add(btnLimpiar);
        panelBotones.add(btnCerrar);

        gbc.gridx = 0; gbc.gridy = fila; gbc.gridwidth = 2;
        gbc.insets = new Insets(20, 5, 5, 5);
        panel.add(panelBotones, gbc);

        add(panel);
    }

    private int agregarFila(JPanel panel, GridBagConstraints gbc,
                             int fila, String labelTexto,
                             JTextField campo, JLabel labelError) {
        gbc.gridwidth = 1;
        gbc.insets = new Insets(8, 5, 0, 5);

        // Label
        gbc.gridx = 0; gbc.gridy = fila; gbc.weightx = 0.3;
        panel.add(new JLabel(labelTexto), gbc);

        // Campo
        gbc.gridx = 1; gbc.weightx = 0.7;
        panel.add(campo, gbc);
        fila++;

        // Error debajo del campo
        gbc.gridx = 1; gbc.gridy = fila;
        gbc.insets = new Insets(0, 5, 0, 5);
        panel.add(labelError, gbc);
        fila++;

        return fila;
    }

    private JLabel crearLabelError() {
        JLabel lbl = new JLabel(" ");
        lbl.setForeground(Color.RED);
        lbl.setFont(new Font("Arial", Font.PLAIN, 11));
        return lbl;
    }

    // ── Validaciones EN campo (tiempo real) ──────────────────────────

    private void initValidacionesEnCampo() {

        // Nombre y Apellido: solo letras en tiempo real
        bloquearNoAlfabetico(txtNombre);
        bloquearNoAlfabetico(txtApellido);

        // DNI y Pasaporte mutuamente excluyentes
        txtDni.getDocument().addDocumentListener(new DocumentListener() {
            public void insertUpdate(DocumentEvent e)  { actualizarExclusividad(); }
            public void removeUpdate(DocumentEvent e)  { actualizarExclusividad(); }
            public void changedUpdate(DocumentEvent e) { actualizarExclusividad(); }
        });

        txtPasaporte.getDocument().addDocumentListener(new DocumentListener() {
            public void insertUpdate(DocumentEvent e)  { actualizarExclusividad(); }
            public void removeUpdate(DocumentEvent e)  { actualizarExclusividad(); }
            public void changedUpdate(DocumentEvent e) { actualizarExclusividad(); }
        });
    }

    private void bloquearNoAlfabetico(JTextField campo) {
        campo.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!Character.isLetter(c) && !Character.isWhitespace(c)) {
                    e.consume();
                }
            }
        });
    }

    private void actualizarExclusividad() {
        boolean dniTieneTexto       = !txtDni.getText().trim().isEmpty();
        boolean pasaporteTieneTexto = !txtPasaporte.getText().trim().isEmpty();

        txtPasaporte.setEnabled(!dniTieneTexto);
        txtDni.setEnabled(!pasaporteTieneTexto);

        if (!(dniTieneTexto && pasaporteTieneTexto)) {
            lblErrorDniPasaporte.setText(" ");
        }
    }

    // ── Métodos públicos para el Controller ──────────────────────────

    public void mostrarError(JLabel label, String mensaje) {
        label.setText(mensaje != null ? mensaje : " ");
    }

    public void limpiarCampos() {
        txtNombre.setText("");
        txtApellido.setText("");
        txtDni.setText("");
        txtPasaporte.setText("");
        txtTelefono.setText("");
        txtCodigoPostal.setText("");
        txtDomicilio.setText("");

        txtDni.setEnabled(true);
        txtPasaporte.setEnabled(true);

        lblErrorNombre.setText(" ");
        lblErrorApellido.setText(" ");
        lblErrorDni.setText(" ");
        lblErrorPasaporte.setText(" ");
        lblErrorDniPasaporte.setText(" ");
        lblErrorTelefono.setText(" ");
        lblErrorCodigoPostal.setText(" ");
        lblErrorDomicilio.setText(" ");
    }

    public void mostrarMensaje(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje);
    }
}