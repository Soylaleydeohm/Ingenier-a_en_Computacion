package TDADiccionario;


public class Entrada<K,V> implements Entry<K,V>{

	private V valor;
	private K clave;
	
	public Entrada(K c, V v){
		valor=v;
		clave=c;
	}
	
	public K getKey() {
		return clave;
	}
	public V getValue() {
		return valor;
	}
    public void setKey(K c){
    	clave=c;
    }
    public void setValue(V v){
    	valor=v;
    }
	public boolean equals(Object o){
		Entrada<K,V> entrada;
		try{
			entrada=(Entrada<K,V>) o;
		}
		catch(ClassCastException e){
			return false;
		}
	    return entrada.getKey().equals(clave) && entrada.getValue().equals(valor);
	}

}
