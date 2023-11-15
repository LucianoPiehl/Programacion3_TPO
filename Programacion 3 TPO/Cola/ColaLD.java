package Cola;

import GRAFOS.NodoGrafo;

public class ColaLD implements ColaTDA{
    class Nodo{
        NodoGrafo info;
        Nodo sig;
    }
    Nodo primero;
    Nodo ultimo;
    public void InicializarCola(){
        primero = null;
        ultimo = null;
    }
    public void Acolar(NodoGrafo x){
        Nodo nuevo = new Nodo();
        nuevo.info = x;
        nuevo.sig = null;
        if (ultimo != null)
            ultimo.sig = nuevo;
        ultimo = nuevo;
        if(primero == null)
            primero = ultimo;
    }
    public void Desacolar(){
        primero = primero.sig;
        if (primero == null)
            ultimo = null;
    }
    public boolean ColaVacia(){
        return (ultimo == null);
    }
    public NodoGrafo Primero(){
        return primero.info;
    }
}
