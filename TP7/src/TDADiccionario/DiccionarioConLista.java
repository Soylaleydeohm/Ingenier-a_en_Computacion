package TDADiccionario;
import java.util.Iterator;

import TDALista.*;

public class DiccionarioConLista<K,V> implements Dictionary<K,V> {

    protected PositionList<Entry<K,V>> lista;
	
    public DiccionarioConLista(){
    	lista=  new ListaDoblementeEnlazada <Entry<K,V>>();
    }
    
	public int size() {
		return lista.size();
	}
 
	public boolean isEmpty() {
	   return lista.isEmpty();
	}

	public Entry<K,V> find(K key) throws InvalidKeyException {
		if(key==null)
			throw new InvalidKeyException("Error: la clave es nula.");
		Entry<K,V> retorno=null;
		Iterator<Entry<K,V>> it= lista.iterator();
		Entry<K,V> actual;
		boolean encontre=false;
		while(it.hasNext() && !encontre){
			actual=it.next();
			if(actual.getKey().equals(key)){
				retorno=actual;
				encontre=true;
			}
		}
		return retorno;
	}
	
	public Iterable<Entry<K, V>> findAll(K key) throws InvalidKeyException {
		if(key==null)
			throw new InvalidKeyException("Error: la clave es nula.");
		PositionList<Entry<K,V>> retorno= new ListaDoblementeEnlazada<Entry<K,V>>();
		Iterator<Entry<K,V>> it= lista.iterator();
		Entry<K,V> actual;
		while(it.hasNext() ){
			actual=it.next();
			if(actual.getKey().equals(key)){
				retorno.addLast(actual);
			}
		}
		return retorno; 
	}

	public Entry<K, V> insert(K key, V value) throws InvalidKeyException {
		if(key==null)
			throw new InvalidKeyException("Error: la clave es nula.");
		Entry<K,V> retorno=null;
		lista.addLast(new Entrada<K,V>(key, value));
		try {
			retorno=lista.last().element();
		} catch (EmptyListException e) {
			e.printStackTrace();
		}
		return retorno;
	}

	public Entry<K, V> remove(Entry<K, V> e) throws InvalidEntryException {
		Entry<K,V> retorno=null;
		Position<Entry<K,V>> posActual;
		Iterator<Position<Entry<K,V>>> it= lista.positions().iterator();
		while(it.hasNext() && retorno==null){
			posActual=it.next();
			if(posActual.element()==e){
				retorno=posActual.element();
				try {
					lista.remove(posActual);
				} catch (TDALista.InvalidPositionException e1) {
					e1.printStackTrace();
				}
			}
		}
		if(retorno==null)
			throw new InvalidEntryException("Error: entrada inválida.");
		return retorno;
	}

	public Iterable<Entry<K, V>> entries() {
		return lista;
	}

}
