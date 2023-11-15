import CONJUNTOS.ConjuntoINT.ConjuntoTDA;
import CONJUNTOS.ConjuntoNodos.ConjuntoTDANodo;
import Cola.ColaLD;
import Cola.ColaTDA;
import GRAFOS.GrafoLA;
import GRAFOS.GrafoTDA;
import GRAFOS.NodoArista;
import GRAFOS.NodoGrafo;

import java.util.ArrayList;

public class Main {
    public static void BFS(GrafoTDA grafo, NodoGrafo origen, int tiempo , int[] arrayTiempos, int[] nodosPadres, ColaTDA cola,ArrayList<Integer> recorrido) {
        //Sumo un tiempo por la ejecucion
        tiempo = tiempo+1;
        arrayTiempos[origen.getNodo()] = tiempo;
        //Marco el origen como "visitado"
        NodoGrafo nodo = grafo.RetornarNodo(origen.getNodo());
        grafo.CambiarEstado("visitado",nodo);

        //obtener nodos adyacentes
        NodoArista arista = nodo.getArista();
        ConjuntoTDANodo nodosAdyacentes = grafo.NodosAdyacentes(arista,"no visitado");
        //iteramos por cada nodo adyacente
        while(!nodosAdyacentes.ConjuntoVacio()){
            NodoGrafo nodoAdyacente = nodosAdyacentes.Elegir();
            nodosAdyacentes.Sacar(nodoAdyacente);
            if (nodoAdyacente.getEstado() == "no visitado" || nodoAdyacente.getEstado() == null){
                nodosPadres[nodoAdyacente.getNodo()] = origen.getNodo();
                cola.Acolar(nodoAdyacente);
                recorrido.add(nodoAdyacente.getNodo());
            }
        }
        //mientras que la cola no este vacia y nos queduen elementos para procesar
        //obtenemos uno de esos elementos y desacolamos
        if (!cola.ColaVacia()){
            NodoGrafo siguienteNodo = cola.Primero();
            cola.Desacolar();
            //llamada recursiva con el siguiente nodo
            BFS(grafo, siguienteNodo, tiempo, arrayTiempos, nodosPadres,cola, recorrido);

        }

    }





    public static void DFS(GrafoTDA grafo, NodoGrafo origen, int tiempo, int[] arrayTiempos, int[] nodosPadres, ArrayList<Integer> recorrido) {
        //Sumo un tiempo por la ejecucion
        tiempo = tiempo+1;

        //Marco el origen como "gris"
        NodoGrafo nodo = grafo.RetornarNodo(origen.getNodo());
        grafo.CambiarEstado("gris",nodo);

        // Obtener los nodos adyacentes
        NodoArista arista = nodo.getArista();
        ConjuntoTDANodo nodosAdyacentes = grafo.NodosAdyacentes(arista,"blanco");

        //Recorro por cada nodo adyacente
        while (!nodosAdyacentes.ConjuntoVacio()){
            NodoGrafo nodoAdyacente = nodosAdyacentes.Elegir();
            nodosAdyacentes.Sacar(nodoAdyacente);
            if (nodoAdyacente.getEstado() == "blanco"|| nodoAdyacente.getEstado() == null){
                nodosPadres[nodoAdyacente.getNodo()] = origen.getNodo();
                DFS(grafo, nodoAdyacente, tiempo, arrayTiempos, nodosPadres,recorrido);
                recorrido.add(nodoAdyacente.getNodo());
            }
        }

        origen.setEstado("negro");
        arrayTiempos[origen.getNodo()] = tiempo;


    }
    public static void main(String[] args){
        GrafoTDA grafo = new GrafoLA();
        // Para utilizar DSF Cambiar estado a "blanco" | Para utilizar BFS cambiar estado a "no visitado"
        String estado = "blanco";
        ColaTDA cola = new ColaLD();

        grafo.AgregarVertice(1,estado);
        grafo.AgregarVertice(2,estado);
        grafo.AgregarVertice(3,estado);
        grafo.AgregarVertice(4,estado);
        grafo.AgregarVertice(5,estado);
        grafo.AgregarVertice(6,estado);
        grafo.AgregarVertice(7,estado);
        grafo.AgregarVertice(8,estado);
        grafo.AgregarArista(1,2,1);
        grafo.AgregarArista(2,3,2);
        grafo.AgregarArista(3,4,3);
        grafo.AgregarArista(1,5,4);
        grafo.AgregarArista(5,6,5);
        grafo.AgregarArista(1,7,6);
        grafo.AgregarArista(7,8,7);
        ConjuntoTDA vertices = grafo.vertices();
        int cantidadVertices = 0;

        //Cuento la cantidad de vertices y obtengo el objeto nodo que coincide con el valor que fue pasado como origen
        while (!vertices.ConjuntoVacio()){
            int valor = vertices.Elegir();
            vertices.Sacar(valor);
            cantidadVertices= cantidadVertices+1;
        }

        //Declaro el array que tendrá los tiempos de cada vertice. Con el dato obtenido en el while
        int[] arrayTiempos = new int[cantidadVertices+1];
        int[] nodosPadres = new int[cantidadVertices+1];
        ArrayList<Integer> recorrido = new ArrayList<Integer>();
        int numeroOrigen = 1;

        String texto;
        //Ejecuto la Funcion
        if (estado.equals("blanco")){
            DFS(grafo, grafo.RetornarNodo(numeroOrigen), 0, arrayTiempos, nodosPadres,recorrido);
            texto = "Recorrido Vertical:";
        }else {
            BFS(grafo, grafo.RetornarNodo(numeroOrigen), 0, arrayTiempos, nodosPadres,cola,recorrido);
            texto = "Recorrido Horizontal:";
        }

        //Muestro los resultados
        System.out.println("Nodo    Tiempo   Nodo Padre");
        for (int i = 1; i <= cantidadVertices; i++) {
            // Utiliza System.out.println para formatear la salida
            System.out.println(i + "      " + arrayTiempos[i] + "               " + nodosPadres[i]);
        }

        System.out.println(texto);
        System.out.println(numeroOrigen);
        for (Integer nodoRecorrido : recorrido) {
            System.out.println(nodoRecorrido);
        }


    }
}
