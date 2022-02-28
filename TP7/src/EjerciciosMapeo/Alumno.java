package EjerciciosMapeo;
import java.util.Iterator;

import TDALista.*;

public class Alumno {

	private String legajo;
	private String nombre;
	private PositionList<ExamenFinal> finales;
	
	public Alumno(String l, String n){
		legajo=l;
		nombre=n;
		finales= new ListaDoblementeEnlazada<ExamenFinal>();
	}	
	public void addExamenFinal(ExamenFinal ex){
		finales.addLast(ex);
	} 
	
	public Iterator<ExamenFinal> getFinales(){
		return finales.iterator();
	}
	
	public String getNombre(){
		return nombre;
	}
	
	public String getLegajo(){
		return nombre;
	}
}
