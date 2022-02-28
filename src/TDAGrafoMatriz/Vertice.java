package TDAGrafoMatriz;

import TDAMapeo.HashAbierto;

public class Vertice<V> extends HashAbierto<Object,Object> implements Vertex<V> {

	protected V rotulo;
    protected int indice;
    protected TDALista.Position<Vertex<V>> posicionEnVertices;
	
    public Vertice(V rot, int ind){
    	rotulo=rot;
    	indice=ind;
    	posicionEnVertices=null;
    }
    
	public V element() {
		return rotulo;
	}
	public int getIndice(){
		return indice;
	}
	public TDALista.Position<Vertex<V>> getPosicionEnVertices(){
		return posicionEnVertices;
	}
	
	public void setElemento(V elem){
		rotulo=elem;
	}
	public void setIndice(int i){
		indice=i;
	}
	public void setPosicionEnVertices(TDALista.Position<Vertex<V>> position){
		posicionEnVertices=position;
	}
}
