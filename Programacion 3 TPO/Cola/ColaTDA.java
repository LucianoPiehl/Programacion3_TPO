package Cola;

import GRAFOS.NodoGrafo;

public interface ColaTDA {
    void InicializarCola();
    void Acolar(NodoGrafo x);
    void Desacolar();
    boolean ColaVacia();
    NodoGrafo Primero();
}
