
public class PilaArreglo<T> implements Stack<T> {
	//Estructura
	protected T [] arr;
	protected int indice;
	private static int aum = 10;
	
	@SuppressWarnings("unchecked")
	public PilaArreglo()
	{
		arr = (T[]) new Object[aum];
		indice = 0;
	}
	
	public int size(){return indice;}
	public boolean isEmpty(){return (indice == 0);}
	public void push(T item){
		if (indice == arr.length) aumentar();
		arr[indice] = item;
		indice++;
	}
	@SuppressWarnings("unchecked")
	private void aumentar(){
		T [] arrAux = (T[]) new Object[arr.length + aum];
		for (int i = 0; i < arr.length; i++){
			arrAux[i] = arr[i];
		}
		arr = arrAux;
	}
	public T pop() throws EmptyStackException{
		if (isEmpty()) throw new EmptyStackException("Pila vacia");
		T aux = arr[indice-1];
		indice--;
		return aux;
	}
	public T top() throws EmptyStackException{
		if (isEmpty()) throw new EmptyStackException("Pila vacia");
		return arr[indice-1];
	}
	
	//Método invertir agregado
	public void invertir(){
		@SuppressWarnings("unchecked")
		T [] arrAux = (T[]) new Object[indice];
		for(int i = 0; i<indice; i++){
			arrAux [i]= arr[indice-1-i];
		}		
		for(int i = 0; i<indice; i++){
			arr[i] = arrAux[i];
		}	
	}
	
}
