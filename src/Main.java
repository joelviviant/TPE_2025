import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Maquina> maquinas = new ArrayList<>();
        int totalPiezasObjetivo;

        // --- lectura y validación ---
        try (BufferedReader br = new BufferedReader(new FileReader("config.txt"))) {
            String linea = br.readLine();
            if (linea == null) {
                System.err.println("El archivo está vacío.");
                return;
            }
            totalPiezasObjetivo = Integer.parseInt(linea.trim());

            while ((linea = br.readLine()) != null) {
                linea = linea.trim();
                if (linea.isEmpty()) continue;
                String[] partes = linea.split(",");
                if (partes.length != 2) {
                    System.err.println("Formato inválido: " + linea);
                    continue;
                }
                String nombre = partes[0].trim();
                int piezas;
                try {
                    piezas = Integer.parseInt(partes[1].trim());
                } catch (NumberFormatException e) {
                    System.err.println("Número inválido en línea: " + linea);
                    continue;
                }
                maquinas.add(new Maquina(nombre, piezas));
            }
        } catch (IOException e) {
            System.err.println("Error leyendo config.txt: " + e.getMessage());
            return;
        }

        // --- Backtracking ---
        System.out.println("=== Backtracking ===");
        BacktrackingSolver bt = new BacktrackingSolver(maquinas, totalPiezasObjetivo);
        Solucion solBT = bt.resolver();
        if (solBT != null) System.out.println(solBT);

        // --- Greedy ---
        System.out.println("\n=== Greedy ===");
        GreedySolver gr = new GreedySolver(maquinas, totalPiezasObjetivo);
        Solucion solGR = gr.resolver();
        if (solGR != null) System.out.println(solGR);
    }
}
