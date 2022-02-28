
public class TesterLista {
	public static void main (String [] arg){
		
	}
	public PositionList<Integer> intercalarOrdenado(PositionList<Integer> L1, PositionList<Integer> L2){
		try{
			PositionList<Integer> U = new ListaSimplementeEnlazada<Integer>();
			Position<Integer> p1 = null;
			Position<Integer> p2 = null;
			if(!L1.isEmpty())
				p1 = L1.first();
			if(!L2.isEmpty())
				p2 = L2.first();
			while(p1!= null && p2!= null){
				if(p1.element() > p2.element()){
					U.addLast(p2.element());
					if(p2!= L2.last())
						p2 = L2.next(p2);
					else p2 = null;
				} else if (p1.element() < p2.element()){
					U.addLast(p1.element());
					if(p1!= L1.last())
						p1 = L1.next(p1);
					else p1 = null;
				} else { //Caso iguales
					U.addLast(p1.element());
					if(p1!= L1.last())
						p1 = L1.next(p1);
					else p1 = null;
					if(p2!= L2.last())
						p2 = L2.next(p2);
					else p2 = null;
				}					
			}
			while(p1!= null){
				U.addLast(p1.element());
				if(p1!= L1.last())
					p1 = L1.next(p1);
				else p1 = null;
			}
			while(p2!= null){
				U.addLast(p2.element());
				if(p2!= L2.last())
					p2 = L2.next(p2);
				else p2 = null;
			}
			return U;
		}catch(EmptyListException e1){
			System.out.println("Al menos una de las listas está vacía");
			return null;
		}catch(InvalidPositionException e2){
			System.out.println("Una de las posiciones no es válida");
			return null;
		}catch(BoundaryViolationException e3){
			System.out.println("Una posición excede el rango de una lista");	
			return null;
		}
	}


	public PositionList<Integer> intercalar(PositionList<Integer> L1, PositionList<Integer> L2){
		try{
			PositionList<Integer> intercalada = new ListaSimplementeEnlazada<Integer>();
			Position<Integer> p1 = null;
			Position<Integer> p2 = null;
			if(!L1.isEmpty())
				p1 = L1.first();
			if(!L2.isEmpty())
				p2 = L2.first();
			while(p1!= null && p2!= null){
				intercalada.addLast(p1.element());
				intercalada.addLast(p2.element());
				if(p1!= L1.last())
					p1 = L1.next(p1);
				else p1 = null;
				if(p2!= L2.last())
					p2 = L2.next(p2);
				else p2 = null;				
			}
			while(p1!= null){
				intercalada.addLast(p1.element());
				if(p1!= L1.last())
					p1 = L1.next(p1);
				else p1 = null;
			}
			while(p2!= null){
				intercalada.addLast(p2.element());
				if(p2!= L2.last())
					p2 = L2.next(p2);
				else p2 = null;
			}
			return intercalada;
		}catch(EmptyListException e){
			System.out.println("Al menos una de las listas está vacía");
			return null;
		}catch(InvalidPositionException e){
			System.out.println("Una de las posiciones no es válida");
			return null;
		}catch(BoundaryViolationException e){
			System.out.println("Una posición excede el rango de una lista");	
			return null;
		}
	}
		
	public <E> void invertir(PositionList<E> l){
		if(l.isEmpty()){
			try{
				int contador = 0;
				Position<E> ini = l.first();
				Position<E> fin = l.last();
				E aux;
				while(contador < l.size()/2){
					aux = ini.element();
					l.set(ini, fin.element());
					l.set(fin, aux);
					ini = l.next(ini);
					fin = l.prev(fin);
					contador++;
				}
			}catch(EmptyListException e){
				System.out.println("Al menos una de las listas está vacía");
			}catch(InvalidPositionException e){
				System.out.println("Una de las posiciones no es válida");
			}catch(BoundaryViolationException e){
				System.out.println("Una posición excede el rango de una lista");	
			}
		}
	}
	
	public <E> void invertirRec(PositionList<E> l){
		try{
			if(!l.isEmpty())
				invertir(l, l.first(), l.last());
		}catch(EmptyListException e){
			System.out.println("Al menos una de las listas está vacía");
		}
	}
	
	private <E> void invertir(PositionList<E> l, Position<E> ini, Position<E> fin){
		try{
			if(ini != fin){ //Caso base un elemento no hace nada
				E aux = ini.element();
				l.set(ini, fin.element());
				l.set(fin, aux);
				if(l.next(ini) != fin) //Si son más de dos elementos vuelve a llamar al algoritmo
					invertir(l, l.next(ini), l.prev(fin));			
			}
		}catch(InvalidPositionException e){
			System.out.println("Una de las posiciones no es válida");
		}catch(BoundaryViolationException e){
			System.out.println("Una posición excede el rango de una lista");	
		}
	}
}
