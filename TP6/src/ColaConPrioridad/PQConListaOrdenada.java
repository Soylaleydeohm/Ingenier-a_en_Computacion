package ColaConPrioridad;

import TDALista.*;
import java.util.Comparator;

public class PQConListaOrdenada<K,V> implements PriorityQueue<K,V> {
	/*  Tiempo de ejecucion con una lista sin ordenar:
	*	size()      -> O(1)
	*	isEmpty()   -> O(1)
	*	Insert(K,V) -> O(1)
	*	min()       -> O(n)
	*	removeMin() -> O(n)
	*/
	private PositionList<Entry<K,V>> lista;
	private Comparator<K> comp;
	
	public PQConListaOrdenada(Comparator<K> c){
		comp = c;
		lista = new ListaDoblementeEnlazada<Entry<K,V>>();
	}
	
	public PQConListaOrdenada(){
		this(new DefaultComparator<K>());
	}
	
	public int size(){return lista.size();}
	
	public boolean isEmpty(){return lista.isEmpty();}
	
	public Entry<K,V> insert(K k, V v) throws InvalidKeyException{
		//Inserta ordenado
		//CheckKey
		try{
			if(k == null || (comp.compare(k,k) != 0))
				 throw new InvalidKeyException("Clave inválida");
		}catch(ClassCastException e){
			throw new InvalidKeyException("Clave inválida");
		}
		Entry<K,V> ent = new Entrada<K,V>(k,v);
		insertarOrdenado(ent);
		return ent;		
	}
	
	private void insertarOrdenado(Entry<K,V> e){
		try {
			if(lista.isEmpty()){ 
				lista.addFirst(e);
			}
			else if(comp.compare(e.getKey(), lista.last().element().getKey())>0){
					lista.addLast(e);
				}
				else{
					Position<Entry<K,V>> actual = lista.first();
					while(comp.compare(e.getKey(), actual.element().getKey())>0 && actual!=null){
						actual = (actual == lista.last() ) ? null : lista.next(actual);
					}
					if(actual!=null) {
						lista.addBefore(actual, e);
					}
					else lista.addLast(e);
				}
		} catch (EmptyListException | InvalidPositionException | BoundaryViolationException err) {
			err.printStackTrace();
		}
	}
	

	public Entry<K,V> min() throws EmptyPriorityQueueException{
		if(lista.isEmpty()) throw new EmptyPriorityQueueException("Cola vacía");
		try{
			return lista.first().element();
		}catch(EmptyListException err){
			return null;
		}		
	}
	
	public Entry<K,V> removeMin() throws EmptyPriorityQueueException{
		if(lista.isEmpty()) throw new EmptyPriorityQueueException("Cola vacía");
		try{
			return lista.remove(lista.first());
		}catch(EmptyListException err){
			return null;
		} catch (InvalidPositionException e) {
			e.printStackTrace();
			return null;
		}	
	} 	
}
