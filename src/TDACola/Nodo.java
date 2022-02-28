package TDACola;

public class Nodo<T> {
  private T elemento;
  private Nodo<T> siguiente;
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
  public Nodo(T elem){
	  elemento=elem;
	  siguiente=null;
  }
  /**
   * Inicializa los atributos de instancia con elem y la referencia a nodo.
   * @param elem objeto con el que se inicializa el atributo elemento.
   * @param nodo objeto al cual se referencia con el atributo siguiente.
   */
  public Nodo(T elem, Nodo<T> nodo){
	  elemento=elem;
	  siguiente=nodo;
  }
  /**
   * Retorna el elemento contenido en el nodo.
   * @return elemento del nodo.
   */
  public T getElemento(){
	  return elemento;
  }
  /**
   * Retorna la referencia al nodo siguiente.
   * @return referencia al nodo siguiente.
   */
  public Nodo<T> getSiguiente(){
	  return siguiente;
  }
  /**
   * Le asigna el objeto elem al atributo de instancia elemento.
   * @param elem objeto que se le asigna al atributo de instancia elemento.
   */
  public void setElemento(T elem){
	  elemento=elem;
  }
  /**
   * Asigna la referencia a nodo al atributo de instancia siguiente.
   * @param nodo objeto al que referenciará el atributo de instancia siguiente.
   */
  public void setSiguiente(Nodo<T> nodo){
	  siguiente=nodo;
  }
}
