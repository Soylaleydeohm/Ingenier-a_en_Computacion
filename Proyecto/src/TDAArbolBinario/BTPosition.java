package TDAArbolBinario;
import TDALista.*;

/**
 * Interface BTPosition
 * @author VirginiaAraceli
 * @param <E> Par�metro formal de tipo que representa el tipo de los elementos de BTPosition.
 */
public interface BTPosition<E> extends Position<E> {
	
	public E element();
	
	/**
	 * Establece el r�tulo de la posici�n.
	 * @param item R�tulo de la posici�n.
	 */	
	public void setElemento(E item);
	
	/**
	 * Consulta la posici�n del padre de la posici�n actual.
	 * @return Posici�n del padre de la posici�n actual.
	 */
	public BTPosition<E> getPadre();
	
	/**
	 * Establece el padre de la posici�n.
	 * @param p padre de la posici�n actual.
	 */
	public void setPadre(BTPosition<E> p);
	
	/**
	 * Consulta la posici�n del hijo derecho de la posici�n actual.
	 * @return Posici�n del hijo derecho de la posici�n actual.
	 */
	public BTPosition<E> getRight();
	
	/**
	 * Establece el hijo derecho de la posici�n.
	 * @param hD hijo derecho de la posici�n actual.
	 */
	public void setRight(BTPosition<E> hD);
	
	/**
	 * Consulta la posici�n del hijo izquierdo de la posici�n actual.
	 * @return Posici�n del hijo izquierdo de la posici�n actual.
	 */
	public BTPosition<E> getLeft();
	
	/**
	 * Establece el hijo izquierdo de la posici�n.
	 * @param hI hijo izquierdo de la posici�n actual.
	 */
	public void setLeft(BTPosition<E> hI);
}
