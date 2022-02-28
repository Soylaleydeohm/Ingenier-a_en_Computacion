package TDACola;

public class ColaConLista <T> implements Queue<T>{

	protected Nodo<T> frente;
	protected Nodo<T> cola;
	protected int tamaño;
	
	public ColaConLista (){
		frente=null;
		cola=null;
		tamaño=0;
	}	
	public void enqueue(T elem) {
		Nodo<T> nodo= new Nodo<T>(elem);
		if (tamaño==0)
			frente=nodo;
		else
		    cola.setSiguiente(nodo);
		cola=nodo;
		tamaño++;
	}
	public T dequeue() throws EmptyQueueException {
		if (tamaño==0)
			throw new EmptyQueueException("Error: la cola está vacía.");
		T aux= frente.getElemento();
		frente=frente.getSiguiente();
		tamaño--;
		return aux;
	}
	public T front() throws EmptyQueueException {
		if (tamaño==0)
			throw new EmptyQueueException("Error: la cola está vacía.");
		return frente.getElemento();
	}
	public boolean isEmpty() {
		return tamaño==0;
	}
	public int size() {
		return tamaño;
	}
	
}
