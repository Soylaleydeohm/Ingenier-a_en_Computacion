package TDAMapeo;
import java.util.Iterator;

import TDALista.*;

public class HashAbierto<K,V> implements Map<K,V>{
	
	protected Map<K,V>[] arreglo;
	protected int cant;
	protected int N;

	public HashAbierto(){
		arreglo= (Map<K,V>[])new Map[101];
		N=101;
		for(int i=0; i<N; i++){
			arreglo[i]= new MapeoConLista<K,V>();
		}
		cant=0;
	}
	
	public int size() {
		return cant;
	}
	public boolean isEmpty() {
		return cant==0;
	}
	//--------------------------------------------------
	//Retorna la función de hash de la clave k
	private int h(K k) throws InvalidKeyException{
		if(k==null)
			throw new InvalidKeyException("Error: la clave es nula.");
		return Math.abs(k.hashCode()%N);
	}
	//Agranda el arreglo de mapeos cuando el factor de carga es superado
	private void reSize(){
		Iterator<Entry<K,V>> it= entries().iterator();
		Map<K,V> [] aux= (Map<K,V> []) new Map[nextPrimo(N*2)];
		N=aux.length;
		Entry<K,V> actual;
		for(int i=0; i<N; i++)
			aux[i]= new MapeoConLista<K,V>();
		while(it.hasNext()){
			actual= it.next();
			try{
			 aux[h(actual.getKey())].put(actual.getKey(), actual.getValue());
			}
			catch(InvalidKeyException e){System.out.println(""+e.getMessage());}
		}
		arreglo=aux;
	}
	//Retorna el número primo siguiente a i
	private int nextPrimo(int i){
		int primo=i+1;
		while(!esPrimo(primo))
			primo++;
		return primo;
	}
	//Dado un entero x retorna verdadero si x es primo y falso en caso contrario
	private boolean esPrimo(int x){
		boolean es=true;
		for(int i=2; i<x && es; i++)
			if(x%i==0)
				es=false;
		return es;
	}
	//--------------------------------------------------
	public V get(K key) throws InvalidKeyException {
		return arreglo[h(key)].get(key);
	}
	public V put(K key, V value) throws InvalidKeyException {
		if((float)cant/N>=0.9)
			reSize();
		V respuesta= arreglo[h(key)].put(key, value);
		if(respuesta==null)
			cant++;
		return respuesta;
	}
	public V remove(K key) throws InvalidKeyException {
		V respuesta= arreglo[h(key)].remove(key);
		if(respuesta!=null)
			cant--;
		return respuesta;
	}
	public Iterable<K> keys() {
		PositionList<K> coleccionOrdenada= new ListaDoblementeEnlazada<K>();
		Iterator<K> it;
		for(int i=0; i<N; i++){
			it=arreglo[i].keys().iterator();
			while(it.hasNext()){
				coleccionOrdenada.addLast(it.next());
			}
		}
		return coleccionOrdenada;
	}
	public Iterable<V> values() {
		PositionList<V> coleccionOrdenada= new ListaDoblementeEnlazada<V>();
		Iterator<V> it;
		for(int i=0; i<N; i++){
			it=arreglo[i].values().iterator();
			while(it.hasNext()){
				coleccionOrdenada.addLast(it.next());
			}
		}
		return coleccionOrdenada;
	}
	public Iterable<Entry<K, V>> entries() {
		PositionList<Entry<K,V>> coleccionOrdenada= new ListaDoblementeEnlazada<Entry<K,V>>();
		Iterator<Entry<K,V>> it;
		for(int i=0; i<N; i++){
			it=arreglo[i].entries().iterator();
			while(it.hasNext()){
				coleccionOrdenada.addLast(it.next());
			}
		}
		return coleccionOrdenada;
	}
	
	public void dobleTamaño(){
		N=2*N;
		Iterator<Entry<K,V>> it= entries().iterator();
		Map<K,V> [] aux= (Map<K,V> []) new Map[N];
		Entry<K,V> entrada;
		for(int i=0; i<N; i++)
			aux[i]=new MapeoConLista<K,V>();
		while(it.hasNext()){
			entrada=it.next();
			try {
				aux[h(entrada.getKey())].put(entrada.getKey(), entrada.getValue());
			} catch (InvalidKeyException e) {
				e.printStackTrace();
			}	
		}
		arreglo=aux;
	}
	
}
