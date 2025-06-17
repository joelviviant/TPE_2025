public class Maquina {
    String nombre;
    int piezas;

    public Maquina(String nombre, int piezas) {
        this.nombre = nombre;
        this.piezas = piezas;
    }

    @Override
    public String toString() {
        return nombre;
    }
}