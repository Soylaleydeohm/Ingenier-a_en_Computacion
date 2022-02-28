package TDAArbol;
import TDALista.*;

public class TNodo<E> implements TPosition<E> {
	private E elemento;
	private TNodo<E> padre;
	private PositionList<TNodo<E>> hijos;

	public TNodo(E elem, TNodo<E> p){
		elemento = elem;
		padre = p;
		hijos = new ListaDoblementeEnlazada<TNodo<E>>();
	}	
	public TNodo(E elem){this(elem, null);}// Nodo raiz
	
	public E element(){return elemento;}
	public void setElemento(E item){elemento = item;}
	public TNodo<E> getPadre(){return padre;}
	public void setPadre(TNodo<E> p){padre = p;}
	public PositionList<TNodo<E>> getHijos(){return hijos;}
}
