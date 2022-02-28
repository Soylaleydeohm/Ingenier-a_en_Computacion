package Project;
import java.util.Iterator;
import TDAArbolBinario.*;
import TDALista.*;
import TDAMapeo.*;
import TDAPila.*;
/**
 * class Programa
 * @author VirginiaAraceli
 * 
 */
public class Programa {
	private Map<String, Float> variables;
	private BinaryTree<String> operaciones;
	
	/**
	 * Constructor de la clase
	 */
	public Programa(){
		variables = new MapeoHashAbierto<String, Float>();
	}
	
	/**
	 * Guarda la variable con su respectivo valor.
	 * @param var : Nombre de la variable de tipo String. 
	 * @param val : Valor de la variable de tipo Float.
	 * @throws InvalidVariableException si el nombre de la variable se había ingresado previamente.
	 */
	
	public void insertarVariable(String var, Float val) throws InvalidVariableException{
		try {
			if((variables.get(var) == null)){
				variables.put(var, val);
			}else {
				throw new InvalidVariableException("");
			}
		} catch (InvalidKeyException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Reemplaza una variable previamente guardada con el nuevo valor asignado.
	 * @param var : Nombre de la variable de tipo String. 
	 * @param val : Valor de la variable de tipo Float.
	 */
	
	public void reemplazarVariable(String var, Float val){
		try {
			if(variables.get(var) != null){
				variables.remove(var);
				variables.put(var, val);
			}
		} catch (InvalidKeyException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Nombre de todas las variables guardadas.
	 * @return Iterable con el nombre de las variables guardadas.
	 */
	
	public Iterable<String> obtenerVariables(){
		return variables.keys();
	}
	
	/**
	 * Valor de todas las variables guardadas.
	 * @return Iterable con el valor de las variables guardadas.
	 */
	
	public Iterable<Float> obtenerValores(){
		return variables.values();
	}
	
	/**
	 * Calcula el valor de una expresión ingresada como un String.
	 * @param s : Expresión a calcular de tipo String.
	 * @return resultado final de la expresión.
	 * @throws DivisionPorCeroException cuando se pretende dividir a un número por cero.
	 * @throws InvalidVariableException cuando se quiere resolver una expresión con una variable no guardada previamente.
	 * @throws ExpresionInvalidaException cuando la expresión no respeta los parámetros establecidos para que sea válida.
	 */

	public float calcular(String s) throws DivisionPorCeroException, InvalidVariableException, ExpresionInvalidaException{
		PositionList<String> op = pasarALista(s);
		return result(op);
	}
	
	/**
	 * Calcula el valor de una expresión ingresada como una lista.
	 * @param l Expresión a calcular de tipo PositionList<String>.
	 * @return resultado final de la expresión.
	 * @throws DivisionPorCeroException cuando se pretende dividir a un número por cero.
	 * @throws InvalidVariableException cuando se quiere resolver una expresión con una variable no guardada previamente.
	 * @throws ExpresionInvalidaException cuando la expresión no respeta los parámetros establecidos para que sea válida.
	 */
	
	private float result (PositionList<String> l) throws ExpresionInvalidaException, DivisionPorCeroException, InvalidVariableException {//se evalúa de forma postfija		
		crearArbol(l);	
		try {
			return resolverArbol(operaciones.root());
		} catch (EmptyTreeException e) {
			throw new ExpresionInvalidaException("Expresión inválida");
		}
	}
	
	/**
	 * Crea un árbol binario a partir de una lista pasada por parámetro.
	 * @param l Expresión a pasar a un árbol de tipo PositionList<String>.
	 * @throws ExpresionInvalidaException cuando la expresión no respeta los parámetros establecidos para que sea válida.
	 */
	
	private void crearArbol(PositionList<String> l) throws ExpresionInvalidaException {
		Stack<BinaryTree<String>> pila = new PilaEnlazada<BinaryTree<String>>();				
		try {
			int cantParentesis = 0;
			Iterable<Position<String>> it = l.positions();
			Iterator<Position<String>> iterador = it.iterator();
			while (iterador.hasNext()){
				String elem = iterador.next().element();		
				if(elem.charAt(0) == '(')
					cantParentesis++;
				else if(elem.charAt(0) == ')')
					cantParentesis--;
				if(elem.charAt(0) != '(' && elem.charAt(0) != ')'){						
					BinaryTree<String> arbolvo = new LinkedBinaryTree<String>();				
					arbolvo.createRoot(elem);
					pila.push(arbolvo);	
				}else if(elem.charAt(0) == ')'){
					BinaryTree<String> arbol2 = pila.pop();
					BinaryTree<String> arbol = pila.pop();
					BinaryTree<String> arbol1 = pila.pop();						
					arbol.Attach(arbol.root(), arbol1, arbol2);
					pila.push(arbol);
				}
			}
			if(!pila.isEmpty())
				operaciones = pila.pop();	
			if(!pila.isEmpty() || cantParentesis != 0) throw new ExpresionInvalidaException("Expresión inválida");
		} catch (InvalidOperationException e) {
			throw new ExpresionInvalidaException("Expresión inválida");
		} catch (EmptyStackException e) {			
			throw new ExpresionInvalidaException("Expresión inválida");
		} catch (InvalidPositionException e) {
			throw new ExpresionInvalidaException("Expresión inválida");
		} catch (EmptyTreeException e) {
			throw new ExpresionInvalidaException("Expresión inválida");
		}
	}
				
	/**
	 * Resuelve recursivamente a un árbol binario creado a partir de una expresión matemática recibiendo como parámetro la posición.
	 * @param pos es la posición del árbol a tratar, de tipo Position<String>.
	 * @return valor luego de resolver cada operación.
	 * @throws DivisionPorCeroException cuando se pretende dividir a un número por cero.
	 * @throws InvalidVariableException cuando se quiere resolver una expresión con una variable no guardada previamente.
	 */
	
	private float resolverArbol(Position<String> pos) throws DivisionPorCeroException, InvalidVariableException {
		try {
			if(operaciones.isExternal(pos)){
				if(variables.get(pos.element()) != null)
					return variables.get(pos.element());
				else throw new InvalidVariableException("La variable no se encuentra guardada");
			}else{
				char operador = pos.element().charAt(0);				
				Float v1 = resolverArbol(operaciones.left(pos));
				Float v2 = resolverArbol(operaciones.right(pos));
				return evaluar(operador, v1, v2);
			}
		} catch (InvalidPositionException e) {
			e.printStackTrace();
			return 0;
		} catch (InvalidKeyException e) {
			e.printStackTrace();
			return 0;
		} catch (BoundaryViolationException e) {
			e.printStackTrace();
			return 0;
		}
	}
	
	/**
	 * Evalúa una operación matemática.
	 * @param op de tipo char, puede ser +, -, *, / y/o ^.
	 * @param v1 de tipo float, primer argumento.
	 * @param v2 de tipo float, segundo argumento.
	 * @return valor de la operación.
	 * @throws DivisionPorCeroException cuando se pretende dividir a un número por cero.
	 */
	
	private float evaluar (char op, float v1, float v2) throws DivisionPorCeroException{
		float resultado = 0;
		if(op == '+'){
			resultado = v1 + v2;
		}if(op == '-'){
			resultado = v1 - v2;
		}if(op == '*'){
			resultado = v1 * v2;
		}if(op == '/'){
			if (v2 != 0)
				resultado = v1 / v2;
			else throw new DivisionPorCeroException("No se puede dividir por cero");
		}else if(op == '^'){
			resultado = (float) Math.pow(v1, v2);
		}
		return resultado;
					
	}
	
	/**
	 * Pasa a una lista a un String.
	 * @param s de tipo String
	 * @return una lista de elementos de tipo String.
	 */
	
	private PositionList<String> pasarALista(String s){
		PositionList<String> l = new ListaDoblementeEnlazada<String>();
		String var = "";
		for (int i = 0; i < s.length(); i++){
			if(operador(s.charAt(i))){	
				if(var != "")
					l.addLast(var);
				l.addLast(""+s.charAt(i));
				var = "";
			}else if(s.charAt(i) != ' ')
				var = var + "" +s.charAt(i);			
		}
		if(var != "")
			l.addLast(var);
		return l;
	}
	
	/**
	 * Consulta si el parámetro ingresado es un operador (+, -, *, /, ^, (, ) ).
	 * @param c de tipo char
	 * @return Verdadero si es un operador, Falso en caos contrario.
	 */
	
	private boolean operador(char c){
		return ((c == '+') || (c == '-') || (c == '/') || (c == '*') || (c == '^') || (c == '(') || (c == ')'));
	}
	
	/**
	 * Expresión en notación infija.
	 * @return String con la expresión en notación infija.
	 */
	
	public String infijoString(){
		try {
			return toStringInorder(operaciones.root());
		} catch (EmptyTreeException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * Recorrido de un árbol en Inorden.
	 * @param v posición del árbol de tipo Position<String>.
	 * @return recorrido del árbol en Inorden como un String.
	 */
	private String toStringInorder( Position<String> v) {
		String s = "";
		try {
			if(operaciones.isExternal(v))
				s = v.element().toString();
			else {
				if(operaciones.hasLeft(v)){
					s = "(" + toStringInorder(operaciones.left(v)) + v.element().toString();
					if(operaciones.hasRight(v)){
						s = s + toStringInorder(operaciones.right(v)) + ")";
					}
				}
			}
		} catch (InvalidPositionException e) {
			e.printStackTrace();
		} catch (BoundaryViolationException e) {
			e.printStackTrace();
		}
	return s;
	}
	
	/**
	 * Expresión en notación prefija.
	 * @return String con la expresión en notación prefija.
	 */
	
	public String prefijoString(){
		try {
			return toStringPreorder(operaciones.root());
		} catch (EmptyTreeException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * Recorrido de un árbol en Preorden.
	 * @param v posición del árbol de tipo Position<String>.
	 * @return recorrido del árbol en Preorden como un String.
	 */
	
	private String toStringPreorder( Position<String> v) {
		String s = v.element().toString();
		try {
			for( Position<String> w : operaciones.children(v) )
			s += toStringPreorder( w );
		} catch (InvalidPositionException e) {
			e.printStackTrace();
		}
	return s;
	}
	
	/**
	 * Expresión en notación postfija.
	 * @return String con la expresión en notación postfija.
	 */
	
	public String postfijoString(){
		try {
			return toStringPostorder(operaciones.root());
		} catch (EmptyTreeException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * Recorrido de un árbol en Postorden.
	 * @param v posición del árbol de tipo Position<String>.
	 * @return recorrido del árbol en Postorden como un String.
	 */
	
	private String toStringPostorder( Position<String> v) {
		String s ="";
		try {
			for( Position<String> w : operaciones.children(v) ){
				s = s + toStringPostorder( w );
			}
			s = s + v.element().toString();
		} catch (InvalidPositionException e) {
			e.printStackTrace();
		}
		return s;
	}
	
	/**
	 * Recorre a un árbol por niveles.
	 * @return String con el recorrido por niveles del árbol.
	 */
	
	public String mostrarArbol(){
		String s = "";
		if(esSimetrico()){
			try {
				if(!operaciones.isEmpty()){
					PositionList<Position<String>> l = new ListaDoblementeEnlazada<Position<String>>();
					l.addFirst(operaciones.root());
					l.addLast(null);
					Position<Position<String>> pos = l.first();
					int espacio = alturaArbol();
					while(pos != null){
						Position<String> v = pos.element();	
						pos = (pos != l.last()) ? l.next(pos) : null;
						if(v != null){							
							for(int i = 0; i <espacio + 1 && v != operaciones.root() && (l.prev(l.prev(pos)).element() != null); i++){
								s =  s + "\t\t\t\t";
							}	
							s = s + v.element();
							if (operaciones.hasLeft(v))
								l.addLast(operaciones.left(v));
							if (operaciones.hasRight(v))
								l.addLast(operaciones.right(v));
						}else{
							s = s + "\n\n";
							if(pos != null){
								l.addLast(null);
								espacio--;
							}
						}
					}
				} 
			}catch (EmptyTreeException e) {
				e.printStackTrace();
	 		} catch (EmptyListException e) {
				e.printStackTrace();
			} catch (InvalidPositionException e) {
				e.printStackTrace();
			} catch (BoundaryViolationException e) {
				e.printStackTrace();
			}
		}
		return s;
	}	
	
	/**
	 * Verifica si el árbol es simétrico, es decir, todas sus hojas tienen la misma profundidad.
	 * @return Verdadero si es simétrico, falso en caso contrario.
	 */
	
	private boolean esSimetrico(){
		int altura = alturaArbol();
		int nodos = ((int) (Math.pow(2, altura+1))) - 1;
		return ( nodos == nodosArbol());
	}

	/**
	 * Consulta la altura de un árbol.
	 * @return Altura del árbol.
	 */
			
	public int alturaArbol(){
		try {
			return alturaNodo(operaciones.root());
		} catch (EmptyTreeException e) {
			e.printStackTrace();
			return 0;
		}
	}
	
	/**
	 * Consulta la altura del nodo de un árbol.
	 * @param p posición del árbol a consultar.
	 * @return Altura de la posición pasada por parámetro.
	 */
	
	private int alturaNodo(Position<String> p){
		try {
			if(operaciones.isExternal(p))
				return 0;
			else{
				int h = 0;
				for(Position<String> w : operaciones.children(p))
					h = Math.max(h, alturaNodo(w));
				return 1 + h;
			}
		} catch (InvalidPositionException e) {
			e.printStackTrace();
			return 0;
		}
	}
	
	/**
	 * Consulta la cantidad de hojas de un árbol.
	 * @return cantidad de hojas del árbol.
	 */
	
	public int hojasArbol() {
		if(!operaciones.isEmpty())
			try {
				return hojasAux(operaciones.root());
			} catch (EmptyTreeException e) {
				e.printStackTrace();
				return 0;
			}
		else return 0;
	}
	
	/**
	 * Consulta si la posición del árbol pasada por parámetro es una hoja.
	 * @param p posición del árbol.
	 * @return Si la posición del árbol pasada por parámetro es una hoja, devuelve 1, sino, 0.
	 */
	
	private int hojasAux(Position<String> p) {
		if(operaciones.isEmpty()) return 0;
		else{
			try {
				if(operaciones.isExternal(p)) return 1;
				else return (hojasAux(operaciones.left(p)) + hojasAux(operaciones.right(p)));
			} catch (InvalidPositionException e) {
				e.printStackTrace();
				return 0;
			} catch (BoundaryViolationException e) {
				e.printStackTrace();
				return 0;
			}
		}
	}
	
	/**
	 * Consulta cuántos nodos hay en un árbol.
	 * @return cantidad de nodos en el árbol.
	 */
	
	public int nodosArbol(){return operaciones.size();}
	
	/**
	 * Consulta cuántos nodos internos hay en un árbol.
	 * @return cantidad de nodos internos en el árbol.
	 */
	
	public int nodosInternosArbol() {
		return nodosArbol() - hojasArbol();
	}
	
	/**
	 * Consulta cuántos nodos de altura 1 hay en un árbol.
	 * @return cantidad de nodos de altura 1 en el árbol. Si la raíz es de altura 1, devuelve 0.
	 */
	
	public int nH1(){
		try {
			PositionList<Position<String>> nodoH1 = new ListaDoblementeEnlazada<Position<String>>();
			PositionList<Position<String>> nodosH1 = obtenerNodosH1(operaciones.root(), nodoH1);
			return nodosH1.size();
		} catch (DivisionPorCeroException e) {
			e.printStackTrace();
			return 0;
		} catch (InvalidVariableException e) {
			e.printStackTrace();
			return 0;
		} catch (EmptyTreeException e) {
			e.printStackTrace();
			return 0;
		}
	}
	
	/**
	 * Crea variables a partir de una lista de nombres de variables pasadas por parámetro.
	 * @param l lista de nombres de variables
	 * @throws ReemplazoInvalidoException si uno de los nombres de las variables de la lista ya se encuentra guardado.
	 */
	
	public void crearVariablesH1(PositionList<String> l) throws ReemplazoInvalidoException{
		try {
			PositionList<Position<String>> nodoH1 = new ListaDoblementeEnlazada<Position<String>>();
			PositionList<Position<String>> nodosH1 = obtenerNodosH1(operaciones.root(), nodoH1);
			reemplazarH1(l, nodosH1);
		} catch (DivisionPorCeroException e) {
			e.printStackTrace();
		} catch (InvalidVariableException e) {
			e.printStackTrace();
		} catch (EmptyTreeException e) {
			e.printStackTrace();
		}			
	}

	/**
	 * Obtiene los nodos de altura 1.
	 * @param pos nodo a verificar su altura.
	 * @param nodoH1 Lista con los nodos de altura 1 del árbol.
	 * @return Lista con los nodos de altura 1 del árbol.
	 * @throws DivisionPorCeroException cuando se pretende dividir a un número por cero.
	 * @throws InvalidVariableException cuando se quiere resolver una expresión con una variable no guardada previamente.
	 */
	
	private PositionList<Position<String>> obtenerNodosH1(Position<String> pos, PositionList<Position<String>> nodoH1) throws DivisionPorCeroException, InvalidVariableException {
		try {
			if(operaciones.isInternal(pos)){
				if (pos!= operaciones.root() && alturaNodo(pos) == 1){
					nodoH1.addLast(pos);
				} else {
					for(Position<String> w : operaciones.children(pos)) {
						obtenerNodosH1(w, nodoH1);
					}
				}
			}
		} catch (InvalidPositionException e) {
			e.printStackTrace();
		} catch (EmptyTreeException e) {
			e.printStackTrace();
		}
		return nodoH1;
	}
	
	/**
	 * Reemplaza a los nodos de altura 1 por un nodo de altura cero.
	 * @param l lista de nombres de variables.
	 * @param lnodos lista de nodos de altura 1.
	 * @throws ReemplazoInvalidoException cuando se quiere reemplazar con un argumento no válido.
	 */
	
	private void reemplazarH1(PositionList<String> l, PositionList<Position<String>> lnodos) throws ReemplazoInvalidoException{
		try {
			while(!lnodos.isEmpty() && !l.isEmpty()){
				reemplazarExp(lnodos.first().element(), l.first().element());
				l.remove(l.first());
				lnodos.remove(lnodos.first());
			}
		} catch (DivisionPorCeroException e) {
			e.printStackTrace();
		} catch (EmptyListException e) {
			e.printStackTrace();
		} catch (InvalidPositionException e) {
			e.printStackTrace();
		}		
	}
	
	/**
	 * Reemplaza una expresión por una variable a la que se le asigna el resultado de la misma.
	 * @param p nodo del árbol a reemplazar.
	 * @param var nombre de la nueva variable
	 * @throws DivisionPorCeroException cuando se pretende dividir a un número por cero.
	 * @throws ReemplazoInvalidoException cuando se quiere reemplazar con un argumento no válido.
	 */
	
	private void reemplazarExp(Position<String> p, String var) throws DivisionPorCeroException, ReemplazoInvalidoException {
		float valor;
		try{
			valor = evaluar(p.element().charAt(0), variables.get(operaciones.left(p).element()), variables.get(operaciones.right(p).element()));
			insertarVariable(var, valor);				
			Position<String> padre = operaciones.parent(p);
			operaciones.remove(operaciones.left(p));
			operaciones.remove(operaciones.right(p));
			if(p == operaciones.left(padre)){
				operaciones.remove(p);
				operaciones.addLeft(padre, var);
			}else if(p == operaciones.right(padre)){
				operaciones.remove(p);
				operaciones.addRight(padre, var);
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (InvalidPositionException e) {
			e.printStackTrace();
		} catch (BoundaryViolationException e) {
			e.printStackTrace();
		} catch (InvalidOperationException e) {
			e.printStackTrace();
		} catch (InvalidKeyException e) {
			e.printStackTrace();
		} catch (InvalidVariableException e) {
			throw new ReemplazoInvalidoException("Variable guardada con otro valor");
		}
	}
	
}
