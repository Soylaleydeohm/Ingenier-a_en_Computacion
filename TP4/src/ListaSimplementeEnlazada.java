
public class ListaSimplementeEnlazada<E> implements PositionList<E>{
	protected Nodo<E> cabeza;
	protected int longitud;
	
	public ListaSimplementeEnlazada(){
		cabeza = null;
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
		return cabeza;
	}

	public Position<E> last() throws EmptyListException {
		if(isEmpty()) throw new EmptyListException("Lista vacía");
		Nodo<E> p = cabeza;
		while(p.getSiguiente()!= null){
			p = p.getSiguiente();
		}
		return p;
	}

	public Position<E> prev(Position<E> p) throws InvalidPositionException, BoundaryViolationException {
		try {
			if(p == first()) throw new BoundaryViolationException("Lista::prev(): Posición primera");
			Nodo<E> n = checkPosition(p);
			Nodo<E> aux = cabeza;
			while (aux.getSiguiente()!= null && aux.getSiguiente()!= n){
				aux = aux.getSiguiente();
			}
			if(aux.getSiguiente() == null) throw new InvalidPositionException("Lista::prev(): Posición no pertenece a la lista");
			return aux;
		} catch (EmptyListException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	private Nodo<E> checkPosition(Position<E> p) throws InvalidPositionException{
		try{
			if(p == null) throw new InvalidPositionException("Posición nula");
			return (Nodo<E>) p;
		}catch(ClassCastException e){
			throw new InvalidPositionException("El argumento no es una posición");
		}
	}
	
	public Position<E> next(Position<E> p) throws InvalidPositionException, BoundaryViolationException {
		Nodo<E> n = checkPosition(p);
		if (n.getSiguiente() == null) throw new BoundaryViolationException("No hay siguiente");
		return n.getSiguiente();
	}

	public void addFirst(E e) {
		cabeza = new Nodo<E>(e, cabeza);
		longitud++;
	}

	public void addLast(E e) {
		if(isEmpty()) addFirst(e);
		else{
			Nodo<E> p = cabeza;
			while(p.getSiguiente() != null) p = p.getSiguiente();
			p.setSiguiente(new Nodo<E> (e));
			longitud++;
		}		
	}

	public void addAfter(Position<E> p, E e) throws InvalidPositionException {
		Nodo<E> n = checkPosition(p);
		Nodo<E> nuevo = new Nodo<E>(e);
		nuevo.setSiguiente(n.getSiguiente());
		n.setSiguiente(nuevo);
		longitud++;
	}

	public void addBefore(Position<E> p, E e) throws InvalidPositionException {
		Nodo<E> n = checkPosition(p);
		try {
			if(p == first()) addFirst(e);
			else{
				Nodo<E> anterior = (Nodo<E>) prev(p);
				Nodo<E> aux = new Nodo<E>(e, n);
				anterior.setSiguiente(aux);
				longitud++;
			}
		} catch (EmptyListException e1) {
			e1.printStackTrace();
		} catch (BoundaryViolationException e2) {
			e2.printStackTrace();		
		}
	}

	public E remove(Position<E> p) throws InvalidPositionException {
		if (isEmpty()) throw new InvalidPositionException("La lista está vacía, no se puede remover esa posición");
		Nodo<E> n = checkPosition(p);
		E aux = p.element();
		if (n == cabeza) cabeza = cabeza.getSiguiente();
		else{
			try {
				Nodo<E> anterior;
				anterior = (Nodo<E>) prev(p);
				anterior.setSiguiente(n.getSiguiente());
			} catch (BoundaryViolationException e) {
				e.printStackTrace();
			}
		}
		return aux;
	}

	public E set(Position<E> p, E e) throws InvalidPositionException {
		if(isEmpty()) throw new InvalidPositionException("Lista vacía, no se puede reemplazar al valor en esa posición");
		else{
			Nodo<E> n = checkPosition(p);
			E aux = n.element();
			n.setElemento(e);
			return aux;
		}
	}

}
