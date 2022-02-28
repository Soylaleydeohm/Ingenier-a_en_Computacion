package Project;
@SuppressWarnings("serial")
/**
 * class ExpresionInvalidaException
 * @author VirginiaAraceli
 * Excepci�n lanzada cuando se ingresa una expresi�n considerada inv�lida por la clase principal.
 */
public class ExpresionInvalidaException extends Exception{
	/**
	 * Crea la excepci�n.
	 * @param err Mensaje de error.
	 */
	public ExpresionInvalidaException(String err){
		super(err);
	}
}