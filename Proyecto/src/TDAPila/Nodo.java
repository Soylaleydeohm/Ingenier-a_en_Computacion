package TDAPila;

/**
 * Class Nodo
 * @author VirginiaAraceli
 * @param <T> Parámetro formal de tipo que representa el tipo de los elementos del Nodo.
 */
public class Nodo<T> {
	private T elemento;
	private Nodo<T> siguiente;
	
	//Constructores
	/**
	 * Crea un Nodo vacío.
	 */
	public Nodo (){this(null, null);}
	
	/**
	 * Crea un Nodo con rótulo r y sin Nodo siguiente.
	 * @param elem rótulo del Nodo.
	 */
	public Nodo (T elem){this(elem, null);}
	
	/**
	 * Crea un Nodo con rótulo r y con Nodo siguiente sig.
	 * @param elem rótulo del Nodo.
	 * @param sig Nodo siguiente.
	 */
	public Nodo (T elem, Nodo <T> sig){elemento = elem; siguiente = sig;}
	
	/**
	 * Establece el rótulo del Nodo.
	 * @param item rótulo del Nodo.
	 */
	public void setElemento(T item){elemento = item;}
	
	/**
	 * Establece el siguiente Nodo del Nodo actual.
	 * @param sig siguiente Nodo del Nodo actual.
	 */
	public void setSiguiente(Nodo<T> sig){siguiente = sig;}
	
	/**
	 * Consulta el rótulo del Nodo.
	 * @return Rótulo del Nodo.
	 */
	public T getElemento(){return elemento;}
	
	/**
	 * Consulta el siguiente del Nodo.
	 * @return Siguiente Nodo del Nodo actual.
	 */
	public Nodo<T> getSiguiente(){return siguiente;}
}
