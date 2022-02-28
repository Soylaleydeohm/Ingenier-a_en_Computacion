package TDAArbol;
import TDALista.*;
import java.lang.Iterable;
import java.util.Iterator;

public class Arbol<E> implements Tree<E>{
	protected TNodo<E> raiz;
	protected int size;
	
	public Arbol(){
		raiz = null;
		size = 0;
	}
	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return (size == 0);
	}

	public Iterator<E> iterator() {
		PositionList<E> list = new ListaDoblementeEnlazada<E>();
		if(!isEmpty()) preordenel(list, raiz);
		return list.iterator(); //Iterador de lista
	}

	private void preordenel(PositionList<E> l, TNodo<E> v){
		l.addLast(v.element());
		Iterable<TNodo<E>> hijos = v.getHijos();
		Iterator<TNodo<E>> itHijos = hijos.iterator();
		while(itHijos.hasNext()){
			preordenel(l, itHijos.next());
		}
	}
	
	public Iterable <TPosition<E>> positions(){
		PositionList<TPosition<E>> list = new ListaDoblementeEnlazada<TPosition<E>>();
		if(!isEmpty()) preorden(list, raiz);
		return list;
	}
	
	private void preorden(PositionList<TPosition<E>> l, TNodo<E> v){
		l.addLast(v);
		Iterable<TNodo<E>> hijos = v.getHijos();
		Iterator<TNodo<E>> itHijos = hijos.iterator();
		while(itHijos.hasNext()){
			preorden(l, itHijos.next());
		}
	}
	
	public E replace(TPosition<E> v, E e) throws InvalidPositionException {
		if(isEmpty()) throw new InvalidPositionException("Lista vacía");
		TNodo<E> n = checkPosition(v);
		E aux = n.element();
		n.setElemento(e);
		return aux;
	}
	
	private TNodo<E> checkPosition(TPosition<E> v) throws InvalidPositionException{
		try{
			if(v == null) throw new InvalidPositionException("Posición nula");
			return (TNodo<E>) v;
		}catch (ClassCastException e){
			throw new InvalidPositionException("El argumento no es una posición");
		}
	}

	public TPosition<E> root() throws EmptyTreeException {
		if(isEmpty()) throw new EmptyTreeException("Árbol vacío");
		return raiz;
	}

	public TPosition<E> parent(TPosition<E> v) throws InvalidPositionException, BoundaryViolationException {
		TNodo<E> n = checkPosition(v);
		if(n == raiz) throw new BoundaryViolationException("La raiz no tiene padre");
		return n.getPadre();
	}

	public Iterable<TPosition<E>> children (TPosition<E> v) throws InvalidPositionException{
		TNodo<E> n = checkPosition(v);
		PositionList<TPosition<E>> l = new ListaDoblementeEnlazada<TPosition<E>>();
		Iterable<TNodo<E>> hijos = n.getHijos();
		Iterator<TNodo<E>> itHijos = hijos.iterator();
		while(itHijos.hasNext()){
			l.addLast(itHijos.next());
		}
		return l;
	}
	
	public boolean isInternal(TPosition<E> v) throws InvalidPositionException {
		TNodo<E> n = checkPosition(v);
		return !n.getHijos().isEmpty();
	}

	public boolean isExternal(TPosition<E> v) throws InvalidPositionException {
		TNodo<E> n = checkPosition(v);
		return n.getHijos().isEmpty();
	}

	public boolean isRoot(TPosition<E> v) throws InvalidPositionException {
		TNodo<E> n = checkPosition(v);
		return n == raiz;
	}
	
	public void  crearRaiz (E e) throws InvalidOperationException{
		if(!isEmpty()) throw new InvalidOperationException("No se puede crear la raiz de un árbol que no es vacío");
		raiz = new TNodo<E>(e);
		size++;
	}
	
	public TPosition<E> AgregarNodoComoPrimerHijo(TPosition<E> p, E e) throws InvalidPositionException{
		TNodo<E> n = checkPosition(p);
		TNodo<E> hijo = new TNodo<E> (e, n);
		n.getHijos().addFirst(hijo);
		size++;
		return hijo;
	}
	
	public TPosition<E> AgregarNodoComoUltimoHijo(TPosition<E> p, E e) throws InvalidPositionException{
		TNodo<E> n = checkPosition(p);
		TNodo<E> hijo = new TNodo<E> (e, n);
		n.getHijos().addLast(hijo);
		size++;
		return hijo;
	}
	
	public TPosition<E> AgregarNodoDelante(TPosition<E> padre, TPosition<E> hermanoDerecho, E rotulo) throws InvalidPositionException{
		TNodo<E> p = checkPosition(padre);
		TNodo<E> hD = checkPosition(hermanoDerecho);
		TNodo<E> hijo = new TNodo<E>(rotulo, p);
		//Primero me fijo que hD es hijo de p
		PositionList<TNodo<E>> hijosPadre = p.getHijos();
		boolean encontre = false;
		try{
			Position<TNodo<E>> posHijosPadre = hijosPadre.first();
			while (posHijosPadre != null && !encontre){
				if(hD != posHijosPadre.element())
					posHijosPadre = posHijosPadre != hijosPadre.last() ? hijosPadre.next(posHijosPadre) : null;
				else encontre = true;
			}
			if(!encontre) throw new InvalidPositionException("Hermano derecho no es hijo de padre");
			hijosPadre.addBefore(posHijosPadre, hijo);
			size++;
			return hijo;
		}catch(InvalidPositionException e){
			System.out.println("Posición Inválida");
			return null;
		}catch(EmptyListException e){
			System.out.println("Lista vacía");	
			return null;
		}catch(BoundaryViolationException e){
			System.out.println("Posición fuera de rango");	
			return null;
		}
	}
	
	public TPosition<E> AgregarNodoDetras(TPosition<E> padre, TPosition<E> hermanoIzquierdo, E rotulo) throws InvalidPositionException{
		TNodo<E> p = checkPosition(padre);
		TNodo<E> hI = checkPosition(hermanoIzquierdo);
		TNodo<E> hijo = new TNodo<E>(rotulo, p);
		//Primero me fijo que hD es hijo de p
		PositionList<TNodo<E>> hijosPadre = p.getHijos();
		boolean encontre = false;
		try{
			Position<TNodo<E>> posHijosPadre = hijosPadre.first();
			while (posHijosPadre != null && !encontre){
				if(hI != posHijosPadre.element())
					posHijosPadre = posHijosPadre != hijosPadre.last() ? hijosPadre.next(posHijosPadre) : null;
				else encontre = true;
			}
			if(!encontre) throw new InvalidPositionException("Hermano derecho no es hijo de padre");
			hijosPadre.addAfter(posHijosPadre, hijo);
			size++;
			return hijo;
		}catch(InvalidPositionException e){
			System.out.println("Posición Inválida");
			return null;
		}catch(EmptyListException e){
			System.out.println("Lista vacía");	
			return null;
		}catch(BoundaryViolationException e){
			System.out.println("Posición fuera de rango");	
			return null;
		}
	}
	
	public void EliminarNodoExterno(TPosition<E> n) throws InvalidPositionException{
		if(isEmpty()) throw new InvalidPositionException("Árbol vacío");
		TNodo<E> nodo = checkPosition(n);
		if(isInternal(nodo)) throw new InvalidPositionException("El nodo a eliminar no es externo");
		if(isRoot(n)) {
			nodo = null;
			size--;
		}else{
			TNodo<E> padre = nodo.getPadre();
			//Tengo que encontrarlo en la lista de hijos del padre
			boolean encontre = false;
			try{
				Position<TNodo<E>> posHijosPadre = padre.getHijos().first();
				while (posHijosPadre != null && !encontre){
					if(nodo != posHijosPadre.element())
						posHijosPadre = posHijosPadre != padre.getHijos().last() ? padre.getHijos().next(posHijosPadre) : null;
					else encontre = true;
				}
				if(!encontre) throw new InvalidPositionException("Árbol corrupto");
				padre.getHijos().remove(posHijosPadre);
				size--;
				posHijosPadre.element().setPadre(null);
			}catch(InvalidPositionException e){
				System.out.println("Posición Inválida");
			}catch(EmptyListException e){
				System.out.println("Lista vacía");	
			}catch(BoundaryViolationException e){
				System.out.println("Posición fuera de rango");	
			}
		}
	}
	
	public void EliminarNodoInterno(TPosition<E> n) throws InvalidPositionException{
		if(isEmpty()) throw new InvalidPositionException("Árbol vacío");
		TNodo<E> nodo = checkPosition(n);
		if(isExternal(nodo)) throw new InvalidPositionException("El nodo a eliminar no es interno");
		if(isRoot(n)) {
			if(nodo.getHijos().size() == 1){
				try{
					TNodo<E> aux = nodo;
					nodo.getHijos().first().element().setPadre(null);
					nodo = nodo.getHijos().first().element();
					aux.getHijos().set(aux.getHijos().first(), null);
					size--;
				}catch(EmptyListException e){
					System.out.println("Lista vacía");
				}
			} else throw new InvalidPositionException("No se puede eliminar una raiz con más de un hijo");
		}else{
			TNodo<E> padre = nodo.getPadre();
			//Tengo que encontrarlo en la lista de hijos del padre
			boolean encontre = false;
			try{
				PositionList<TNodo<E>> hermanos = padre.getHijos();
				PositionList<TNodo<E>> hijos = nodo.getHijos();
				Position<TNodo<E>> posHijosPadre = padre.getHijos().first();
				while (posHijosPadre != null && !encontre){
					if(nodo != posHijosPadre.element())
						posHijosPadre = posHijosPadre != hermanos.last() ? hermanos.next(posHijosPadre) : null;
					else encontre = true;
				}
				if(!encontre) throw new InvalidPositionException("Árbol corrupto");
				while(!hijos.isEmpty()){
					Position<TNodo<E>> hijo = hijos.first();
					hijo.element().setPadre(padre);
					hermanos.addBefore(posHijosPadre, hijo.element());
					hijos.remove(hijo);
				}
				hermanos.remove(posHijosPadre);
				size--;
				posHijosPadre.element().setPadre(null);
			}catch(InvalidPositionException e){
				System.out.println("Posición Inválida");
			}catch(EmptyListException e){
				System.out.println("Lista vacía");	
			}catch(BoundaryViolationException e){
				System.out.println("Posición fuera de rango");	
			}
		}
	}
	
	public void EliminarNodo(TPosition<E> n) throws InvalidPositionException{
		if(isEmpty()) throw new InvalidPositionException("Árbol vacío");
		TNodo<E> nodo = checkPosition(n);
		if(isRoot(n)) {
			if(nodo.getHijos().size() == 0){
				nodo = null;
				size = 0;
			}else if (nodo.getHijos().size() == 1){
				try{
					TNodo<E> aux = nodo;
					nodo.getHijos().first().element().setPadre(null);
					nodo = nodo.getHijos().first().element();
					aux.getHijos().set(aux.getHijos().first(), null);
					size--;
				}catch(EmptyListException e){
					System.out.println("Lista vacía");
				}
			} else throw new InvalidPositionException("No se puede eliminar una raiz con más de un hijo");
		}else{
			TNodo<E> padre = nodo.getPadre();
			//Tengo que encontrarlo en la lista de hijos del padre
			boolean encontre = false;
			try{
				PositionList<TNodo<E>> hermanos = padre.getHijos();
				PositionList<TNodo<E>> hijos = nodo.getHijos();
				Position<TNodo<E>> posHijosPadre = padre.getHijos().first();
				while (posHijosPadre != null && !encontre){
					if(nodo != posHijosPadre.element())
						posHijosPadre = posHijosPadre != hermanos.last() ? hermanos.next(posHijosPadre) : null;
					else encontre = true;
				}
				if(!encontre) throw new InvalidPositionException("Árbol corrupto");
				while(!hijos.isEmpty()){
					Position<TNodo<E>> hijo = hijos.first();
					hijo.element().setPadre(padre);
					hermanos.addBefore(posHijosPadre, hijo.element());
					hijos.remove(hijo);
				}
				hermanos.remove(posHijosPadre);
				size--;
				posHijosPadre.element().setPadre(null);
			}catch(InvalidPositionException e){
				System.out.println("Posición Inválida");
			}catch(EmptyListException e){
				System.out.println("Lista vacía");	
			}catch(BoundaryViolationException e){
				System.out.println("Posición fuera de rango");	
			}
		}
	}
}
