package EjerciciosGrafo;
import TDAGrafoLista.*;
import TDAMapeo.*;
import TDACola.*;
import TDALista.*;

public class Recorridos {

	private static final Object ESTADO= new Object();
	private static final Object VISITADO= new Object();
	private static final Object NOVISITADO= new Object();
	
	public static void main(String[] args) {
		
		GrafoConLista<Integer, Double> grafo= new GrafoConLista<Integer, Double>();
		Vertex<Integer> v1,v2,v3,v4,v5,v6,v7,v8,v9,v10,v11;
        v1=grafo.insertVertex(1);
        v2=grafo.insertVertex(2);
        v3=grafo.insertVertex(3);
        v4=grafo.insertVertex(4);
        v5=grafo.insertVertex(5);
        v6=grafo.insertVertex(6);
        v7=grafo.insertVertex(7);
        v8=grafo.insertVertex(8);
        v9=grafo.insertVertex(9);
        v10=grafo.insertVertex(10);
        v11=grafo.insertVertex(11);
        try{
        grafo.insertEdge(v1, v2, 1d);
        grafo.insertEdge(v1, v3, 1d);
        grafo.insertEdge(v1, v4, 1d);
        grafo.insertEdge(v2, v5, 1d);
        grafo.insertEdge(v2, v6, 1d);
        grafo.insertEdge(v3, v7, 1d);
        grafo.insertEdge(v4, v8, 1d);
        grafo.insertEdge(v4, v9, 1d);
        grafo.insertEdge(v6, v10, 1d);
        grafo.insertEdge(v8, v11, 1d);
        grafo.insertEdge(v5,v11,10d);
        grafo.insertEdge(v5,v7,19d);
        grafo.insertEdge(v7,v11,1d);
        }
        catch(InvalidVertexException e){
        	e.printStackTrace();
        }
		
        System.out.println("DFSLista: ");
        grafo.DFS();
        
        System.out.println('\n'+"BFSLista: ");
        grafo.BFS();
        
        System.out.println('\n'+"DFSmain: ");
        DFS(grafo);
        
        System.out.println('\n'+"BFSMain: ");
        BFS(grafo);
        
        System.out.println('\n'+"Camino mas economico entre 11 y 5: ");
        PositionList<Vertex<Integer>> camino= new ListaDoblementeEnlazada<Vertex<Integer>>();
        caminoMasEconomico(grafo, v11, v5, camino);
        for(TDALista.Position<Vertex<Integer>> elem: camino.positions())
        	System.out.print(elem.element().element()+" ");
        
        System.out.println('\n'+"Camino mas corto entre 11 y 5: ");
        PositionList<Vertex<Integer>> camino2= new ListaDoblementeEnlazada<Vertex<Integer>>();
        caminoMasCorto(grafo, v11, v5, camino2);
        for(TDALista.Position<Vertex<Integer>> elem: camino2.positions())
        	System.out.print(elem.element().element()+" ");
        
        System.out.print('\n'+"Todos los caminos entre 11 y 5: ");
        PositionList<PositionList<Vertex<Integer>>> camino3= new ListaDoblementeEnlazada<PositionList<Vertex<Integer>>>();
        todosLosCaminos(grafo, v11, v5, camino3);
        for(TDALista.Position<PositionList<Vertex<Integer>>> lista: camino3.positions()){
        	System.out.println("");
        	for(TDALista.Position<Vertex<Integer>> elem: lista.element().positions())
            	System.out.print(elem.element().element()+" ");
        }
        
        System.out.println('\n'+"Un camino entre 11 y 5: ");
        PositionList<Vertex<Integer>> camino4= new ListaDoblementeEnlazada<Vertex<Integer>>();
        caminoMasEconomico(grafo, v11, v5, camino4);
        for(TDALista.Position<Vertex<Integer>> elem: camino4.positions())
        	System.out.print(elem.element().element()+" ");
        
        //--------------------------------------------------------------
        
        GrafoConLista<String,Integer> g = new GrafoConLista<String,Integer>();
		
		Vertex<String> bb = g.insertVertex("Bahia Blanca");
		Vertex<String> nqn = g.insertVertex("Neuquen");
		Vertex<String> plott = g.insertVertex("Plottier");
		Vertex<String> bsas = g.insertVertex("Buenos Aires");
		
		try {
			g.insertEdge(bb, nqn, 700);
			g.insertEdge(bb,plott,750);
			g.insertEdge(bb,bsas,750);
			g.insertEdge(nqn, plott, 50);
			g.insertEdge(nqn, bsas, 1500);
			g.insertEdge(plott, bsas, 1550);
			g.insertEdge(plott, plott, 0);
		} catch (InvalidVertexException err) {
			err.printStackTrace();
		}
		 System.out.println('\n'+"DFSLista: ");
	        g.DFS();
	        
	        System.out.println('\n'+"BFSLista: ");
	        g.BFS();
	        
	        System.out.println('\n'+"DFSmain: ");
	        DFS(g);
	        
	        System.out.println('\n'+"BFSMain: ");
	        BFS(g);
	}
	
	//Recorrido por nivel.
	public static<V,E> void BFS(Graph<V,E> g){
		//Marca todos los vértices como no visitados.
		for(Vertex<V> vertice: g.vertices())
			try {
				vertice.put(ESTADO,NOVISITADO);
			} catch (InvalidKeyException e) {
				e.printStackTrace();
			}	
		//Hace BFS con todos los vértices porque puede haber grafos conexos.
		for(Vertex<V> vertice: g.vertices())
			try {
				if(vertice.get(ESTADO)==NOVISITADO)
					BFSAux(g, vertice);
			} catch (InvalidKeyException e) {
				e.printStackTrace();
			}
	}
	private static<V,E> void BFSAux(Graph<V,E> g, Vertex<V> vertice){
		Queue<Vertex<V>> cola= new ColaConLista<Vertex<V>>();
		Vertex<V> actual;
		cola.enqueue(vertice);
		try {
			vertice.put(ESTADO,VISITADO);
		} catch (InvalidKeyException e1) {
			e1.printStackTrace();
		}
		while(!cola.isEmpty())
			try {
				actual=cola.dequeue();
				//Procesar a actual
				System.out.print(actual.element()+" ");
				for(Edge<E> arco: g.incidentEdges(actual)) {
					Vertex<V> opuesto = g.opposite(actual,arco);
					if(opuesto.get(ESTADO)==NOVISITADO){
						cola.enqueue(opuesto);
						opuesto.put(ESTADO, VISITADO);
					}
				}
			} catch (EmptyQueueException | InvalidKeyException | InvalidEdgeException | InvalidVertexException e) {
				e.printStackTrace();
			}
	}

	public static<V,E> void DFS(Graph<V,E> g){
		//Marca todos los vértices como no visitados.
		for(Vertex<V> vertice: g.vertices())
			try {
				vertice.put(ESTADO,NOVISITADO);
			} catch (InvalidKeyException e) {
				e.printStackTrace();
			}
		//Hace DFS con todos los vértices porque puede haber grafos conexos.
		for(Vertex<V> vertice: g.vertices())
			try {
				if(vertice.get(ESTADO)==NOVISITADO)
					DFSAux(vertice, g);
			} catch (InvalidKeyException e) {
				e.printStackTrace();
			}
	}

	private static<V,E> void DFSAux(Vertex<V> vertice, Graph<V,E> g){
		//Procesamiento de vertice, en este caso imprimimos su rótulo
		System.out.print(vertice.element()+" ");
		try {
			vertice.put(ESTADO, VISITADO);
			Iterable<Edge<E>> adyacentes = g.incidentEdges(vertice);
			for(Edge<E> arco: adyacentes) {
				Vertex<V> opuesto = g.opposite(vertice,arco);
				if(opuesto.get(ESTADO)==NOVISITADO)
					DFSAux(opuesto,g);
			}
		}
		catch (InvalidKeyException | InvalidVertexException | InvalidEdgeException e) {
			e.printStackTrace();
		}
	}
	
	public static <V>void caminoMasEconomico
	(Graph<V,Double> grafo, Vertex<V> origen, Vertex<V> destino, PositionList<Vertex<V>> caminoMinimo){
		//Pone todos los vertices como NOVISITADOS.
		for(Vertex<V> vertice: grafo.vertices())
			try {
				vertice.put(ESTADO,NOVISITADO);
			} catch (InvalidKeyException e) {
				e.printStackTrace();
			}
		caminoMasEconomicoAux(grafo, origen, destino, new ListaDoblementeEnlazada<Vertex<V>>(),
				new Solucion(0), caminoMinimo,  new Solucion((2-Math.pow(2, -52))*Math.pow(2, 1023)));
	}
	private static<V> void caminoMasEconomicoAux
	(Graph<V,Double> grafo, Vertex<V> origen, Vertex<V> destino, PositionList<Vertex<V>> caminoActual,
			Solucion costoCaminoActual, PositionList<Vertex<V>> caminoMinimo,Solucion costoCaminoMinimo){
		try {
			origen.put(ESTADO,VISITADO);
			caminoActual.addLast(origen);
			if(origen==destino){
				if(costoCaminoActual.getResultado()<costoCaminoMinimo.getResultado()){
					costoCaminoMinimo.setResultado(costoCaminoActual.getResultado());
					copiar(caminoMinimo, caminoActual);
				}
			}
			else{
				for(Edge<Double> arco: grafo.incidentEdges(origen)){
                    if(grafo.opposite(origen, arco).get(ESTADO)==NOVISITADO){
                    	//costoCaminoActual.setResultado(costoCaminoActual.getResultado()+(double)arco.element());
                    	caminoMasEconomicoAux(grafo,grafo.opposite(origen, arco), destino,
                    	caminoActual, new Solucion (costoCaminoActual.getResultado()+(double)arco.element()), caminoMinimo, costoCaminoMinimo);
                    }
				}
			}
		  caminoActual.remove(caminoActual.last());
		  origen.put(ESTADO, NOVISITADO);
		}
		catch (InvalidKeyException | InvalidPositionException | EmptyListException |InvalidEdgeException | InvalidVertexException e) {
			e.printStackTrace();
		}

	}

	private static<V> void copiar(PositionList<Vertex<V>> en, PositionList<Vertex<V>> esto) {
	   //remuevo todo de la lista a la que voy a copiar (caminoMinimo)
		while(!en.isEmpty())
			try {
				en.remove(en.first());
			} catch (InvalidPositionException | EmptyListException e) {
				e.printStackTrace();
			}
		//copio los elementos de esto(caminoActual) en en(caminoMinimo)
		for(TDALista.Position<Vertex<V>> elem: esto.positions()){
			en.addLast(elem.element());
		}
	}
	
	public static <V,E>void caminoMasCorto
	(Graph<V,E> grafo, Vertex<V> origen, Vertex<V> destino, PositionList<Vertex<V>> caminoMinimo){
		//Pone todos los vertices como NOVISITADOS.
		for(Vertex<V> vertice: grafo.vertices())
			try {
				vertice.put(ESTADO,NOVISITADO);
			} catch (InvalidKeyException e) {
				e.printStackTrace();
			}
		caminoMasCortoAux(grafo, origen, destino, new ListaDoblementeEnlazada<Vertex<V>>(),
				new Solucion(0), caminoMinimo,  new Solucion(2147483647));
	}
	private static<V,E> void caminoMasCortoAux
	(Graph<V,E> grafo, Vertex<V> origen, Vertex<V> destino, PositionList<Vertex<V>> caminoActual,
			Solucion cantCaminoActual, PositionList<Vertex<V>> caminoMinimo,Solucion cantCaminoMinimo){
		try {
			origen.put(ESTADO,VISITADO);
			caminoActual.addLast(origen);
			if(origen==destino){
				if(cantCaminoActual.getResultado()<cantCaminoMinimo.getResultado()){
					cantCaminoMinimo.setResultado(cantCaminoActual.getResultado());
					copiar(caminoMinimo, caminoActual);
				}
			}
			else{
				for(Edge<E> arco: grafo.incidentEdges(origen)){
                    if(grafo.opposite(origen, arco).get(ESTADO)==NOVISITADO){
                    	cantCaminoActual.setResultado(cantCaminoActual.getResultado()+1);
                    	caminoMasCortoAux(grafo,grafo.opposite(origen, arco), destino,
                    	caminoActual, cantCaminoActual, caminoMinimo, cantCaminoMinimo);
                    }
				}
			}
		  cantCaminoActual.setResultado(cantCaminoActual.getResultado()-1);
		  caminoActual.remove(caminoActual.last());
		  origen.put(ESTADO, NOVISITADO);
		}
		catch (InvalidKeyException | InvalidPositionException | EmptyListException |InvalidEdgeException | InvalidVertexException e) {
			e.printStackTrace();
		}

	}
	
	public static <V,E>void todosLosCaminos
	(Graph<V,E> grafo, Vertex<V> origen, Vertex<V> destino, PositionList<PositionList<Vertex<V>>> todos){
		//Pone todos los vertices como NOVISITADOS.
		for(Vertex<V> vertice: grafo.vertices())
			try {
				vertice.put(ESTADO,NOVISITADO);
			} catch (InvalidKeyException e) {
				e.printStackTrace();
			}
		todosLosCaminosAux(grafo, origen, destino, new ListaDoblementeEnlazada<Vertex<V>>(),
				todos);
	}
	private static<V,E> void todosLosCaminosAux
	(Graph<V,E> grafo, Vertex<V> origen, Vertex<V> destino, PositionList<Vertex<V>> caminoActual,
			PositionList<PositionList<Vertex<V>>> todos){
		try {
			origen.put(ESTADO,VISITADO);
			caminoActual.addLast(origen);
			if(origen==destino){
				PositionList<Vertex<V>> copia=new ListaDoblementeEnlazada<Vertex<V>>();
				copiar(copia,caminoActual);
				todos.addLast(copia);
				}
			else{
				for(Edge<E> arco: grafo.incidentEdges(origen)){
                    if(grafo.opposite(origen, arco).get(ESTADO)==NOVISITADO)
                    	todosLosCaminosAux(grafo,grafo.opposite(origen, arco), destino,
                    	caminoActual, todos);
				}
			}
		  caminoActual.remove(caminoActual.last());
		  origen.put(ESTADO, NOVISITADO);
		}
		catch (InvalidKeyException | InvalidPositionException | EmptyListException |InvalidEdgeException | InvalidVertexException e) {
			e.printStackTrace();
		}

	}
	
	public static <V,E>void unCamino
	(Graph<V,E> grafo, Vertex<V> origen, Vertex<V> destino, PositionList<Vertex<V>> camino){
		//Pone todos los vertices como NOVISITADOS.
		for(Vertex<V> vertice: grafo.vertices())
			try {
				vertice.put(ESTADO,NOVISITADO);
			} catch (InvalidKeyException e) {
				e.printStackTrace();
			}
		unCaminoAux(grafo, origen, destino, camino);
	}
	private static<V,E> void unCaminoAux
	(Graph<V,E> grafo, Vertex<V> origen, Vertex<V> destino, PositionList<Vertex<V>> camino){
		try {
			origen.put(ESTADO,VISITADO);
			camino.addLast(origen);
			if(origen!=destino){
				for(Edge<E> arco: grafo.incidentEdges(origen)){
                    if(grafo.opposite(origen, arco).get(ESTADO)==NOVISITADO)
                    	unCaminoAux(grafo,grafo.opposite(origen, arco), destino,
                    	camino);
				}
			}
		  camino.remove(camino.last());
		}
		catch (InvalidKeyException | InvalidPositionException | EmptyListException |InvalidEdgeException | InvalidVertexException e) {
			e.printStackTrace();
		}
	}
}
