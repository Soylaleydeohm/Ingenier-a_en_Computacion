package EjerciciosMapeo;

import TDAMapeo.*;

public class LejagoDatosCompletos {

	private Map<String,Alumno> mapeo;
	
	public LejagoDatosCompletos(){
		mapeo=new HashAbierto<String,Alumno>();
	}
	
	public void añadirAlumno(Alumno alum){
		try {
			mapeo.put(alum.getLegajo(), alum);
		} catch (InvalidKeyException e) {
			e.printStackTrace();
		}
	}
	
	public Alumno getAlumno(String legajo){
		Alumno retorno=null;
		try {
			retorno= mapeo.get(legajo);
		} catch (InvalidKeyException e) {
			e.printStackTrace();
		}
		return retorno;
	}
}
