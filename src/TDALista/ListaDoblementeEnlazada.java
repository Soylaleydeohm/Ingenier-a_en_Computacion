package TDALista;

import java.util.Iterator;

public class ListaDoblementeEnlazada<E> implements PositionList<E> {

	protected NodoDoble<E> cabeza;
	protected NodoDoble<E> cola;
	protected int tama�o;
	
	public ListaDoblementeEnlazada(){
		cabeza= new NodoDoble<E>(null,null,null);
		cola=new NodoDoble<E>(cabeza,null,null);
		cabeza.setSiguiente(cola);
		tama�o=0;
	}

	public int size() {
		return tama�o;
	}
	public boolean isEmpty() {
		return tama�o==0;
	}
	public Position<E> first() throws EmptyListException {
		if (isEmpty())
			throw new EmptyListException("Error: la lista est� vac�a, por lo que no tiene primer elemento.");
		return cabeza.getSiguiente();
	}
	public Position<E> last() throws EmptyListException {
		if (isEmpty())
			throw new EmptyListException("Error: la lista est� vac�a, por lo que no tiene �ltimo elemento.");
		return cola.getAnterior();
	}
	//----------------------------------------------------------
	protected NodoDoble<E> checkPosition(Position<E> p) throws InvalidPositionException{
		if (p==null)
			throw new InvalidPositionException("Error: la posici�n es nula.");
		if (p==cabeza)
			throw new InvalidPositionException("Error: la cabeza (dummy) no es una posici�n v�lida.");
		if (p==cola)
			throw new InvalidPositionException("Error: la cola (dummy) no es una posici�n v�lida.");
		try{
			NodoDoble<E> aux= (NodoDoble<E>)p;
			if (aux.getSiguiente()==null || aux.getAnterior()==null)
				throw new InvalidPositionException("Error: la posici�n no corresponde a una PositionList v�lida.");
			return aux;
		}
		catch(ClassCastException e){
			throw new InvalidPositionException("Error: la posici�n es de un tipo inv�lido para esta lista.");
		}
	}
	//----------------------------------------------------------
	public Position<E> prev(Position<E> p) throws InvalidPositionException, BoundaryViolationException {
		if(isEmpty())
			throw new InvalidPositionException("Error: la lista est� vac�a.");
		NodoDoble<E> pNodo= checkPosition(p);
		NodoDoble<E> anterior= pNodo.getAnterior();
		if(anterior==cabeza)
			throw new BoundaryViolationException("Error: la primera posici�n no tiene anterior.");
	    return anterior;
	}
	public Position<E> next(Position<E> p) throws InvalidPositionException, BoundaryViolationException {
		if (isEmpty())
			throw new InvalidPositionException("Error: la lista est� vac�a.");
		NodoDoble<E> pNodo= checkPosition(p);
		NodoDoble<E> siguiente= pNodo.getSiguiente();
		if (siguiente==cola)
			throw new BoundaryViolationException("Error: el �ltimo elemento no tiene siguiente.");
		return siguiente;
	}
	public void addFirst(E e) {
      tama�o++;
	  NodoDoble<E> nuevo= new NodoDoble<E>(cabeza,e,cabeza.getSiguiente());
	  cabeza.setSiguiente(nuevo);
	  nuevo.getSiguiente().setAnterior(nuevo);
	}
	public void addLast(E e) {
	  tama�o++;
	  NodoDoble<E> nuevo = new NodoDoble<E>(cola.getAnterior(),e,cola);
	  cola.getAnterior().setSiguiente(nuevo);
	  cola.setAnterior(nuevo);
	}
	public void addAfter(Position<E> p, E e) throws InvalidPositionException {
		NodoDoble<E> pNodo= checkPosition(p);
		tama�o++;
	    NodoDoble<E> nuevo= new NodoDoble<E>(pNodo,e,pNodo.getSiguiente());
	    pNodo.getSiguiente().setAnterior(nuevo);
	    pNodo.setSiguiente(nuevo);   	
	}
	public void addBefore(Position<E> p, E e) throws InvalidPositionException {
		NodoDoble<E> pNodo= checkPosition(p);
		tama�o++;
		NodoDoble<E>nuevo= new NodoDoble<E>(pNodo.getAnterior(),e,pNodo);
		pNodo.getAnterior().setSiguiente(nuevo);
		pNodo.setAnterior(nuevo);
	}
	public E remove(Position<E> p) throws InvalidPositionException {
		if (isEmpty())
			throw new InvalidPositionException ("Error: no se puede remover de una lista vac�a.");
		NodoDoble<E> pNodo= checkPosition(p);
		tama�o--;
		E retorno= p.element();
		pNodo.getAnterior().setSiguiente(pNodo.getSiguiente());
		pNodo.getSiguiente().setAnterior(pNodo.getAnterior());
		return retorno;
	}
	public E set(Position<E> p, E e) throws InvalidPositionException {
		if (isEmpty())
			throw new InvalidPositionException ("Error: no se puede setear en una lista vac�a.");
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