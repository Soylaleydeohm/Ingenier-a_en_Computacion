package TDAArbolBinario;

@SuppressWarnings("serial")
/**
 * class InvalidOperationException
 * @author VirginiaAraceli
 * Excepci�n lanzada cuando se quiere realizar una operaci�n considerada inv�lida.
 */
public class InvalidOperationException extends Exception{
	/**
	 * Crea la excepci�n.
	 * @param err Mensaje de error.
	 */
	public InvalidOperationException(String err){
		super(err);
	}
}
