import java.util.*;

/*
 * Estrategia Backtracking:
 * - Se exploran todas las secuencias posibles de puestas en marcha.
 * - Estado final: suma == totalPiezasObjetivo.
 * - Poda: si suma > totalPiezasObjetivo o si la secuencia ya es peor que la mejor.
 */
public class BacktrackingSolver {
    private List<Maquina> maquinas;
    private int objetivo;
    private int estadosGenerados;
    private Solucion mejorSolucion;

    public BacktrackingSolver(List<Maquina> maquinas, int objetivo) {
        this.maquinas = maquinas;
        this.objetivo = objetivo;
        this.estadosGenerados = 0;
        this.mejorSolucion = null;
    }

    public Solucion resolver() {
        backtracking(new ArrayList<>(), 0);
        return mejorSolucion;
    }

    private void backtracking(List<Maquina> actual, int suma) {
        estadosGenerados++;

        if (suma > objetivo) return;
        if (suma == objetivo) {
            if (mejorSolucion == null || actual.size() < mejorSolucion.puestasEnMarcha) {
                mejorSolucion = new Solucion(actual, suma, actual.size(), estadosGenerados);
            }
            return;
        }

        for (Maquina m : maquinas) {
            actual.add(m);
            backtracking(actual, suma + m.piezas);
            actual.remove(actual.size() - 1);
        }
    }
}
