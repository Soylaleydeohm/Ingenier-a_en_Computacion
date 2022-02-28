
public class TesterPilaArreglo {
	public static void main (String [] args){
		Stack<Integer> pila = new PilaArreglo<Integer>();
		PilaArreglo<Integer> pila2 = new PilaArreglo<Integer>();
		for(int i = 0; i < 10; i++)
			pila.push(i+1);
		mostrar(pila);
		invertirExt(pila);
		mostrar(pila);
		pila2.invertir();
		mostrar(pila);
	}
	
	private static <Integer> void mostrar(Stack<Integer> p){
		Stack<Integer> pilaAux = new PilaArreglo<Integer>();
		try{
			while(!p.isEmpty()){
				System.out.println(p.top());
				pilaAux.push(p.pop());
			}
			while(!pilaAux.isEmpty()){				
				p.push(pilaAux.pop());
			}
		}catch (EmptyStackException e){
			System.out.println("Pila vacia");
		}
	}
	
	private static <Integer> void invertirExt (Stack<Integer> p){
		Stack<Integer> p1 = new PilaArreglo<Integer>();
		Stack<Integer> p2 = new PilaArreglo<Integer>();
		try{
			while(!p.isEmpty()){
				p1.push(p.pop());
			}
			while(!p1.isEmpty()){
				p2.push(p1.pop());
			}
			while(!p2.isEmpty()){
				p.push(p2.pop());
			}
		}catch (EmptyStackException e){
			System.out.println("Pila vacia");
		}
	}
	
}
