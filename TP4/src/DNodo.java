
public class DNodo<E> implements Position<E> {
	private E elemento;
	private DNodo<E> siguiente;
	private DNodo<E> previo;

	public DNodo(DNodo<E> prev, DNodo<E> sig, E elem){
		elemento = elem;
		siguiente = sig;
		previo = prev;
	}
	
	public E element(){ //throws InvalidPositionException{
		//if((previo == null) && (siguiente == null)) throw new InvalidPositionException("La posición no está en la lista");
		return elemento;
		}
	public void setElemento(E item){elemento = item;}
	public DNodo<E> getNext(){return siguiente;}
	public void setNext(DNodo<E> sig){siguiente = sig;}
	public DNodo<E> getPrev(){return previo;}
	public void setPrev(DNodo<E> prev){previo = prev;}
}
