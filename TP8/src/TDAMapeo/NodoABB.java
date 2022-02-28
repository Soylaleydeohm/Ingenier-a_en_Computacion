package TDAMapeo;

public class NodoABB<E> {

	protected NodoABB<E> padre;
	protected E elemento;
	protected NodoABB<E> izquierdo;
	protected NodoABB<E> derecho;

	public NodoABB(NodoABB<E> p, E e, NodoABB<E> i, NodoABB<E> d){
		padre=p;
		elemento=e;
		izquierdo=i;
		derecho=d;
	}
	
	public void setPadre(NodoABB<E> nodo){
		padre=nodo;
	}
	public void setElemento(E e){
		elemento=e;
	}
	public void setIzquierdo(NodoABB<E> nodo){
		izquierdo=nodo;
	}
	public void setDerecho(NodoABB<E> nodo){
		derecho=nodo;
	}
	
	public NodoABB<E> getPadre(){
		return padre;
	}
	public E getElemento(){
		return elemento;
	}
	public NodoABB<E> getIzquierdo(){
		return izquierdo;
	}
	public NodoABB<E> getDerecho(){
		return derecho;
	}
}
