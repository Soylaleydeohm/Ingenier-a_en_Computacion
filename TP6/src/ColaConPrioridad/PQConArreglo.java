package ColaConPrioridad;

import java.util.Comparator;

public class PQConArreglo<K,V> implements PriorityQueue<K,V>{
	/*
	*	Arreglo ordenado (claves de mayor a menor).
	*	size()      -> O(1)
	*	isEmpty()   -> O(1)
	*	Insert(K,V) -> O(n)
	*	min()       -> O(1)
	*	removeMin() -> O(1)
	*/
	private Entry<K,V>[] array; 
	private Comparator<K> comp;
	private int cursor;

	public PQConArreglo(){
		array = (Entry<K,V>[]) new Entrada[100];
		comp = new DefaultComparator<K>();
	}

	public PQConArreglo(Comparator<K> c){
		array = (Entry<K,V>[]) new Entrada[100];
		comp = c;	
	}

	public int size(){return cursor;}

	public boolean isEmpty(){return cursor == 0;}

	public Entry<K,V> insert(K key, V value) throws InvalidKeyException{
		checkKey(key);
		Entrada<K,V> entry = new Entrada<K,V>(key,value);
		insertEntry(entry);
		return entry;
	}

	public Entry<K,V> min() throws EmptyPriorityQueueException{
		if(cursor == 0) throw new EmptyPriorityQueueException("Cola vacía");
		else return array[cursor-1];
	}

	public Entry<K,V> removeMin() throws EmptyPriorityQueueException{
		if(cursor == 0) throw new EmptyPriorityQueueException("Cola vacía");
		else{
			Entry<K,V> aux = array[cursor-1] ;
			array[--cursor] = null;
			return aux;
		}

	}

	private void checkKey(K k) throws InvalidKeyException{
		try{
			if(k == null || (comp.compare(k,k) != 0))
				 throw new InvalidKeyException("Clave inválida");
		}catch(ClassCastException e){
			throw new InvalidKeyException("Clave inválida");
		}
	}

	private void insertEntry(Entry<K,V> e){
		if(cursor == 0) {
			array[cursor] = e;
			cursor++;
		}		
		else{ 
			if(cursor==array.length) agrandarArreglo();
			if(comp.compare(array[cursor-1].getKey(),e.getKey()) >= 0){
				array[cursor++] = e;
			}
			else{
				int cont = 0;
				while(cont < cursor && comp.compare(array[cont].getKey(),e.getKey()) > 0 ){
					cont++;
				}
				if(cont < cursor){ //Innecesario porque siempre va a frenar antes del ultimo.
					for(int i=cursor-1; i >= cont; i--){
						array[i+1] = array[i];
					}
					array[cont] = e;
					cursor++;
				}
			}
		}
	}
	private void agrandarArreglo(){
		Entrada <K,V> [] nuevo = (Entrada<K,V>[]) new Entrada[cursor*2];
		for(int i=0;i<cursor;i++) 
			nuevo[i]=(Entrada<K, V>) array[i];
		array=nuevo;
	}
}



