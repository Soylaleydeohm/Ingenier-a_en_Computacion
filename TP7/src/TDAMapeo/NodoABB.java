package TDAMapeo;

/**
* Clase para el crear un nodo de un arbol binario de búsqueda.
* @param <E> Parametro generico.
*/
public class NodoABB <E> {
	
	private E rotulo;
	private NodoABB <E> left, right,padre;
	
	/**
	 * Crea un nodo nuevo.
	 * @param rotulo= Rótulo del nodo.
	 * @param left= Referencia al hijo izquierdo
	 * @param rigt= Referencia al hijo derecho.
	 */
	public NodoABB(E rotulo, NodoABB<E> left, NodoABB<E> right,NodoABB<E> padre) 
	   {
		this.rotulo = rotulo;
		this.left = left;
		this.right = right;
		this.padre = padre;
	    }
	
	/**
	 * Crea un nodo nuevo con los nodos hijos nulos.
	 * @param rotulo= Rótulo del nodo.
	 */
	public NodoABB(E rotulo) 
	   {
		this.rotulo = rotulo;
		this.left = null; 
		this.right = null;
		this.padre = null;
	    }
	
	/**
	 * Retorna el nodo que es hijo izquierdo del nodo
	 * @return hijo izquierdo
	 */
	public NodoABB <E> getLeft() {
		return left;
		}
	
	/**
	 * Permite establecer el hijo izquierdo del nodo.
	 * @param: left Nodo hijo izquierdo  que se utiliza para  establecer.
	 */
	public void setLeft(NodoABB<E> left) {
		this.left = left;
		}
	
	/**
	 * Retorna el nodo que es hijo derecho del nodo
	 * @return hijo derecho
	 */
	public NodoABB <E> getRight() {
		return right;
		}
	
	/**
	 * Permite establecer el hijo derecho del nodo.
	 * @param right: Nodo hijo derecho que se utiliza para establecer
	 */
	public void setRight(NodoABB<E> right) {
		this.right = right;
		}
	
	/**
	 * Permite obtener el rótulo del nodo.
	 * @return Rótulo del nodo.
	 */
	public E getRotulo() {
		return rotulo;
		}
	
	/**
	 * Permite establecer el rótulo del nodo
	 * @param rotulo del nodo.
	 */
	public void setRotulo(E rotulo) {
		this.rotulo = rotulo;
		}
			
	/**
	 * Retorna el nodo que es padre del nodo
	 * @return padre
	 */
	public NodoABB <E> getPadre() {
		return padre;
		}
	
	/**
	 * Permite establecer el padre del nodo.
	 * @param: left Nodo padre  que se utiliza para  establecer.
	 */
	public void setPadre(NodoABB<E> padre) {
		this.padre = padre;
		}
	
	}



