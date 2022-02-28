
public interface Stack<T> {
	public void push (T item);
	public T pop() throws EmptyStackException;
	public T top() throws EmptyStackException;
	public int size();
	public boolean isEmpty();
}
