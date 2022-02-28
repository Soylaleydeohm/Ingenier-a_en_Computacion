
public interface Queue<T> {
	public int size();
	public boolean isEmpty();
	public void enqueue (T item);
	public T dequeue () throws EmptyQueueException;
	public T front() throws EmptyQueueException;
}
