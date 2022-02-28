
public class Nodo<E> implements Position<E> {
	private E elemento;
	private Nodo<E> siguiente;

	public Nodo(E elem, Nodo<E> sig){
		elemento = elem;
		siguiente = sig;
	}
	
	public Nodo(E elem){this(elem, null);}
	
	public E element(){return elemento;}
	public void setElemento(E item){elemento = item;}
	public Nodo<E> getSiguiente(){return siguiente;}
	public void setSiguiente(Nodo<E> sig){siguiente = sig;}
}
