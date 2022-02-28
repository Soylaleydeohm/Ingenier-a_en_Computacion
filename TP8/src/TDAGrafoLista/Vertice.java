package TDAGrafoLista;

import TDALista.*;
import TDAMapeo.*;

public class Vertice<V,E> extends HashAbierto<Object,Object> implements Vertex<V> {

	protected V rotulo;
	protected PositionList<Arco<V,E>> adyacentes;
    protected TDALista.Position<Vertice<V,E>> posicionEnVertices;
	
    public Vertice(V rot){
    	rotulo=rot;
    	posicionEnVertices=null;
    	adyacentes= new ListaDoblementeEnlazada<Arco<V,E>>();
    }
    
	public V element() {
		return rotulo;
	}
	public TDALista.Position<Vertice<V,E>> getPosicionEnVertices(){
		return posicionEnVertices;
	}
	public PositionList<Arco<V,E>> getAdyacentes() {
		return adyacentes;
	}
	public void setElemento(V elem){
		rotulo=elem;
	}
	public void setPosicionEnVertices(TDALista.Position<Vertice<V,E>> position){
		posicionEnVertices=position;
	}
	public void setAdyacente(Arco<V,E> arco){
		adyacentes.addLast(arco);
	}
}
