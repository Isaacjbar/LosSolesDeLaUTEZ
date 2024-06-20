package jbar.testthree;

import java.util.ArrayList;

public class Escena {
    private ArrayList<String> escenas;

    public Escena() {
        this.escenas = new ArrayList<>();
    }

    public void addScene(String escena) {
        escenas.add(escena);
    }

    public String obtenerEscena(int indice) {
        if (indice >= 0 && indice < escenas.size()) {
            return escenas.get(indice);
        } else {
            throw new IndexOutOfBoundsException("Índice fuera de rango: " + indice);
        }
    }

    public void eliminarEscena(int indice) {
        if (indice >= 0 && indice < escenas.size()) {
            escenas.remove(indice);
        } else {
            throw new IndexOutOfBoundsException("Índice fuera de rango: " + indice);
        }
    }

    public int obtenerNumeroDeEscenas() {
        return escenas.size();
    }

    public void imprimirEscenas() {
        for (String escena : escenas) {
            System.out.println(escena);
        }
    }

    public void limpiarEscenas() {
        escenas.clear();
    }

    @Override
    public String toString() {
        return "Escena{" +
                "escenas=" + escenas +
                '}';
    }

    public ArrayList<String> getEscenas() {
        return escenas;
    }

    public void setEscenas(ArrayList<String> escenas) {
        this.escenas = escenas;
    }
}

