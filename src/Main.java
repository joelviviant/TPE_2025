import java.io.*;
import java.util.*;

public class Main {
    static int totalPiezasObjetivo;
    static List<Maquina> maquinas;

    public static void main(String[] args) throws IOException {
        leerArchivo("config.txt");

        System.out.println("=== Backtracking ===");
        BacktrackingSolver bt = new BacktrackingSolver(maquinas, totalPiezasObjetivo);
        Solucion solBacktracking = bt.resolver();
        System.out.println(solBacktracking);

        System.out.println("\n=== Greedy ===");
        GreedySolver gr = new GreedySolver(maquinas, totalPiezasObjetivo);
        Solucion solGreedy = gr.resolver();
        System.out.println(solGreedy);
    }

    static void leerArchivo(String nombreArchivo) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(nombreArchivo));
        totalPiezasObjetivo = Integer.parseInt(br.readLine().trim());
        maquinas = new ArrayList<>();
        String linea;
        while ((linea = br.readLine()) != null) {
            String[] partes = linea.split(",");
            maquinas.add(new Maquina(partes[0], Integer.parseInt(partes[1])));
        }
        br.close();
    }
}
