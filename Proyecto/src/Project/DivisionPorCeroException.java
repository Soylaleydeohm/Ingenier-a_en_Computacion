package Project;
@SuppressWarnings("serial")
/**
 * Class DivisionPorCeroException
 * @author VirginiaAraceli
 * Excepción lanzada cuando se quiere realizar una división por cero.
 */
public class DivisionPorCeroException extends Exception {
	/**
	 * Crea la excepción.
	 * @param err Mensaje de error.
	 */
	public DivisionPorCeroException(String err){
		super(err);
	}
}
