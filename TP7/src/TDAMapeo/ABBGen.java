package TDAMapeo;

import java.util.Comparator;
import TDALista.*;

public class ABBGen<E extends Comparable<E>>  {

	protected NodoABB<E> raiz;
	protected Comparator<E> comp;
	protected int tamaño; //para poder usarlo en mapero
	
	public ABBGen(Comparator<E> c){
		raiz= new NodoABB<E>(null,null,null,null);
		tamaño=0;
		comp=c;
	}

	public ABBGen(){
		raiz= new NodoABB<E>(null,null,null,null);
		tamaño=0;
		comp= new DefaultComparator<E>();
	}	

	public E min(){
		//TP 7, ej 11.e
		NodoABB<E> n = raiz;
		while(n.getLeft().getRotulo() != null){
			n = n.getLeft();
		}
		return n.getRotulo();
	}
	
	public int size(){return tamaño;}
	
	public boolean isEmpty(){return tamaño ==0;}
	
	public boolean pertenece(E k){
		return buscarAux(k,raiz).getRotulo() != null;
	}
	
	public E buscar(E k){
		return buscarAux(k,raiz).getRotulo();
	}
	
	private NodoABB<E> buscarAux(E k, NodoABB<E> n){
		if(n.getRotulo() == null) return n;
		else{
			int c = k.compareTo(n.getRotulo());
			if(c==0) return n;
			else{
				if(c>0) return buscarAux(k,n.getRight());
				else return buscarAux(k,n.getLeft());
			}
		}
	}
	
	public void insertar(E k){
		NodoABB<E> nodo = buscarAux(k,raiz);
		//retorna un nodo si k existe y si no el nulo en la posicion a insertar k.
		if(nodo.getRotulo() == null){
			nodo.setRotulo(k);
			nodo.setRight(new NodoABB<E>(nodo.getRotulo(),null, null, null));
			nodo.setLeft(new NodoABB<E>(nodo.getRotulo(),null, null, null));
			tamaño++;
		}
	}
	
	public String toString(){
		//Retorna las claves insertadas ordenadas en forma ascendente.
		return inorder(raiz);
	}
	
	private String inorder(NodoABB<E> n){
		if(n.getRotulo() != null){
			return "("+inorder(n.getLeft())+n.getRotulo()+inorder(n.getRight())+")";
		}
		else return "";
	}
	
	public Iterable<E> elementos(){
		PositionList<E> l = new ListaDoblementeEnlazada<E>();
		if(tamaño>0)inorder2(raiz,l);
		return l;
	}
	
	private void inorder2(NodoABB<E> n, PositionList<E> l){
		if(n.getLeft().getRotulo() != null){
			inorder2(n.getLeft(),l);
			l.addLast(n.getRotulo());
		}
		else l.addLast(n.getRotulo());
		if(n.getRight().getRotulo() != null){
			inorder2(n.getRight(),l);
		}
	}
	
	

	public E eliminar(E k){
		NodoABB<E> n = buscarAux(k,raiz);
		if(n.getRotulo() != null){
			E eliminado = n.getRotulo();
			eliminarAux(n);
			tamaño--;
			return eliminado;
		}
		return null;//k no esta en el arbol
	}
	
	private void eliminarAux(NodoABB<E> n){
		if(esHoja(n))hacerDummy(n);
		else{
			if(soloHijosIzq(n)){
				if(n == raiz){
					raiz = n.getLeft();
					raiz.setPadre(null);
				}
				else{
					if(n.getPadre().getLeft() == n){
						n.getPadre().setLeft(n.getLeft());
					}
					else{
						n.getPadre().setRight(n.getLeft());
					}
					n.getLeft().setPadre(n.getPadre());
				}
				hacerDummy(n);
			}else{ 
				if(soloHijosDer(n)){
					if(n == raiz){
						raiz = n.getRight();
						raiz.setPadre(null);
					}
					else{
						if(n.getPadre().getRight() == n){
							n.getPadre().setRight(n.getRight());
						}
						else n.getPadre().setLeft(n.getRight());
						n.getRight().setPadre(n.getPadre());
					}
					hacerDummy(n);
				}
				else{ //n tiene 2 hijos: seteo como rotulo de n al rotulo del succesor inorder de n
					NodoABB<E> succ = succesorInorder(n.getRight());
					n.setRotulo(succ.getRotulo());
					if(esHoja(succ)) hacerDummy(succ);
					else{
						if(succ.getPadre().getLeft() == succ){
							succ.getPadre().setLeft(succ.getRight());
						}
						else{
							succ.getPadre().setRight(succ.getRight());
						}
						succ.getRight().setPadre(succ.getPadre());
						hacerDummy(succ);
					}
				}
			}
		}
	}
	
	private void hacerDummy(NodoABB<E> n){
		n.setRotulo(null);
		n.setRight(null);
		n.setLeft(null);
	}
	
	private boolean esHoja(NodoABB<E> n){
		return n.getLeft().getRotulo() == null && n.getRight().getRotulo() == null;
	}
	
	private boolean soloHijosIzq(NodoABB<E> n){
		return n.getLeft().getRotulo() != null && n.getRight().getRotulo() == null;
	}
	
	private boolean soloHijosDer(NodoABB<E> n){
		return n.getLeft().getRotulo() == null && n.getRight().getRotulo() != null;
	}
	
	private NodoABB<E> succesorInorder(NodoABB<E> n){
		if(n.getLeft().getRotulo() == null){
			return n;
		}
		else return succesorInorder(n.getLeft());
	}
}
