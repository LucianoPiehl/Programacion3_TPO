package CONJUNTOS.ConjuntoINT;

public interface ConjuntoTDA {
    void InicializarConjunto(); // Sin pre-condicion.
    void Agregar(int x); // Conjunto inicializado.
    int Elegir(); // Conjunto inicializado y no vacio.
    boolean ConjuntoVacio(); // Conjunto Incializado.
    void Sacar(int x); // Conjunto inicializado.
    boolean Pertenece(int x); // Conjunto inicializado
}
