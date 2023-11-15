package GRAFOS;

public class NodoGrafo {
    int nodo;
    NodoArista arista;
    NodoGrafo sigNodo;
    String estado;

    public String getEstado() {
        return estado;
    }

    public int getNodo() {
        return nodo;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public NodoArista getArista() {
        return arista;
    }
}
