import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Escena testOne = new Escena();
        boolean nu = true;
        String answer = "", algId = "A";
        Scanner sc = new Scanner(System.in);

        while (nu) {
            if (testOne.obtenerNumeroDeEscenas() == 0) {
                System.out.println("¿Desea crear la escena inicial? (y/n)");
                answer = sc.next();
                if (answer.equals("y")) {
                    testOne.addScene(algId);
                } else {
                    System.out.println("Que tengas un buen día :)");
                    nu = false;
                }
            } else {
                System.out.println("¿Deseas agregar una escena? (y/n)");
                answer = sc.next();
                if (answer.equals("y")) {
                    int large = algId.length();
                    // Add number after letter
                    if (algId.substring(large - 1).equals("A") || algId.substring(large - 1).equals("B")) {
                        if (large == 1) {
                            algId += "1";
                        } else {
                            algId += "1";
                        }
                    } else {
                        // Add letter after number
                        if (algId.substring(large - 1).equals("1")) {
                            if (large == 2) {
                                algId += "A";
                            } else {
                                algId += "A";
                            }
                        }
                    }
                    testOne.addScene(algId);
                } else {
                    System.out.println("Recuerda que eres el mejor :)");
                    nu = false;
                }
            }
        }
        
        // Imprimir todas las escenas agregadas
        System.out.println("Escenas agregadas:");
        testOne.imprimirEscenas();
    }
}