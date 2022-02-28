package TDAPila;

/**
 * Clase que modela una excepción cuando la pila es vacía
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

