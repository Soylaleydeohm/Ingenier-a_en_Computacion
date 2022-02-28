package TDALista;
	
@SuppressWarnings("serial")
/**
 * class EmptyListException
 * @author VirginiaAraceli
 * Excepción lanzada cuando se quiere utilizar una lista vacía.
 */
public class EmptyListException extends Exception{
	/**
	 * Crea la excepción.
	 * @param err Mensaje de error.
	 */
	public EmptyListException(String err){
		super(err);
	}
}


