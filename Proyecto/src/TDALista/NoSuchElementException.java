package TDALista;

@SuppressWarnings("serial")
/**
 * class NoSuchElementException
 * @author VirginiaAraceli
 * Excepción lanzada cuando el elemento a utilizar no se ha creado.
 */
public class NoSuchElementException extends Exception{
	/**
	 * Crea la excepción.
	 * @param err Mensaje de error.
	 */
	public NoSuchElementException(String err){
		super(err);
	}
}
