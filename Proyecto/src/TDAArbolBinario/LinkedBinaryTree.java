package TDAArbolBinario;
import java.util.Iterator;
import TDALista.*;

/**
 * class LinkedBinaryTree
 * @author VirginiaAraceli
 * @param <E> Parámetro formal de tipo que representa el tipo de los elementos de LinkedBinaryTree.
 */
public class LinkedBinaryTree<E> implements BinaryTree<E>{
	protected BTPosition<E> root;
	protected int size;
	
	/**
	 * Crea un árbol binario vacío.
	 */
	public LinkedBinaryTree(){
		root = null;
		size = 0;
	}
	
	/**
	 * Crea un árbol binario con una raíz con rótulo r como único elemento.
	 * @param r rótulo de la raiz.
	 */

	public LinkedBinaryTree(E r){
		root = createNodo(r, null, null, null);
		size = 1;
	}
	
	public int size() {return size;}

	public boolean isEmpty() {return size == 0;}

	public Iterator<E> iterator() {
		PositionList<E> list = new ListaDoblementeEnlazada<E>();
		if(!isEmpty()) preorden(list, root);
		return list.iterator(); //Iterador de lista
	}

	/**
	 * Recorre al árbol en preorden y agregando en una lista los elementos en ese orden.
	 * @param l lista de los elementos del arbol en orden "preorden".
	 * @param v Posición de un nodo.
	 */
	
	private void preorden(PositionList<E> l, Position<E> v){
		l.addLast(v.element());
		try {
			if(hasLeft(v)) preorden(l, left(v));
			if(hasRight(v)) preorden(l, right(v));
		} catch (InvalidPositionException e) {e.printStackTrace();
		} catch (BoundaryViolationException e) {e.printStackTrace();
		}		
	}

	public Iterable<Position<E>> positions() {
		PositionList<Position<E>> list = new ListaDoblementeEnlazada<Position<E>>();
		if(!isEmpty()) preordenPos(list, root);
		return list; 
	}

	/**
	 * Recorre al árbol en preorden y agregando en una lista la posición de los elementos en ese orden.
	 * @param l lista de la posición de los elementos del arbol en orden "preorden".
	 * @param v Posición de un nodo.
	 */
	
	private void preordenPos(PositionList<Position<E>> l, Position<E> v){		
		l.addLast(v);
		try {
			if(hasLeft(v)) preordenPos(l, left(v));
			if(hasRight(v)) preordenPos(l, right(v));
		} catch (InvalidPositionException e) {e.printStackTrace();
		} catch (BoundaryViolationException e) {e.printStackTrace();
		}		
	}

	public E replace(Position<E> v, E e) throws InvalidPositionException {
		BTPosition<E> w = checkPosition(v);
		E temp = v.element();
		w.setElemento(e);
		return temp;
	}
	
	/**
	 * Verifica que la posición ingresada por parámetro sea válida.
	 * @param v Posición de un nodo.
	 * @return La posición v luego de realizarle un casting.
	 * @throws InvalidPositionException si la posición pasada por parámetro es inválida.
	 */
	
	private BTPosition<E> checkPosition(Position<E> v)throws InvalidPositionException {
		try{
			if(v == null) throw new InvalidPositionException("Posición inválida");
			return (BTPosition<E>) v;
		}catch(ClassCastException e){
			throw new InvalidPositionException("El argumento no es una posición");
		}
	}

	public Position<E> root() throws EmptyTreeException {
		if(isEmpty()) throw new EmptyTreeException("Árbol vacío");
		return root;
	}
	
	public Position<E> parent(Position<E> v) throws InvalidPositionException, BoundaryViolationException {
		BTPosition<E> w = checkPosition(v);
		if(w == root) throw new BoundaryViolationException("La raiz no tiene padre");
		return w.getPadre();
	}

	public Iterable<Position<E>> children(Position<E> v) throws InvalidPositionException {
		PositionList<Position<E>> children = new ListaDoblementeEnlazada<Position<E>>();
		try{
			if(hasLeft(v)) children.addLast(left(v));
			if(hasRight(v)) children.addLast(right(v));
		}catch(BoundaryViolationException e){e.printStackTrace();}
		return children;
	}

	public boolean isInternal(Position<E> v) throws InvalidPositionException {
		checkPosition(v);
		return (hasLeft(v) || hasRight(v));
	}

	public boolean isExternal(Position<E> v) throws InvalidPositionException {
		checkPosition(v);
		return !(hasLeft(v) && hasRight(v));
	}

	public boolean isRoot(Position<E> v) throws InvalidPositionException {
		checkPosition(v);
		return (v == root);
	}

	public Position<E> left(Position<E> v) throws InvalidPositionException, BoundaryViolationException {
		BTPosition<E> w = checkPosition(v);
		Position<E> leftPos = w.getLeft();
		if (leftPos == null) throw new BoundaryViolationException("No hay hijo izquierdo");
		return leftPos;
	}

	public Position<E> right(Position<E> v) throws InvalidPositionException, BoundaryViolationException {
		BTPosition<E> w = checkPosition(v);
		Position<E> rightPos = w.getRight();
		if (rightPos == null) throw new BoundaryViolationException("No hay hijo derecho");
		return rightPos;
	}

	public boolean hasLeft(Position<E> v) throws InvalidPositionException {
		BTPosition<E> w = checkPosition(v);
		return (w.getLeft() != null);
	}

	public boolean hasRight(Position<E> v) throws InvalidPositionException {
		BTPosition<E> w = checkPosition(v);
		return (w.getRight() != null);
	}

	public Position<E> createRoot(E r) throws InvalidOperationException {
		if(!isEmpty()) throw new InvalidOperationException("No se puede crear la raíz de un árbol no vacío");
		size = 1;
		root = createNodo(r, null, null, null);
		return root;
	}
	
	/**
	 * Crea un nodo de rótulo r con hijos left y right y con padre parent.
	 * @param r Rótulo del nuevo nodo.
	 * @param parent Posición del nodo padre.
	 * @param left Posición del nodo hijo izquierdo.
	 * @param right Posición del nodo hijo derecho.
	 * @return La posición del nuevo nodo creado.
	 */
	
	private BTPosition<E> createNodo(E r, BTPosition<E> parent, BTPosition<E> left, BTPosition<E> right){
		return new BTNodo<E>(r, parent, left, right);
	}

	public Position<E> addLeft(Position<E> v, E r) throws InvalidOperationException, InvalidPositionException {
		BTPosition<E> w = checkPosition(v);
		if(hasLeft(w)) throw new InvalidOperationException("La posición tiene un hijo izquiero no nulo");
		size++;
		BTPosition<E> hijoIzquierdo = createNodo(r, w, null, null);
		w.setLeft(hijoIzquierdo);
		return hijoIzquierdo;
	}

	public Position<E> addRight(Position<E> v, E r) throws InvalidOperationException, InvalidPositionException {
		BTPosition<E> w = checkPosition(v);
		if(hasRight(w)) throw new InvalidOperationException("La posición tiene un hijo derecho no nulo");
		size++;
		BTPosition<E> hijoDerecho = createNodo(r, w, null, null);
		w.setRight(hijoDerecho);
		return hijoDerecho;
	}

	public E remove(Position<E> v) throws InvalidOperationException, InvalidPositionException {
		BTPosition<E> w = checkPosition(v);
		BTPosition<E> leftPos = w.getLeft();
		BTPosition<E> rightPos = w.getRight();
		if(leftPos != null && rightPos != null) throw new InvalidOperationException("No se puede eliminar un nodo con dos hijos");
		BTPosition<E> hijo;	// Hijo único
		if(leftPos != null) hijo = leftPos;
		else if(rightPos != null) hijo = rightPos;
		else hijo = null;	// es una hoja		
		if(hijo == root){	
			if(hijo != null)
				hijo.setPadre(null);
			root = hijo;
		} else {
			BTPosition<E> padre = w.getPadre();
			if(w == padre.getLeft()) padre.setLeft(hijo);
			else if(w == padre.getRight()) padre.setRight(hijo);			
			w.setPadre(null);
			if(hijo != null){
				hijo.setPadre(padre);
				if(hijo == leftPos) w.setLeft(null);
				else if(hijo == rightPos) w.setRight(null);
			}
		}
		E aux = w.element();
		w.setElemento(null);
		size--;				
		return 	aux;
	}

	public void Attach(Position<E> v, BinaryTree<E> T1, BinaryTree<E> T2) throws InvalidPositionException {
		BTPosition<E> w = checkPosition(v);
		if(isInternal(w)) throw new InvalidPositionException("No se puede agregar dos subárboles a un nodo interno");
		try{
			if(!T1.isEmpty()){
				BTPosition<E> r1 = checkPosition(T1.root());
				w.setLeft(r1);
				r1.setPadre(w);
			}
			if(!T2.isEmpty()){
				BTPosition<E> r2 = checkPosition(T2.root());
				w.setRight(r2);
				r2.setPadre(w);
			}
			//Copiar T1 y T2 para agregar su raíz como hijos de v, etc.
			size = T1.size() + T2.size() + 1;
		}catch(EmptyTreeException e){System.out.println("Al menos uno de los subárboles es vacío");}
	}		
}
