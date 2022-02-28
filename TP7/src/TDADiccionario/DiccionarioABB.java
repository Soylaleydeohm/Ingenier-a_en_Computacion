package TDADiccionario;

import java.util.Iterator;

import EjercicioPArcial.Dictionary;
import EjercicioPArcial.Entry;
import EjercicioPArcial.InvalidEntryException;
import EjercicioPArcial.InvalidPositionException;
import EjercicioPArcial.PositionList;

public class DiccionarioABB<K extends Comparable<K>,V> implements Dictionary<K,V> {
	protected ABB<Entry<K,V>> arbol;// par que almacena una clave y una lista con todas las entradas con igual clave.
	protected int size;

	public DiccionarioABB(){
		arbol = new ABB<Par<K,V>>();
		size = 0;
	}
	
	public int size() {return size;}

	public boolean isEmpty() {return size==0;}

	public Entry<K,V> find(K k) throws InvalidKeyException{
		if(k == null) throw new InvalidKeyException();
		Entry<K,V> aux = null;
		Par<K,V> p = arbol.buscar(new Par<K,V>(k)); 
		if( p != null){
			try {
				aux = p.getLista().first().element();// Es seguro que no esta vacia.
			} catch (EmptyListException e) {
				e.printStackTrace();
			}
		}
		return aux;
	}
	
	public Iterable<Entry<K,V>> findAll(K k) throws InvalidKeyException{
		if(k == null) throw new InvalidKeyException();
		Par<K,V> p = arbol.buscar(new Par<K,V>(k));
		PositionList<Entry<K,V>> l = new DoubleLinkedList<Entry<K,V>>();
		if(p != null){
			l = p.getLista();
		}
		return l;
	}
	
	public Entry<K,V> insert(K k, V v) throws InvalidKeyException{
		if(k == null) throw new InvalidKeyException();
		Par<K,V> par = new Par<K,V>(k);
		Par<K,V> p = arbol.buscar(par);
		Entry<K,V> ent = new EjercicioPArcial.Entrada<K,V>(k,v);
		if( p == null){//No esta en el arbol
			par.agregarEntrada(ent);
			arbol.insertar(par);
		}
		else{
			p.getLista().addLast(ent);
		}
		size++;
		return ent;
	}
	
	public Entry<K,V> remove(Entry<K,V> e) throws InvalidEntryException{
		if(e == null || e.getKey() == null) throw new InvalidEntryException();
		Par<K,V> p = arbol.buscar(new Par<K,V>(e.getKey()));
		if(p==null) throw new InvalidEntryException();
		Iterator<Position<Entry<K,V>>> it = p.getLista().positions().iterator();
		Entry<K,V> retorno = null;
		while(retorno == null && it.hasNext() ){
			Position<Entry<K,V>> aux = it.next();
			if(aux.element().equals(e)){//Comaparo que las entradas sean iguales
				
					retorno = aux.element();
					if(p.getLista().size() == 1){
						arbol.eliminar(p);
					}
					
					else{
						try {
							p.getLista().remove(aux);
						}catch (InvalidPositionException e1) {e1.printStackTrace();	}
					}
					size--;
			}
		}
		if(retorno == null) throw new InvalidEntryException(); // la entrada no existe.
		return retorno;
	}
	
	public Iterable<Entry<K,V>> entries(){
		PositionList<Entry<K,V>> l = new DoubleLinkedList<Entry<K,V>>();
		for(Par<K,V> p : arbol.elementos()){
			for(Entry<K,V> e : p.getLista()){
				l.addLast(e);
			}
		}
		return l;
	}
	
}
