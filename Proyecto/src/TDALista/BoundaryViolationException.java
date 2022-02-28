package TDALista;

@SuppressWarnings("serial")

/**
 * class BoundaryViolationException
 * @author VirginiaAraceli
 * Excepci�n lanzada cuando se quiere realizar una operaci�n sobre una posici�n que est� fuera de los l�mites designados por la clase.
 */
public class BoundaryViolationException extends Exception{
	/**
	 * Crea la excepci�n.
	 * @param err Mensaje de error.
	 */
	public BoundaryViolationException(String err){
		super(err);
	}
}