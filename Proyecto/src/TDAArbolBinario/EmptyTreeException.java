package TDAArbolBinario;
@SuppressWarnings("serial")
/**
 * class EmptyTreeException
 * @author VirginiaAraceli
 * Excepci�n lanzada cuando se quiere evaluar un �rbol vac�o.
 */
public class EmptyTreeException extends Exception{
	/**
	 * Crea la excepci�n.
	 * @param err Mensaje de error.
	 */
	public EmptyTreeException(String err){
		super(err);
	}
}
