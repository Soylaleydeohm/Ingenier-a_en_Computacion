package ColaConPrioridad;

public class Testeo {
	public static void main (String [] args){
		PriorityQueue<Integer, String> pq= new PQConArreglo2<Integer, String>();
		String n1, n2, n3, n4, n5, n6;
		Integer i1, i2, i3, i4, i5, i6;
		n1 = "Uno";
		n2 = "Dos";
		n3 = "Tres";
		n4 = "Cuatro";
		n5 = "Cinco";
		n6 = "Seis";
		i1 = 1;
		i2 = 2;
		i3 = 3;
		i4 = 4;
		i5 = 5;
		i6 = 6;
		
		try {
			pq.insert(i1, n1);
			pq.insert(i2, n2);
			pq.insert(i3, n3);
			pq.insert(i4, n4);
			pq.insert(i5, n5);
			pq.insert(i6, n6);
			System.out.println(pq.min().getKey()+pq.removeMin().getValue());
			System.out.println(pq.min().getKey()+pq.removeMin().getValue());
			System.out.println(pq.min().getKey()+pq.removeMin().getValue());
			System.out.println(pq.min().getKey()+pq.removeMin().getValue());
			System.out.println(pq.min().getKey()+pq.removeMin().getValue());
			System.out.println(pq.min().getKey()+pq.removeMin().getValue());
			
			pq.insert(i6, n6);
			pq.insert(i5, n5);
			pq.insert(i4, n4);
			pq.insert(i3, n3);
			pq.insert(i2, n2);
			pq.insert(i1, n1);
			System.out.println(pq.min().getKey()+pq.removeMin().getValue());
			System.out.println(pq.min().getKey()+pq.removeMin().getValue());
			System.out.println(pq.min().getKey()+pq.removeMin().getValue());
			System.out.println(pq.min().getKey()+pq.removeMin().getValue());
			System.out.println(pq.min().getKey()+pq.removeMin().getValue());
			System.out.println(pq.min().getKey()+pq.removeMin().getValue());
			
		} catch (InvalidKeyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (EmptyPriorityQueueException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
