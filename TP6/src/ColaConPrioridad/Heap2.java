package ColaConPrioridad;

import java.util.Comparator;

public class Heap2<K,V> implements PriorityQueue<K,V> {
	/*  Tiempo de ejecucion utilizando arbol binario parcialmente ordenado:
	 *	size()      -> O(1)
	 *	isEmpty()   -> O(1)
	 *	Insert(K,V) -> O(log(n)) //Si es amortizado (hay que agrandar arreglo).
	 *	min()       -> O(1)
	 *	removeMin() -> O(log(n))
	 */
	private Entry<K,V>[] heap;
	private Comparator<K> comp;
	private int size;
	
	public Heap2(Comparator<K> c){
		comp = c;
		heap = (Entry<K,V>[]) new Entrada[100];
		size=0;
	}
	
	public Heap2(){
		this(new DefaultComparator<K>());
	}
	
	public int size(){return size;}
	
	public boolean isEmpty(){return size == 0;}
	
	public Entry<K,V> insert(K k, V v) throws InvalidKeyException{
		try{
			if(k == null || (comp.compare(k,k) != 0))
				throw new InvalidKeyException("Clave inválida");
		}catch(ClassCastException err){
			throw new InvalidKeyException("Clave inválida");
		}
		if(size+1 == heap.length){
			agrandar();
		}
		Entry<K,V> entrada = new Entrada<K,V>(k,v);
		heap[++size] = entrada;		
		//Burbujeo para arriba.
		int i = size; 
		boolean seguir = true;
		while(i > 1 && seguir){
			if(comp.compare(heap[i].getKey(), heap[i/2].getKey()) < 0){
				intercambiar(i);
				i = i/2;
			}
			else seguir = false;
		}
		return entrada;
	}
	
	public Entry<K,V> min() throws EmptyPriorityQueueException{
		if(isEmpty()) throw new EmptyPriorityQueueException("Cola vacía");
		return heap[1]; //la entrada 0 del arreglo no se usa.
	}
	
	public Entry<K,V> removeMin()throws EmptyPriorityQueueException{
		if(isEmpty()) throw new EmptyPriorityQueueException("Cola vacía");
		Entry<K,V> aux = heap[1];
		size--;
		if(size >= 1){
			//Paso el ultimo a la raiz y lo borro
			heap[1] = heap[size+1];
			heap[size+1] = null;
			//Burbujeo la raiz hacia abajo
			int i = 1;
			boolean seguir = true;
			int menor,hi,hd;
			while(seguir){
				hi = 2*i;
				hd = 2*i+1;
				if(hi <= size){
					if(hd <= size){
						if(comp.compare(heap[hi].getKey(),heap[hd].getKey()) < 0) menor = hi;
						else menor = hd;
					}
					else menor = hi;
					if(comp.compare(heap[i].getKey(),heap[menor].getKey()) > 0){
						intercambiar(menor);
						i = menor;
					}
					else seguir = false;
				}
				else seguir = false;
				
			}
		}
		return aux;
	}
	
	//Privados
	private void intercambiar(int x){
		//Intercambia un nodo en la posicion x del arreglo con su padre.
		Entry<K,V> aux = heap[x];
		heap[x] = heap[x/2];
		heap[x/2] = aux;
	}
	
	private void agrandar(){
		Entry<K,V> [] temp = (Entry<K,V>[]) new Entrada[heap.length*2];
		int i=0;
		for(Entry<K,V> ent : heap){
			temp[i] = ent;
			i++;
		}
		heap = temp;
	}
}
