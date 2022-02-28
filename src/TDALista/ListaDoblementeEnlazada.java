package TDALista;

import java.util.Iterator;

public class ListaDoblementeEnlazada<E> implements PositionList<E> {

	protected NodoDoble<E> cabeza;
	protected NodoDoble<E> cola;
	protected int tamaño;
	
	public ListaDoblementeEnlazada(){
		cabeza= new NodoDoble<E>(null,null,null);
		cola=new NodoDoble<E>(cabeza,null,null);
		cabeza.setSiguiente(cola);
		tamaño=0;
	}

	public int size() {
		return tamaño;
	}
	public boolean isEmpty() {
		return tamaño==0;
	}
	public Position<E> first() throws EmptyListException {
		if (isEmpty())
			throw new EmptyListException("Error: la lista está vacía, por lo que no tiene primer elemento.");
		return cabeza.getSiguiente();
	}
	public Position<E> last() throws EmptyListException {
		if (isEmpty())
			throw new EmptyListException("Error: la lista está vacía, por lo que no tiene último elemento.");
		return cola.getAnterior();
	}
	//----------------------------------------------------------
	protected NodoDoble<E> checkPosition(Position<E> p) throws InvalidPositionException{
		if (p==null)
			throw new InvalidPositionException("Error: la posición es nula.");
		if (p==cabeza)
			throw new InvalidPositionException("Error: la cabeza (dummy) no es una posición válida.");
		if (p==cola)
			throw new InvalidPositionException("Error: la cola (dummy) no es una posición válida.");
		try{
			NodoDoble<E> aux= (NodoDoble<E>)p;
			if (aux.getSiguiente()==null || aux.getAnterior()==null)
				throw new InvalidPositionException("Error: la posición no corresponde a una PositionList válida.");
			return aux;
		}
		catch(ClassCastException e){
			throw new InvalidPositionException("Error: la posición es de un tipo inválido para esta lista.");
		}
	}
	//----------------------------------------------------------
	public Position<E> prev(Position<E> p) throws InvalidPositionException, BoundaryViolationException {
		if(isEmpty())
			throw new InvalidPositionException("Error: la lista está vacía.");
		NodoDoble<E> pNodo= checkPosition(p);
		NodoDoble<E> anterior= pNodo.getAnterior();
		if(anterior==cabeza)
			throw new BoundaryViolationException("Error: la primera posición no tiene anterior.");
	    return anterior;
	}
	public Position<E> next(Position<E> p) throws InvalidPositionException, BoundaryViolationException {
		if (isEmpty())
			throw new InvalidPositionException("Error: la lista está vacía.");
		NodoDoble<E> pNodo= checkPosition(p);
		NodoDoble<E> siguiente= pNodo.getSiguiente();
		if (siguiente==cola)
			throw new BoundaryViolationException("Error: el último elemento no tiene siguiente.");
		return siguiente;
	}
	public void addFirst(E e) {
      tamaño++;
	  NodoDoble<E> nuevo= new NodoDoble<E>(cabeza,e,cabeza.getSiguiente());
	  cabeza.setSiguiente(nuevo);
	  nuevo.getSiguiente().setAnterior(nuevo);
	}
	public void addLast(E e) {
	  tamaño++;
	  NodoDoble<E> nuevo = new NodoDoble<E>(cola.getAnterior(),e,cola);
	  cola.getAnterior().setSiguiente(nuevo);
	  cola.setAnterior(nuevo);
	}
	public void addAfter(Position<E> p, E e) throws InvalidPositionException {
		NodoDoble<E> pNodo= checkPosition(p);
		tamaño++;
	    NodoDoble<E> nuevo= new NodoDoble<E>(pNodo,e,pNodo.getSiguiente());
	    pNodo.getSiguiente().setAnterior(nuevo);
	    pNodo.setSiguiente(nuevo);   	
	}
	public void addBefore(Position<E> p, E e) throws InvalidPositionException {
		NodoDoble<E> pNodo= checkPosition(p);
		tamaño++;
		NodoDoble<E>nuevo= new NodoDoble<E>(pNodo.getAnterior(),e,pNodo);
		pNodo.getAnterior().setSiguiente(nuevo);
		pNodo.setAnterior(nuevo);
	}
	public E remove(Position<E> p) throws InvalidPositionException {
		if (isEmpty())
			throw new InvalidPositionException ("Error: no se puede remover de una lista vacía.");
		NodoDoble<E> pNodo= checkPosition(p);
		tamaño--;
		E retorno= p.element();
		pNodo.getAnterior().setSiguiente(pNodo.getSiguiente());
		pNodo.getSiguiente().setAnterior(pNodo.getAnterior());
		return retorno;
	}
	public E set(Position<E> p, E e) throws InvalidPositionException {
		if (isEmpty())
			throw new InvalidPositionException ("Error: no se puede setear en una lista vacía.");
		NodoDoble<E> pNodo= checkPosition(p);
		E retorno= p.element();
		pNodo.setElemento(e);
		return retorno;
	}
	public Iterator<E> iterator() {
		return new ElementIterator(this);
	}
	public Iterable<Position<E>> positions() {
	  //Crea una lista de posiciones
	  PositionList<Position<E>> listaPosiciones= new ListaSimplementeEnlazada<Position<E>>();
	     if (!isEmpty()){
	    	try{
	          Position<E> p= cabeza.getSiguiente();
	          while(p!=cola){
	        	  listaPosiciones.addLast(p);
	        	  p=next(p);
	          }
	    	 }
	    	 catch(BoundaryViolationException | InvalidPositionException e){}
	      }
	    	return listaPosiciones;
	    }
	
	public void eliminarConsecutivos(E A, E B){
	  if (!isEmpty()){
	  try{
		NodoDoble<E> posActual= cabeza.getSiguiente();
		E anterior= posActual.element();
		posActual=posActual.getSiguiente();
		E actual;
		NodoDoble<E> aux;
		while(posActual!=cola){
			actual= posActual.element();
			aux=posActual;
			posActual=posActual.getSiguiente();
			if (anterior.equals(A) && actual.equals(B)){
				remove(aux.getAnterior());
				remove(aux);
			}
			anterior=actual;	
		}
	   }
	  catch(InvalidPositionException e){};
	  }
	}
	
	/*public void eliminarMasCantidad(PositionList<E> B){
	 try{
		Position<E> actualB= B.first();
		while(actualB!=B.last()){
			if(cantidad(actualB.element(), B)> cantidad(actualB.element(), this))
				eliminarTodos(actualB.element(), this);	
			actualB=B.next(actualB);
		}
		if(cantidad(actualB.element(), B)> cantidad(actualB.element(), this))
			eliminarTodos(actualB.element(), this);	
	 }
	 catch(EmptyListException e){System.out.println(""+e.getMessage());}
	 catch(BoundaryViolationException e){System.out.println(""+e.getMessage());}
	 catch(InvalidPositionException e){System.out.println(""+e.getMessage());}
	}
	*/
	}