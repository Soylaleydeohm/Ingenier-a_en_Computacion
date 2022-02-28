package EjerciciosGrafo;
import java.util.Iterator;

import TDAGrafoMatriz.*;
import TDAMapeo.*;
import TDALista.*;

public class Digrafos {
	
	private static final Object ESTADO= new Object();
	private static final Object VISITADO= new Object();
	private static final Object NOVISITADO= new Object();
	
	public static void main (String a[]){
			
		GraphD<Integer, Double> grafo= new GrafoDirigidoConMatriz<Integer, Double>(100);
		Vertex<Integer> v1,v2,v3,v4,v5,v6,v7,v8,v9,v10,v11;
        v1=grafo.insertVertex(1);
        v2=grafo.insertVertex(2);
        v3=grafo.insertVertex(3);
        v4=grafo.insertVertex(4);
        v5=grafo.insertVertex(5);
        v6=grafo.insertVertex(6);
        v7=grafo.insertVertex(7);
        v8=grafo.insertVertex(8);
        v9=grafo.insertVertex(9);
        v10=grafo.insertVertex(10);
        v11=grafo.insertVertex(11);
        try{
        grafo.insertEdge(v1, v2, 1d);
        grafo.insertEdge(v1, v3, 1d);
        grafo.insertEdge(v1, v4, 1d);
        grafo.insertEdge(v2, v5, 1d);
        grafo.insertEdge(v2, v6, 1d);
        grafo.insertEdge(v3, v7, 1d);
        grafo.insertEdge(v4, v8, 1d);
        grafo.insertEdge(v4, v9, 1d);
        grafo.insertEdge(v6, v10, 1d);
        grafo.insertEdge(v8, v11, 1d);
        grafo.insertEdge(v5,v11,10d);
        grafo.insertEdge(v5,v7,19d);
        grafo.insertEdge(v7,v11,1d);
        }
        catch(InvalidVertexException e){
        	e.printStackTrace();
        }
        
        System.out.println('\n'+"Camino mas largo entre 5 y 11: ");
        PositionList<Vertex<Integer>> camino= new ListaDoblementeEnlazada<Vertex<Integer>>();
        caminoMasLargo(grafo, camino, v5, v11);
        for(TDALista.Position<Vertex<Integer>> elem: camino.positions())
        	System.out.print(elem.element().element()+" ");
	}
	
	public static<V,E> Vertex<V> primeroR(GraphD<V,E> grafo, V rotulo){
		Iterator<Vertex<V>> it= grafo.vertices().iterator();
		Vertex<V> actual;
		Vertex<V> retorno=null;
		while(it.hasNext() && retorno==null){
			actual=it.next();
			if(actual.element().equals(rotulo))
				retorno=actual;
		}
		return retorno;
	}
	
	public static<V,E> void caminoMasLargo(GraphD<V,E> g, PositionList<Vertex<V>> camino, Vertex<V> origen, Vertex<V> destino){
		//Marca todos los vértices como no visitados.
		for(Vertex<V> vertice: g.vertices())
			try {
				vertice.put(ESTADO,NOVISITADO);
			} catch (InvalidKeyException e) {
				e.printStackTrace();
			}
		caminoMasLargoAux(g, origen, destino,new ListaDoblementeEnlazada<Vertex<V>>() , new Solucion(0), 
				camino, new Solucion(0));
	}

	private static<V,E> void caminoMasLargoAux(GraphD<V,E> g, Vertex<V> origen, Vertex<V> destino,
			PositionList<Vertex<V>> caminoActual, Solucion cantActual, PositionList<Vertex<V>> caminoMasLargo, Solucion cantMasLargo){
		try{
			origen.put(ESTADO, VISITADO);
			caminoActual.addLast(origen);
			if(origen==destino){
				if(cantActual.getResultado()>cantMasLargo.getResultado()){
					cantMasLargo.setResultado(cantActual.getResultado());
					copiar(caminoMasLargo, caminoActual);
				}
			}
			else{
				for(Edge<E> arco: g.succesorEdges(origen)){
					if(g.opposite(origen, arco).get(ESTADO)==NOVISITADO){
						cantActual.setResultado(cantActual.getResultado()+1);
						caminoMasLargoAux(g, g.opposite(origen, arco), destino,
						caminoActual, cantActual, caminoMasLargo, cantMasLargo);
					}
				}
			}
			cantActual.setResultado(cantActual.getResultado()-1);
			caminoActual.remove(caminoActual.last());
			origen.put(ESTADO, NOVISITADO);
		}
		catch(InvalidKeyException| EmptyListException | InvalidPositionException | InvalidEdgeException | InvalidVertexException e){
			e.printStackTrace();
		}
	}
	
	private static<V> void copiar(PositionList<Vertex<V>> en, PositionList<Vertex<V>> esto) {
		   //remuevo todo de la lista a la que voy a copiar (caminoMinimo)
			while(!en.isEmpty())
				try {
					en.remove(en.first());
				} catch (InvalidPositionException | EmptyListException e) {
					e.printStackTrace();
				}
			//copio los elementos de esto(caminoActual) en en(caminoMinimo)
			for(TDALista.Position<Vertex<V>> elem: esto.positions()){
				en.addLast(elem.element());
			}
		}
	
}
