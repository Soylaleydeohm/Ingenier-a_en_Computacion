package TDALista;

import java.util.Iterator;

public class ElementIterator<E> implements Iterator<E> {
	
	protected PositionList<E> lista;
	protected Position<E> cursor;
	
	public ElementIterator(PositionList<E> lista){
		this.lista=lista;
		if(lista.isEmpty())
			cursor=null;
		else
			try{
			cursor=lista.first();
			}
		    catch(EmptyListException e){}
	}
	public boolean hasNext() {
	  return(cursor!=null);
	}
	public E next() /*throws NoSuchElementException*/{
	  /*if(cursor==null)
		  throw new NoSuchElementException("Error: no hay siguiente.");*/
	  E retorno= cursor.element();
	  try{
	   if(cursor==lista.last())
		  cursor=null;
	   else
	      cursor=lista.next(cursor);
	  }
	  catch(EmptyListException | BoundaryViolationException | InvalidPositionException e){}
	  return retorno;
	}

}
