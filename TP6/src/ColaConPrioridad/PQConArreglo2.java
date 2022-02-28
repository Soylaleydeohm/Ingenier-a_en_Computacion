package ColaConPrioridad;

import java.util.Comparator;

public class PQConArreglo2<K,V> implements PriorityQueue<K,V> {
	private Entry<K,V> [] array; //Usar Entry
	private Comparator<K> comp;
	private int cantElem;
	
	public PQConArreglo2(){
		array = (Entrada<K,V> []) new Entrada[50];
		comp= new DefaultComparator<K>();
		cantElem=0;
	}
	public int size() {return cantElem;}
	public boolean isEmpty() {return cantElem==0;}
	public Entry<K, V> min() throws EmptyPriorityQueueException {
		if(cantElem==0) throw new EmptyPriorityQueueException("Cola vacia");
	return array[0];}
	
	public Entry<K, V> insert(K key, V value) throws InvalidKeyException {
		checkKey(key);
		if (isEmpty()){
			array[0]=new Entrada<K,V>(key,value);
			cantElem++;
			return array[0];}
		else{
			if(cantElem==array.length) agrandarArreglo();
			int pos = buscarPosicion(key);
			atrasarDesde(pos);
			array[pos]=new Entrada<K,V>(key,value);
			cantElem++;
			return array[pos];}
	}
	private void checkKey(K k) throws InvalidKeyException{
		try{
			if(k == null || (comp.compare(k,k) != 0))
				 throw new InvalidKeyException("Clave inválida");
		}catch(ClassCastException e){
			throw new InvalidKeyException("Clave inválida");
		}
	}
	
	private void agrandarArreglo(){
		Entrada <K,V> [] nuevo = (Entrada<K,V>[]) new Entrada[cantElem*2];
		for(int i=0;i<cantElem;i++) {
			nuevo[i]=(Entrada<K, V>) array[i];
		}
		array=nuevo;
	}
	private int buscarPosicion(K key){
		int pos=0; boolean encontre=false;
		for(int i=0;i<cantElem && !encontre;i++){
			if(comp.compare(key, array[i].getKey())<=0){
				pos=i;
				encontre=true;}
		}
		if (encontre)
			return pos;
		else 
			return cantElem;
	}
	private void atrasarDesde(int pos){
		Entrada<K,V> aux;
			for(int i=cantElem-1;i>=pos;i--) {
				array[i+1]=array[i];
			}
		
	}
	public Entry<K, V> removeMin() throws EmptyPriorityQueueException {
		if(isEmpty()) throw new EmptyPriorityQueueException("La cola esta vacia");
		Entry<K,V> toReturn = array[0];
		adelantarArreglo();
		array[cantElem-1]=null;
		cantElem--;
	return toReturn;}
	
	private void adelantarArreglo(){
		for(int i=0;i<cantElem-1;i++){
			array[i]=array[i+1];
		}
	}
}

