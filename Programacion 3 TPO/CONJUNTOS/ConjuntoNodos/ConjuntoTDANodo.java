package CONJUNTOS.ConjuntoNodos;

import GRAFOS.NodoGrafo;

public interface ConjuntoTDANodo {
    void InicializarConjunto(); // Sin pre-condicion.
    void Agregar(NodoGrafo x); // Conjunto inicializado.
    NodoGrafo Elegir(); // Conjunto inicializado y no vacio.
    boolean ConjuntoVacio(); // Conjunto Incializado.
    void Sacar(NodoGrafo x); // Conjunto inicializado.
    boolean Pertenece(NodoGrafo x); // Conjunto inicializado
}
