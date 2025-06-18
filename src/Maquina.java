public class Maquina {
    private final String nombre;
    private final int piezas;

    public Maquina(String nombre, int piezas) {
        this.nombre = nombre;
        this.piezas = piezas;
    }

    public int getPiezas() {
        return piezas;
    }

    @Override
    public String toString() {
        return nombre;
    }
}