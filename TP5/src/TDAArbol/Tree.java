package TDAArbol;
import java.util.Iterator;

//import TDALista.Iterable;
import TDALista.*;

public interface Tree<E> extends Iterable<E>{
	public int size();
	public boolean isEmpty();
	public Iterator<E> iterator();
	public Iterable <TPosition<E>> positions();
	public E replace (TPosition<E> v, E e) throws InvalidPositionException;
	public TPosition<E> root() throws EmptyTreeException;
	public TPosition<E> parent(TPosition<E> v) throws InvalidPositionException, BoundaryViolationException;
	public Iterable<TPosition<E>> children (TPosition<E> v) throws InvalidPositionException;
	public boolean isInternal(TPosition<E> v) throws InvalidPositionException;
	public boolean isExternal(TPosition<E> v) throws InvalidPositionException;
	public boolean isRoot(TPosition<E> v) throws InvalidPositionException;
}
