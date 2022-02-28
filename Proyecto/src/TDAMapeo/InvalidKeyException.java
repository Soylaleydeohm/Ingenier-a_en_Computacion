package TDAMapeo;

@SuppressWarnings("serial")
/**
 * class InvalidKeyException
 * @author VirginiaAraceli
 * Excepción lanzada cuando se quiere utilizar una clave considerada inválida.
 */
public class InvalidKeyException extends Exception{
	/**
	 * Crea la excepción.
	 * @param err Mensaje de error.
	 */
    public InvalidKeyException(String err){
        super(err);
    }
}