package TDAMapeo;

import java.lang.Iterable;
import TDALista.*;

/**
 * Class MapeoHashAbierto
 * @author VirginiaAraceli
 * @param <K> Parámetro formal de tipo que representa el tipo de la clave los elementos de MapeoConLista.
 * @param <V> Parámetro formal de tipo que representa el tipo del valor los elementos de MapeoConLista.
 */
public class MapeoHashAbierto <K,V> implements Map<K,V> {
	protected Map<K,V> [] array;
	protected int size;
	protected int N;
	
	@SuppressWarnings("unchecked")
	/**
	 * Crea un mapeo con un arreglo de MapeoConLista.
	 */
	public MapeoHashAbierto(){
		N = 11;
		array = (Map<K,V>[]) new MapeoConLista[N];	
		for(int i=0; i < N; i++)
			array[i] = new MapeoConLista<K,V>();
		size = 0;
	}
	
	public V put (K k, V v) throws InvalidKeyException{
		checkKey(k);
		if((size/N) > 0.9){
			rehash();
		}		
		V value = array[hash(k)].put(k,v);
		if(value == null) size++;
		return value;
	}
	
	public V get (K k) throws InvalidKeyException{
		checkKey(k);
		return array[hash(k)].get(k);
	}
		
	public int size (){
		return size;
	}
	
	public boolean isEmpty(){
		return (size == 0);
	}
	
	public V remove(K k) throws InvalidKeyException{
		checkKey(k);
		V value = array[hash(k)].remove(k);
		if(value != null)
			size--;
		return value;
	}
	
	public Iterable<K> keys(){
		PositionList<K> claves = new ListaDoblementeEnlazada<K>();
		for(int i=0; i<N; i++){
			for(K k : array[i].keys())
				claves.addLast(k);
		}
		return claves;
	}
	
	public Iterable<V> values(){
		PositionList<V> valores = new ListaDoblementeEnlazada<V>();
		for(int i=0; i<N; i++){
			for(V v : array[i].values())
				valores.addLast(v);
		}
		return valores;
	}
	
	public Iterable<Entry<K, V>> entries(){
		ListaDoblementeEnlazada<Entry<K, V>> entradas = new ListaDoblementeEnlazada<Entry<K, V>>();
		for(int i = 0; i < array.length; i++){
			if(!array[i].isEmpty()){
				for(Entry<K, V> entrada : array[i].entries())
					entradas.addLast(entrada);
			}
		}
		return entradas;
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
	
	/**
	 * Distribuye a las entradas según la función de hash.
	 * @param key Clave a evaluar en la función.
	 * @return Ubibación en la tabla de hash.
	 */
	private int hash(K key){
	    return Math.abs(key.hashCode() % N);
	}
	
	@SuppressWarnings("unchecked")
	/**
	 * Aumenta el tamaño del arreglo.
	 */
	private void rehash(){
		int n = proximoPrimo();
		Map<K,V> []  aux = (Map<K,V>[]) new MapeoConLista[n];
		for(int i = 0; i < n; i++){
			aux[i] = new MapeoConLista<K,V>();
		}
		N = n;
		for(Entry<K,V> e: entries()){
			try {
				aux[hash(e.getKey())].put(e.getKey(), e.getValue());
			} catch (InvalidKeyException e1) {
				e1.printStackTrace();
			}
		}
		array = aux;
		
	}
	
	/**
	 * Busca el próximo número primo.
	 * @return Siguiente número primo.
	 */
	private int proximoPrimo(){
		int n = N*2+1;
		while(!esPrimo(n)){
			n++;
		}
		return n;
	}
	
	/**
	 * Verifica si un número pasado por parámetro es primo.
	 * @param numero número a evaluar.
	 * @return Verdadero si es primo, falso en caso contrario.
	 */
	private boolean esPrimo(int numero){
		int contador = 2;
		boolean primo = true;
		while ((primo) && (contador <= numero/2)){
			if (numero % contador == 0)
				primo = false;
			contador++;
		}
	return primo;
	}
}