package NAV_ID;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Escena testOne = new Escena();
        boolean nu = true;
        String answer = "";
        Scanner sc = new Scanner(System.in);
        testOne.addScene("A");
        while (nu) {
            // Imprimir todas las escenas agregadas
            System.out.println("Escenas disponibles: ");
            testOne.imprimirEscenas(); 

            System.out.println("Ingresa ID de escena para agregar ramificaciones");
            answer = sc.next();

            int large = answer.length();
            // Add number after letter
            if (answer.substring(large - 1).equals("A") || answer.substring(large - 1).equals("B")) {
                testOne.addScene(answer+"1");
                testOne.addScene(answer+"2");
            } else {
                // Add letter after number
                testOne.addScene(answer+"A");
                testOne.addScene(answer+"B");
            }
        }
    }
}