package GRAFOS;

import CONJUNTOS.ConjuntoINT.ConjuntoTDA;
import CONJUNTOS.ConjuntoNodos.ConjuntoTDANodo;

public interface GrafoTDA {
    void InicializarGrafo(); // Sin pre-condicion.
    void AgregarVertice(int v, String estado); // Grafo inicializado y existe nodo v.
    void EliminarVertice(int v); // Grafo inicializado y existe nodo v.
    void AgregarArista(int v1, int v2, int p); // Grafo inicializado y no existe arista (v1, v2).
    void EliminarArista(int v1, int v2); // Grafo inicializado y existe arista (v1, v2).
    int PesoArista(int v1, int v2); // Grafo inicializado y existe arista (v1, v2).
    ConjuntoTDA vertices(); // Grafo Inicializado.
    boolean ExisteArista(int v1, int v2); // Grafo inicializado y existen nodos v1,v2


    void CambiarEstado(String estado, NodoGrafo nodo);
    public NodoGrafo RetornarNodo(int v);
    public ConjuntoTDANodo NodosAdyacentes(NodoArista arista, String estado);

}
