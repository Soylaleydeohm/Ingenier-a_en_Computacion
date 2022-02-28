package TDAPila;

/**
 * Clase que modela una excepci�n cuando la pila es vac�a
 * @author VirginiaAraceli
 *
 */
@SuppressWarnings("serial")
public class EmptyStackException extends Exception{
	/**
	 * 
	 * @param err es el mensaje de error
	 */
	public EmptyStackException(String err){
		super(err);
	}
}

