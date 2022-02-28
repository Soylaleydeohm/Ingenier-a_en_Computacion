package TDAMapeo;


/**
 * Class Entrada
 * @author VirginiaAraceli
 * @param <K> Parámetro formal de tipo que representa el tipo de la clave los elementos de MapeoConLista.
 * @param <V> Parámetro formal de tipo que representa el tipo del valor los elementos de MapeoConLista.
 */
public class Entrada <K,V> implements Entry<K,V>{
	
	private K clave;
	private V valor;
	
	/**
	 * Crea una nueva entrada de clave k y valor v.
	 * @param k Clave de la entrada.
	 * @param v Valor de la entrada.
	 */
	public Entrada (K k,V v){
		clave = k;
		valor = v;
	}
	public K getKey(){
		return clave;
	}
	public V getValue(){
		return valor;
	}
	
	/**
	 * Modifica la clave de la entrada.
	 * @param k Clave de la entrada.
	 */
	public void setKey(K k){
		clave = k;
	}
	
	/**
	 * Modifica el valor de la entrada.
	 * @param v Valor de la entrada.
	 */
	public void setValue(V v){
		valor = v;
	}

}