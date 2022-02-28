package TDALista;

import java.util.Iterator;

public interface PositionList <E> extends Iterable<E>{
	/**
	 * Retorna el tamaño de la lista.
	 * @return tamaño de la lista.
	 */
	public int size();
	/**
	 * Retorna si la lista está vacía.
	 * @return verdadero si la lista está vacía y falso en caso contrario.
	 */
	public boolean isEmpty();
	/**
	 * Retorna la posición del primer elemento de la lista.
	 * @return posición del primer elemento de la lista.
	 * @throws EmptyListException si la lista está vacía.
	 */
	public Position<E> first() throws EmptyListException;
	/**
	 * Retorna la posición del último elemento de la lista.
	 * @return posición del último elemento de la lista.
	 * @throws EmptyListException si la lista está vacía.
	 */
	public Position<E> last() throws EmptyListException;
	/**
	 * Retorna la posición del elemento anterior al elemento de la posición pasada como parámetro.
	 * @param p posición del elemento que procede.
	 * @return posición del elemento que precede al elemento en la posición p.
	 * @throws InvalidPositionException si p no es una posición válida.
	 * @throws BoundaryViolationException si p es la posición del primer elemento.
	 */
	public Position<E> prev( Position<E> p )
	throws InvalidPositionException, BoundaryViolationException;
	/**
	 * Retorna la posición del elemento posterior al elemento de la posición pasada como parámetro.
	 * @param p posición del elemento que precede.
	 * @return posición del elemento que procede al elemento en la posición p.
	 * @throws InvalidPositionException si p no es una posición válida.
	 * @throws BoundaryViolationException si p es la posición del ultimo elemento.
	 */
	public Position<E> next( Position<E> p )
	throws InvalidPositionException, BoundaryViolationException;
	/**
	 * Añade el elemento e a la lista en la primera posición.
	 * @param e elemento a añadir.
	 */
	public void addFirst(E e);
	/**
	 * Añade el elemento e a la lista en la última posición.
	 * @param e elemento a añadir.
	 */
	public void addLast(E e);
	/**
	 * Añade el elemento e despúes del elemento en la posición p.
	 * @param p posición anterior al elemento a añadir.
	 * @param e elemento a insertar.
	 * @throws InvalidPositionException si p no es una posición válida.
	 */
	public void addAfter( Position<E> p, E e ) throws InvalidPositionException;
	/**
      * Inserta el elemento e antes de la posición p.
	  * @param p posición posterior al elemento a insetar.
	  * @param e elemento a añadir.
	  * @throws InvalidPositionException si p no es una posición válida.
	  */
	public void addBefore( Position<E> p, E e )
	throws InvalidPositionException;
	/**
	 * Elimina el elemento de la posición p y lo retorna.
	 * @param p posición del elemento a eliminar.
	 * @return el elemento eliminado.
	 * @throws InvalidPositionException si p no es una posición válida.
	 */
	public E remove( Position<E> p ) throws InvalidPositionException;
	/**
	 * Reemplaza el elemento de la posición p con el elemento e. 
	 * @param p posición del elemento que será reemplazado.
	 * @param e elemento por el cuál se reemplazará.
	 * @return el elemento que estaba anteriormente en p.
	 * @throws InvalidPositionException si p no es una posición válida.
	 */
	public E set( Position<E> p, E e ) throws InvalidPositionException;
	/**
	 * Retorna un iterador de todos los elementos de la lista.
	 * @return un iterador de todos los elementos de la lista.
	 */
	public Iterator<E> iterator();
	/**
	 * Retorna una colección iterable de todos los nodos de la lista.
	 * @return colección iterable de los nodos de la lista.
	 */
	public Iterable<Position<E>> positions();
}
