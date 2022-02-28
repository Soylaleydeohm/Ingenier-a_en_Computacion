package TDACola;

public class ColaConArregloCircular<T> implements Queue<T> {
	private int indiceCola;
	private int indiceFrente;
	private int tama�o;
	private final int MAX=100;
    private T[] arreglo;
    
    /**
     * Inicializa los atributos de instancia
     */
    public ColaConArregloCircular(){
    	indiceCola=0;
    	indiceFrente=0;
    	tama�o=0;
    	arreglo= (T[]) new Object[MAX];
    }
    
	public void enqueue(T elem) {
		if (tama�o==arreglo.length){
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
	    tama�o++;
	}
	public T dequeue() throws EmptyQueueException {
		if (tama�o==0)
			throw new EmptyQueueException ("Error: la cola est� vac�a.");
		T aux= arreglo[indiceFrente];
		arreglo[indiceFrente]=null;
		indiceFrente=(indiceFrente+1)%arreglo.length;
		tama�o--;
		return aux;
	}
	public T front() throws EmptyQueueException {
		if (tama�o==0)
			throw new EmptyQueueException ("Error: la cola est� vac�a.");
		return arreglo[indiceFrente];
	}
	public boolean isEmpty() {
		return tama�o==0;
	}
	public int size() {
		return tama�o;
	}
	
}
