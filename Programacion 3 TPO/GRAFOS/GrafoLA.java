package GRAFOS;

import CONJUNTOS.ConjuntoINT.ConjuntoLD;
import CONJUNTOS.ConjuntoINT.ConjuntoTDA;
import CONJUNTOS.ConjuntoNodos.ConjuntoLDNodo;
import CONJUNTOS.ConjuntoNodos.ConjuntoTDANodo;

import java.util.Locale;

public class GrafoLA implements GrafoTDA{
    NodoGrafo origen;

    @Override
    public void InicializarGrafo() {
        origen = null;
    }

    @Override
    public void AgregarVertice(int v,String estado) {
        NodoGrafo aux = new NodoGrafo();
        aux.estado = estado;
        aux.nodo = v;
        aux.arista = null;
        aux. sigNodo = origen;
        origen = aux;
    }
    private NodoGrafo Vert2Nodo(int v){
        NodoGrafo aux = origen;
        while (aux != null && aux.nodo != v){
            aux = aux.sigNodo;
        }
        return aux;
    }
    @Override
    public void EliminarVertice(int v) {
        if(origen.nodo == v){
            origen = origen.sigNodo;
        }
        NodoGrafo aux = origen;
        while(aux != null){
            this.EliminarAristaNodo(aux, v);
            if(aux.sigNodo != null && aux.sigNodo.nodo == v){
                aux.sigNodo = aux.sigNodo.sigNodo;
            }
            aux = aux.sigNodo;
        }
    }

    @Override
    public void AgregarArista(int v1, int v2, int p) {
        NodoGrafo n1 = Vert2Nodo(v1);
        NodoGrafo n2 = Vert2Nodo(v2);
        NodoArista aux = new NodoArista();
        aux.etiqueta = p;
        aux.nodoDestino = n2;
        aux.sigArista = n1.arista;
        n1.arista = aux;
    }
    private void EliminarAristaNodo(NodoGrafo nodo, int v){
        NodoArista aux = nodo.arista;
        if (aux != null){
            if (aux.nodoDestino.nodo == v){
                nodo.arista = aux.sigArista;
            }else{
                while (aux.sigArista != null && aux.sigArista.nodoDestino.nodo != v){
                    aux = aux.sigArista;
                }
                if (aux.sigArista != null){
                    aux.sigArista = aux.sigArista.sigArista;
                }
            }
        }
    }
    @Override
    public void EliminarArista(int v1, int v2) {
        NodoGrafo n1 = Vert2Nodo(v1);
        EliminarAristaNodo(n1, v2);
    }

    @Override
    public int PesoArista(int v1, int v2) {
        NodoGrafo n1 = Vert2Nodo(v1);
        NodoArista aux = n1.arista;
        while (aux.nodoDestino.nodo != v2){
            aux = aux.sigArista;
        }
        return aux.etiqueta;
    }

    @Override
    public ConjuntoTDA vertices() {
        ConjuntoTDA c = new ConjuntoLD();
        c.InicializarConjunto();
        NodoGrafo aux = origen;
        while (aux != null){
            c.Agregar(aux.nodo);
            aux = aux.sigNodo;
        }
        return c;
    }

    @Override
    public boolean ExisteArista(int v1, int v2) {
        NodoGrafo n1 = Vert2Nodo(v1);
        NodoArista aux = n1.arista;
        while (aux != null && aux.nodoDestino.nodo != v2){
            aux = aux.sigArista;
        }
        return (aux != null);
    }

    @Override
    public void CambiarEstado(String estado,NodoGrafo nodo) {
        nodo.estado = estado;
    }
    public NodoGrafo RetornarNodo(int v){
        NodoGrafo nodo = Vert2Nodo(v);
        return nodo;
    }


    public ConjuntoTDANodo NodosAdyacentes(NodoArista arista,String estado){
        ConjuntoTDANodo nodosAdyacentes = new ConjuntoLDNodo();
        while (arista != null) {
            NodoGrafo nodoDestino = arista.getNodoDestino();
            if (nodoDestino.getEstado().equals(estado)) {
                nodosAdyacentes.Agregar(nodoDestino);
            }
            arista = arista.getSigArista();
        }
        return nodosAdyacentes;

    }
}
