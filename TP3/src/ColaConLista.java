
public class ColaConLista<T> implements Queue<T> {
	protected Nodo<T> head;
	protected Nodo<T> tail;
	protected int tamaño;
	
	public ColaConLista(){
		head = new Nodo<T>();
		tail = new Nodo<T>();
		tamaño = 0;
	}
	public int size(){return tamaño;}
	public boolean isEmpty(){return tamaño == 0;}
	
	public void enqueue (T item){
		Nodo<T> aux = new Nodo<T>(item);
		if (tamaño == 0) head = aux;
		else tail.setSiguiente(aux); //Conecto a la cola con lo último que agregué, aux
		tail = aux;//Ahora aux está siendo referido por tail
		tamaño++;
	}
	
	public T dequeue() throws EmptyQueueException{
		if(isEmpty()) throw new EmptyQueueException ("Cola vacía");
		Nodo<T> aux = head;
		head = head.getSiguiente();
		tamaño--;
		if (tamaño == 0) tail = null;
		return aux.getElemento();
	}
	
	public T front() throws EmptyQueueException{
		if(isEmpty()) throw new EmptyQueueException ("Cola vacía");
		return head.getElemento();
	}
}
