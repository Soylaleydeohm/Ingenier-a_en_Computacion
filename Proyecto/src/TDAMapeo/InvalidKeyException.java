package TDAMapeo;

@SuppressWarnings("serial")
/**
 * class InvalidKeyException
 * @author VirginiaAraceli
 * Excepci�n lanzada cuando se quiere utilizar una clave considerada inv�lida.
 */
public class InvalidKeyException extends Exception{
	/**
	 * Crea la excepci�n.
	 * @param err Mensaje de error.
	 */
    public InvalidKeyException(String err){
        super(err);
    }
}