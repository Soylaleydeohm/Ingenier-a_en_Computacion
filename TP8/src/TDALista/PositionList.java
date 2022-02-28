package TDALista;

import java.util.Iterator;

public interface PositionList <E> extends Iterable<E>{
	/**
	 * Retorna el tama�o de la lista.
	 * @return tama�o de la lista.
	 */
	public int size();
	/**
	 * Retorna si la lista est� vac�a.
	 * @return verdadero si la lista est� vac�a y falso en caso contrario.
	 */
	public boolean isEmpty();
	/**
	 * Retorna la posici�n del primer elemento de la lista.
	 * @return posici�n del primer elemento de la lista.
	 * @throws EmptyListException si la lista est� vac�a.
	 */
	public Position<E> first() throws EmptyListException;
	/**
	 * Retorna la posici�n del �ltimo elemento de la lista.
	 * @return posici�n del �ltimo elemento de la lista.
	 * @throws EmptyListException si la lista est� vac�a.
	 */
	public Position<E> last() throws EmptyListException;
	/**
	 * Retorna la posici�n del elemento anterior al elemento de la posici�n pasada como par�metro.
	 * @param p posici�n del elemento que procede.
	 * @return posici�n del elemento que precede al elemento en la posici�n p.
	 * @throws InvalidPositionException si p no es una posici�n v�lida.
	 * @throws BoundaryViolationException si p es la posici�n del primer elemento.
	 */
	public Position<E> prev( Position<E> p )
	throws InvalidPositionException, BoundaryViolationException;
	/**
	 * Retorna la posici�n del elemento posterior al elemento de la posici�n pasada como par�metro.
	 * @param p posici�n del elemento que precede.
	 * @return posici�n del elemento que procede al elemento en la posici�n p.
	 * @throws InvalidPositionException si p no es una posici�n v�lida.
	 * @throws BoundaryViolationException si p es la posici�n del ultimo elemento.
	 */
	public Position<E> next( Position<E> p )
	throws InvalidPositionException, BoundaryViolationException;
	/**
	 * A�ade el elemento e a la lista en la primera posici�n.
	 * @param e elemento a a�adir.
	 */
	public void addFirst(E e);
	/**
	 * A�ade el elemento e a la lista en la �ltima posici�n.
	 * @param e elemento a a�adir.
	 */
	public void addLast(E e);
	/**
	 * A�ade el elemento e desp�es del elemento en la posici�n p.
	 * @param p posici�n anterior al elemento a a�adir.
	 * @param e elemento a insertar.
	 * @throws InvalidPositionException si p no es una posici�n v�lida.
	 */
	public void addAfter( Position<E> p, E e ) throws InvalidPositionException;
	/**
      * Inserta el elemento e antes de la posici�n p.
	  * @param p posici�n posterior al elemento a insetar.
	  * @param e elemento a a�adir.
	  * @throws InvalidPositionException si p no es una posici�n v�lida.
	  */
	public void addBefore( Position<E> p, E e )
	throws InvalidPositionException;
	/**
	 * Elimina el elemento de la posici�n p y lo retorna.
	 * @param p posici�n del elemento a eliminar.
	 * @return el elemento eliminado.
	 * @throws InvalidPositionException si p no es una posici�n v�lida.
	 */
	public E remove( Position<E> p ) throws InvalidPositionException;
	/**
	 * Reemplaza el elemento de la posici�n p con el elemento e. 
	 * @param p posici�n del elemento que ser� reemplazado.
	 * @param e elemento por el cu�l se reemplazar�.
	 * @return el elemento que estaba anteriormente en p.
	 * @throws InvalidPositionException si p no es una posici�n v�lida.
	 */
	public E set( Position<E> p, E e ) throws InvalidPositionException;
	/**
	 * Retorna un iterador de todos los elementos de la lista.
	 * @return un iterador de todos los elementos de la lista.
	 */
	public Iterator<E> iterator();
	/**
	 * Retorna una colecci�n iterable de todos los nodos de la lista.
	 * @return colecci�n iterable de los nodos de la lista.
	 */
	public Iterable<Position<E>> positions();
}
