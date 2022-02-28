package TDAGrafoLista;
import java.util.Iterator;
import TDACola.*;
import TDALista.*;
import TDAMapeo.*;

public class GrafoConLista<V,E> implements Graph<V,E> {

	protected PositionList<Vertice<V,E>> vertices;
	protected PositionList<Arco<V,E>> arcos;
	
	public GrafoConLista(){
		vertices= new ListaDoblementeEnlazada<Vertice<V,E>>();
		arcos= new ListaDoblementeEnlazada<Arco<V,E>>();
	}

	public Iterable<Vertex<V>> vertices() {
		PositionList<Vertex<V>> retorno= new ListaDoblementeEnlazada<Vertex<V>>();
		for(Vertice<V,E> vertice: vertices)
			retorno.addLast(vertice);
		return retorno;
	}

	public Iterable<Edge<E>> edges() {
		PositionList<Edge<E>> retorno= new ListaDoblementeEnlazada<Edge<E>>();
		for(Arco<V,E> arco: arcos)
			retorno.addLast(arco);
		return retorno;
	}

	//----------------------------------------------------------------------
	protected Vertice<V,E> checkVertex(Vertex<V> v) throws InvalidVertexException{
		if(v==null)
			throw new InvalidVertexException("Error: el vértice es nulo.");
		try{
			return (Vertice<V,E>) v;
		}
		catch(ClassCastException e){
			throw new InvalidVertexException("Error: el vértice no pertenece a un grafo.");
		}
	}
	
	protected Arco<V,E> checkEdge(Edge<E> e) throws InvalidEdgeException{
		if(e==null)
			throw new InvalidEdgeException("Error: el arco es nulo.");
		try{
			return (Arco<V,E>) e;
		}
		catch(ClassCastException exc){
			throw new InvalidEdgeException("Error: el arco no pertenece a un grafo.");
		}
	}
	//----------------------------------------------------------------------
	
	public Iterable<Edge<E>> incidentEdges(Vertex<V> v) throws InvalidVertexException {
		if(vertices.size()==0)
			throw new InvalidVertexException("Error: el grafo no tiene vértices, por lo tanto es inválido.");
	    Vertice<V,E> vv=checkVertex(v);
	    PositionList<Edge<E>> retorno= new ListaDoblementeEnlazada<Edge<E>>();
	    for(Arco<V,E> arco: vv.getAdyacentes())
	    	retorno.addLast(arco);
	    return retorno;
	}

	public Vertex<V> opposite(Vertex<V> v, Edge<E> e) throws InvalidVertexException, InvalidEdgeException {
		if(vertices.size()==0)
			throw new InvalidVertexException("Error: el grafo no tiene vértices, por lo tanto es inválido.");
		if(arcos.size()==0)
			throw new InvalidEdgeException("Error: el grafo no tiene arcos, por lo tanto es inválido.");
		Vertice<V,E> vv=checkVertex(v);
		Arco<V,E> ee=checkEdge(e);
		Vertex<V> retorno;
		if(ee.getV1()==v)
			retorno=ee.getV2();
		else
			if(ee.getV2()==v)
				retorno=ee.getV1();
			else
				throw new InvalidVertexException("Error: el vértice no esta conectado con el arco.");
		return retorno;
	}

	public Vertex<V>[] endVertices(Edge<E> e) throws InvalidEdgeException {
		if(arcos.size()==0)
			throw new InvalidEdgeException("Error: el grafo no tiene arcos, por lo tanto es inválido.");
		Arco<V,E> ee=checkEdge(e);
		@SuppressWarnings("unchecked")
		Vertex<V>[] arreglo= (Vertex<V>[]) new Vertice[2];
		arreglo[0]=ee.getV1();
		arreglo[1]=ee.getV2();
		return arreglo;
	}

	public boolean areAdjacent(Vertex<V> v, Vertex<V> w) throws InvalidVertexException {
		if(vertices.size()<2)
			throw new InvalidVertexException("Error: el grafo no tiene al menos 2 vértices, por lo tanto son inválidos.");
		Vertice<V,E> vv=checkVertex(v);
		Vertice<V,E> ww=checkVertex(w);
		boolean son=false;
		Iterator<Arco<V,E>> it= vv.getAdyacentes().iterator();
		Arco<V,E> actual;
		while(it.hasNext() && !son){
			actual=it.next();
			if(actual.getV1()==w || actual.getV2()==w)
				son=true;
		}
		return son;
	}

	public V replace(Vertex<V> v, V x) throws InvalidVertexException {
		if(vertices.size()==0)
			throw new InvalidVertexException("Error: el grafo no tiene vértices, por lo tanto es inválido.");
	    Vertice<V,E> vv=checkVertex(v);
	    V retorno= vv.element();
	    vv.setElemento(x);
	    return retorno;
	}

	public E replace(Edge<E> v, E x) throws InvalidEdgeException {
		if(arcos.size()==0)
			throw new InvalidEdgeException("Error: el grafo no tiene arcos, por lo tanto es inválido.");
	    Arco<V,E> vv=checkEdge(v);
	    E retorno= vv.element();
	    vv.setElemento(x);
	    return retorno;
	}

	public Vertex<V> insertVertex(V x) {
		Vertice<V,E> nuevo= new Vertice<V,E>(x);
		vertices.addLast(nuevo);
		try {
			nuevo.setPosicionEnVertices(vertices.last());
		} catch (EmptyListException e) {
			e.printStackTrace();
		}
		return nuevo;
	}

	public Edge<E> insertEdge(Vertex<V> v, Vertex<V> w, E e) throws InvalidVertexException {
		if(vertices.size()<2)
			throw new InvalidVertexException("Error: el grafo no tiene al menos 2 vértices, por lo tanto son inválidos.");
		Vertice<V,E> vv=checkVertex(v);
		Vertice<V,E> ww=checkVertex(w);
		Arco<V,E> nuevo= new Arco<V,E>(e,vv,ww);
		arcos.addLast(nuevo);
		try {
			nuevo.setPosicionEnArcos(arcos.last());
		} catch (EmptyListException e1) {
			e1.printStackTrace();
		}
		vv.setAdyacente(nuevo);
		ww.setAdyacente(nuevo);
		try{
		  nuevo.setPosicionEnListaAdyacenciaV1(vv.getAdyacentes().last());
		  nuevo.setPosicionEnListaAdyacenciaV2(ww.getAdyacentes().last());
		}
		catch(EmptyListException exp){
			exp.printStackTrace();
		}
		return nuevo;
	}

	public V removeVertex(Vertex<V> v) throws InvalidVertexException {
		//Asume que no tiene arcos
		if(vertices.size()==0)
			throw new InvalidVertexException("Error: el grafo no tiene vértices, por lo tanto es inválido.");
	    Vertice<V,E> vv=checkVertex(v);
	    V retorno= vv.element();
	    try {
			vertices.remove(vv.getPosicionEnVertices());
		} catch (InvalidPositionException e) {
			e.printStackTrace();
		}
	    return retorno;
	}

	public E removeEdge(Edge<E> e) throws InvalidEdgeException {
		if(arcos.size()==0)
			throw new InvalidEdgeException("Error: el grafo no tiene arcos, por lo tanto es inválido.");
	    Arco<V,E> ee=checkEdge(e);
	    E retorno=ee.element();
	    try {
			ee.getV1().getAdyacentes().remove(ee.getPosicionEnListaAdyacenciaV1());
			ee.getV2().getAdyacentes().remove(ee.getPosicionEnListaAdyacenciaV2());
			arcos.remove(ee.getPosicionEnArcos());
		} catch (InvalidPositionException e1) {
			e1.printStackTrace();
		}
	    return retorno;
	}
	
	private static final Object ESTADO= new Object();
	private static final Object VISITADO= new Object();
	private static final Object NOVISITADO= new Object();
	
	public void DFS(){
		//Marca todos los vértices como no visitados.
		for(Vertice<V,E> vertice: vertices)
			try {
				vertice.put(ESTADO, NOVISITADO);
			} catch (InvalidKeyException e) {
				e.printStackTrace();
			}
		for(Vertice<V,E> vertice: vertices){
			try {
				if(vertice.get(ESTADO)==NOVISITADO)
					DFSAux(vertice);
			} catch (InvalidKeyException e) {
				e.printStackTrace();
			}
		}
	}
	private void DFSAux(Vertice<V,E> vertice){
		System.out.print(vertice.element()+" ");
        try{
		  vertice.put(ESTADO, VISITADO);
		  for(Arco<V,E> arco: vertice.getAdyacentes()){
			  if(arco.getV1()==vertice && arco.getV2().get(ESTADO)==NOVISITADO)
					DFSAux(arco.getV2());
			  else
				 if(arco.getV2()==vertice && arco.getV1().get(ESTADO)==NOVISITADO)
					 DFSAux(arco.getV1());
		  }
        }
        catch(InvalidKeyException e){
        	e.printStackTrace();
        }
	}
	
	public void BFS(){ 
		//Marca todos los vértices como no visitados.
		for(Vertice<V,E> vertice: vertices)
			try {
				vertice.put(ESTADO, NOVISITADO);
			} catch (InvalidKeyException e) {
				e.printStackTrace();
			}
		for(Vertice<V,E> vertice: vertices){
			try {
				if(vertice.get(ESTADO)==NOVISITADO)
					BFSAux(vertice);
			} catch (InvalidKeyException e) {
				e.printStackTrace();
			}
		}
	}
	private void BFSAux(Vertice<V,E> vertice){
		Queue<Vertice<V,E>> cola= new ColaConLista<Vertice<V,E>>();
		cola.enqueue(vertice);
		try {
			vertice.put(ESTADO, VISITADO);
		} catch (InvalidKeyException e1) {
			e1.printStackTrace();
		}
		Vertice<V,E> actual;
		while(!cola.isEmpty()){
			try {
				actual=cola.dequeue();
				//Procesar actual
				System.out.print(actual.element()+" ");
				actual.put(ESTADO, VISITADO);
				for(Arco<V,E> arco: actual.getAdyacentes()){
					if(arco.getV1()==actual && arco.getV2().get(ESTADO)==NOVISITADO){
						cola.enqueue(arco.getV2());
						arco.getV2().put(ESTADO, VISITADO);
					}
					else if(arco.getV2()==actual && arco.getV1().get(ESTADO)==NOVISITADO){
						cola.enqueue(arco.getV1());
						arco.getV1().put(ESTADO, VISITADO);
					}
				}
			} catch (EmptyQueueException | InvalidKeyException e) {
				e.printStackTrace();
			}
		}
	}
}
