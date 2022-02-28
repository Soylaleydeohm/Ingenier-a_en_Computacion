package TDALista;

public class NodoDoble<E> implements Position<E> {

	protected NodoDoble<E> anterior;
	protected NodoDoble<E> siguiente;
	protected E elemento;
	
	/**
	 * Inicializa los atributos de instancia.
	 */
	public NodoDoble(NodoDoble<E> ant, E elem, NodoDoble<E> sig){
		anterior=ant;
		siguiente=sig;
		elemento=elem;
	}
	public E element(){
		return elemento;
	}
	/**
	  * Retorna la referencia al nodo siguiente.
	  * @return referencia al nodo siguiente.
	  */
	public NodoDoble<E> getSiguiente(){
		  return siguiente;
	 }
	/**
	  * Retorna la referencia al nodo anterior.
	  * @return referencia al nodo anterior
	  */
	public NodoDoble<E> getAnterior(){
		  return anterior;
	 }
	/**
      * Le asigna el objeto elem al atributo de instancia elemento.
      * @param elem objeto que se le asigna al atributo de instancia elemento.
      */
	public void setElemento(E elem){
		  elemento=elem;
	}
	/**
      * Asigna la referencia a nodo al atributo de instancia siguiente.
      * @param nodo objeto al que referenciará el atributo de instancia siguiente.
      */
	 public void setSiguiente(NodoDoble<E> nodo){
		siguiente=nodo;
	}
	 /**
      * Asigna la referencia a nodo al atributo de instancia anterior.
      * @param nodo objeto al que referenciará el atributo de instancia anterior.
      */
	 public void setAnterior(NodoDoble<E> nodo){
		anterior=nodo;
	}
}
