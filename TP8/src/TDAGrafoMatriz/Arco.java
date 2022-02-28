package TDAGrafoMatriz;

public class Arco <V,E> implements Edge<E>{

	protected E rotulo;
	protected TDALista.Position<Edge<E>> posicionEnArcos;
	protected Vertice<V> v1;
	protected Vertice<V> v2;
	
	public Arco(E rot, Vertice<V> uno, Vertice<V> dos){
		rotulo=rot;
		v1=uno;
		v2=dos;
		posicionEnArcos=null;
	}
	
	public E element(){
		return rotulo;
	}
	public TDALista.Position<Edge<E>> getPosicionEnArcos(){
		return posicionEnArcos;
	}
	public Vertice<V> getV1(){
		return v1;
	}
	public Vertice<V> getV2(){
		return v2;
	}
	
	public void setElemento(E elem){
		rotulo=elem;
	}
	public void setPosicionEnArcos(TDALista.Position<Edge<E>> pos){
		posicionEnArcos=pos;
	}
	public void setV1(Vertice<V> uno){
		v1=uno;
	}
	public void setV2(Vertice<V> dos){
		v2=dos;
	}
	
}
