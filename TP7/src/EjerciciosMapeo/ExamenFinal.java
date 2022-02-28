package EjerciciosMapeo;

public class ExamenFinal {

	private String nombreMateria;
	private Integer nota;
 // private Date fecha;

	public ExamenFinal(String m, Integer n){
		nombreMateria=m;
		nota=n;
	}
	
	public Integer getNota(){
		return nota;
	}
}
