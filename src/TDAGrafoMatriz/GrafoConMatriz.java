package TDAGrafoMatriz;
import TDALista.*;

public class GrafoConMatriz<V,E> implements Graph<V,E> {

	protected PositionList<Vertex<V>> vertices;
	protected PositionList<Edge<E>> arcos;
	protected Edge<E> [][] matriz;
	protected int cant;
	
	public GrafoConMatriz(int n){
		vertices= new ListaDoblementeEnlazada<Vertex<V>>();
		arcos= new ListaDoblementeEnlazada<Edge<E>>();
		matriz= (Edge<E>[][]) new Arco[n][n];
		cant=0;
	}
	
	public Iterable<Vertex<V>> vertices() {
		PositionList<Vertex<V>> retorno= new ListaDoblementeEnlazada<Vertex<V>>();
		for(Vertex<V> vertice: vertices)
			retorno.addLast(vertice);
		return retorno;
	}

	public Iterable<Edge<E>> edges() {
		PositionList<Edge<E>> retorno= new ListaDoblementeEnlazada<Edge<E>>();
		for(Edge<E> arco: arcos)
			retorno.addLast(arco);
		return retorno;
	}

	public Iterable<Edge<E>> incidentEdges(Vertex<V> v) throws InvalidVertexException {
		if(cant==0)
			throw new InvalidVertexException("Error: el grafo no tiene vértices, por lo tanto, no es válido.");
		Vertice<V> vv= checkVertex(v);
		int fila= vv.getIndice();
		PositionList<Edge<E>> incidentes=new ListaDoblementeEnlazada<Edge<E>>();
		for(int i=0; i<cant; i++){
			if(matriz[fila][i]!=null)
				incidentes.addLast(matriz[fila][i]);
		}
		return incidentes;
	}
    //---------------------------------------------------------------------
	private Arco<V,E> checkEdge(Edge<E> e) throws InvalidEdgeException{
		if(e==null)
			throw new InvalidEdgeException("Error: el arco es nulo.");
		try{
			return (Arco<V,E>) e;
		}
		catch(ClassCastException ex){
			throw new InvalidEdgeException("Error: el arco no pertenece a un grafo.");
		}
	}
	
	private Vertice<V> checkVertex(Vertex<V> v) throws InvalidVertexException{
		if(v==null)
			throw new InvalidVertexException("Error: el vértice es nulo.");
		try{
			return (Vertice<V>) v;
		}
		catch(ClassCastException e){
			throw new InvalidVertexException("Error: el vértice no pertenece a un grafo.");
		}
	}
    //---------------------------------------------------------------------
	

	public Vertex<V> opposite(Vertex<V> v, Edge<E> e) throws InvalidVertexException, InvalidEdgeException {
		if(cant==0)
			throw new InvalidVertexException("Error: el grafo no tiene vértices, por lo tanto, no es válido.");
	    if(arcos.size()==0)
	    	throw new InvalidEdgeException("Error: el grafo no tiene arcos, por lo tanto, no es válido."); 
	    Vertice<V> vv= checkVertex(v);
	    Arco<V,E> ee= checkEdge(e);
	    Vertex<V> retorno;
	    if(ee.getV1()==vv)
	    	retorno=ee.getV2();
	    else
	    	if(ee.getV2()==vv)
	    		retorno=ee.getV1();
	    	else throw new InvalidVertexException("Error: el vértice no está conectado al arco."); 
	    return retorno;    
	}

	@SuppressWarnings("unchecked")
	public Vertex<V>[] endVertices(Edge<E> e) throws InvalidEdgeException {
		if(arcos.size()==0)
    	   throw new InvalidEdgeException("Error: el grafo no tiene arcos, por lo tanto, no es válido."); 
		Arco<V,E> arco= checkEdge(e);
		Vertex<V>[] arreglo=(Vertex<V>[]) new Vertice[2];
		arreglo[0]=arco.getV1();
		arreglo[1]=arco.getV2();
		return arreglo;
	}

	public boolean areAdjacent(Vertex<V> v, Vertex<V> w) throws InvalidVertexException {
		if(cant==0)
			throw new InvalidVertexException("Error: el grafo no tiene vértices, por lo tanto, no es válido.");
	    Vertice<V> vv=checkVertex(v);
	    Vertice<V> ww=checkVertex(w);
	    int indice1= vv.getIndice();
	    int indice2= ww.getIndice();
	    return matriz[indice1][indice2]!=null;
	}

	public V replace(Vertex<V> v, V x) throws InvalidVertexException {
		if(cant==0)
			throw new InvalidVertexException("Error: el grafo no tiene vértices, por lo tanto, no es válido.");
	    Vertice<V> vv=checkVertex(v);
	    V retorno= vv.element();
	    vv.setElemento(x);
	    return retorno;
	}

	public E replace(Edge<E> e, E x) throws InvalidEdgeException {
		if(arcos.size()==0)
			throw new InvalidEdgeException("Error: el grafo no tiene arcos, por lo tanto, no es válido.");
	    Arco<V,E> ee=checkEdge(e);
	    E retorno= ee.element();
	    ee.setElemento(x);
	    return retorno;
	}

	public Vertex<V> insertVertex(V x) {
		Vertice<V> nuevo= new Vertice<V>(x, cant);
		cant++;
		vertices.addLast(nuevo);
		try{
		 nuevo.setPosicionEnVertices(vertices.last());
		}
		catch(EmptyListException e){
			e.printStackTrace();
		}
		return nuevo;
	}
	
	public Edge<E> insertEdge(Vertex<V> v, Vertex<V> w, E e) throws InvalidVertexException {
		if(cant<2)
			throw new InvalidVertexException("Error: el grafo no tiene al menos dos vértices, por lo tanto no son válidos.");
		Vertice<V> vv=checkVertex(v);
		Vertice<V> ww=checkVertex(w);
		Arco<V,E> nuevo= new Arco<V,E>(e, vv, ww);
		int indice1=vv.getIndice();
		int indice2=ww.getIndice();
		matriz[indice1][indice2]=nuevo;
		matriz[indice2][indice1]=nuevo;
		arcos.addLast(nuevo);
		try {
			nuevo.setPosicionEnArcos(arcos.last());
		} catch (EmptyListException e1) {
			e1.printStackTrace();
		}
		return nuevo;
	}

	public V removeVertex(Vertex<V> v) throws InvalidVertexException {
		//Asume que todos los arcos fueron removidos
		if(cant==0)
			throw new InvalidVertexException("Error: el grafo no tiene vértices, por lo tanto, no es válido.");
	    Vertice<V> vv=checkVertex(v);
	    V retorno= vv.element();
	    try{
	    	vertices.remove(vv.getPosicionEnVertices());
	    	cant--;
	    }
	    catch(InvalidPositionException e){
	    	e.printStackTrace();
	    }
	    return retorno;
	}

	public E removeEdge(Edge<E> e) throws InvalidEdgeException {
		if(arcos.size()==0)
			throw new InvalidEdgeException("Error: el grafo no tiene arcos, por lo tanto, no es válido.");
	    Arco<V,E> ee=checkEdge(e);
	    E retorno= ee.element();
	    int indicev1= ee.getV1().getIndice();
	    int indicev2= ee.getV2().getIndice();
	    matriz[indicev1][indicev2]=null;
	    matriz[indicev2][indicev1]=null;
	    try {
			arcos.remove(ee.getPosicionEnArcos());
		} catch (InvalidPositionException e1) {
			e1.printStackTrace();
		}
	    return retorno;
	}
}
