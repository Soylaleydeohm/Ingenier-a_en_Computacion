package TDALista;
import java.util.Iterator;

/**
 * 
 * @author VirginiaAraceli
 * @param <E> Parámetro formal de tipo que representa el tipo de los elementos de ElementIterator.
 */
public class ElementIterator<E> implements Iterator<E> {
	protected PositionList<E> list;
	protected Position<E> cursor;
	
	/**
	 * Crea un nuevo ElementIterator
	 * @param l lista de la que quiero obtener el iterador.
	 */
	public ElementIterator(PositionList<E> l){
		list = l;
		if (list.isEmpty())
			cursor = null;
		else
			try {
				cursor = list.first();
			} catch (EmptyListException e) {
				e.printStackTrace();
			}
	}
	
	/**
	 * Consulta si hay siguiente.
	 * @return Verdadero si hay siguiente, falso en caso contrario.
	 */
	public boolean hasNext(){ return cursor != null;}
	
	/**
     * Devuelve el elemento siguiente.
	 * @return Elemento siguiente.
	 */
	public E next(){
		E toReturn = cursor.element();
		try {
			cursor = (cursor == list.last()) ? null : list.next(cursor);
		} catch (EmptyListException e) {
			e.printStackTrace();
		} catch (InvalidPositionException e) {
			e.printStackTrace();
		} catch (BoundaryViolationException e) {
			e.printStackTrace();
		}
		return toReturn;
	}
}
