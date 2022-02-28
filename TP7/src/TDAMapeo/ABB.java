package TDAMapeo;

import java.util.*;

import TDALista.*;

/**
 * Clase para crear un Arbol Binario de Búsqueda(ABB) con referencia al nodo raíz.
 * @param <K> Parametro genérico de la clave.
 * @param <V> Parametro genérico del valor.
 */
public class ABB<K,V> {
	protected NodoABB <Entry<K,V>> raiz ;
	protected Comparator <K> comp;
	protected int size;
	
	/**
	 * Constructor que inicializa el arból con la raíz.
	 * @param k Clave de la raíz
	 * @param v Valor rótulo de la raíz 
	 * @param compa Comparador de claves.
	 */
	public ABB( K k , V v , Comparator<K> compa)
	  { raiz = new NodoABB <Entry<K,V>>(new Entrada<K, V>(k,v));
	    raiz.setLeft(new NodoABB <Entry<K,V>>(null));
	    raiz.setRight(new NodoABB <Entry<K,V>> (null));
	  	size=1;
	  	comp=compa;
	  }
	
	/**
	 * Constructor que inicializa el arból vacío.
	 * @param compa Comparador de claves.
	 */
	public ABB(Comparator<K> compa)
	  { raiz = new NodoABB<Entry<K,V>>(null,null,null,null);
	  	size=0;
	  	comp=compa;
	  }
	
	public ABB(){
		this(new DefaultComparator<K>());
	  }
	 
	/**
	 * Testea si el árbol está vacío.
	 * @return verdadero si el árbol está vacío y falso en caso contrario
	 */
	public boolean isEmpty() 
		{return (size()==0);
		}
	
	/**
	 * Devuelve un iterador de entradas.
	 * @return Un iterador de entradas.
	 */
	public Iterator<Entry<K,V>> iterator() 
		{Iterable<Entry<K,V>> posiciones= entriesArbol();
			PositionList<Entry<K,V>> elements= new ListaSimplementeEnlazada <Entry<K,V>> ();
		 for(Entry<K,V> pos:posiciones)
			elements.addLast(pos);
		 return elements.iterator();
	    }

	/**
	 * Devuelve una coleccion iterable de las entradas almacenadas en el ABB.
	 * @return
	 */
	public Iterable <Entry<K,V>> entriesArbol()
		{ListaSimplementeEnlazada <Entry<K,V>> l=new ListaSimplementeEnlazada <Entry<K,V>>();
		 pre(l,raiz);		
		 return l;
	    }

	/**
	 * Recorrido en preorden
	 * @param l Lista de posiciones del arbol a recorrer
	 * @param r El nodo raíz del arbol
	 */
	public void pre(ListaSimplementeEnlazada <Entry<K,V>> l, NodoABB<Entry<K,V>> r)
		{l.addLast(r.getRotulo());
		 if (r.getLeft().getRotulo()!=null)
			pre(l,r.getLeft());
		
		 if (r.getRight().getRotulo()!=null)
			pre(l,r.getRight());
		}
	
	/**
	 * Devuelve la cantidad de nodos que tiene el árbol.
	 * @return Cantidad de nodos.
	 */
	public int size() 
	      {return size;
	      }
	
	/**
	 * Permite ingresar un nodo nuevo al árbol.
	 * Si el mapeo NO contiene una entrada con la clave y valor dados, entonces la agrega.
	 * Sino, si existe una entrada con dicha clave, reemplaza su valor por el valor dado.
	 * @param e Valor de la entrada a insertar.
	 * @return Null si no existe una clave con los parametros dados; y sino retorna
	 * el antiguo valor de la entrada, antes de ser reemplazado.
	 */
	public V insert (Entry<K,V> e)
		{return insertAux(e,raiz);
		}
	
	/**
	 * Método recursivo auxiliar de insert().
	 * @param e Entrada a insertar.
	 * @param v Nodo raíz del árbol en el cual se va a insertar.
	 * @return Null si no existe una clave con los parametros dados; y sino retorna
	 * el antiguo valor de la entrada, antes de ser reemplazado.
	 */
	private V insertAux(Entry<K,V> e , NodoABB <Entry<K,V>> v){
		if (v.getRotulo()==null)//caso base no lo encontro.
			{v.setRotulo(e);
			 v.setLeft(new NodoABB <Entry<K,V>>(null,null,null,v));
			 v.setRight(new NodoABB <Entry<K,V>> (null,null,null,v));
			 size++;
			 return null;
		    }
		 else
			{if (comp.compare(e.getKey(),v.getRotulo().getKey())==0) //Ya esta la clave
				{
				V aux = v.getRotulo().getValue();
			    v.setRotulo(e);
			    return aux;
				}
			else
				if (comp.compare(e.getKey(),v.getRotulo().getKey())<0)// busco en el subárbol izquierdo.
					return insertAux(e,v.getLeft());
				else
					return insertAux(e,v.getRight());// busco en el subárbol derecho.
			}
		}
	
	/**
	 * Retorna el valor de la entrada con una clave "key" determinada
	 * @param key Clave de la entrada buscada
	 * @return Valor de la entrada, si existe una entrada con clave "key", null en caso contrario.
	 */
	public Entry<K,V> find(K key) throws InvalidKeyException{  
		if (key==null)throw new InvalidKeyException("Clave nula");
		return findAux(key, raiz);}
		
		
	/**
	 * Método recursivo auxiliar de find().
	 * @param key Clave de la entrada buscada
	 * @param v Nodo raíz del árbol en el cual se va a insertar.
	 * @return Valor de la entrada, si existe una entrada con clave "key", null en caso contrario.
	 */
	private Entry<K,V> findAux (K key , NodoABB <Entry<K,V>> v)	
		{if (v.getRotulo()==null)//caso base no lo encontro
			return null;
		else
			if (comp.compare(v.getRotulo().getKey(), key)==0)// caso base lo encontro
				return v.getRotulo();
			 else
				  if (comp.compare(key,v.getRotulo().getKey())<0) // busco en el subárbol izquierdo.
					  return findAux(key,v.getLeft());
				  else
					  return findAux(key,v.getRight());// busco en el subárbol derecho.
		}
	
	/**
	 * Remueve del árbol a la entrada con la clave dada 
	 * @param key Clave de la entrada a eliminar	
	 * @return Null si no existe entrada con la clave buscada; el valor de la entrada
	 * eliminada, en caso contrario.
	 */
	public V remove (K key)
		{		
		return removeAux(key,raiz);}
	
	/**
	 * Método recursivo auxiliar de remove().
	 * @param key Clave de la entrada buscada
	 * @param v Nodo raíz del árbol en el cual se va a removerr.
	 * @return Null si no existe entrada con la clave buscada; el valor de la entrada
	 * eliminada, en caso contrario.
	 */
	private V removeAux (K key, NodoABB <Entry<K,V>> v)
	{if (v.getRotulo()==null)//caso base la clave no estaba 
		return null;
	 else if (comp.compare(key,v.getRotulo().getKey())==0) //la clave esta y la elimino
			 {V eliminado = v.getRotulo().getValue();
			 size--;
		      if  (v.getLeft().getRotulo()==null && v.getRight().getRotulo()==null) // es nodo con sus dos hijos hoja
		    	  {v.setRotulo(null);
		    	  if(v.getPadre().getLeft()==v) v.getPadre().setLeft(null);
		    	  else v.getPadre().setRight(null);
		    	  v.setPadre(null);		           
		    	  }
		      else{
		    	  if (v.getLeft().getRotulo()==null && v.getRight().getRotulo()!=null){
		    		  if(v.getPadre().getLeft()==v){
		    			  v.getRight().setPadre(v.getPadre());
		    			  v.getPadre().setLeft(v.getRight());
		    		  }else{
		    			  v.getRight().setPadre(v.getPadre());
		    			  v.getPadre().setRight(v.getRight());
		    		  }
		    		  v.setRotulo(null);
		    		  v.setPadre(null);
		    	  }else if (v.getLeft().getRotulo()!=null && v.getRight().getRotulo()==null){
		    		  if(v.getPadre().getLeft()==v){
		    			  v.getLeft().setPadre(v.getPadre());
		    			  v.getPadre().setLeft(v.getLeft());
		    		  }else{
		    			  v.getLeft().setPadre(v.getPadre());
		    			  v.getPadre().setRight(v.getLeft());
		    		  }
		    		  v.setRotulo(null);
		    		  v.setPadre(null);
		    	  }else{//Tiene dos hijos
		    		  NodoABB<Entry<K,V>> sucesor = sucesorInorden(v.getRight());
		    		  v.setRotulo(sucesor.getRotulo());
		    		  if(sucesor.getLeft()== null && sucesor.getRight()== null){
		    			  sucesor.setRotulo(null);
		    			  sucesor.getPadre().setLeft(null);
		    			  sucesor.setPadre(null);
		    		  }else{
		    			  if(sucesor.getPadre().getLeft() == sucesor){
		    				  sucesor.getPadre().setLeft(sucesor.getRight());
		    			  }else {
		    				  sucesor.getPadre().setRight(sucesor.getRight());		    				  
		    			  }
		    			  sucesor.getRight().setPadre(sucesor.getPadre());
		    			  sucesor.setRotulo(null);
		    			  sucesor.setPadre(null);
		    		  }
		    	  }
		      }
		      size--;
		      return eliminado;
	 }	else if (comp.compare(key,v.getRotulo().getKey())<0)// busco en el subárbol izquierdo.
				return removeAux(key,v.getLeft());
			else
				return removeAux(key,v.getRight());// busco en el subárbol derecho.	 
	}
	
	private NodoABB<Entry<K,V>> sucesorInorden(NodoABB<Entry<K,V>> n){
		if(n.getLeft().getRotulo()==null)//Falta el caso en que tenga dos hijos v y n no tenga hijos. 
			return n;
		else
			return sucesorInorden(n.getLeft());
	}
	

}	

