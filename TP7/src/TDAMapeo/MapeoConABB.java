package TDAMapeo;

import TDALista.*;
import java.util.Comparator;

public class MapeoConABB<K,V> implements Map<K,V> {
	protected ABB<K,V> arbol;
	protected int size;
	Comparator<K> comp;

	public MapeoConABB(Comparator<K> comp) {
		arbol = new ABB<K,V>();
		size = 0;
		this.comp = comp;
	}
	
	public MapeoConABB() {
		this(new DefaultComparator<K>());
	}
	
	public int size() {
		return size;
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	
	public V get(K key) throws InvalidKeyException {
		if(key == null)
			throw new InvalidKeyException("Clave invalida");
		return arbol.find(key).getValue();
	}
	
	public V put(K key, V value) throws InvalidKeyException {
		if(key == null)
			throw new InvalidKeyException("Clave invalida");
		size++;
		return arbol.insert(new Entrada<K,V>(key, value));
	}
		
	
	public V remove(K key) throws InvalidKeyException {
		if(key == null || size == 0)
			throw new InvalidKeyException("Clave invalida");
		size--;
		return arbol.remove(key);
	}	
		
	public Iterable<V> values() {
		PositionList<V> lista = new ListaDoblementeEnlazada<V>();
		for(Entry<K,V> e : arbol.entriesArbol()){
			lista.addLast(e.getValue());
		}
		return lista;
	}
	
	public Iterable<K> keys() {
		PositionList<K> lista = new ListaDoblementeEnlazada<K>();
		for(Entry<K,V> e : arbol.entriesArbol()){
			lista.addLast(e.getKey());
		}
		return lista;
	}
	
	public Iterable<Entry<K,V>> entries() {
		PositionList<Entry<K,V>> lista = new ListaDoblementeEnlazada<Entry<K,V>>();
		for(Entry<K,V> e : arbol.entriesArbol()){
			lista.addLast(e);
		}
		return lista;
	}
	
}
