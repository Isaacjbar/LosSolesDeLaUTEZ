package PruebaIDs;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<Escena> historias = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        boolean crearHistoria = true;
        int h = 0;

        // CREAR HISTORIAS
        while (crearHistoria) {
            System.out.println("Título de la historia #" + (h + 1));
            String tituloHistoria = sc.next(); // Leer el título de la historia
            Escena nuevaHistoria = new Escena(tituloHistoria); // Crear nueva historia con título
            historias.add(nuevaHistoria);
            System.out.println("¿Deseas crear otra historia? \n Si(1) No(2)");

            if (sc.nextInt() == 1) {
                crearHistoria = true;
            } else {
                crearHistoria = false;
            }
            h++;
        }

        // CREAR ESCENAS
        for (int i = 0; i < historias.size(); i++) {
            Escena historiaActual = historias.get(i);
            boolean crearEscena = true;
            int e = 0;

            while (crearEscena) {
                System.out.println("ID de la escena #" + (e + 1) + " de la historia #" + (i + 1));
                String idEscena = sc.next();
                System.out.println("Título de la escena #" + (e + 1) + " de la historia #" + (i + 1));
                String tituloEscena = sc.next();
                historiaActual.agregarEscena(idEscena, tituloEscena);
                System.out.println("¿Deseas crear otra escena para esta historia? \n Si(1) No(2)");

                if (sc.nextInt() == 1) {
                    crearEscena = true;
                } else {
                    crearEscena = false;
                }
                e++;
            }
        }

        // Listar todas las historias y sus escenas
        for (int i = 0; i < historias.size(); i++) {
            System.out.println("Historia #" + (i + 1));
            historias.get(i).listarEscenas();
        }

        sc.close(); // Cerramos el Scanner al final del uso
    }
}