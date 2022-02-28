
public class ColaConPila <T> implements Queue <T> {
	// Estructura
	protected Stack<T> pila;
	protected int tamaño;
	
	//Constructores
	public ColaConPila(){	
		pila = new PilaArreglo<T>();
		tamaño = 0;
	}
	public int size(){return tamaño;}
	public boolean isEmpty(){return (tamaño == 0);}
	
	public void enqueue (T item){
		Stack<T> pAux = new PilaArreglo<T>();
		try{
			while (!pila.isEmpty())
				pAux.push(pila.pop());
			pAux.push(item);
			while (!pAux.isEmpty())
				pila.push(pAux.pop());
			tamaño++;
		}catch(EmptyStackException e){
			System.out.println("Pila vacía");
		}
	}
	
	public T dequeue() throws EmptyQueueException{
		if(pila.isEmpty()) throw new EmptyQueueException("Cola vacía");
		try{
			tamaño--;
			return pila.pop();
		}catch(EmptyStackException e){ 
			System.out.println("Pila vacía");
			return null;
		}
	}
	
	public T front() throws EmptyQueueException{
		if(pila.isEmpty()) throw new EmptyQueueException("Cola vacía");
		try{
			return pila.top();
		}catch(EmptyStackException e){ 
			System.out.println("Pila vacía");
			return null;
		}
	}
	
}
