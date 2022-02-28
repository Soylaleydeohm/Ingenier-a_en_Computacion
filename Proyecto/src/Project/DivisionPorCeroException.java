package Project;
@SuppressWarnings("serial")
/**
 * Class DivisionPorCeroException
 * @author VirginiaAraceli
 * Excepci�n lanzada cuando se quiere realizar una divisi�n por cero.
 */
public class DivisionPorCeroException extends Exception {
	/**
	 * Crea la excepci�n.
	 * @param err Mensaje de error.
	 */
	public DivisionPorCeroException(String err){
		super(err);
	}
}
