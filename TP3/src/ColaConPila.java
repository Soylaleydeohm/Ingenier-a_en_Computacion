
public class ColaConPila <T> implements Queue <T> {
	// Estructura
	protected Stack<T> pila;
	protected int tama�o;
	
	//Constructores
	public ColaConPila(){	
		pila = new PilaArreglo<T>();
		tama�o = 0;
	}
	public int size(){return tama�o;}
	public boolean isEmpty(){return (tama�o == 0);}
	
	public void enqueue (T item){
		Stack<T> pAux = new PilaArreglo<T>();
		try{
			while (!pila.isEmpty())
				pAux.push(pila.pop());
			pAux.push(item);
			while (!pAux.isEmpty())
				pila.push(pAux.pop());
			tama�o++;
		}catch(EmptyStackException e){
			System.out.println("Pila vac�a");
		}
	}
	
	public T dequeue() throws EmptyQueueException{
		if(pila.isEmpty()) throw new EmptyQueueException("Cola vac�a");
		try{
			tama�o--;
			return pila.pop();
		}catch(EmptyStackException e){ 
			System.out.println("Pila vac�a");
			return null;
		}
	}
	
	public T front() throws EmptyQueueException{
		if(pila.isEmpty()) throw new EmptyQueueException("Cola vac�a");
		try{
			return pila.top();
		}catch(EmptyStackException e){ 
			System.out.println("Pila vac�a");
			return null;
		}
	}
	
}
