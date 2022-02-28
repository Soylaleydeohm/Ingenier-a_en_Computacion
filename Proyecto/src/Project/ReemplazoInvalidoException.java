package Project;
@SuppressWarnings("serial")
/**
 * class ReemplazoInvalidoException
 * @author VirginiaAraceli
 * Es una excepción lanzada por un método cuando se quiere reemplazar y no es válido.
 */
public class ReemplazoInvalidoException extends Exception {
	public ReemplazoInvalidoException(String err){
		super(err);
	}
}
