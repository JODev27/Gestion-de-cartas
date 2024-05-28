package proyectofinal;

public class Carta {
    
    private String simbolo;
    private String numero;

    //Constructores
    public Carta() {
    }
    
    public Carta(String simbolo,String numero) {
        this.simbolo = simbolo;
        this.numero = numero;
    }
    
    //Get & Set
    public String getSimbolo() {
        return simbolo;
    }

    public void setSimbolo(String simbolo) {
        this.simbolo = simbolo;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    //To String
    @Override
     public String toString() {
        return numero + " de " + simbolo;
    }
    
    
    


    
}
