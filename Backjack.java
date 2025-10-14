import java.util.Scanner;

public class Blackjack {

    // Método personalizado para pausar mensajes
    public static void pausaMensaje(String mensaje) {
        try {
            Thread.sleep(1000); 
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt(); 
            System.out.println("No deberías poder ver este mensaje.");
        }
        System.out.println(mensaje);
    }

    // Método para leer y validar la respuesta del jugador (S/N)
    public static char leerRespuesta(Scanner sc) {
        while (true) {
            System.out.println("¿Desea una carta más? S/N");
            String entrada = sc.nextLine();

            if (entrada.isEmpty()) {
                System.out.println("Error: No has introducido nada. Inténtalo de nuevo.");
                continue;
            }

            char respuesta = entrada.toUpperCase().charAt(0);
            if (respuesta == 'S' || respuesta == 'N') {
                return respuesta;
            }

            System.out.println("Error: Respuesta no válida. Por favor, introduce 'S' o 'N'.");
        }
    }

    public static void main(String[] args) throws InterruptedException {

        Scanner sc = new Scanner(System.in);

        // Variables del jugador
        int nuevaCarta = 0;
        int puntuajeJugador = 0;
        char deseo;
        boolean jugadorTieneBlackjack = false;
        int opcion;
        // Variables del croupier
        int cartaCroupier = 0;
        int puntuajeCroupier = 0; 
        
        do{
            System.out.println("==== Menú principal ====");
            System.out.println("1. Jugar");
            System.out.println("2. Ver reglas");
            System.out.println("3. Salir");
            System.out.println("Elige una opción ");
            opcion = sc.nextInt();
            sc.nextLine();
               
            switch (opcion) {
                
                case 1: //Jugar


                //Se resetean las variables en cada ciclo
                puntuajeJugador = 0;
                puntuajeCroupier = 0;
                jugadorTieneBlackjack = false;

                    System.out.println("======== BLACK JACK =======");

                    // Bienvenida
                    pausaMensaje("Bienvenido al juego de Blackjack, vamos a proceder con el juego.");

                    // Primera carta
                    nuevaCarta = (int)(Math.random()*10 + 1);
                    puntuajeJugador += nuevaCarta;
                    pausaMensaje("Su primera carta tiene un valor de: " + nuevaCarta);

                    // Segunda carta
                    nuevaCarta = (int)(Math.random()*10 + 1);
                    puntuajeJugador += nuevaCarta;
                    pausaMensaje("Su segunda carta tiene un valor de: " + nuevaCarta);
                    pausaMensaje("Con un puntuaje total de: " + puntuajeJugador);

                    // Comprobación inicial de Blackjack
                    if (puntuajeJugador == 21) {
                        pausaMensaje("¡BLACKJACK! Tienes 21 con tus primeras dos cartas.");
                        jugadorTieneBlackjack = true;
                    }

                    // Cartas del croupier
                    System.out.println();
                    Thread.sleep(2000);
                    System.out.println("Ahora voy a recibir mis cartas.");
                    cartaCroupier = (int)(Math.random()*10 + 1);
                    puntuajeCroupier += cartaCroupier;
                    pausaMensaje("La primera carta del croupier es: " + cartaCroupier);
                    pausaMensaje("La segunda carta está oculta.");

                    // Si el jugador no tiene Blackjack, se le pregunta si quiere más cartas
                    if (!jugadorTieneBlackjack) {
                        deseo = leerRespuesta(sc);

                        // Ciclo de pedir cartas
                        while (deseo == 'S' && puntuajeJugador < 21) {
                            nuevaCarta = (int)(Math.random()*10 + 1);
                            puntuajeJugador += nuevaCarta;
                            System.out.println("Su nueva carta tiene un valor de: " + nuevaCarta);
                            pausaMensaje("Con un puntuaje total de: " + puntuajeJugador);

                            if (puntuajeJugador > 21) {
                                pausaMensaje("Te pasaste por " + (puntuajeJugador - 21) + " puntos.");
                                pausaMensaje("Por ende, perdiste tras sobrepasar los 21 puntos!");
                                deseo = 'N'; 
                            } else if (puntuajeJugador == 21) {
                                pausaMensaje("¡Felicidades! tienes un puntuaje de 21.");
                                deseo = 'N'; 
                                jugadorTieneBlackjack = true;
                            } else {
                                deseo = leerRespuesta(sc);
                            }
                        }
                    }

                    // Turno del croupier
                    if (puntuajeJugador <= 21) {
                        pausaMensaje("Voy a proceder a revelar mi segunda carta.");
                        cartaCroupier = (int)(Math.random()*10 + 1);
                        Thread.sleep(1000);
                        System.out.print("Mi segunda carta es.");
                        Thread.sleep(500);
                        System.out.print(".");
                        Thread.sleep(500);
                        System.out.print(".");
                        Thread.sleep(2000);
                        System.out.println(" " + cartaCroupier);
                        puntuajeCroupier += cartaCroupier;
                        pausaMensaje("El croupier cuenta con una puntuación de: " + puntuajeCroupier);
                        System.out.println(" ");
                        Thread.sleep(1000);
                        
                        while (puntuajeCroupier <= 16) {
                            pausaMensaje("Tengo 16 o menos, por ende voy a pedir una carta.");
                            Thread.sleep(1000);
                            cartaCroupier = (int)(Math.random()*10 + 1);
                            puntuajeCroupier += cartaCroupier;
                            pausaMensaje("Mi nueva carta es: " + cartaCroupier);
                            pausaMensaje("Con una puntuación de: " + puntuajeCroupier);
                        }
                    }

                    // Resultado final
                    System.out.println();
                    pausaMensaje("===== RESULTADO FINAL =====");

                    if (puntuajeJugador > 21) {
                        pausaMensaje("Has perdido. La casa gana.");
                    } else if (puntuajeCroupier > 21) {
                        pausaMensaje("El croupier se ha pasado con " + puntuajeCroupier + " puntos. ¡Has ganado!");
                    } else if (jugadorTieneBlackjack && puntuajeCroupier != 21) {
                        pausaMensaje("¡Tienes 21! Ganas la partida.");
                    } else {
                        pausaMensaje("Tu puntuación final es: " + puntuajeJugador);
                        pausaMensaje("La puntuación final del croupier es: " + puntuajeCroupier);

                        if (puntuajeJugador > puntuajeCroupier) {
                            pausaMensaje("¡Tu puntuación es más alta! Has ganado.");
                        } else if (puntuajeCroupier > puntuajeJugador) {
                            pausaMensaje("La puntuación del croupier es más alta. La casa gana.");
                        } else {
                            pausaMensaje("¡Es un empate (Push)!");
                        } 
                    }
                    Thread.sleep(2000);
                    System.out.println(" ");
                    break; //Fin jugar  

            case 2: //Reglas
                System.out.println("Aqui deberian ir las reglas del juego pero tengo flojera");
                Thread.sleep(1000);
                System.out.println(" ");
                break; //Fin reglas

            case 3:
                System.out.println("Gracias por jugar, hasta luego.");
                break;

            default:
                pausaMensaje("Opcion no valida, intente de nuevo");
                Thread.sleep(1000);
                System.out.println(" ");
                continue;

            }//Fin switch

        } while (opcion != 3); //Fin do

        sc.close();

    } //Fin main

}//Fin de la clase ;p
