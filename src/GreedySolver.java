import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class GreedySolver {
    private final List<Maquina> maquinas;
    private final int objetivo;

    /*
     * Estrategia Greedy:
     *
     * - En cada paso, se consideran como candidatos todas las máquinas disponibles.
     * - Se selecciona la máquina que más piezas produce sin exceder el objetivo restante.
     * - Se repite hasta alcanzar el total de piezas o hasta que ya no haya candidatos válidos.
     * - No garantiza una solución óptima, pero es eficiente en tiempo.
     * - Un estado solución es cualquier secuencia que alcanza exactamente la cantidad objetivo.
     * - Se cuenta la cantidad de candidatos evaluados como métrica de costo.
     */

    public GreedySolver(List<Maquina> maquinas, int objetivo) {
        this.maquinas = new ArrayList<>(maquinas);
        this.objetivo = objetivo;
    }

    public Solucion resolver() {
        // pre-ordeno de mayor a menor producción
        maquinas.sort(Comparator.comparingInt(Maquina::getPiezas).reversed());

        List<Maquina> secuencia = new ArrayList<>();
        int suma = 0, candidatosConsiderados = 0;

        while (suma < objetivo) {
            Maquina elegido = null;
            // tomo el primero que quepa, cuento sólo esos candidatos
            for (Maquina m : maquinas) {
                if (suma + m.getPiezas() <= objetivo) {
                    candidatosConsiderados++;
                    elegido = m;
                    break;
                }
            }
            if (elegido == null) break;
            secuencia.add(elegido);
            suma += elegido.getPiezas();
        }

        if (suma < objetivo) {
            System.out.println("Greedy: no se pudo alcanzar " + objetivo + " piezas.");
            return null;
        }
        return new Solucion(secuencia, suma, secuencia.size(), candidatosConsiderados);
    }
}