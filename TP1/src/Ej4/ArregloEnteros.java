package Ej4;

public class ArregloEnteros implements ColeccionEnteros {
	//Estructura
	private int a[];
	private int indice;	//Cantidad de elementos, no posición
	
	public ArregloEnteros(){
		a = new int[10];
		indice = 0;
	}
	
	public void insertar (int i){
		a[indice++] = i;
	}

	public void eliminar(int n) {
		boolean encontre = false;
		int i = 0;
		while (i < indice && !encontre){
			if (a[i++]== n)
				encontre = true;
			else i++;
		}
		if (encontre){
			while (i < indice){
				a[i] = a [i+1];		
				i++;
			}
			a[i] = 0;
			indice--;
		}
	}

	public int cantidadElementos() {
		return indice;
	}

	public boolean pertenece(int n) {
		int i = 0;
		boolean pert = false;
		while (i < indice && !pert){
			pert = (a[i]==n);
			i++;
		}
		return pert;
	}
	

	
}
