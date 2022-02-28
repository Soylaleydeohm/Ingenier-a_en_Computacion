package TDAMapeo;

import java.util.Iterator;
import TDALista.*;

public class TablaDispersionCerrada<K,V> implements Map<K,V> {

	protected Entry<K,V> DISPONIBLE= new Entrada<K,V>(null,null); //marca
	protected int cant;
	protected int capacidad;
	protected Entrada<K,V> [] arreglo;

	public TablaDispersionCerrada(){
		cant=0;
		capacidad=1023;
		arreglo= (Entrada<K,V> []) new Entrada[capacidad];
	}

	private int h(K key){
		return key.hashCode()%capacidad;
	}

	public int size() {
		return cant;
	}

	public boolean isEmpty() {
		return cant==0;
	}

	public Iterable<K> keys() {
		PositionList<K> lista= new ListaDoblementeEnlazada<K>();
		for(int i=0; i<capacidad; i++){
			if(arreglo[i]!= null && arreglo[i]!=DISPONIBLE)
				lista.addLast(arreglo[i].getKey());
		}
		return lista;
	}

	public Iterable<V> values() {
		PositionList<V> lista= new ListaDoblementeEnlazada<V>();
		for(int i=0; i<capacidad; i++){
			if(arreglo[i]!= null && arreglo[i]!=DISPONIBLE)
				lista.addLast(arreglo[i].getValue());
		}
		return lista;
	}

	public Iterable<Entry<K, V>> entries() {
		PositionList<Entry<K,V>> lista= new ListaDoblementeEnlazada<Entry<K,V>>();
		for(int i=0; i<capacidad; i++){
			if(arreglo[i]!= null && arreglo[i]!=DISPONIBLE)
				lista.addLast(arreglo[i]);
		}
		return lista;
	}

	public V get(K key) throws InvalidKeyException {
		if(key==null)
			throw new InvalidKeyException("Error: la clave es nula.");
		V anterior=null;
		boolean encontre=false;
		int inicio=h(key);
		int posActual=inicio;
		do{
			if(arreglo[posActual]==null)
				encontre=true;
			else{
				if(arreglo[posActual]==DISPONIBLE || !arreglo[posActual].getKey().equals(key)){
					//disponible                        //claves distintas
					posActual=(posActual+1)%capacidad; //para dar la vuelta	
				}
				else{ //clave igual
					anterior=arreglo[posActual].getValue();
					encontre=true;
				}
			}
		}
		while(posActual!=inicio && !encontre);
		return anterior;
	}

	public V put(K key, V value) throws InvalidKeyException {
		if(key==null)
			throw new InvalidKeyException("Error: la clave es nula.");
		if(cant>=capacidad/2)
			resize();
		V anterior=null;
		int primerDisponible=-1;
		int inicio=h(key);
		int posActual=inicio;
		do{
			if(arreglo[posActual]==null){
				cant++;
				if(primerDisponible==-1){
					//inserto en posActual
					arreglo[posActual]= new Entrada<K,V>(key, value);
				}
				else{
					//inserto en primerdisp
					arreglo[primerDisponible]= new Entrada<K,V>(key, value);
				}
				posActual=inicio;
			}
			else{
				if(arreglo[posActual]==DISPONIBLE || !arreglo[posActual].getKey().equals(key)){
					//disponible                        //claves distintas
					if(arreglo[posActual]==DISPONIBLE && primerDisponible==-1)
						primerDisponible=posActual;	
					posActual=(posActual+1)%capacidad; //para dar la vuelta	
				}
				else{ //clave igual
					anterior=arreglo[posActual].getValue();
					arreglo[posActual].setValue(value);
				}
			}
		}
		while(posActual!=inicio && anterior==null);
		return anterior;
	}

	protected void resize(){
		Iterator<Entry<K,V>> it= entries().iterator();
		Entrada<K,V>[] aux= (Entrada<K,V> []) new Entrada[nextPrimo(capacidad*2)];
		capacidad=aux.length;
		Entry<K,V> actual;
		int inicio;
		boolean coloque;
		while(it.hasNext()){
			actual= it.next();
			inicio=h(actual.getKey());
			coloque=false;
			while(!coloque){
				if(aux[inicio]==null){
					coloque=true;
					aux[inicio]=(Entrada<K,V>)actual;
				}
				else
					inicio=(inicio+1)%capacidad; //para dar la vuelta
			}
		}
		arreglo=aux;
	}
	//Retorna el número primo siguiente a i
	private int nextPrimo(int i){
		int primo=i+1;
		while(!esPrimo(primo))
			primo++;
		return primo;
	}
	//Dado un entero x retorna verdadero si x es primo y falso en caso contrario
	private boolean esPrimo(int x){
		boolean es=true;
		for(int i=2; i<x && es; i++)
			if(x%i==0)
				es=false;
		return es;
	}

	public V remove(K key) throws InvalidKeyException {
		if(key==null)
			throw new InvalidKeyException("Error: la clave es nula.");
		V anterior=null;
		boolean encontre=false;
		int inicio=h(key);
		int posActual=inicio;
		do{
			if(arreglo[posActual]==null)
				encontre=true;
			else{
				if(arreglo[posActual]==DISPONIBLE || !arreglo[posActual].getKey().equals(key)){
					//disponible                        //claves distintas
					posActual=(posActual+1)%capacidad; //para dar la vuelta	
				}
				else{ //clave igual
					anterior=arreglo[posActual].getValue();
					arreglo[posActual]=(Entrada<K,V>)DISPONIBLE;
					encontre=true;
					cant--;
				}
			}
		}
		while(posActual!=inicio && !encontre);
		return anterior;
	}
}

