package EjercicioPArcial;
import TDADiccionario.InvalidKeyException;

public interface Dictionary<K,V>
{	public int size();
	
	public boolean isEmpty();
	
	public Entry<K,V> find(K key) throws InvalidKeyException;
	
	public Iterable<Entry<K,V>> findAll(K key) throws InvalidKeyException;
	
	public Entry<K,V> insert(K key, V value) throws InvalidKeyException;
	
	public Entry<K,V> remove(Entry<K,V> e) throws InvalidEntryException;
	
	public Iterable<Entry<K,V>> entries();	
}

public class DiccionarioConHash<K,V> implements Dictionary<K,V> {
	protected PositionList<Entry<K,V>>[] lista;
	protected int cant;
	protected int capacidad;
	protected Comparator<K> comp;
	
	public DiccionarioConHash(){
		lista= (PositionList<Entry<K,V>>[])new Object[1023];
		cant=0;
		capacidad=1023;
		for(int i=0; i<capacidad; i++){
			lista[i]=new ListaDoblementeEnlazada<Entry<K,V>>();
		}
		comp = new DefaultComparator<K>();
	}
	
	protected int h(K x){}
	
	public int size() {}

	public boolean isEmpty() {}

	public Entry<K, V> find(K key) throws InvalidKeyException {}

	public Iterable<Entry<K, V>> findAll(K key) throws InvalidKeyException {}

	public Entry<K, V> insert(K key, V value) throws InvalidKeyException {}

	protected void reSize(){}
	
	public Entry<K, V> remove(Entry<K, V> e) throws InvalidEntryException {}

	public Iterable<Entry<K, V>> entries() {}
}


public interface Entry<K,V> {

	public K getKey();
	
	public V getValue();
}

public class Entrada<K,V> implements Entry<K,V>{
	private V valor;
	private K clave;
	
	public Entrada(K c, V v){
		valor=v;
		clave=c;
	}
	
	public K getKey() {}
	public V getValue() {}
    public void setKey(K c){}
    public void setValue(V v){}
}

public class InvalidEntryException extends Exception{

	public InvalidEntryException(String msg){
		super(msg);
	}
}

b)
public interface PositionList<E> extends Iterable<E> {
	public Position<E> first() throws EmptyListException;
	public Position<E> last() throws EmptyListException;
	public Position<E> prev(Position<E> p) throws InvalidPositionException, BoundaryViolationException;
	public Position<E> next(Position<E> p) throws InvalidPositionException, BoundaryViolationException;
}

public class Nodo<E> implements Position<E> {
	private E elemento;
	private Nodo<E> siguiente;

	public Nodo(E elem, Nodo<E> sig){
		elemento = elem;
		siguiente = sig;
	}	
	public Nodo(E elem){}	
	public E element(){}
	public void setElemento(E item){}
	public Nodo<E> getSiguiente(){}
	public void setSiguiente(Nodo<E> sig){}
}

public class ListaDoblementeEnlazada<E> implements PositionList<E>{
	protected DNodo<E> header;
	protected DNodo<E> trailer;
	protected int longitud;
	
	public ListaDoblementeEnlazada(){
		header = new DNodo<E>(null, null, null);
		trailer = new DNodo<E>(header, null, null);
		header.setNext(trailer);
		longitud = 0;
	}
	
	public void addLast(E e) {
		DNodo<E> nuevo = new DNodo<E>(trailer.getPrev(), trailer, e);
		trailer.getPrev().setNext(nuevo);
		trailer.setPrev(nuevo);
		longitud++;	
	}
	
	public E remove(Position<E> p) throws InvalidPositionException {
		if (isEmpty()) throw new InvalidPositionException("La lista está vacía, no se puede remover esa posición");
		DNodo<E> n = checkPosition(p);
		E aux = n.element();
		DNodo<E> pPrev = n.getPrev();
		DNodo<E> pNext = n.getNext();
		pPrev.setNext(pNext);
		pNext.setPrev(pPrev);
		n.setNext(null);
		n.setPrev(null);
		return aux;
	}
	
	private DNodo<E> checkPosition(Position<E> p) throws InvalidPositionException{
		if(p == null) throw new InvalidPositionException("Posición nula");
		if(p == header || p == trailer) throw new InvalidPositionException("No es posición válida");
		try{
			DNodo<E> n = (DNodo<E>) p;
			if(n.getPrev() == null || n.getNext() == null)
				throw new InvalidPositionException("No es posición válida");
			return n;
		}catch(ClassCastException e){
			throw new InvalidPositionException("El argumento no es una posición");
		}
	}
	
}

public class InvalidPositionException extends Exception{
	public InvalidPositionException(String err){
		super(err);
	}
}

c)

public void prueba(){
	Map<K, Integer> mapeo = new TablaDispersionCerrada<K, Integer>();
	PriorityQueue<Integer, K> pq = new PQConArreglo<Integer, K>();
	try {
		for(Entry<K,V> e : entries()){
			if(mapeo.get(e.getKey())==null){
				int tamaño = 0;				
				for(Entry<K,V> ent : findAll(e.getKey())){
					tamaño++;
				}
				mapeo.put(e.getKey(), tamaño);
			}				
		} 
		for(TDAMapeo.Entry<K, Integer> e : mapeo.entries()){
			pq.insert(e.getValue(), e.getKey());
		}
		while(!pq.isEmpty()){
			System.out.println(""+pq.removeMin().toString());
		}
	}catch (InvalidKeyException e1) {
		e1.printStackTrace();
	} catch (TDAMapeo.InvalidKeyException e1) {
		e1.printStackTrace();
	} catch (ColaConPrioridad.InvalidKeyException e1) {
		e1.printStackTrace();
	} catch (EmptyPriorityQueueException e1) {
		e1.printStackTrace();
	}
}
