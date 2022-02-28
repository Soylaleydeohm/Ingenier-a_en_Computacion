package TDAMapeo;
import java.util.Iterator;

import TDALista.*;

public class MapeoConLista<K,V> implements Map<K,V> {
	
	protected PositionList<Entrada<K,V>> lista;

	public MapeoConLista(){
		lista= new ListaDoblementeEnlazada<Entrada<K,V>>();
	}
	
	public int size() {
		return lista.size();
	}
	public boolean isEmpty() {
		return lista.isEmpty();
	}
	public V get(K key) throws InvalidKeyException {
		if(key==null)
			throw new InvalidKeyException("Error: la clave es nula.");
		V retorno = null;
		boolean encontre=false;
		Iterator<Entrada<K,V>> it= lista.iterator();
		Entrada<K,V> actual;
		while(it.hasNext() && !encontre){
			actual=it.next();
			if(actual.getKey().equals(key)){
				encontre=true;
				retorno=actual.getValue();
			}		
		}
		return retorno;		
	}
	public V put(K key, V value) throws InvalidKeyException {
		if(key==null)
			throw new InvalidKeyException("Error: la clave es nula.");
		boolean encontre=false;
		V retorno= null;
		Iterator<Entrada<K,V>> it= lista.iterator();
		Entrada<K,V> actual;
		while(it.hasNext() && !encontre){
			actual=it.next();
			if(actual.getKey().equals(key)){
				encontre=true;
				retorno=actual.getValue();
				actual.setValue(value);
			}
		}
		if (!encontre){
			lista.addLast(new Entrada<K,V>(key, value));
		}
		return retorno;
	}
	public V remove(K key) throws InvalidKeyException {
		if(key==null)
			throw new InvalidKeyException("Error: la clave es nula.");
		boolean encontre=false;
		V retorno= null;
		Iterator<Position<Entrada<K,V>>> it= lista.positions().iterator();
		Position<Entrada<K,V>> actual;
		while(it.hasNext() && !encontre){
			actual=it.next();
			if(actual.element().getKey().equals(key)){
				encontre=true;
				retorno=actual.element().getValue();
				try{
				lista.remove(actual);
				}
				catch(InvalidPositionException e){System.out.println(e.getMessage()+"");};
			}
		}
		return retorno;
	}
	public Iterable<K> keys() {
		PositionList<K> coleccionIterable= new ListaDoblementeEnlazada<K>();
		Iterator<Entrada<K,V>> it= lista.iterator();
		while(it.hasNext())
			coleccionIterable.addLast(it.next().getKey());
		return coleccionIterable;
	}
	public Iterable<V> values() {
		PositionList<V> coleccionIterable= new ListaDoblementeEnlazada<V>();
		Iterator<Entrada<K,V>> it= lista.iterator();
		while(it.hasNext())
			coleccionIterable.addLast(it.next().getValue());
		return coleccionIterable;
	}
	public Iterable<Entry<K, V>> entries() {
		PositionList<Entry<K,V>> coleccionIterable= new ListaDoblementeEnlazada<Entry<K,V>>();
		Iterator<Entrada<K,V>> it= lista.iterator();
		while(it.hasNext())
			coleccionIterable.addLast(it.next());
		return coleccionIterable;
	}
}
