package TDAMapeo;

import TDALista.*;

public class MapeoConLista3<K, V> implements Map<K, V> { 
	protected ListaDoblementeEnlazada<Entrada<K,V>> S;
	
	public MapeoConLista3() {
		S = new ListaDoblementeEnlazada<Entrada<K,V>>();
	}
	
	public int size() {
		return S.size();
	}
	
	public boolean isEmpty() {
		return S.isEmpty();
	}
	
	public V put(K k, V v) throws InvalidKeyException {
		if(k == null)
			throw new InvalidKeyException("Clave nula");
		V toReturn = null;
		for(Entrada<K,V> e : S)
			if(e.getKey() == k) {
				toReturn = e.getValue();
				e.setValue(v);
				return toReturn;
			}
		Entrada<K,V> e = new Entrada<K,V>(k,v);
		S.addLast(e);
		return null;
	}
	
	public V get(K k) throws InvalidKeyException {
		if(k == null)
			throw new InvalidKeyException("Clave nula");
		for(Entrada<K,V> e : S)
			if(e.getKey().equals(k))
				return e.getValue();
		return null;
	}
	
	public V remove(K k) throws InvalidKeyException {
		if(k == null)
			throw new InvalidKeyException("Clave nula");
		try {
			for(Position<Entrada<K,V>> p : S.positions())
				if(p.element().getKey().equals(k)) {
					V toReturn = p.element().getValue();
					S.remove(p);
					return toReturn;
				}
		}catch(InvalidPositionException e) {}
		return null;
	}
	
	public Iterable<K> keys() {
		PositionList<K> lista = new ListaDoblementeEnlazada<K>();
		for(Entrada<K,V> e : S)
			lista.addLast(e.getKey());
		return lista;
	}
    
	public Iterable<V> values() {
		PositionList<V> lista = new ListaDoblementeEnlazada<V>();
		for(Entrada<K,V> e : S)
			lista.addLast(e.getValue());
		return lista;
	}
	
	public Iterable<Entry<K,V>> entries() {
		PositionList<Entry<K,V>> lista = new ListaDoblementeEnlazada<Entry<K,V>>();
		for(Entrada<K,V> e : S)
			lista.addLast(e);
		return lista;
	}
}

