package ColaConPrioridad;

import TDALista.*;
import java.util.Comparator;

public class PQConListaNoOrdenada<K,V> implements PriorityQueue<K,V> {
	/*  Tiempo de ejecucion con una lista sin ordenar:
	*	size()      -> O(1)
	*	isEmpty()   -> O(1)
	*	Insert(K,V) -> O(1)
	*	min()       -> O(n)
	*	removeMin() -> O(n)
	*/
	private PositionList<Entry<K,V>> lista;
	private Comparator<K> comp;
	
	public PQConListaNoOrdenada(Comparator<K> c){
		comp = c;
		lista = new ListaDoblementeEnlazada<Entry<K,V>>();
	}
	
	public PQConListaNoOrdenada(){
		this(new DefaultComparator<K>());
	}
	
	public int size(){return lista.size();}
	
	public boolean isEmpty(){return lista.isEmpty();}
	
	public Entry<K,V> insert(K k, V v) throws InvalidKeyException{
		//Inserta sin ordenar
		try{
			if(k == null || (comp.compare(k,k) != 0))
				 throw new InvalidKeyException("Clave inválida");
		}catch(ClassCastException e){
			throw new InvalidKeyException("Clave inválida");
		}
		Entry<K,V> ent = new Entrada<K,V>(k,v);
		lista.addFirst(ent);
		return ent;
		
	}
	
	public Entry<K,V> min() throws EmptyPriorityQueueException{
		if(lista.isEmpty()) throw new EmptyPriorityQueueException("Cola vacía");
		try{
			//Ya me fijé que no esté vacía
			Position<Entry<K,V>> pos = lista.first();
			Entry<K,V> ent = pos.element();
			while(pos != null){
				if(comp.compare(pos.element().getKey(),ent.getKey()) < 0 ){
					ent = pos.element();
				}
				pos = (pos == lista.last() ) ? null : lista.next(pos);
			}
			return ent;
		}catch(EmptyListException | BoundaryViolationException | InvalidPositionException err){
			return null;
		}
		
	}
	
	public Entry<K,V> removeMin() throws EmptyPriorityQueueException{
		if(lista.isEmpty()) throw new EmptyPriorityQueueException("Cola vacía");
		try{
			Position<Entry<K,V>> pos = lista.first();
			Position<Entry<K,V>> posAremover = lista.first();
			Entry<K,V> ent = pos.element();
			while(pos != null){
				if(comp.compare(pos.element().getKey(),ent.getKey()) < 0 ){
					ent = pos.element();
					posAremover = pos;
				}
				pos = (pos == lista.last() ) ? null : lista.next(pos);
			}
			lista.remove(posAremover);
			return ent;
		}catch(EmptyListException | BoundaryViolationException | InvalidPositionException err){
			return null;
		}
	} 
	
}

