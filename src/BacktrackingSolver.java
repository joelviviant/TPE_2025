import java.util.ArrayList;
import java.util.List;

public class BacktrackingSolver {
    private final List<Maquina> maquinas;
    private final int objetivo;
    private int estadosGenerados;
    private Solucion mejorSolucion;

    public BacktrackingSolver(List<Maquina> maquinas, int objetivo) {
        // defensiva: lista inmutable
        this.maquinas = List.copyOf(maquinas);
        this.objetivo = objetivo;
        this.estadosGenerados = 0;
        this.mejorSolucion = null;
    }

    public Solucion resolver() {
        backtracking(new ArrayList<>(), 0);
        if (mejorSolucion == null) {
            System.out.println("Backtracking: no existe combinación que alcance " + objetivo + " piezas.");
        }
        return mejorSolucion;
    }

    private void backtracking(List<Maquina> actual, int suma) {
        estadosGenerados++;
        if (suma > objetivo) return;              // poda
        if (suma == objetivo) {
            // nueva mejor si aún no hay o usa menos máquinas
            if (mejorSolucion == null
                    || actual.size() < mejorSolucion.getPuestasEnMarcha()) {
                mejorSolucion = new Solucion(actual, suma, actual.size(), estadosGenerados);
            }
            return;
        }
        for (Maquina m : maquinas) {
            actual.add(m);
            backtracking(actual, suma + m.getPiezas());
            actual.remove(actual.size() - 1);
        }
    }
}