package TDAMapeo;

import java.util.Comparator;

public class ABB<K,V> implements Map<K,V> {

	protected NodoABB<Entrada<K,V>> raiz;
	protected Comparator<Entrada<K,V>> comp;
	protected int tama�o;
	
	public ABB(Comparator<Entrada<K,V>> c){
		raiz= new NodoABB<Entrada<K,V>>(null,null,null,null);
		tama�o=0;
		comp=c;
	}

	public int size() {
		return tama�o;
	}

	public boolean isEmpty() {
		return tama�o==0;
	}

	public V get(K key) throws InvalidKeyException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public V put(K key, V value) throws InvalidKeyException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public V remove(K key) throws InvalidKeyException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<K> keys() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<V> values() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<Entry<K, V>> entries() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
