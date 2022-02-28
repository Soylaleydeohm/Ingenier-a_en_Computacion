package EjerciciosMapeo;

import java.util.Iterator;

import TDAMapeo.*;

public class Acomodar {

    public static void main (String a[]){
    	
    	Map<Integer, Character> mapeo= new HashAbierto<Integer,Character>();
    	try {
			mapeo.put(1,'a');
			mapeo.put(2,'b');
	    	mapeo.put(3,'c');
	    	mapeo.put(4,'b');
	    	mapeo.put(5,'a');
	    	mapeo.put(6,'a');
		} catch (InvalidKeyException e) {
			e.printStackTrace();
		}
    	
    	System.out.println("Mapeo: ");
    	mostrarMapeo(mapeo);
    	
    	System.out.println('\n'+"Mapeo despúes de ACOMODAR: ");
        ACOMODAR(mapeo);
    	mostrarMapeo(mapeo);
    	
    }	
	
    public static<K,V> void mostrarMapeo(Map<K,V> mapeo){
    	for(Entry<K,V> entrada: mapeo.entries()){
    		System.out.print("<"+entrada.getKey()+","+entrada.getValue()+"> ");
    	}
    }
    
	public static<K,V> void ACOMODAR(Map<K,V> D){
		//Primer parte: crea un mapeo nuevo con las claves 
		//como valor y los valores como claves
		Iterator<Entry<K,V>> it= D.entries().iterator();
		Entry<K,V> actual;
		Map<V,K> alreves= new TablaDispersionCerrada<V,K>();
		while(it.hasNext()){
			actual=it.next();
			try {
				alreves.put(actual.getValue(), actual.getKey());
			} catch (InvalidKeyException e) {
				e.printStackTrace();
			}
		}
		//Crea un nuevo mapeo con alreves, las claves son valores y biceversa
		Map<K,V> sinrepetir= new TablaDispersionCerrada<K,V>();
		for(Entry<V,K> entry: alreves.entries()){
			try {
				sinrepetir.put(entry.getValue(),entry.getKey());
			} catch (InvalidKeyException e) {
				e.printStackTrace();
			}
		}
		//Elimina de D todo lo que no esta en alreves
		for(Entry<K,V> entrada: D.entries()){
			try {
				if(sinrepetir.get(entrada.getKey())==null)
					D.remove(entrada.getKey());
			} catch (InvalidKeyException e) {
				e.printStackTrace();
			}
		}
	}
}
