package TDAArbolBinario;
import TDALista.*;

/**
 * Interface BTPosition
 * @author VirginiaAraceli
 * @param <E> Parámetro formal de tipo que representa el tipo de los elementos de BTPosition.
 */
public interface BTPosition<E> extends Position<E> {
	
	public E element();
	
	/**
	 * Establece el rótulo de la posición.
	 * @param item Rótulo de la posición.
	 */	
	public void setElemento(E item);
	
	/**
	 * Consulta la posición del padre de la posición actual.
	 * @return Posición del padre de la posición actual.
	 */
	public BTPosition<E> getPadre();
	
	/**
	 * Establece el padre de la posición.
	 * @param p padre de la posición actual.
	 */
	public void setPadre(BTPosition<E> p);
	
	/**
	 * Consulta la posición del hijo derecho de la posición actual.
	 * @return Posición del hijo derecho de la posición actual.
	 */
	public BTPosition<E> getRight();
	
	/**
	 * Establece el hijo derecho de la posición.
	 * @param hD hijo derecho de la posición actual.
	 */
	public void setRight(BTPosition<E> hD);
	
	/**
	 * Consulta la posición del hijo izquierdo de la posición actual.
	 * @return Posición del hijo izquierdo de la posición actual.
	 */
	public BTPosition<E> getLeft();
	
	/**
	 * Establece el hijo izquierdo de la posición.
	 * @param hI hijo izquierdo de la posición actual.
	 */
	public void setLeft(BTPosition<E> hI);
}
