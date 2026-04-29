package Controlador;
 
import Model.Figura;
import Model.Modelo;
import javax.swing.JOptionPane;
import vista.Vista;
 
public class Controlador {
    private Modelo modelo;
    private Vista vista;
 
    public Controlador(Modelo modelo, Vista vista) {
        this.modelo = modelo;
        this.vista = vista;
        vista.btnAgregar.addActionListener(e -> agregarFigura());
        vista.btnLimpiar.addActionListener(e -> limpiar());
    }
 
    private void agregarFigura() {
        try {
            String tipo = vista.comboTipo.getSelectedItem().toString();
            int x = Integer.parseInt(vista.txtX.getText());
            int y = Integer.parseInt(vista.txtY.getText());
            int tamano = Integer.parseInt(vista.txtTamano.getText());
 
            // Validación de rango 1-20
            if (x < 1 || x > 20 || y < 1 || y > 20 || tamano < 1 || tamano > 20) {
                JOptionPane.showMessageDialog(
                    null,
                    "Los valores de X, Y y Tamaño deben estar entre 1 y 20.",
                    "Valor fuera de rango",
                    JOptionPane.WARNING_MESSAGE
                );
                return;
            }
 
            int confirm = JOptionPane.showConfirmDialog(
                null,
                "Tipo: " + tipo + "\nX: " + x + "\nY: " + y + "\nTamaño: " + tamano,
                "Confirmar datos",
                JOptionPane.YES_NO_OPTION
            );
 
            if (confirm == JOptionPane.YES_OPTION) {
                modelo.agregarFigura(new Figura(tipo, x, y, tamano));
                vista.panel.repaint();
            }
 
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(
                null,
                "Ingresá solo números enteros en X, Y y Tamaño.",
                "Dato inválido",
                JOptionPane.ERROR_MESSAGE
            );
        }
    }
 
    private void limpiar() {
        modelo.limpiar();
        vista.panel.repaint();
    }
}