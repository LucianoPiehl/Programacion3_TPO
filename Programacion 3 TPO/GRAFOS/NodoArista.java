package GRAFOS;

public class NodoArista {
    int etiqueta;
    NodoGrafo nodoDestino;
    NodoArista sigArista;

    public NodoGrafo getNodoDestino() {
        return nodoDestino;
    }

    public NodoArista getSigArista() {
        return sigArista;
    }
}
