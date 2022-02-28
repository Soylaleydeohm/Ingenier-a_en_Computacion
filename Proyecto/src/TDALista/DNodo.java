package TDALista;

/**
 * Class DNodo
 * @author VirginiaAraceli
 *
 * @param <E> Parámetro formal de tipo que representa el tipo de los elementos de DNodo.
 */
public class DNodo<E> implements Position<E> {
	private E elemento;
	private DNodo<E> siguiente;
	private DNodo<E> previo;

	/**
	 * Crea un DNodo con rótulo elem, y DNodo previo prev y siguiente sig.
	 * @param prev Posición previa.
	 * @param sig Posición siguiente.
	 * @param elem Rótulo de la posición.
	 */
	public DNodo(DNodo<E> prev, DNodo<E> sig, E elem){
		elemento = elem;
		siguiente = sig;
		previo = prev;
	}
	
	public E element(){ return elemento;}
	
	/**
	 * Establece el rótulo de la posición.
	 * @param item Rótulo de la posición.
	 */	
	public void setElemento(E item){elemento = item;}
	
	/**
	 * Consulta la posición siguiente a la posición actual.
	 * @return Posición siguiente a la posición actual.
	 */
	public DNodo<E> getNext(){return siguiente;}
	
	/**
	 * Establece la posición siguiente a la posición actual.
	 * @param sig Posición siguiente a la posición actual.
	 */
	public void setNext(DNodo<E> sig){siguiente = sig;}
	
	/**
	 * Consulta la posición anterior a la posición actual.
	 * @return Posición anterior a la posición actual.
	 */
	public DNodo<E> getPrev(){return previo;}
	
	/**
	 * Establece la posición anterior a la posición actual.
	 @param prev Posición anterior a la posición actual.
	 */
	public void setPrev(DNodo<E> prev){previo = prev;}
}
