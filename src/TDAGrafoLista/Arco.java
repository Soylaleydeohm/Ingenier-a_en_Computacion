package TDAGrafoLista;

public class Arco <V,E> implements Edge<E>{

	protected E rotulo;
	protected TDALista.Position<Arco<V,E>> posicionEnArcos;
	protected Vertice<V,E> v1;
	protected Vertice<V,E> v2;
	protected TDALista.Position<Arco<V,E>> posicionEnListaAdyacenciaV1;
	protected TDALista.Position<Arco<V,E>> posicionEnListaAdyacenciaV2;
	
	public Arco(E rot, Vertice<V,E> uno, Vertice<V,E> dos){
		rotulo=rot;
		v1=uno;
		v2=dos;
		posicionEnArcos=null;
		posicionEnListaAdyacenciaV1=null;
		posicionEnListaAdyacenciaV2=null;
	}
	
	public E element(){
		return rotulo;
	}
	public TDALista.Position<Arco<V,E>> getPosicionEnListaAdyacenciaV1(){
		return posicionEnListaAdyacenciaV1;
	}
	public TDALista.Position<Arco<V,E>> getPosicionEnListaAdyacenciaV2(){
		return posicionEnListaAdyacenciaV2;
	}
	public TDALista.Position<Arco<V,E>> getPosicionEnArcos(){
		return posicionEnArcos;
	}
	public Vertice<V,E> getV1(){
		return v1;
	}
	public Vertice<V,E> getV2(){
		return v2;
	}
	
	public void setElemento(E elem){
		rotulo=elem;
	}
	public void setPosicionEnArcos(TDALista.Position<Arco<V,E>> pos){
		posicionEnArcos=pos;
	}
	public void setPosicionEnListaAdyacenciaV2(TDALista.Position<Arco<V,E>> pos){
		posicionEnListaAdyacenciaV2=pos;
	}
	public void setPosicionEnListaAdyacenciaV1(TDALista.Position<Arco<V,E>> pos){
		posicionEnListaAdyacenciaV1=pos;
	}
	public void setV1(Vertice<V,E> uno){
		v1=uno;
	}
	public void setV2(Vertice<V,E> dos){
		v2=dos;
	}
	
}
