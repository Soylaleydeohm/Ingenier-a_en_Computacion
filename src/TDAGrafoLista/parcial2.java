import TDALista.EmptyListException;
import TDALista.InvalidPositionException;
import TDALista.ListaDoblementeEnlazada;
import TDALista.PositionList;
import TDAMapeo.InvalidKeyException;
import TDAMapeo.Map;
import TDAMapeo.MapeoConLista;

public interface Graph<V,E> {
	
	public Iterable<Vertex<V>> vertices();

	public Iterable<Edge<E>> edges();

	public Iterable<Edge<E>> incidentEdges(Vertex<V> v) throws InvalidVertexException;

	public Vertex<V> opposite(Vertex<V> v, Edge<E> e) throws InvalidVertexException, InvalidEdgeException;

	public Vertex<V> [] endVertices(Edge<E> e) throws InvalidEdgeException;

	public boolean areAdjacent(Vertex<V> v,Vertex<V> w) throws InvalidVertexException;

	public V replace(Vertex<V> v, V x) throws InvalidVertexException;

	public E replace(Edge<E> v, E x) throws InvalidEdgeException;

	public Vertex<V> insertVertex(V x);
	
	public Edge<E> insertEdge(Vertex<V> v, Vertex<V> w, E e) throws InvalidVertexException;
	
	public V removeVertex(Vertex<V> v) throws InvalidVertexException;

	public E removeEdge(Edge<E> e) throws InvalidEdgeException;
}

public interface Vertex<E> extends Position<E> {}

public interface Edge<E> extends Position<E> {}

b)
public class Vertice<V,E> implements Vertex<V> {
	
	private V rotulo;
	private PositionList<Arco<V,E>> adyacentes;
	private Position<Vertice<V,E>> posicionEnNodos;
	
	public Vertice(V rotulo) {
		this.rotulo = rotulo;
		adyacentes = new ListaDoblementeEnlazada<Arco<V,E>>();
	}
	
	public V element() {}
	
	public PositionList<Arco<V,E>> getAdyacentes() {}
	
	public Position<Vertice<V,E>> getPosicionEnNodos() {}
	
	public void setRotulo(V nuevoRotulo) {}
	
	public void setPosicionEnNodos(Position<Vertice<V,E>> p) {}
}

public class Arco<V,E> implements Edge<E> {
	
	private E rotulo;
	private Vertice<V,E> sucesor, predecesor;
	private Position<Arco<V,E>> posicionEnAdyacentes;
	
	public Arco(E rotulo, Vertice<V,E> predecesor, Vertice<V,E> sucesor) {
		this.rotulo = rotulo;
		this.predecesor = predecesor;
		this.sucesor = sucesor;
	}
	
	public E element() { }
	
	public void setRotulo(E rotulo) {}
	
	public Vertice<V,E> getPredecesor() {}
	
	public Vertice<V,E> getSucesor() {}
	
	public Position<Arco<V,E>> getPosicionEnAdyacentes() {}
	
	public void setPosicionEnAdyacentes(Position<Arco<V,E>> p) {}
}

c)
public class GrafoNoDirListaAdy <V,E> implements Graph <V,E>{

	protected PositionList<Vertice<V,E>> vertices;
	protected PositionList<Arco<V,E>> arcos; //opcional
	
	public GrafoNoDirListaAdy()
	{
		vertices= new ListaDoblementeEnlazada<Vertice<V,E>>();
		arcos= new ListaDoblementeEnlazada<Arco<V,E>>(); //opcional
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
	
	d) Acceso a la estructura
	
	public Map<V,Integer> ejercicio (Vertex<V> v1){
		Map<V,Integer> toReturn = new MapeoConLista<V, Integer>();
		Map<Vertex<V>, Boolean> vis = new MapeoConLista<Vertex<V>,Boolean>();
		try{
			Vertice<V,E> vv1 = checkVertex(v1);
			for(Vertice<V,E> v : vertices){
				vis.put(v, false);
			}
			DFSAux2(vv1, vis, toReturn);
		} catch (InvalidKeyException | InvalidVertexException e){}
		return toReturn;
	}
	
	private void DFSAux2(Vertice<V,E> v, Map<Vertex<V>, Boolean> vis, Map<V,Integer> retorno){
		try{
			vis.put(v, true);
			if(retorno.get(v.element())==null){
				retorno.put(v.element(), v.getAdyacentes().size());
			}else{
				if(retorno.get(v.element())< v.getAdyacentes().size()){
					retorno.put(v.element(), v.getAdyacentes().size());
				}
			}
			for(Arco<V,E> a: v.getAdyacentes()){
				if(a.getPredecesor() == v && vis.get(a.getSucesor())==false){
					DFSAux2(a.getSucesor(),vis,retorno);
				} else if(a.getSucesor() == v && vis.get(a.getPredecesor())==false){
					DFSAux2(a.getPredecesor(),vis,retorno);
				}
			}
		}catch(InvalidKeyException e){}
	}
	
	//Vértices Decorables
	private static final Object ESTADO= new Object();
	private static final Object VISITADO= new Object();
	private static final Object NOVISITADO= new Object();
	
	private void DFSD(){
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
					DFSAuxD(vertice);
			} catch (InvalidKeyException e) {
				e.printStackTrace();
			}
		}
	}
	private void DFSAuxD(Vertice<V,E> vertice){
		System.out.print(vertice.element()+" ");
        try{
		  vertice.put(ESTADO, VISITADO);
		  for(Arco<V,E> arco: vertice.getAdyacentes()){
			  if(arco.getV1()==vertice && arco.getV2().get(ESTADO)==NOVISITADO)
					DFSAuxD(arco.getV2());
			  else
				 if(arco.getV2()==vertice && arco.getV1().get(ESTADO)==NOVISITADO)
					 DFSAuxD(arco.getV1());
		  }
        }
        catch(InvalidKeyException e){
        	e.printStackTrace();
        }
	}
	
}

