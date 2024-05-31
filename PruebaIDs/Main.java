package PruebaIDs;

import java.util.ArrayList;
import java.util.Scanner;

public class Main{
    public static void main(String[] args) {

        ArrayList<String> Historia = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        boolean crearHistoria = true, crearEscena = true;
        int h=0,e=0;

        //CREAR HISTORIAS
        while(crearHistoria==true){

            System.out.println("Titulo de la historia #"+(h+1));
            Historia.add(sc.next());
            
            System.out.println("Titulo de historia #"+(h+1)+": "+ Historia.get(h));
            System.out.println("¿Deseas crear otra historia? \n Si(1) No(2)");
            
            if(sc.nextInt()==1){
                crearHistoria=true;
            } else {
                crearHistoria=false;
            }
            h++;
        }
        crearHistoria=true;

        //CREAR ESCENAS
        while(crearEscena==true){

            System.out.println("Id de historia");
            Historia.add(sc.next());
            System.out.println("Titulo de historia #"+(e+1)+": "+ Historia.get(e));
            System.out.println("¿Deseas crear otra historia? \n Si(1) No(2)");
            
            if(sc.nextInt()==1){
                crearEscena=true;
            } else {
                crearEscena=false;
            }
            e++;
        }
    }
    
}
