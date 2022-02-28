package Project;
@SuppressWarnings("serial")
/**
 * class InvalidVariableException
 * @author VirginiaAraceli
 * Excepción lanzada cuando se ingresa una variable considerada inválida por la clase principal.
 */
public class InvalidVariableException extends Exception{
	/**
	 * Crea la excepción.
	 * @param err Mensaje de error.
	 */
	public InvalidVariableException(String err){
		super(err);
	}
}

