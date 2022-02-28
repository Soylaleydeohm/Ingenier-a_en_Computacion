package TDAMapeo;

/**
 * Interface Entry
 * @author VirginiaAraceli
 * @param <K> Parámetro formal de tipo que representa el tipo de la clave los elementos de MapeoConLista.
 * @param <V> Parámetro formal de tipo que representa el tipo del valor los elementos de MapeoConLista.
 */
public interface Entry <K,V>{
	
	/**
	 * Devuelve la clave de la entrada.
	 * @return Clave de la entrada.
	 */
    public K getKey();   
    
    /**
	 * Devuelve el valor de la entrada.
	 * @return Valor de la entrada.
	 */
    public V getValue();
 
}