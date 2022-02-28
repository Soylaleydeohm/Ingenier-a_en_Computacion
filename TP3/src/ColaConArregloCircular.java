
public class ColaConArregloCircular<T> implements Queue<T>{
	//Estructura
	protected T [] arr;
	protected int f;	//front, donde inicia la cola
	protected int r;	//rear, donde finaliza la cola
	private static final int aumento = 10;
	
	//Constructor
	@SuppressWarnings("unchecked")
	public ColaConArregloCircular(){
		arr = (T[]) new Object[aumento];
		f = 0;
		r = 0;
	}
	public int size(){return (arr.length - f + r)% arr.length;} //Al tamaño del arreglo le resto donde inicia y le sumo donde finaliza

	public boolean isEmpty(){return f == r;}
	
	public void enqueue(T item){
		if(size() == arr.length-1) resize();
		arr[r] = item;
		r = (r+1) % arr.length;
	}
	private void resize(){//faltaría Try catch classcastException
		@SuppressWarnings("unchecked")
		T [] arrAux = (T[]) new Object[arr.length+aumento];
		int aux = size();
		int posArr;
		for (int i = 0; i < arr.length; i++){
			posArr = (f+i) % arr.length;
			arrAux[i] = arr[posArr];	//reordena
		}
		arr = arrAux;
		r = aux;
		f = 0;
	}
	
	public T dequeue() throws EmptyQueueException{
		if(f == r) throw new EmptyQueueException("Cola vacía");
		T aux = arr[f];
		arr[f] = null;
		f = (f+1) % arr.length;
		return aux;
	}
	public T front() throws EmptyQueueException{
		if(isEmpty()) throw new EmptyQueueException("Cola vacía");
		return arr[f];
	}
}
