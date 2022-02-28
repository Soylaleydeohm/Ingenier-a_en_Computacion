package TDALista;

@SuppressWarnings("serial")
/**
 * class NoSuchElementException
 * @author VirginiaAraceli
 * Excepci�n lanzada cuando el elemento a utilizar no se ha creado.
 */
public class NoSuchElementException extends Exception{
	/**
	 * Crea la excepci�n.
	 * @param err Mensaje de error.
	 */
	public NoSuchElementException(String err){
		super(err);
	}
}
