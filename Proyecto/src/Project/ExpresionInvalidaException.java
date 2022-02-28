package Project;
@SuppressWarnings("serial")
/**
 * class ExpresionInvalidaException
 * @author VirginiaAraceli
 * Excepción lanzada cuando se ingresa una expresión considerada inválida por la clase principal.
 */
public class ExpresionInvalidaException extends Exception{
	/**
	 * Crea la excepción.
	 * @param err Mensaje de error.
	 */
	public ExpresionInvalidaException(String err){
		super(err);
	}
}