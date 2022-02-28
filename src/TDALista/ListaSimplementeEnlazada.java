package TDALista;
import java.util.Iterator;

public class ListaSimplementeEnlazada<E> implements PositionList<E> {

	protected Nodo<E> cabeza;
	protected int tamaño;

	public ListaSimplementeEnlazada(){
		cabeza= null;
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
			throw new EmptyListException("Error: la lista está vacía.");
		return cabeza;
	}
	public Position<E> last() throws EmptyListException {
		if (isEmpty())
			throw new EmptyListException("Error: la lista está vacía.");
		Nodo<E> nodo= cabeza;
		while(nodo.getSiguiente()!=null){
			nodo=nodo.getSiguiente();
		}
		return nodo;
	}
	//---------------------------------------------------------
	private Nodo<E> checkPosition( Position<E> p )throws InvalidPositionException {
	  try {
		   if(p==null ) 
			   throw new InvalidPositionException("Error: posición nula.");
		   return (Nodo<E>) p;
		  } 
	  catch(ClassCastException e){
		throw new InvalidPositionException("Error: la posición pertenece a otro TDA.");
	  }
	}
	//---------------------------------------------------------
	public Position<E> prev(Position<E> p) throws InvalidPositionException, BoundaryViolationException {
	  try{
		if (p==first())
			throw new BoundaryViolationException("Error: la primer posición no tiene previo.");
	     }
	  catch(EmptyListException e){
		  throw new InvalidPositionException("Error: la lista está vacía, por lo tanto la posición no es válida.");
	  }
	    Nodo<E> nodo= checkPosition(p);
		Nodo<E> aux= cabeza;
        while(aux.getSiguiente()!=nodo && aux.getSiguiente()!=null){
        	aux=aux.getSiguiente();
        }
        if (aux.getSiguiente()==null)
        	throw new InvalidPositionException("Error: la posición no pertenece a la lista.");
        return aux;
	}
	public Position<E> next(Position<E> p) throws InvalidPositionException, BoundaryViolationException {
	  Nodo<E> nodo= checkPosition(p);
	  if (nodo.getSiguiente()==null)
		  throw new BoundaryViolationException("Error: la última posición no tiene seguiente.");
	  return nodo.getSiguiente();  
	}
	public void addFirst(E e) {
	  Nodo<E> nodo= new Nodo<E>(e,cabeza);
	  cabeza=nodo;
	  tamaño++;
	}
	public void addLast(E e) {
	 if(isEmpty())
		 addFirst(e);
	 else{
		  Nodo<E> nodo= new Nodo<E>(e,null);
          Nodo<E> p= cabeza;
          while(p.getSiguiente()!=null)
        	p=p.getSiguiente();	
          p.setSiguiente(nodo);
     	  tamaño++;
	   }
	}
	public void addAfter(Position<E> p, E e) throws InvalidPositionException {
		if(isEmpty())
			throw new InvalidPositionException("Error: la lista está vacía.");
		Nodo<E> pos= checkPosition(p);
		if(pos.getSiguiente()==null)
			addLast(e);
		else{
		  Nodo<E> nodo= new Nodo<E>(e,pos.getSiguiente());
		  pos.setSiguiente(nodo);
		  tamaño++;
		}
	}	
	public void addBefore(Position<E> p, E e) throws InvalidPositionException {
		Nodo<E> pNodo= checkPosition(p);
		try{
		if(p==first())
			addFirst(e);
		else{
			Nodo<E> anterior=( Nodo<E> )prev(p);
			Nodo<E> nodo= new Nodo<E>(e,pNodo);
			anterior.setSiguiente(nodo);
			tamaño++;
			}
		}
		catch(EmptyListException | BoundaryViolationException ex){}
	}
	public E remove(Position<E> p) throws InvalidPositionException {
		 if (isEmpty())
			 throw new InvalidPositionException("Error: la lista está vacía, no hay elemento para remover.");
         Nodo<E> pNodo= checkPosition(p);
         E retorno=p.element();
         if (p==cabeza){
        	cabeza=pNodo.getSiguiente();
         }
         else{
        	 try{
        	    Nodo<E> anterior= (Nodo<E>)prev(p);
        	    anterior.setSiguiente(pNodo.getSiguiente());
        	 }
        	 catch(BoundaryViolationException ex){}
         }
         tamaño--;
       return retorno;
	}
	public E set(Position<E> p, E e) throws InvalidPositionException {
		if (isEmpty())
			throw new InvalidPositionException("Error: la lista no tiene elementos para setear.");
		Nodo<E> pNodo= checkPosition(p);
		E retorno= pNodo.element();
		pNodo.setElemento(e);
		return retorno;
	}
    public Iterator<E> iterator(){
    	return new ElementIterator(this);
    }	
    public Iterable<Position<E>> positions(){
      //Crea una lista de posiciones
      PositionList<Position<E>> listaPosiciones= new ListaSimplementeEnlazada<Position<E>>();
      if (!isEmpty()){
    	 try{
          Position<E> p= cabeza;
          while(p!=last()){
        	  listaPosiciones.addLast(p);
        	  p=next(p);
          }
          listaPosiciones.addLast(p);
    	 }
    	 catch(EmptyListException | BoundaryViolationException | InvalidPositionException e){}
      }
    	return listaPosiciones;
    }
    
   public void invertir(){
	   E aux;
	   try{
	   if(!isEmpty()){
		  Nodo<E> inicio=cabeza;
		  Nodo<E> fin= (Nodo<E>)last();
		  for(int i=1; i<= tamaño/2; i++){
		    aux= inicio.element();
		    inicio.setElemento(fin.element());
		    fin.setElemento(aux);
		    inicio=inicio.getSiguiente();
		    fin=(Nodo<E>)prev(fin);
		  }
		 }
		 }//fin del try
	     catch(InvalidPositionException e3){System.out.println(e3.getMessage()+"");}
		 catch(EmptyListException e1){System.out.println(e1.getMessage()+"");}
	     catch(BoundaryViolationException e2){System.out.println(e2.getMessage()+"");}
   }
   
   public PositionList<E> clone(){
	  PositionList<E> copia= new ListaSimplementeEnlazada<E>();
	  try{
	   Position<E> actual= cabeza;
	   Position<E> ultimo=last();
	   while(actual!=ultimo){
		  copia.addLast(actual.element()); 
	   }
	   copia.addLast(actual.element()); 
	  }
	  catch(EmptyListException e){}
	   return copia;
   }
}
