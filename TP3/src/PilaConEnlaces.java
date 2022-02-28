
public class PilaConEnlaces<T> implements Stack<T> {
	//Estructura
	protected Nodo<T> head;
	protected int tama�o;
	
	//Constructor
	public PilaConEnlaces(){
		head = null;
		tama�o = 0;
	}
	
	//M�todos
	public int size(){return tama�o;}
	public boolean isEmpty(){return tama�o == 0;}
	public void push(T item){
		Nodo <T> nuevo = new Nodo<T>(item, head);
		head = nuevo;
		tama�o++;
	}
	public T pop() throws EmptyStackException{
		if(isEmpty()) throw new EmptyStackException("Pila vac�a");
		T elem = head.getElemento();
		head = head.getSiguiente();		
		tama�o--;
		return elem;
	}
	
	public T top() throws EmptyStackException{
		if(isEmpty()) throw new EmptyStackException("Pila vac�a");
		return head.getElemento();
	}

}
