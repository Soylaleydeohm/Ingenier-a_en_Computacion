package TDALista;

@SuppressWarnings("serial")
/**
 * class InvalidPositionException
 * @author VirginiaAraceli
 * Excepción lanzada cuando se quiere utilizar una posición inválida.
 */
public class InvalidPositionException extends Exception{
	/**
	 * Crea la excepción.
	 * @param err Mensaje de error.
	 */
	public InvalidPositionException(String err){
		super(err);
	}
}
