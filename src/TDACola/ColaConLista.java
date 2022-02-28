package TDACola;

public class ColaConLista <T> implements Queue<T>{

	protected Nodo<T> frente;
	protected Nodo<T> cola;
	protected int tama�o;
	
	public ColaConLista (){
		frente=null;
		cola=null;
		tama�o=0;
	}	
	public void enqueue(T elem) {
		Nodo<T> nodo= new Nodo<T>(elem);
		if (tama�o==0)
			frente=nodo;
		else
		    cola.setSiguiente(nodo);
		cola=nodo;
		tama�o++;
	}
	public T dequeue() throws EmptyQueueException {
		if (tama�o==0)
			throw new EmptyQueueException("Error: la cola est� vac�a.");
		T aux= frente.getElemento();
		frente=frente.getSiguiente();
		tama�o--;
		return aux;
	}
	public T front() throws EmptyQueueException {
		if (tama�o==0)
			throw new EmptyQueueException("Error: la cola est� vac�a.");
		return frente.getElemento();
	}
	public boolean isEmpty() {
		return tama�o==0;
	}
	public int size() {
		return tama�o;
	}
	
}
