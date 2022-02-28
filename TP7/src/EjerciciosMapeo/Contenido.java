package EjerciciosMapeo;
import java.util.Iterator;

import TDAMapeo.*;
public class Contenido {
	
	public static void main(String args[]){
		
		Map<Integer, Character> mapeo= new HashAbierto<Integer,Character>();
		try {
    		mapeo.put(1,'j');
			mapeo.put(2,'b');
	    	mapeo.put(3,'c');
	    	mapeo.put(4,'b');
	    	mapeo.put(5,'a');
	    	mapeo.put(6,'a');
		} catch (InvalidKeyException e) {
			e.printStackTrace();
		}
    	
    	System.out.println("M1: ");
    	mostrarMapeo(mapeo);
    	
    	Map<Integer, Character> mapeo2= new HashAbierto<Integer,Character>();
    	try {
			mapeo2.put(1,'a');
			mapeo2.put(2,'b');
	    	mapeo2.put(3,'c');
	    	mapeo2.put(4,'f');
	    	mapeo2.put(5,'a');
	    	mapeo2.put(6,'a');
	    	
		} catch (InvalidKeyException e) {
			e.printStackTrace();
		}
    	
    	System.out.println('\n'+"M2: ");
    	mostrarMapeo(mapeo2);
    	
    	System.out.println('\n'+"Todas las claves de M1 están contenidas en M2?: "
    			+todasContenidas(mapeo, mapeo2));
    }	
	
    public static<K,V> void mostrarMapeo(Map<K,V> mapeo){
    	for(Entry<K,V> entrada: mapeo.entries()){
    		System.out.print("<"+entrada.getKey()+","+entrada.getValue()+"> ");
    	}
    }

	public static <K,V> boolean todasContenidas(Map<K,V> M1, Map<K,V> M2){
		boolean cumple=true;
		Iterator<Entry<K,V>> itM1= M1.entries().iterator();
		while(itM1.hasNext() && cumple){
			try {
				cumple=M2.get(itM1.next().getKey())!=null;
			} catch (InvalidKeyException e) {
				cumple=false; 
			}
		}
		return cumple;
	}
	
}
