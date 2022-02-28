package TDALista;

/**
 * Class DNodo
 * @author VirginiaAraceli
 *
 * @param <E> Par�metro formal de tipo que representa el tipo de los elementos de DNodo.
 */
public class DNodo<E> implements Position<E> {
	private E elemento;
	private DNodo<E> siguiente;
	private DNodo<E> previo;

	/**
	 * Crea un DNodo con r�tulo elem, y DNodo previo prev y siguiente sig.
	 * @param prev Posici�n previa.
	 * @param sig Posici�n siguiente.
	 * @param elem R�tulo de la posici�n.
	 */
	public DNodo(DNodo<E> prev, DNodo<E> sig, E elem){
		elemento = elem;
		siguiente = sig;
		previo = prev;
	}
	
	public E element(){ return elemento;}
	
	/**
	 * Establece el r�tulo de la posici�n.
	 * @param item R�tulo de la posici�n.
	 */	
	public void setElemento(E item){elemento = item;}
	
	/**
	 * Consulta la posici�n siguiente a la posici�n actual.
	 * @return Posici�n siguiente a la posici�n actual.
	 */
	public DNodo<E> getNext(){return siguiente;}
	
	/**
	 * Establece la posici�n siguiente a la posici�n actual.
	 * @param sig Posici�n siguiente a la posici�n actual.
	 */
	public void setNext(DNodo<E> sig){siguiente = sig;}
	
	/**
	 * Consulta la posici�n anterior a la posici�n actual.
	 * @return Posici�n anterior a la posici�n actual.
	 */
	public DNodo<E> getPrev(){return previo;}
	
	/**
	 * Establece la posici�n anterior a la posici�n actual.
	 @param prev Posici�n anterior a la posici�n actual.
	 */
	public void setPrev(DNodo<E> prev){previo = prev;}
}
