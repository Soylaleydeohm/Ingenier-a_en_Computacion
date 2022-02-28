package TDAListaIterable;

public class TesterLista {
	public static void main (String [] arg){
		
	}
	
	
	public PositionListIterable<Integer> intercalarIt(PositionListIterable<Integer> L1, PositionListIterable<Integer> L2){
		try{
			PositionListIterable<Integer> intercalada = new ListaEnlazadaIterable<Integer>();
			Iterator<Integer> it1 = L1.iterator();
			Iterator<Integer> it2 = L2.iterator();
			while(it1.hasNext() && it2.hasNext()){
				intercalada.addLast(it1.next());
				intercalada.addLast(it2.next());		
			}
			while(it1.hasNext()){
				intercalada.addLast(it1.next());
			}
			while(it2.hasNext()){
				intercalada.addLast(it2.next());
			}
			return intercalada;
		}catch(NoSuchElementException e){
			System.out.println("Al menos una de las listas está vacía");
			return null;
		}
	}
	
	public PositionListIterable<Integer> intercalarItPos(PositionListIterable<Integer> L1, PositionListIterable<Integer> L2){
		try{
			PositionListIterable<Integer> intercalada = new ListaEnlazadaIterable<Integer>();
			Iterable<Position<Integer>> pL1 = L1.positions();
			Iterable<Position<Integer>> pL2 = L2.positions();
			Iterator<Position<Integer>> it1 = pL1.iterator();
			Iterator<Position<Integer>> it2 = pL2.iterator();
			while(it1.hasNext() && it2.hasNext()){
				intercalada.addLast(it1.next().element());
				intercalada.addLast(it2.next().element());		
			}
			while(it1.hasNext()){
				intercalada.addLast(it1.next().element());
			}
			while(it2.hasNext()){
				intercalada.addLast(it2.next().element());
			}
			return intercalada;
		}catch(NoSuchElementException e){
			System.out.println("Al menos una de las listas está vacía");
			return null;
		}
	}
	
	}
