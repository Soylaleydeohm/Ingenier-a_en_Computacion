package TDADiccionario;

import TDAMapeo.*;
import TDALista.*;

import java.util.Iterator;

import ColaConPrioridad.*;

public class DiccionarioConHash<K,V> implements Dictionary<K,V> {

	/*
	protected PositionList<Entry<K,V>>[] lista;
	protected int cant;
	protected int capacidad;
	
	public DiccionarioConHash(){
		lista= (PositionList<Entry<K,V>>[])new Object[1023];
		cant=0;
		capacidad=1023;
		for(int i=0; i<capacidad; i++){
			lista[i]=new ListaDoblementeEnlazada<Entry<K,V>>();
		}
	}
	 */
	protected Dictionary<K,V>[] arreglo;
	protected int cant;
	protected int capacidad;
	
	public DiccionarioConHash(){
		arreglo= (Dictionary<K,V> [])new Dictionary[1023];
		cant=0;
		capacidad=1023;
		for(int i=0; i<capacidad; i++){
			arreglo[i]=new DiccionarioConLista<K,V>();
		}
	}
	
	protected int h(K x){
		return Math.abs(x.hashCode()%capacidad);
	}
	
	public int size() {
		return cant;
	}

	public boolean isEmpty() {
		return cant==0;
	}

	public Entry<K, V> find(K key) throws InvalidKeyException {
		if(key==null)
			throw new InvalidKeyException("Error: la clave es nula.");
		return arreglo[h(key)].find(key);
	}

	public Iterable<Entry<K, V>> findAll(K key) throws InvalidKeyException {
		if(key==null)
			throw new InvalidKeyException("Error: la clave es nula.");
		return arreglo[h(key)].findAll(key);
	}

	public Entry<K, V> insert(K key, V value) throws InvalidKeyException {
		if(key==null)
			throw new InvalidKeyException("Error: la clave es nula.");
		if((cant/capacidad>=1))
			reSize();
		Entry<K,V> retorno= arreglo[h(key)].insert(key, value);
		cant++;
		return retorno;
	}

	protected void reSize(){
		capacidad=capacidad*2;
		Dictionary<K,V>[] aux= (Dictionary<K,V> [])new Dictionary[capacidad];
		for(int i=0; i<capacidad; i++){
			aux[i]=new DiccionarioConLista<K,V>();
		}
		for(Entry<K,V> entrada: entries()){
			try {
				aux[h(entrada.getKey())].insert(entrada.getKey(), entrada.getValue());
			} catch (InvalidKeyException e) {
				e.printStackTrace();
			}
		}
	}
	
	public Entry<K, V> remove(Entry<K, V> e) throws InvalidEntryException {
		if(e==null || e.getKey()==null)
			throw new InvalidEntryException("Error: la entrada o la clave son nulas.");
		Entry<K,V> retorno= arreglo[h(e.getKey())].remove(e);
		cant--;
		return retorno;
	}

	public Iterable<Entry<K, V>> entries() {
		PositionList<Entry<K,V>> retorno= new ListaDoblementeEnlazada<Entry<K,V>>();
		for(int i=0; i<capacidad; i++){
				for(Entry<K,V> entrada: arreglo[i].entries()){
					retorno.addLast(entrada);
				}
		}
		return retorno;
	}
	
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
				System.out.println(""+pq.removeMin().getValue());
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

}
