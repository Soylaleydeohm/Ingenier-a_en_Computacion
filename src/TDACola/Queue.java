package TDACola;

public interface Queue<T> {
	/**
	 * Inserta el elemento que pasa como par�metro al final de la cola.
	 * @param elem elemento a insertar.
	 */
	public void enqueue(T elem);
	/**
	 * Elimina el elemento del frente de la cola y lo retorna.
	 * @return el elemento del frente de la cola.
	 * @throws EmptyQueueException si la cola est� vac�a.
	 */
	public T dequeue() throws EmptyQueueException;
	/**
	 * Retorna el elemento del frente de la cola sin eliminarlo.
	 * @return el elemento del frente de la cola.
	 * @throws EmptyQueueException si la cola est� vac�a.
	 */
	public T front() throws EmptyQueueException;
	/**
	 * Retorna si la cola est� vac�a.
	 * @return verdadero si la cola no contiene
               elementos y falso en caso contrario.
	 */
	public boolean isEmpty();
	/**
	 * Retorna la cantidad de elementos de la cola.
	 * @return cantidad de elementos de la cola.
	 */
	public int size();
}
