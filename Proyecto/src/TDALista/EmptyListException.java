package TDALista;
	
@SuppressWarnings("serial")
/**
 * class EmptyListException
 * @author VirginiaAraceli
 * Excepci�n lanzada cuando se quiere utilizar una lista vac�a.
 */
public class EmptyListException extends Exception{
	/**
	 * Crea la excepci�n.
	 * @param err Mensaje de error.
	 */
	public EmptyListException(String err){
		super(err);
	}
}


