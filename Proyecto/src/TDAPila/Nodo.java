package TDAPila;

/**
 * Class Nodo
 * @author VirginiaAraceli
 * @param <T> Par�metro formal de tipo que representa el tipo de los elementos del Nodo.
 */
public class Nodo<T> {
	private T elemento;
	private Nodo<T> siguiente;
	
	//Constructores
	/**
	 * Crea un Nodo vac�o.
	 */
	public Nodo (){this(null, null);}
	
	/**
	 * Crea un Nodo con r�tulo r y sin Nodo siguiente.
	 * @param elem r�tulo del Nodo.
	 */
	public Nodo (T elem){this(elem, null);}
	
	/**
	 * Crea un Nodo con r�tulo r y con Nodo siguiente sig.
	 * @param elem r�tulo del Nodo.
	 * @param sig Nodo siguiente.
	 */
	public Nodo (T elem, Nodo <T> sig){elemento = elem; siguiente = sig;}
	
	/**
	 * Establece el r�tulo del Nodo.
	 * @param item r�tulo del Nodo.
	 */
	public void setElemento(T item){elemento = item;}
	
	/**
	 * Establece el siguiente Nodo del Nodo actual.
	 * @param sig siguiente Nodo del Nodo actual.
	 */
	public void setSiguiente(Nodo<T> sig){siguiente = sig;}
	
	/**
	 * Consulta el r�tulo del Nodo.
	 * @return R�tulo del Nodo.
	 */
	public T getElemento(){return elemento;}
	
	/**
	 * Consulta el siguiente del Nodo.
	 * @return Siguiente Nodo del Nodo actual.
	 */
	public Nodo<T> getSiguiente(){return siguiente;}
}
