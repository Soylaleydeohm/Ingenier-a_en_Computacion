package EjerciciosMapeo;
import TDAMapeo.*;
import TDAMapeo.Entry;
import TDAMapeo.InvalidKeyException;
import TDADiccionario.*;

public class MapeoInverso {
	
	public static void main(String[] args) {
		DiccionarioConHash<Integer, Character> dic= new DiccionarioConHash<Integer,Character>();
    	try {
    		dic.insert(1,'a');
    		dic.insert(1,'b');
    		dic.insert(1,'c');
    		dic.insert(1,'d');
    		dic.insert(2,'b');
    		dic.insert(3,'c');
    		dic.insert(3,'d');
    		dic.insert(4,'d');
    		dic.insert(4,'e');
    		dic.insert(4,'f');
    		dic.insert(4,'g');
    		dic.insert(4,'h');
    		dic.prueba();
		} catch (TDADiccionario.InvalidKeyException e) {
			e.printStackTrace();
		}
    	
    	
	}

	/*public static void main(String[] args) {
		Map<Integer, Character> mapeo= new HashAbierto<Integer,Character>();
    	try {
			mapeo.put(1,'a');
			mapeo.put(2,'b');
	    	mapeo.put(3,'c');
	    	mapeo.put(4,'d');
	    	mapeo.put(5,'e');
	    	mapeo.put(6,'f');
		} catch (InvalidKeyException e) {
			e.printStackTrace();
		}
    	
    	System.out.println("Mapeo: ");
    	mostrarMapeo(mapeo);
    	
    	System.out.println('\n'+"CREAR_MAPEO_INVERSO: ");
    	mostrarMapeo(CREAR_MAPEO_INVERSO(mapeo));
	}

	public static<K,V> void mostrarMapeo(Map<K,V> mapeo){
		for(Entry<K,V> entrada: mapeo.entries()){
			System.out.print("<"+entrada.getKey()+","+entrada.getValue()+"> ");
		}
	}

	public static <K,V> Map<V,K> CREAR_MAPEO_INVERSO(Map<K,V> D){
		//D debe ser biyectivo
		Map<V,K> M = new HashAbierto<V,K>();
		for(Entry<K,V> entrada: D.entries()){
			try {
				M.put(entrada.getValue(), entrada.getKey());
			} catch (InvalidKeyException e) {
				e.printStackTrace();
			}
		}
		return M;
	}*/

}
