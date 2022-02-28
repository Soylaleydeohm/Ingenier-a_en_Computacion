package Ej4;

public interface Conjunto<E> {
	public void insertar (E e);
	public void eliminar (E e) throws Exception;
	public int cantidadElementos();
	public boolean pertenece (E e);
}
