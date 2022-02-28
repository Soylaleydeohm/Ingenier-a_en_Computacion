package Project;
@SuppressWarnings("serial")
/**
 * class ReemplazoInvalidoException
 * @author VirginiaAraceli
 * Es una excepci�n lanzada por un m�todo cuando se quiere reemplazar y no es v�lido.
 */
public class ReemplazoInvalidoException extends Exception {
	public ReemplazoInvalidoException(String err){
		super(err);
	}
}
