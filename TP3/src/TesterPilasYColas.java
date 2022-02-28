
public class TesterPilasYColas {
	//public static void main (String [] arg){
	//	Queue<Stack<Character>> c1 = new ColaConLista<Stack<Character>>();
	//	Queue<Stack<Character>> c2 = new ColaConLista<Stack<Character>>();
	//}
	
	public Queue<Stack<Character>> ordenar (Queue<Stack<Character>> cin1, Queue<Stack<Character>> cin2){
		Queue<Stack<Character>> COut = new ColaConLista<Stack<Character>>();
		Queue<Stack<Character>> Cin1Aux = new ColaConLista<Stack<Character>>();
		Queue<Stack<Character>> Cin2Aux = new ColaConLista<Stack<Character>>();
		Stack<Character> p1 = new PilaArreglo<Character>();
		Stack<Character> p2 = new PilaArreglo<Character>();
		try{
			while(!cin1.isEmpty() && !cin2.isEmpty()){
				p1 = cin1.front();
				p2 = cin2.front();
				if(p1.size() > p2.size()){
					Cin2Aux.enqueue(cin2.dequeue());
					COut.enqueue(p2);
				} else {
					Cin1Aux.enqueue(cin1.dequeue());
					COut.enqueue(p1);
				}
			}
			while(!cin1.isEmpty()){
				p1 = cin1.dequeue();
				Cin1Aux.enqueue(p1);
				COut.enqueue(p1);
			}
			while(!cin2.isEmpty()){
				p2 = cin2.dequeue();
				Cin2Aux.enqueue(p2);
				COut.enqueue(p2);
			}
			while(!Cin1Aux.isEmpty()){
				cin1.enqueue(Cin1Aux.dequeue());
			}
			while(!Cin2Aux.isEmpty()){
				cin2.enqueue(Cin2Aux.dequeue());
			}
		} catch (EmptyQueueException e){System.out.println(e.getMessage());
		} return COut;
	}
	
	public Stack<Integer> almacenarPilas(Stack<Stack<Integer>> ppe){
		Stack<Stack<Integer>> ppeAux = new PilaArreglo<Stack<Integer>>();
		Stack<Stack<Integer>> ppeCopy = new PilaArreglo<Stack<Integer>>();
		Stack<Integer> peAux = new PilaArreglo<Integer>();
		Stack<Integer> pe = new PilaArreglo<Integer>();
		try{
			while (!ppe.isEmpty()){
				ppeAux.push(ppe.pop());
			}
			while (!ppeAux.isEmpty()){
				Stack<Stack<Integer>> peAux2 = new PilaArreglo<Stack<Integer>>();
				ppeCopy.push(ppeAux.top());
				peAux2.push(ppeAux.pop());
				while(!peAux2.top().isEmpty()){
					peAux.push(peAux2.top().pop());
				}
				while(!peAux.isEmpty()){
					pe.push(peAux.pop());
				}
			}
			while (!ppeCopy.isEmpty()){
				ppe.push(ppeCopy.pop());
			}
		} catch (EmptyStackException e){System.out.println("Pila vacía");}
		return pe;
	}
	
	public Stack<Queue<Integer>> pilasDeColas(Stack<Queue<Integer>> p1, Stack<Queue<Integer>> p2){
		Stack<Queue<Integer>> p1Aux = new PilaConEnlaces<Queue<Integer>>();
		Stack<Queue<Integer>> p2Aux = new PilaConEnlaces<Queue<Integer>>();
		Stack<Queue<Integer>> pAux = new PilaConEnlaces<Queue<Integer>>();
		Stack<Queue<Integer>> pOut = new PilaConEnlaces<Queue<Integer>>();
		Queue<Integer> c1Aux = new ColaConLista<Integer>();
		Queue<Integer> c2Aux = new ColaConLista<Integer>();
		try{
			while(!p1.isEmpty() && !p2.isEmpty()){
				c1Aux = p1.top();
				c2Aux = p2.top();
				if(c1Aux.size() > c2Aux.size()){
					p2Aux.push(p2.pop());
					pAux.push(c2Aux);
				}else{
					p1Aux.push(p1.pop());
					pAux.push(c1Aux);
				}
			}
			while(!p1.isEmpty()){
				c1Aux = p1.pop();
				p1Aux.push(c1Aux);
				pAux.push(c1Aux);
			}
			while(!p2.isEmpty()){
				c2Aux = p2.pop();
				p2Aux.push(c2Aux);
				pAux.push(c2Aux);
			}
			while(!p1Aux.isEmpty())
				p1.push(p1Aux.pop());
			while(!p2Aux.isEmpty())
				p2.push(p2Aux.pop());
			while(!pAux.isEmpty())
				pOut.push(pAux.pop());
		} catch (EmptyStackException e){System.out.println(e.getMessage());}
		return pOut;
	}
	
	public boolean respeta(String cadena){
		boolean r = true;
		Queue<Character> cadenaCola = new ColaConLista<Character>();
		for (int i = 0; i < cadena.length(); i++){
			cadenaCola.enqueue(cadena.charAt(i));
		}
		Queue<Character> cadenaAux = new ColaConLista<Character>();
		Stack<Character> pila = new PilaArreglo<Character>();
		try{
			while (!cadenaCola.isEmpty()){
				while(!cadenaCola.isEmpty() && !cadenaCola.front().equals('z')){
					cadenaAux.enqueue(cadenaCola.front());
					pila.push(cadenaCola.dequeue());
				}
				pila.push(cadenaCola.dequeue()); //Agrego z
				while (!cadenaCola.isEmpty() && !cadenaCola.front().equals('x') && !cadenaAux.isEmpty() && r){
					r = cadenaAux.front().equals(cadenaCola.front());
					cadenaAux.enqueue(cadenaCola.front());
					pila.push(cadenaCola.dequeue());
				}
				cadenaCola.dequeue(); //Quito x
				while (!cadenaCola.isEmpty() && !pila.isEmpty() && r)
					r = cadenaCola.dequeue().equals(pila.pop());				
				if (!cadenaCola.isEmpty()) cadenaCola.dequeue(); //Saco x
			}
		}catch (EmptyQueueException e){System.out.println(e.getMessage());
		}catch (EmptyStackException e){System.out.println(e.getMessage());
		}return r;
	}
}
