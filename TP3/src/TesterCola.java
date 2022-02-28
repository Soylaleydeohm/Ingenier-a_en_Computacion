
public class TesterCola {
	public static void main (String [] arg){
		Queue<Character> q1 = new ColaConLista<Character>();
		Queue<Character> q2 = new ColaConLista<Character>();
		Queue<Character> q3 = new ColaConLista<Character>();
		
		q1.enqueue('a');
		q1.enqueue('b');
		q1.enqueue('c');
		q1.enqueue('x');
		q1.enqueue('c');
		q1.enqueue('b');
		q1.enqueue('a');
		q1.enqueue('a');
		q1.enqueue('b');
		q1.enqueue('c');
		
		q2.enqueue('a');
		q2.enqueue('b');
		q2.enqueue('x');
		q2.enqueue('b');
		q2.enqueue('a');
		q2.enqueue('a');
		q2.enqueue('b');
		
		q3.enqueue('a');
		q3.enqueue('b');
		q3.enqueue('x');
		q3.enqueue('a');
		q3.enqueue('a');
		q3.enqueue('a');
		q3.enqueue('b');

		System.out.println("q1 respeta el formato(T): " + respetaFormato(q1,'x'));
		System.out.println("q2 respeta el formato(T): " + respetaFormato(q2,'x'));
		System.out.println("q3 respeta el formato(F): " + respetaFormato(q3,'x'));
	}
	
	private static boolean respetaFormato(Queue<Character> q, Character x){
		boolean respeta = false;
		Character elem;
		Queue<Character> C_Aux = new ColaConLista<Character>();
		Stack<Character> P_Aux = new PilaConEnlaces<Character>();
		Queue<Character> C_Copy = new ColaConLista<Character>();
		try{
			while(!q.isEmpty() && !q.front().equals(x)){
				elem = q.dequeue();
				C_Aux.enqueue(elem);
				P_Aux.push(elem);
				C_Copy.enqueue(elem);
			}
			if(!q.isEmpty() && q.front().equals(x)){
				C_Copy.enqueue(q.dequeue());
				respeta = true;
			}
			while(!q.isEmpty() && !P_Aux.isEmpty() && respeta){
				elem = q.dequeue();
				respeta = P_Aux.pop().equals(elem);
				C_Copy.enqueue(elem);
			}
			while(!q.isEmpty() && !C_Aux.isEmpty() && respeta){
				elem = q.dequeue();
				respeta = C_Aux.dequeue().equals(elem);
				C_Copy.enqueue(elem);
			}
			respeta = (respeta && q.isEmpty() && C_Aux.isEmpty() && P_Aux.isEmpty());
			//Si q no es vacía aún
			while(!q.isEmpty()){
				C_Copy.enqueue(q.dequeue());
			}
			//Paso toda la copia a la cola original así no se ve alterada.
			while(!C_Copy.isEmpty()){
				q.enqueue(C_Copy.dequeue());

			}
		}catch(EmptyQueueException e){System.out.println("Cola vacía");
		}catch(EmptyStackException e){System.out.println("Pila auxiliar vacía");
		}return respeta;
	}
	
	private static Queue<Stack<Character>> ordenar(Queue<Stack<Character>> Cin1, Queue<Stack<Character>> Cin2){
		Queue<Stack<Character>> Cout = new ColaConLista<Stack<Character>>();	
		Queue<Stack<Character>> Cin1Aux = new ColaConLista<Stack<Character>>();
		Queue<Stack<Character>> Cin2Aux = new ColaConLista<Stack<Character>>();
		Stack<Character> p1 = new PilaConEnlaces<Character>();
		Stack<Character> p2 = new PilaConEnlaces<Character>();
		try{
			while(!Cin1.isEmpty() && !Cin2.isEmpty()){
				p1 = Cin1.front();
				p2 = Cin2.front();
				if(p1.size()> p2.size()){ 
					Cout.enqueue(p2);
					Cin2Aux.enqueue(Cin2.dequeue());
				} else {
					Cout.enqueue(p1);
					Cin1Aux.enqueue(Cin1.dequeue());
				}
			}
			while(!Cin1.isEmpty()){
				p1 = Cin1.dequeue();
				Cout.enqueue(p1);
				Cin1Aux.enqueue(p1);
			}
			while(!Cin2.isEmpty()){
				p2 = Cin2.dequeue();
				Cout.enqueue(p2);
				Cin2Aux.enqueue(p2);
			}
			while(!Cin1Aux.isEmpty()){
				Cin1.enqueue(Cin1Aux.dequeue());
			}
			while(!Cin2Aux.isEmpty()){
				Cin2.enqueue(Cin2Aux.dequeue());
			}
		}catch(EmptyQueueException e){
			System.out.println("Cola vacía");
		}
		return Cout;
	}
	
	
}
