package EjerciciosMapeo;
import TDAMapeo.*;
import java.util.Iterator;

import TDALista.*;

public class IgualDomDiferenteIm {

	public static PositionList<Entry<Integer,Integer>> DomIm(Map<Integer,Integer> M1, Map<Integer, Integer> M2){
		PositionList<Entry<Integer,Integer>> retorno= new ListaDoblementeEnlazada<Entry<Integer,Integer>>();
		Iterator<Entry<Integer,Integer>> it= M1.entries().iterator();
		Entry<Integer,Integer> actual;
	    try{
		 while(it.hasNext()){
			actual=it.next();
			if(M2.get(actual.getKey())!=null)
				retorno.addLast(actual);
		 }
	    }
	    catch(InvalidKeyException e){System.out.println(e.getMessage()+"");}
		return retorno;
	}
	
}
