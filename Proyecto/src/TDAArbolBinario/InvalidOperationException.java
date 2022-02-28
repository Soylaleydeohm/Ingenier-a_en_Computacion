package TDAArbolBinario;

@SuppressWarnings("serial")
/**
 * class InvalidOperationException
 * @author VirginiaAraceli
 * Excepción lanzada cuando se quiere realizar una operación considerada inválida.
 */
public class InvalidOperationException extends Exception{
	/**
	 * Crea la excepción.
	 * @param err Mensaje de error.
	 */
	public InvalidOperationException(String err){
		super(err);
	}
}
