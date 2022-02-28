package TDAPila;

/**
 * Class PilaEnlazada.
 * @author VirginiaAraceli
 * @param <E> Parámetro formal de tipo que representa el tipo de los elementos de la PilaEnlazada.
 */
public class PilaEnlazada <E> implements Stack<E> {
		//Estructura
		protected Nodo<E> head;
		protected int tamaño;
		
		/**
		 * Crea una pila vacía.
		 */
		public PilaEnlazada(){
			head = null;
			tamaño = 0;
		}
		
		public int size(){return tamaño;}

		public boolean isEmpty(){return tamaño == 0;}

		public void push(E item){
			Nodo <E> nuevo = new Nodo<E>(item, head);
			head = nuevo;
			tamaño++;
		}
		
		public E pop() throws EmptyStackException{
			if(isEmpty()) throw new EmptyStackException("Pila vacía");
			E elem = head.getElemento();
			head = head.getSiguiente();		
			tamaño--;
			return elem;
		}
		
		public E top() throws EmptyStackException{
			if(isEmpty()) throw new EmptyStackException("Pila vacía");
			return head.getElemento();
		}
}
