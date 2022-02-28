package TDALista;

public class Nodo<E> implements Position<E>{
  private E elemento;
  private Nodo<E> siguiente;
  /**
   * Inicializa los atributos de instancia con referencias nulas.
   */
  public Nodo(){
	  elemento=null;
	  siguiente=null;
  }
  /**
   * Inicializa los atributos de instancia con elem y referencia nula en el atributo siguiente.
   * @param elem objeto con el que se inicializa el atributo elemento.
   */
  public Nodo(E elem){
	  elemento=elem;
	  siguiente=null;
  }
  /**
   * Inicializa los atributos de instancia con elem y la referencia a nodo.
   * @param elem objeto con el que se inicializa el atributo elemento.
   * @param nodo objeto al cual se referencia con el atributo siguiente.
   */
  public Nodo(E elem, Nodo<E> nodo){
	  elemento=elem;
	  siguiente=nodo;
  }
  
  public E element(){
	  return elemento;
  }
  /**
   * Retorna la referencia al nodo siguiente.
   * @return referencia al nodo siguiente.
   */
  public Nodo<E> getSiguiente(){
	  return siguiente;
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
  public void setSiguiente(Nodo<E> nodo){
	  siguiente=nodo;
  }
}
