package TDAArbolBinario;

public class BTNodo<E> implements BTPosition<E> {
	private E elemento;
	private BTPosition<E> padre;
	private BTPosition<E> hD;	//right
	private BTPosition<E> hI;	//left

	public BTNodo(E elem, BTPosition<E> parent, BTPosition<E> hijoD, BTPosition<E> hijoI){
		elemento = elem;
		padre = parent;
		hD = hijoD;
		hI = hijoI;
	}	
	
	public E element(){return elemento;}
	public void setElemento(E item){elemento = item;}
	public BTPosition<E> getPadre(){return padre;}
	public void setPadre(BTPosition<E> p){padre = p;}
	public BTPosition<E> getRight(){return hD;}
	public void setRight(BTPosition<E> hD){this.hD = hD;}
	public BTPosition<E> getLeft(){return hI;}
	public void setLeft(BTPosition<E> hI){this.hI = hI;}

}
