package PruebaIDs;

import java.util.ArrayList;
import java.util.Scanner;

public class Escena {
    String[][] historiaA = new String[200][2];
    int currentSize = 0; // Para rastrear el número de escenas añadidas
    String tituloHistoria; // Título de la historia

    // Constructor para inicializar el título de la historia
    public Escena(String titulo) {
        this.tituloHistoria = titulo;
    }

    // Método para agregar una escena
    public void agregarEscena(String id, String titulo) {
        if (currentSize < historiaA.length) {
            historiaA[currentSize][0] = id;
            historiaA[currentSize][1] = titulo;
            currentSize++;
        } else {
            System.out.println("No se pueden agregar más escenas, la matriz está llena.");
        }
    }

    // Método para obtener una escena por ID
    public String obtenerTituloPorID(String id) {
        for (int i = 0; i < currentSize; i++) {
            if (historiaA[i][0].equals(id)) {
                return historiaA[i][1];
            }
        }
        return "Escena no encontrada";
    }

    // Método para listar todas las escenas
    public void listarEscenas() {
        System.out.println("Título de la historia: " + tituloHistoria);
        for (int i = 0; i < currentSize; i++) {
            System.out.println("ID: " + historiaA[i][0] + " - Título: " + historiaA[i][1]);
        }
    }
}