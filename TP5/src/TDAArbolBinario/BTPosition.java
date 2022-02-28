package TDAArbolBinario;
import TDALista.*;

public interface BTPosition<E> extends Position<E> {
	public E element();
	public void setElemento(E item);
	public BTPosition<E> getPadre();
	public void setPadre(BTPosition<E> p);
	public BTPosition<E> getRight();
	public void setRight(BTPosition<E> hD);
	public BTPosition<E> getLeft();
	public void setLeft(BTPosition<E> hI);
}
