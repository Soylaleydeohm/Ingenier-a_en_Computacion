package ColaConPrioridad;
import java.util.Comparator;

public class Heap<K,V> implements PriorityQueue<K,V>{
	protected Entry<K,V> [] elems;
	protected Comparator<K> comp;
	protected int size;
	
	public Heap(int maxElems, Comparator<K> comp) {
		elems = (Entry<K,V> []) new Entry[maxElems];
		this.comp = comp;
		size = 0;
	}
	
	public Heap() {
		elems = (Entry<K,V> []) new Entry[1000];
		comp = new DefaultComparator<K>();
		size = 0;
	}
	
	public int size() {
		return size;
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	public Entry<K,V> min() throws EmptyPriorityQueueException {
		if(isEmpty())
			throw new EmptyPriorityQueueException("Cola vacia");
		return elems[1];
	}
	
	public Entry<K,V> insert(K key, V value) throws InvalidKeyException {
		if(key == null)
			throw new InvalidKeyException("Clave nula");
		Entrada<K,V> entrada = new Entrada<K,V>(key, value);
		if(size == elems.length-1)
			 this.duplicar();
		elems[++size] = entrada;
		int i = size;
		boolean ordenado = false;
		while(i > 1 && !ordenado) {
			Entry<K,V> elemActual = elems[i];
			Entry<K,V> elemPadre = elems[i/2];
			if(comp.compare(elemActual.getKey(), elemPadre.getKey()) < 0) {
				Entry<K,V> aux = elems[i];
				elems[i] = elems[i/2];
				elems[i/2] = aux;
				i /= 2;
			}
			else
				ordenado = true;
		}
		return entrada;
	}
	
	/**
	  * Remueve y devuelve la entrada con menor prioridad de la cola.
	  * @return Entrada con menor prioridad.
	  * @throws EmptyPriorityQueueException si la cola está vacía.
	  */
	public Entry<K,V> removeMin() throws EmptyPriorityQueueException {
		Entry<K,V> toReturn = min();
		if(size == 1) {
			elems[1] = null;
			size = 0;
		}
		else {
			elems[1] = elems[size];
			elems[size--] = null;
			int i = 1;
			boolean ordenado = false;
			while(!ordenado) {
				int hi = i*2;
				int hd = i*2+1;
				boolean tieneHijoIzquierdo = hi <= size;
				boolean tieneHijoDerecho =  hd <= size;
				ordenado = !tieneHijoIzquierdo;
				if(!ordenado) {
					int minimoHijo;
					if(tieneHijoDerecho) {
						if(comp.compare(elems[hi].getKey(), elems[hd].getKey()) < 0)
							minimoHijo = hi;
						else
							minimoHijo = hd;
					}
					else
						minimoHijo = hi;
					if(comp.compare(elems[i].getKey(), elems[minimoHijo].getKey()) > 0) {
						Entry<K,V> aux = elems[i];
						elems[i] = elems[minimoHijo];
						elems[minimoHijo] = aux;
						i = minimoHijo;
					}
					else
						ordenado = true;
				}
			}
		}
		return toReturn;
	}
	
	private void duplicar() {
		Entry<K,V> [] aux = (Entry<K,V> []) new Entrada[elems.length];
		for(int i = 1 ; i < elems.length; i++)
			aux[i] = elems[i];
		elems = (Entrada<K,V> []) new Entrada[2*aux.length];
		for(int i = 1 ; i < aux.length; i++) 
			elems[i] = aux[i];
	}
}
