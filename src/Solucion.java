import java.util.*;

public class Solucion {
    List<Maquina> secuencia;
    int totalPiezas;
    int puestasEnMarcha;
    int costo;

    public Solucion(List<Maquina> secuencia, int totalPiezas, int puestasEnMarcha, int costo) {
        this.secuencia = new ArrayList<>(secuencia);
        this.totalPiezas = totalPiezas;
        this.puestasEnMarcha = puestasEnMarcha;
        this.costo = costo;
    }

    @Override
    public String toString() {
        return "Secuencia: " + secuencia +
                " | Piezas: " + totalPiezas +
                " | Puestas en marcha: " + puestasEnMarcha +
                " | Costo: " + costo;
    }
}