package Project;
@SuppressWarnings("serial")
/**
 * class InvalidVariableException
 * @author VirginiaAraceli
 * Excepci�n lanzada cuando se ingresa una variable considerada inv�lida por la clase principal.
 */
public class InvalidVariableException extends Exception{
	/**
	 * Crea la excepci�n.
	 * @param err Mensaje de error.
	 */
	public InvalidVariableException(String err){
		super(err);
	}
}

