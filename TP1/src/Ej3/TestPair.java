package Ej3;
public class TestPair {
	public static void main (String[] args){
		Pair <String, Float> p = new Pair <String, Float>("Hola", 1.12f);
		Pair <Integer, String> q = new Pair <Integer, String>(23, "Hola");
		Pair <Float, Integer> r = new Pair <Float, Integer>(23.2f, 21345);
		Pair <String, String> s = new Pair <String, String>("Hola", "Mundo");
		System.out.println(p.toString());
		System.out.println(q.toString());
		System.out.println(r.toString());
		System.out.println(s.toString());
	}	
}
