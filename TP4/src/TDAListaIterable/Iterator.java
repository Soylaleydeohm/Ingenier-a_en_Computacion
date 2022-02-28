package TDAListaIterable;

public interface Iterator<E> {
	public boolean hasNext();
	public E next() throws NoSuchElementException;
}
