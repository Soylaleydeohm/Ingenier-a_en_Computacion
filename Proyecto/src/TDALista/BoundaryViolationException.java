package TDALista;

@SuppressWarnings("serial")

/**
 * class BoundaryViolationException
 * @author VirginiaAraceli
 * Excepción lanzada cuando se quiere realizar una operación sobre una posición que está fuera de los límites designados por la clase.
 */
public class BoundaryViolationException extends Exception{
	/**
	 * Crea la excepción.
	 * @param err Mensaje de error.
	 */
	public BoundaryViolationException(String err){
		super(err);
	}
}