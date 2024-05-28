package proyectofinal;

public class ListaDoble {
    
    private NodoDoble inicio,fin;

    public ListaDoble() {
        inicio = fin = null;
    }

    //Get & Set
    public NodoDoble getInicio() {
        return inicio;
    }

    public void setInicio(NodoDoble inicio) {
        this.inicio = inicio;
    }

    public NodoDoble getFin() {
        return fin;
    }

    public void setFin(NodoDoble fin) {
        this.fin = fin;
    }
    
    //Consultar si la lista esta vacia
    public boolean esVacia(){
        return inicio==null;
    }
    
    
    //Metodo para agregar al inicio
    public void agregarInicio(Carta dato){
        if(!esVacia()){
            inicio = new NodoDoble(dato,inicio,fin);
            inicio.siguiente.anterior  = inicio;
        }
        else{
            inicio = fin = new NodoDoble(dato);
            
        }
    }
    
    //Metodo para agregar al final
    public void agregarFinal(Carta dato){
        if(!esVacia()){
            fin = new NodoDoble(dato,null,fin);
            fin.anterior.siguiente = fin;
        }
        else{
            inicio = fin = new NodoDoble(dato);
            
        }
    }
    
    //Mostrar lista de Inicio a Fin
    public void recorrer(){
       if(!esVacia()){
           String datos = ""; 
           NodoDoble aux = inicio;
           while(aux!=null){
               datos = datos + "[" + aux.carta + "]";
               aux = aux.siguiente;
           }
           System.out.println(datos); 
       } 
    }
    
    //Contar los nodos existentes
    public int contarNodos() {
        int contador = 0;
        NodoDoble actual = inicio;
        while (actual != null) {
            contador++;
            actual = actual.siguiente;
        }
        return contador;
    }


    //Robar primera carta
    public Carta retirarPrimeraCarta() {
        if (inicio == null) {
            return null; // Cuando la lista esté vacía
        }
        Carta primeraCarta = inicio.carta;
        inicio = inicio.siguiente;
        if (inicio != null) {
            inicio.anterior = null;
        } else {
            fin = null; // La lista ahora está vacía
        }
        return primeraCarta;
    }
    
    
    //Clonar lista para luego imprimir la baraja sin cambios
    public ListaDoble clonar() {
        ListaDoble copia = new ListaDoble();
        NodoDoble actual = this.inicio;
        while (actual != null) {
            copia.agregarFinal(new Carta(actual.carta.getSimbolo(), actual.carta.getNumero()));
            actual = actual.siguiente;
        }
        return copia;
        
    }
  
    //Robar ultima carta
    public Carta retirarUltimaCarta() {
        if (fin == null) {
            return null; //Lista está vacía
        }
        Carta ultimaCarta = fin.carta;
        fin = fin.anterior;
        if (fin != null) {
            fin.siguiente = null;
        } else {
            inicio = null; // La lista ahora está vacía
        }
        return ultimaCarta;
    }
    
    //Borrar baraja
    public void vaciarBaraja() {
        inicio = null;
        fin = null;
    }
    
    //Metodo para dividir la lista
    public NodoDoble dividir(NodoDoble cabeza) {
        //Comprobar si esta vacía o tiene un elemento
        if (cabeza == null || cabeza.siguiente == null) {
            return cabeza;
        }
        
        NodoDoble lento = cabeza; //Avanza de 1 en 1
        NodoDoble rapido = cabeza.siguiente; //Avanza de 2 en 2

        while (rapido != null && rapido.siguiente != null) {
            lento = lento.siguiente;
            rapido = rapido.siguiente.siguiente;
        }
        NodoDoble mitad = lento.siguiente;
        lento.siguiente = null;
        return mitad;
        
    }
    
    //Merge sort recursivo
    public NodoDoble mergeSort(NodoDoble cabeza) {
        if (cabeza == null || cabeza.siguiente == null) {
            return cabeza;
        }
        NodoDoble mitad = dividir(cabeza);
        NodoDoble izquierda = mergeSort(cabeza); //Primera mitad
        NodoDoble derecha = mergeSort(mitad); //Segunda mitad

        return merge(izquierda, derecha); //Las combina
    }
    
    //Mezclar las listas
    public NodoDoble merge(NodoDoble izquierda, NodoDoble derecha) {
        if (izquierda == null) {
            return derecha;
        }
        if (derecha == null) {
            return izquierda;
        }
        //Si la carta izquierda es menor a derecha
        if (compare(izquierda.carta, derecha.carta) <= 0) {
            izquierda.siguiente = merge(izquierda.siguiente, derecha);
            izquierda.siguiente.anterior = izquierda;
            izquierda.anterior = null;
            return izquierda;
        //sino derecha menor a izquierda    
        } else {
            derecha.siguiente = merge(izquierda, derecha.siguiente);
            derecha.siguiente.anterior = derecha;
            derecha.anterior = null;
            return derecha;
        }
    }

    //Comprar cartas
    public int compare(Carta carta1, Carta carta2) {
        //Parametros de ordenamiento
        String[] valoresOrdenados = {"2", "3", "4", "5", "6", "7", "8", "9", "J", "Q", "K", "A"};
        String[] palosOrdenados = {"Corazones", "Diamantes", "Tréboles","Picas"};

        
        int valor1 = -1, valor2 = -1, palo1 = -1, palo2 = -1; //Almacenar indices

        //Obtener indices del numero
        for (int i = 0; i < valoresOrdenados.length; i++) {
            if (carta1.getNumero().equals(valoresOrdenados[i])) {
                valor1 = i;
        }
            if (carta2.getNumero().equals(valoresOrdenados[i])) {
                valor2 = i;
            }
        }
        
        //Obtener indice de los palos
        for (int i = 0; i < palosOrdenados.length; i++) {
            if (carta1.getSimbolo().equals(palosOrdenados[i])) {
                palo1 = i;
            }
            if (carta2.getSimbolo().equals(palosOrdenados[i])) {
                palo2 = i;
            }
        }

        //Comparar valores
        if (valor1 != valor2) {
            return valor1 - valor2;
        } else {
            return palo1 - palo2; //Si son iguales comparar los palos
        }
    }
    
    public void ordenar() {
        inicio = mergeSort(inicio);
        // Actualizar la cola
        NodoDoble actual = inicio;
        while (actual != null && actual.siguiente != null) {
            actual = actual.siguiente;
        }
        fin = actual;
    }
    
    
}
