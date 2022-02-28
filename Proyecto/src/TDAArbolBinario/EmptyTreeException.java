package TDAArbolBinario;
@SuppressWarnings("serial")
/**
 * class EmptyTreeException
 * @author VirginiaAraceli
 * Excepción lanzada cuando se quiere evaluar un árbol vacío.
 */
public class EmptyTreeException extends Exception{
	/**
	 * Crea la excepción.
	 * @param err Mensaje de error.
	 */
	public EmptyTreeException(String err){
		super(err);
	}
}
