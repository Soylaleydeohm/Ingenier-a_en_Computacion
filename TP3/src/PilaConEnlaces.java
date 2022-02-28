
public class PilaConEnlaces<T> implements Stack<T> {
	//Estructura
	protected Nodo<T> head;
	protected int tamaño;
	
	//Constructor
	public PilaConEnlaces(){
		head = null;
		tamaño = 0;
	}
	
	//Métodos
	public int size(){return tamaño;}
	public boolean isEmpty(){return tamaño == 0;}
	public void push(T item){
		Nodo <T> nuevo = new Nodo<T>(item, head);
		head = nuevo;
		tamaño++;
	}
	public T pop() throws EmptyStackException{
		if(isEmpty()) throw new EmptyStackException("Pila vacía");
		T elem = head.getElemento();
		head = head.getSiguiente();		
		tamaño--;
		return elem;
	}
	
	public T top() throws EmptyStackException{
		if(isEmpty()) throw new EmptyStackException("Pila vacía");
		return head.getElemento();
	}

}
