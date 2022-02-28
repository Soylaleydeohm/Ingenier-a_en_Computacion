package Ej4;

public class Arreglo2 <E> implements Conjunto <E>{
		//Estructura
		protected E a[];
		protected int indice;
		
		public Arreglo2(){
			a = (E[]) new Object[10];
			indice = 0;
		}
		
		public void insertar (E e){
			a[indice++] = e;
		}

		public void eliminar(E e) throws ElementoInvalidoException{
			boolean encontre = false;
			int i = 0;
			while (i < 10 && !encontre){
				if (a[i].equals(e))
					encontre = true;
				else i++;
			}
			if (encontre){
				while (i < indice-1){
					a[i] = a[i+1];
					i++;
				}
				a[i] = null;
				indice--;
			} else throw new ElementoInvalidoException("Elemento Invalido");
		}

		public int cantidadElementos() {		
			return indice;
		}

		public boolean pertenece(E e) {
			boolean pert = false;
			int i = 0;
			while (i < indice && !pert){
				pert = (a[i].equals(e));
				i++;
			}
			return pert;
		}	
}
