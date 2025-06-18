import java.util.ArrayList;
import java.util.List;

public class Solucion {
    private final List<Maquina> secuencia;
    private final int totalPiezas;
    private final int puestasEnMarcha;
    private final int costo;

    public Solucion(List<Maquina> secuencia, int totalPiezas, int puestasEnMarcha, int costo) {
        this.secuencia = new ArrayList<>(secuencia);
        this.totalPiezas = totalPiezas;
        this.puestasEnMarcha = puestasEnMarcha;
        this.costo = costo;
    }

    public int getPuestasEnMarcha() {
        return puestasEnMarcha;
    }

    @Override
    public String toString() {
        return "Secuencia: " + secuencia +
                " | Piezas: " + totalPiezas +
                " | Puestas en marcha: " + puestasEnMarcha +
                " | Costo: " + costo;
    }
}