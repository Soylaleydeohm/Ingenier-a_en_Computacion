package TDALista;

@SuppressWarnings("serial")
/**
 * class InvalidPositionException
 * @author VirginiaAraceli
 * Excepci�n lanzada cuando se quiere utilizar una posici�n inv�lida.
 */
public class InvalidPositionException extends Exception{
	/**
	 * Crea la excepci�n.
	 * @param err Mensaje de error.
	 */
	public InvalidPositionException(String err){
		super(err);
	}
}
