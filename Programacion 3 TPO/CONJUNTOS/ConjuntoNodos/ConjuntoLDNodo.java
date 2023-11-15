package CONJUNTOS.ConjuntoNodos;

import GRAFOS.NodoGrafo;

public class ConjuntoLDNodo implements ConjuntoTDANodo {
    private class Nodo {
        NodoGrafo info;
        Nodo sig;
    }

    private Nodo c;
    @Override
    public void InicializarConjunto() {
        c = null;
    }

    @Override
    public void Agregar(NodoGrafo x) {
        if (this.Pertenece(x)){
            Nodo nuevo = new Nodo();
            nuevo.info = x;
            nuevo.sig = c;
            c = nuevo;
        }
    }

    @Override
    public NodoGrafo Elegir() {
    return c.info;
    }

    @Override
    public boolean ConjuntoVacio() {
        return (c == null);
    }

    @Override
    public void Sacar(NodoGrafo x) {
        if(c != null){
            if (c.info == x){
                c = c.sig;
            }else {
                Nodo aux = c;
                while (aux.sig != null && aux.sig.info != x){
                    aux = aux.sig;
                    if (aux.sig != null){
                        aux.sig = aux.sig.sig;
                    }
                }
            }
        }
    }

    @Override
    public boolean Pertenece(NodoGrafo x) {
        Nodo aux = c;
        while (aux != null && aux.info != x){
            aux = aux.sig;
        }
        return (aux == null);
    }
}
