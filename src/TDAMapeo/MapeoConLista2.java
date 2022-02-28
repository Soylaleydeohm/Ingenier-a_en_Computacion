package TDAMapeo;

import java.util.Comparator;
import TDALista.*;

 
public class MapeoConLista2<K, V> implements Map<K, V> {
	protected ListaDoblementeEnlazada<Entrada<K,V>> L;
	protected Comparator<K> c;
	public MapeoConLista2() { L = new ListaDoblementeEnlazada<Entrada<K,V>>(); }
	
	public int size(){return L.size();}
	public boolean isEmpty(){return L.isEmpty();}
	
	public V put(K k, V v) throws InvalidKeyException{
		if(k == null) throw new InvalidKeyException("Clave inválida");
		for(Entrada<K,V> p : L){
			if(p.getKey().equals(k)){
				V aux = p.getValue();
				p.setValue(v);
				return aux;
			}
		}
		L.addLast(new Entrada<K,V>(k,v));
		return null;
	}
	
	public V get(K k) throws InvalidKeyException{
	if(k == null) throw new InvalidKeyException("Clave inválida");
		for(Position<Entrada<K,V>> p : L.positions()){
			if(p.element().getKey().equals(k))
				return p.element().getValue();
			}
		return null;
	}
	public V remove (K k)throws InvalidKeyException{
		try{
			if(k == null) throw new InvalidKeyException("Clave inválida");
			for(Position<Entrada<K,V>> p : L.positions()){
				if(p.element().getKey().equals(k)){
					V v = p.element().getValue();
					L.remove(p);
					return v;
				}
			}
		}catch (InvalidPositionException x){x.getStackTrace();}
		return null;
	}
	
	public Iterable<K> keys(){
		PositionList<K> toReturn = new ListaDoblementeEnlazada<K>();
		for(Position<Entrada<K,V>> p : L.positions())
			toReturn.addLast(p.element().getKey());
		return toReturn;}
	
	public Iterable<V> values(){
		PositionList<V> toReturn = new ListaDoblementeEnlazada<V>();
		for(Entrada<K,V> p : L) 
		toReturn.addLast(p.getValue());
		return toReturn;}
	///////////POR QUE NO PUEDO HACER ENTRIES ASI ?????
	/*public Iterable<Entry<K,V>> entries1(){
	return (Iterable<Entry<K,V>>) L;}*/
	
	public Iterable<Entry<K,V>> entries(){
	PositionList<Entry<K,V>> toReturn = new ListaDoblementeEnlazada<Entry<K,V>>();
	for(Position<Entrada<K,V>> p: L.positions()) toReturn.addLast(p.element());
	return toReturn;
	}

}