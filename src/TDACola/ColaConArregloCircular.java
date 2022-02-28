package TDACola;

public class ColaConArregloCircular<T> implements Queue<T> {
	private int indiceCola;
	private int indiceFrente;
	private int tamaño;
	private final int MAX=100;
    private T[] arreglo;
    
    /**
     * Inicializa los atributos de instancia
     */
    public ColaConArregloCircular(){
    	indiceCola=0;
    	indiceFrente=0;
    	tamaño=0;
    	arreglo= (T[]) new Object[MAX];
    }
    
	public void enqueue(T elem) {
		if (tamaño==arreglo.length){
			T[] aux= (T[]) new Object[arreglo.length + MAX];
			int auxIF=indiceFrente;
			for (int i=0; i<arreglo.length; i++){
				aux[i]=arreglo[auxIF];
				auxIF=(auxIF+1)%arreglo.length;
			}	
			indiceFrente=0;
			indiceCola=arreglo.length;
			arreglo=aux;
		}
		arreglo[indiceCola]=elem;
	    indiceCola=(indiceCola+1)%arreglo.length;	
	    tamaño++;
	}
	public T dequeue() throws EmptyQueueException {
		if (tamaño==0)
			throw new EmptyQueueException ("Error: la cola está vacía.");
		T aux= arreglo[indiceFrente];
		arreglo[indiceFrente]=null;
		indiceFrente=(indiceFrente+1)%arreglo.length;
		tamaño--;
		return aux;
	}
	public T front() throws EmptyQueueException {
		if (tamaño==0)
			throw new EmptyQueueException ("Error: la cola está vacía.");
		return arreglo[indiceFrente];
	}
	public boolean isEmpty() {
		return tamaño==0;
	}
	public int size() {
		return tamaño;
	}
	
}
