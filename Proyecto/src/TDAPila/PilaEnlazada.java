package TDAPila;

/**
 * Class PilaEnlazada.
 * @author VirginiaAraceli
 * @param <E> Par�metro formal de tipo que representa el tipo de los elementos de la PilaEnlazada.
 */
public class PilaEnlazada <E> implements Stack<E> {
		//Estructura
		protected Nodo<E> head;
		protected int tama�o;
		
		/**
		 * Crea una pila vac�a.
		 */
		public PilaEnlazada(){
			head = null;
			tama�o = 0;
		}
		
		public int size(){return tama�o;}

		public boolean isEmpty(){return tama�o == 0;}

		public void push(E item){
			Nodo <E> nuevo = new Nodo<E>(item, head);
			head = nuevo;
			tama�o++;
		}
		
		public E pop() throws EmptyStackException{
			if(isEmpty()) throw new EmptyStackException("Pila vac�a");
			E elem = head.getElemento();
			head = head.getSiguiente();		
			tama�o--;
			return elem;
		}
		
		public E top() throws EmptyStackException{
			if(isEmpty()) throw new EmptyStackException("Pila vac�a");
			return head.getElemento();
		}
}
