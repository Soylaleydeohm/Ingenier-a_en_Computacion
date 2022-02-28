
public class Nodo<T> {
	private T elemento;
	private Nodo<T> siguiente;
	
	//Constructores
	public Nodo (){this(null, null);}
	public Nodo (T elem){this(elem, null);}
	public Nodo (T elem, Nodo <T> sig){elemento = elem; siguiente = sig;}
	
	//Metodos
	public void setElemento(T item){elemento = item;}
	public void setSiguiente(Nodo<T> sig){siguiente = sig;}
	public T getElemento(){return elemento;}
	public Nodo<T> getSiguiente(){return siguiente;}
}
