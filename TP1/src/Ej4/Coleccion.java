package Ej4;

public interface Coleccion <E> {
	public void insertar (E e);
	public void eliminar (E e);
	public int cantidadElementos();
	public boolean pertenece (E e);
}
