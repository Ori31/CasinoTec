import java.util.Scanner;

public class Backjack {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //Variables
        int nuevaCarta = 0;
        int puntuajeJugador = 0;

        //Bienvenida
        System.out.println("Bienvenido al juego de Black Jack");
        //Se da la primera carta
        nuevaCarta = (int)(Math.random()*10 + 1);
        puntuajeJugador = puntuajeJugador + nuevaCarta;
        System.out.println("Su primera carta tiene un valor de: " + nuevaCarta);
        //Se da la segunda carta
        nuevaCarta = (int)(Math.random()*10 + 1);
        puntuajeJugador = puntuajeJugador + nuevaCarta;
        System.out.println("Su segunda carta tiene un valor de: " + nuevaCarta);
        System.out.println("Con un puntuaje total de: " + puntuajeJugador);
        //Se pregunta si va continuar
        System.out.println("Desea una carta más? S/N");
        String deseo = sc.nextLine();

        while (deseo == ) {
            
        }

    }
}
