package Ej4;
import java.util.Vector;

public class VectorEnteros implements ColeccionEnteros {
	private Vector<Integer> vector;
	
	public VectorEnteros(){
		vector = new Vector<Integer>();		
	}	
	public void insertar (int n){
		vector.addElement(n);
	}
	public void eliminar(int n){
		vector.remove(n);
	}
	public int cantidadElementos(){
		return vector.size();
	}
	public boolean pertenece (int n){
		return (vector.indexOf(n)!=-1);
	}
}
