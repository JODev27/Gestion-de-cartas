package proyectofinal;

import java.util.Scanner;

public class ProyectoFinal {

    public static void main(String[] args) {
        //Crear recursos
        Scanner scanner = new Scanner(System.in);
        Baraja baraja = new Baraja();
        int opcion;
        
        //Imprimir baraja
        System.out.println("Baraja original:");
        baraja.mostrarBaraja();
        do {
            //Menu
            System.out.println("\n--- Menú ---");
            System.out.println("1. Barajar la baraja");
            System.out.println("2. Robar primera carta");
            System.out.println("3. Ver primera carta sin alterar la baraja");
            System.out.println("4. Robar última carta");
            System.out.println("5. Vaciar la baraja");
            System.out.println("6. Ordenar la baraja");
            System.out.println("7. Salir");
            System.out.print("Ingrese su opción: ");
            
            opcion = scanner.nextInt();
            
            //Casos
            switch (opcion) {
                case 1:
                    //Barajar baraja e imprimir
                    baraja.barajar();
                    System.out.println("Baraja barajada.");
                    baraja.mostrarBaraja();
                    break;
                case 2:
                    //Imprimir la carta robada y baraja actualizada
                    Carta primeraCarta = baraja.retirarPrimeraCarta();
                    if (primeraCarta != null) {
                        System.out.println("Carta robada: " + primeraCarta);
                        System.out.println("\nBaraja después de retirar la primera carta:");
                        baraja.mostrarBaraja();
                    } else {
                        System.out.println("La baraja está vacía.");
                    }
                    break;
                case 3:
                    //Ver primera carta sin alterar baraja
                    baraja.retirarPrimeraCartaSinModificar();
                    break;
                case 4:
                    //Robar ultima carta
                    Carta ultimaCarta = baraja.robarUltimaCarta();
                    if (ultimaCarta != null) {
                        System.out.println("carta robada: " + ultimaCarta);
                        System.out.println("\nBaraja después de robar la última carta:");
                        baraja.mostrarBaraja();
                    } else {
                        System.out.println("La baraja está vacía.");
                    }
                    break;
                case 5:
                    //Vaciar baraja
                    baraja.vaciarBaraja();
                    System.out.println("La baraja ha sido vaciada.");
                    break;
                case 6:
                    //Merge Sort
                    baraja.ordenar();
                    System.out.println("La baraja ha sido ordenada.");
                    baraja.mostrarBaraja();
                    break;
                case 7:
                    //Finalizar
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, ingrese una opción válida.");
            }
        } while (opcion != 7);

        scanner.close();
        

    }
    
}
