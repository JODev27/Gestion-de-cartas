package proyectofinal;

public class NodoDoble {
    
    Carta carta;
    NodoDoble siguiente,anterior;

    //constructor por defecto sin nodos
    public NodoDoble(Carta dato) {
        this.carta = dato;
        this.siguiente = null;
        this.anterior = null;
    }

    //Constructor para cuando hay nodos
    public NodoDoble(Carta dato, NodoDoble siguiente, NodoDoble anterior) {
        this.carta = dato;
        this.siguiente = siguiente;
        this.anterior = anterior;
    }
    
    
    
    
    
    
    
    
}
