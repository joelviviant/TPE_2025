import java.util.*;

/*
 * Estrategia Greedy:
 * - Siempre se elige la máquina con mayor producción que no exceda el objetivo restante.
 * - No garantiza óptimo, pero es eficiente.
 */
public class GreedySolver {
    private List<Maquina> maquinas;
    private int objetivo;

    public GreedySolver(List<Maquina> maquinas, int objetivo) {
        this.maquinas = maquinas;
        this.objetivo = objetivo;
    }

    public Solucion resolver() {
        List<Maquina> secuencia = new ArrayList<>();
        int suma = 0;
        int candidatosConsiderados = 0;

        while (suma < objetivo) {
            Maquina mejor = null;
            for (Maquina m : maquinas) {
                candidatosConsiderados++;
                if (suma + m.piezas <= objetivo) {
                    if (mejor == null || m.piezas > mejor.piezas) {
                        mejor = m;
                    }
                }
            }
            if (mejor == null) break;
            secuencia.add(mejor);
            suma += mejor.piezas;
        }
        return new Solucion(secuencia, suma, secuencia.size(), candidatosConsiderados);
    }
}
