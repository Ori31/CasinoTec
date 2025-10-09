import java.util.Scanner;

public class Backjack {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //Variables
        int nuevaCarta = 0;
        int puntuajeJugador = 0;
        char deseo;
        

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
        deseo = sc.nextLine().toUpperCase().charAt(0);

        //Ciclo para seguir dando cartas
        while (deseo == 'S' && puntuajeJugador < 21) {
            
            // Se genera la nueva
            nuevaCarta = (int)(Math.random()*10 + 1);
            puntuajeJugador = puntuajeJugador + nuevaCarta;
            System.out.println("Su nueva carta tiene un valor de : " + nuevaCarta);
            System.out.println("Con un puntuaje total de: " + puntuajeJugador);

            if (puntuajeJugador > 21){
            System.out.println("Te pasaste de 21! Perdiste.");
                System.out.println("Te pasaste por " + (puntuajeJugador - 21) + " puntos.");
                deseo = 'N';

            } else if (puntuajeJugador == 21) {
                System.out.println("Felicidades! tienes un puntuaje de 21, black jack!!!");
                deseo = 'N';

            } else {
                    System.out.println("¿Desea una carta más? S/N");
                    deseo = sc.nextLine().toUpperCase().charAt(0);
            }
        }


        sc.close();
    }
}
