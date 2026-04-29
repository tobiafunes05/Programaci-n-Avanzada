package Model;
 
import java.util.ArrayList;
import java.util.List;
 
public class Modelo {
    private List<Figura> figuras = new ArrayList<>();
 
    public void agregarFigura(Figura f) {
        figuras.add(f);
    }
 
    public List<Figura> getFiguras() {
        return figuras;
    }
 
    public void limpiar() {
        figuras.clear();
    }
}
 