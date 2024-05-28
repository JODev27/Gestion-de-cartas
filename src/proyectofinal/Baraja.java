package proyectofinal;

import java.util.Random;

public class Baraja {
    
    //Valores de la baraja
    private ListaDoble cartas;
    private static final String[] PALOS = {"Corazones", "Diamantes", "Tréboles", "Picas"};
    private static final String[] VALORES = {"2", "3", "4", "5", "6", "7", "8", "9","J", "Q", "K", "A"};
    
    //Crear baraja
     public Baraja() {
        cartas = new ListaDoble();
        for (String palos : PALOS) {
            for (String valor : VALORES) {
                cartas.agregarFinal(new Carta(palos, valor));
            }
        }
    }

    public void barajar() {
        
        int tamaño = cartas.contarNodos(); // Obtener el tamaño actual de la lista
        if (tamaño <= 1) {
            return; //Es ilógico barajar si la lista tiene 0 o 1 carta
        }
        
        NodoDoble actual = cartas.getInicio();
        Carta[] arrayCartas = new Carta[tamaño];
        int i = 0;
        

        // Copiar cartas de la lista a un array
        while (actual != null) {
            arrayCartas[i++] = actual.carta;
            actual = actual.siguiente;
        }

        // Barajar aleatoriamente las cartas
        Random random = new Random();
        Carta temp;
        for (i = 0; i < tamaño; i++) {
            int j = random.nextInt(tamaño);
            temp = arrayCartas[i];
            arrayCartas[i] = arrayCartas[j];
            arrayCartas[j] = temp;
        }

        // Copiar cartas del array de nuevo a la lista
        actual = cartas.getInicio();
        i = 0;
        while (actual != null) {
            actual.carta = arrayCartas[i++];
            actual = actual.siguiente;
        }
    }

    //Motrar baraja
    public void mostrarBaraja() {
        cartas.recorrer();
    }

    //Robar la primera carta
   public Carta retirarPrimeraCarta() {
        return cartas.retirarPrimeraCarta();
    }
   
   //Metodo baraja sin modificar
   public void retirarPrimeraCartaSinModificar() {
       
       //Cuando la baraja esta vacia
        if (cartas.getInicio()== null) {
            System.out.println("La baraja está vacía.");
            return;
        }
        
        ListaDoble copia = cartas.clonar();
        Carta primeraCarta = copia.retirarPrimeraCarta();
        System.out.println("\nPrimera carta: " + primeraCarta);
        System.out.println("\nBaraja original:");
        mostrarBaraja();
   }
   
   //Robar ultima carta
   public Carta robarUltimaCarta() {
        return cartas.retirarUltimaCarta();
    }
   
   //Llamar metodo para vaciar baraja
    public void vaciarBaraja() {
        cartas.vaciarBaraja();
    }
    
    //Llamar Merge Sort
    public void ordenar() {
        cartas.ordenar();
    }
    
    
}
