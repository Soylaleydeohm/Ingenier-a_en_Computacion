
public class ColaConLista<T> implements Queue<T> {
	protected Nodo<T> head;
	protected Nodo<T> tail;
	protected int tama�o;
	
	public ColaConLista(){
		head = new Nodo<T>();
		tail = new Nodo<T>();
		tama�o = 0;
	}
	public int size(){return tama�o;}
	public boolean isEmpty(){return tama�o == 0;}
	
	public void enqueue (T item){
		Nodo<T> aux = new Nodo<T>(item);
		if (tama�o == 0) head = aux;
		else tail.setSiguiente(aux); //Conecto a la cola con lo �ltimo que agregu�, aux
		tail = aux;//Ahora aux est� siendo referido por tail
		tama�o++;
	}
	
	public T dequeue() throws EmptyQueueException{
		if(isEmpty()) throw new EmptyQueueException ("Cola vac�a");
		Nodo<T> aux = head;
		head = head.getSiguiente();
		tama�o--;
		if (tama�o == 0) tail = null;
		return aux.getElemento();
	}
	
	public T front() throws EmptyQueueException{
		if(isEmpty()) throw new EmptyQueueException ("Cola vac�a");
		return head.getElemento();
	}
}
