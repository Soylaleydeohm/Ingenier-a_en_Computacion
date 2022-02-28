package TDAMapeo;

public class NodoABBGen<E> {

	protected NodoABBGen<E> padre;
	protected E elemento;
	protected NodoABBGen<E> izquierdo;
	protected NodoABBGen<E> derecho;

	public NodoABBGen(NodoABBGen<E> p, E e, NodoABBGen<E> i, NodoABBGen<E> d){
		padre=p;
		elemento=e;
		izquierdo=i;
		derecho=d;
	}
	
	public void setPadre(NodoABBGen<E> nodo){
		padre=nodo;
	}
	public void setElemento(E e){
		elemento=e;
	}
	public void setIzquierdo(NodoABBGen<E> nodo){
		izquierdo=nodo;
	}
	public void setDerecho(NodoABBGen<E> nodo){
		derecho=nodo;
	}
	
	public NodoABBGen<E> getPadre(){
		return padre;
	}
	public E getElemento(){
		return elemento;
	}
	public NodoABBGen<E> getIzquierdo(){
		return izquierdo;
	}
	public NodoABBGen<E> getDerecho(){
		return derecho;
	}
}
