package TDAMapeo;

import TDALista.*;
import java.util.Iterator;

/**
 * Class MapeoConLista
 * @author VirginiaAraceli
 * @param <K> Parámetro formal de tipo que representa el tipo de la clave los elementos de MapeoConLista.
 * @param <V> Parámetro formal de tipo que representa el tipo del valor los elementos de MapeoConLista.
 */
public class MapeoConLista<K, V> implements Map <K, V>{
	
	protected ListaDoblementeEnlazada <Entrada<K, V>> s;
	
	/**
	 * Crea un nuevo Mapeo con listas.
	 */
	public MapeoConLista(){
		s = new ListaDoblementeEnlazada<Entrada<K,V>>();
	}
	
	public int size() {
		return s.size();
	}

	public boolean isEmpty() {
		return s.isEmpty();
	}

	public V get(K key) throws InvalidKeyException {
		checkKey(key);
		V v = null;
		boolean encontre = false;
		Iterable<Entry<K, V>> it = entries();
		Iterator<Entry<K, V>> iterador = it.iterator();
		while(iterador.hasNext() && !encontre){
			Entry<K, V> valor = iterador.next();
			if(valor.getKey().equals(key)){
				v = valor.getValue();
				encontre = true;
			}
		}
		return v;
	}
	
	/**
	 * Verifica que la clave pasada por parámetro sea válida
	 * @param key Clave a verificar 
	 * @throws InvalidKeyException si la clave pasada por parámetro es inválida.
	 */
	private void checkKey(K key)throws InvalidKeyException{
		if(key == null)
			throw new InvalidKeyException("Clave inválida");
	}

	public V put(K key, V value) throws InvalidKeyException {
		checkKey(key);
		boolean encontre = false;
		V v = null;
		Iterable<Entry<K, V>> it = entries();
		Iterator<Entry<K, V>> iterador = it.iterator();
		while(iterador.hasNext() && !encontre){
			Entrada<K, V> valor = (Entrada<K, V>)iterador.next();
			if(valor.getKey().equals(key)){
				v = valor.getValue();
				valor.setValue(value);
				encontre = true;
			}
		}
		if (!encontre)	
			s.addLast(new Entrada<K, V> (key, value));
		return v;
	}

	public V remove(K key) throws InvalidKeyException {
		checkKey(key);
		V v = null;
		boolean encontre = false;
		Iterable<Position<Entrada<K, V>>> itPos = s.positions();
		Iterator<Position<Entrada<K, V>>> iterador = itPos.iterator();
		while(iterador.hasNext() && !encontre){
			Position<Entrada<K, V>> posValor = iterador.next();
			Entry<K, V> valor = posValor.element();
			if(valor.getKey().equals(key)){
				v = valor.getValue();
				try {
					s.remove(posValor);
				} catch (InvalidPositionException e) {
					e.printStackTrace();
				}
				encontre = true;
			}
		}
		return v;
	}

	public Iterable<K> keys() {
		ListaDoblementeEnlazada<K> keys = new ListaDoblementeEnlazada<K>();
		Iterable<Position<Entrada<K, V>>> itPos = s.positions();
		Iterator<Position<Entrada<K, V>>> iterador = itPos.iterator();
		while(iterador.hasNext()){
			keys.addLast(iterador.next().element().getKey());
		}
		return keys;
	}

	public Iterable<V> values() {
		ListaDoblementeEnlazada<V> values = new ListaDoblementeEnlazada<V>();
		Iterable<Position<Entrada<K, V>>> itPos = s.positions();
		Iterator<Position<Entrada<K, V>>> iterador = itPos.iterator();
		while(iterador.hasNext()){
			values.addLast(iterador.next().element().getValue());
		}
		return values;
	}

	public Iterable<Entry<K, V>> entries() {
		ListaDoblementeEnlazada<Entry<K, V>> entradas = new ListaDoblementeEnlazada<Entry<K, V>>();
		Iterable<Position<Entrada<K, V>>> itPos = s.positions();
		Iterator<Position<Entrada<K, V>>> iterador = itPos.iterator();
		while(iterador.hasNext()){
			entradas.addLast(iterador.next().element());
		}
		return entradas;
	}
}
