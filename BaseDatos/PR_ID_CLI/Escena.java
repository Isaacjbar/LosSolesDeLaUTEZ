import java.util.ArrayList;

public class Escena {
    // Atributo: lista de escenas
    private ArrayList<String> escenas;

    // Constructor sin parámetros
    public Escena() {
        this.escenas = new ArrayList<>();
    }
    // Método para agregar una nueva escena
    public void addScene(String escena) {
        escenas.add(escena);
    }

    // Método para obtener una escena por índice
    public String obtenerEscena(int indice) {
        if (indice >= 0 && indice < escenas.size()) {
            return escenas.get(indice);
        } else {
            throw new IndexOutOfBoundsException("Índice fuera de rango: " + indice);
        }
    }

    // Método para eliminar una escena por índice
    public void eliminarEscena(int indice) {
        if (indice >= 0 && indice < escenas.size()) {
            escenas.remove(indice);
        } else {
            throw new IndexOutOfBoundsException("Índice fuera de rango: " + indice);
        }
    }

    // Método para obtener el número de escenas
    public int obtenerNumeroDeEscenas() {
        return escenas.size();
    }

    // Método para imprimir todas las escenas
    public void imprimirEscenas() {
        for (String escena : escenas) {
            System.out.println(escena);
        }
    }

    // Método para limpiar todas las escenas
    public void limpiarEscenas() {
        escenas.clear();
    }

    // Método toString para imprimir la lista de escenas
    @Override
    public String toString() {
        return "Escena{" +
                "escenas=" + escenas +
                '}';
    }

    // Getters y Setters
    public ArrayList<String> getEscenas() {
        return escenas;
    }

    public void setEscenas(ArrayList<String> escenas) {
        this.escenas = escenas;
    }
}

