
public class ListaDoblementeEnlazada<E> implements PositionList<E>{
	protected DNodo<E> header;
	protected DNodo<E> trailer;
	protected int longitud;
	
	public ListaDoblementeEnlazada(){
		header = new DNodo<E>(null, null, null);
		trailer = new DNodo<E>(header, null, null);
		header.setNext(trailer);
		longitud = 0;
	}
	
	public int size() {
		return longitud;
	}

	public boolean isEmpty() {
		return (longitud == 0);
	}

	public Position<E> first() throws EmptyListException {
		if(isEmpty()) throw new EmptyListException("Lista vacía");
		return header.getNext();
	}

	public Position<E> last() throws EmptyListException {
		if(isEmpty()) throw new EmptyListException("Lista vacía");
		return trailer.getPrev();
	}

	public Position<E> prev(Position<E> p) throws InvalidPositionException, BoundaryViolationException {
		DNodo<E> n = checkPosition(p);
		DNodo<E> previo = n.getPrev();
		if(previo == header) throw new BoundaryViolationException("Apunta al header de la lista");
		return previo;
	}
	
	private DNodo<E> checkPosition(Position<E> p) throws InvalidPositionException{
		if(p == null) throw new InvalidPositionException("Posición nula");
		if(p == header || p == trailer) throw new InvalidPositionException("No es posición válida");
		try{
			DNodo<E> n = (DNodo<E>) p;
			if(n.getPrev() == null || n.getNext() == null)
				throw new InvalidPositionException("No es posición válida");
			return n;
		}catch(ClassCastException e){
			throw new InvalidPositionException("El argumento no es una posición");
		}
	}
	
	public Position<E> next(Position<E> p) throws InvalidPositionException, BoundaryViolationException {
		DNodo<E> n = checkPosition(p);
		DNodo<E> siguiente = n.getNext();
		if(siguiente == trailer) throw new BoundaryViolationException("Apunta al trailer de la lista");
		return siguiente;
	}

	public void addFirst(E e) {
		DNodo<E> nuevo = new DNodo<E>(header, header.getNext(), e);
		header.getNext().setPrev(nuevo);
		header.setNext(nuevo);
		longitud++;
	}

	public void addLast(E e) {
		DNodo<E> nuevo = new DNodo<E>(trailer.getPrev(), trailer, e);
		trailer.getPrev().setNext(nuevo);
		trailer.setPrev(nuevo);
		longitud++;	
	}

	public void addAfter(Position<E> p, E e) throws InvalidPositionException {
		DNodo<E> n = checkPosition(p);
		DNodo<E> nuevo = new DNodo<E>(n, n.getNext(), e);
		n.getNext().setPrev(nuevo);
		n.setNext(nuevo);
		longitud++;
	}

	public void addBefore(Position<E> p, E e) throws InvalidPositionException {
		DNodo<E> n = checkPosition(p);
		DNodo<E> nuevo = new DNodo<E>(n.getPrev(), n, e);
		n.getPrev().setNext(nuevo);
		n.setPrev(nuevo);
		longitud++;
	}

	public E remove(Position<E> p) throws InvalidPositionException {
		if (isEmpty()) throw new InvalidPositionException("La lista está vacía, no se puede remover esa posición");
		DNodo<E> n = checkPosition(p);
		E aux = n.element();
		DNodo<E> pPrev = n.getPrev();
		DNodo<E> pNext = n.getNext();
		pPrev.setNext(pNext);
		pNext.setPrev(pPrev);
		n.setNext(null);
		n.setPrev(null);
		return aux;
	}

	public E set(Position<E> p, E e) throws InvalidPositionException {
		if(isEmpty()) throw new InvalidPositionException("Lista vacía, no se puede reemplazar al valor en esa posición");
		DNodo<E> n = checkPosition(p);
		E aux = n.element();
		n.setElemento(e);
		return aux;		
	}

}

