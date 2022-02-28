package TDALista;

import java.util.Iterator;

public class ListaCircular<E> implements PositionList<E> {

	protected Nodo<E> cabeza;
	protected int tamaño;
	
	public ListaCircular(){
		tamaño=0;
		cabeza= null;
	}
	public int size() {
	  return tamaño;
	}
	public boolean isEmpty() {
		return tamaño==0;
	}
	public Position<E> first() throws EmptyListException {
		if (isEmpty())
			throw new EmptyListException("Error: la lista está vacía.");
		return cabeza;
	}
	public Position<E> last() throws EmptyListException {
		if (isEmpty())
		   throw new EmptyListException("Error: la lista está vacía.");
		Nodo<E> anterior= cabeza;
		while(anterior.getSiguiente()!=cabeza)
			anterior=anterior.getSiguiente();
		return anterior;
	}
//----------------------------------------------------------------
	protected Nodo<E> checkPosition(Position<E> p) throws InvalidPositionException{
		if (p==null)
			throw new InvalidPositionException("Error: la posición es nula.");
		try{
			Nodo<E> pNodo= (Nodo<E>)p;
			if(pNodo.getSiguiente()==null)
				throw new InvalidPositionException("Error: la posición corresponde a un nodo no válido en la lista.");
			return pNodo;
		}
		catch(ClassCastException e){
			throw new InvalidPositionException("Error: la posición no es de un tipo válido.");
		}
	}
//----------------------------------------------------------------
	public Position<E> prev(Position<E> p) throws InvalidPositionException, BoundaryViolationException {
		//No tira BoundaryViolationException
		Position<E> retorno=null;
		if (isEmpty())
			throw new InvalidPositionException("Error: la lista está vacía.");
		Nodo<E> pNodo= checkPosition(p);
		if (p==cabeza)
		try{
			retorno=last();
		}
		catch(EmptyListException e){System.out.println(""+e.getMessage());}
		else{
			Nodo<E> inicio=cabeza;
			while(inicio.getSiguiente()!=pNodo){
				inicio=inicio.getSiguiente();
			}
			retorno=inicio;
		}
		return retorno;
	}
	public Position<E> next(Position<E> p) throws InvalidPositionException, BoundaryViolationException {
		//No tira BoundaryViolationException
		if (isEmpty())
			throw new InvalidPositionException("Error: la lista está vacía.");
		Nodo<E> pNodo= checkPosition(p);
		return pNodo.getSiguiente();
	}
	public void addFirst(E e) {
		Nodo<E> nuevo= new Nodo<E>(e,cabeza);
		cabeza=nuevo;
		if (isEmpty())
			nuevo.setSiguiente(nuevo);
		tamaño++;
	}
	public void addLast(E e) {
		if(isEmpty())
			addFirst(e);
		else{
			try{
			  Nodo<E> ultimo= (Nodo<E>)last();
		      Nodo<E> nuevo= new Nodo<E>(e, cabeza);
	          ultimo.setSiguiente(nuevo);
	          tamaño++;	
			}
			catch(EmptyListException e1){System.out.println(""+e1.getMessage());};
		}
	}
	public void addAfter(Position<E> p, E e) throws InvalidPositionException {
		if(isEmpty())
			throw new InvalidPositionException ("Error: la lista está vacía.");
		Nodo<E> pNodo= checkPosition(p);
		Nodo<E> nuevo= new Nodo<E>(e, pNodo.getSiguiente());
		pNodo.setSiguiente(nuevo);
		tamaño++;
	}
	public void addBefore(Position<E> p, E e) throws InvalidPositionException {
		if(isEmpty())
			throw new InvalidPositionException ("Error: la lista está vacía.");
		if (p==cabeza)
			addFirst(e);
		else{
			try{
		     Nodo<E> pNodo= checkPosition(p);
		     Nodo<E> anterior= (Nodo<E>)prev(p);
		     Nodo<E> nuevo= new Nodo<E>(e, pNodo);
		     anterior.setSiguiente(nuevo);	
		     tamaño++;
			}
			catch(BoundaryViolationException e1){System.out.println(""+e1.getMessage());}
			catch(InvalidPositionException e1){System.out.println(""+e1.getMessage());}
		}
	}
	public E remove(Position<E> p) throws InvalidPositionException {
		if(isEmpty())
			throw new InvalidPositionException("Error: la lista está vacía, no hay nada que remover.");
	    E retorno= p.element();
	    Nodo<E> pNodo= checkPosition(p);
	    try{
	       Nodo<E> anterior= (Nodo<E>)prev(p);
	       if (p==cabeza)
	    	   cabeza=pNodo.getSiguiente();
	       anterior.setSiguiente(pNodo.getSiguiente());
	       pNodo.setSiguiente(null);
	    }
	    catch(InvalidPositionException e1){System.out.println(""+e1.getMessage());}
	    catch(BoundaryViolationException e1){System.out.println(""+e1.getMessage());}
	    tamaño--;
	    return retorno;
	}
	public E set(Position<E> p, E e) throws InvalidPositionException {
		if (isEmpty())
			throw new InvalidPositionException("Error: la lista está vacía, no hay nada que setear.");
		E retorno=p.element();
		Nodo<E> pNodo= checkPosition(p);
		pNodo.setElemento(e);
		return retorno;
	}
	public Iterator<E> iterator() {
		return new ElementIterator<E>(this);
	}
	public Iterable<Position<E>> positions() {
	  PositionList<Position<E>> lista= new ListaSimplementeEnlazada<Position<E>>();
	  try{
		if (!isEmpty()){
		  Position<E> actual=first();
		  while(actual!=last()){
			lista.addLast(actual);
			actual=next(actual);
		  }
		  lista.addLast(actual);
		}
	   }
	   catch(EmptyListException e1){System.out.println(""+e1.getMessage());}
	   catch(InvalidPositionException e1){System.out.println(""+e1.getMessage());}
	   catch(BoundaryViolationException e1){System.out.println(""+e1.getMessage());}
	 return lista;
	}
	
	

}
