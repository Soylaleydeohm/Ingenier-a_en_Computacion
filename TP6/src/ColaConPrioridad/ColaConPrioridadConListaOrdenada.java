package ColaConPrioridad;

import java.util.Comparator;

import TDALista.*;


    /**
     *Implementación de COLA CON PRIORIDAD mediante una Lista (previamente ordenada)
     *Fast removals and slow insertions
     */
	public class ColaConPrioridadConListaOrdenada<k, v> implements PriorityQueue<k,v>{
		
		protected PositionList<Entry<k,v>> elems;
		protected Comparator<k> comp;
		
		public static class Entrada <k,v> implements Entry<k,v>
		{   private k clave;
			private v valor;
			
			public Entrada (k key, v value)
			{ clave=key; valor= value; }
			
			public k getKey() {return clave;}	
			public v getValue() {return valor;}
			public String toString()
			{String cadena=" Clave: "+clave+" Valor: "+valor; return cadena;}
			
		}
		
		public ColaConPrioridadConListaOrdenada (Comparator<k> comp)
		{ elems = new ListaDoblementeEnlazada<Entry<k,v>> ();
		  this.comp=comp;
		  }
		
		public ColaConPrioridadConListaOrdenada (){ 
			this(new DefaultComparator<k>());
		  }
		
		public Entry<k,v> insert (k key, v value) throws InvalidKeyException{
			checkKey(key);
			Entry<k,v> entrada=new Entrada<k,v>(key,value);
			insertEntrada(entrada);           //metodo aux					
			return entrada;
		}

		public void insertEntrada(Entry<k,v> e){		 
			try{
			Position<Entry<k,v>> actionPos=null;    //posicion de la entrada ingresada
			if (elems.isEmpty()){
				elems.addFirst(e);
			    actionPos=elems.first();
			}
			else if (comp.compare(e.getKey(),elems.last().element().getKey())>0)
				{	elems.addLast(e);
					actionPos=elems.last();}
				else
					{Position<Entry<k,v>> current=elems.first();
					 while(comp.compare(e.getKey(),current.element().getKey())>0)
					 	{current=elems.next(current);           //me corro hasta la posicion de insercion adecuada
					 	}
					 elems.addBefore(current,e);
					 actionPos=elems.prev(current);
					}
			}catch (EmptyListException | InvalidPositionException | BoundaryViolationException ez ){System.out.println(ez.getMessage());}
		}
	
		public boolean isEmpty() {return elems.isEmpty();}

		public Entry<k,v> min() throws EmptyPriorityQueueException {
			if (elems.isEmpty()) throw new EmptyPriorityQueueException("¡Cola c/ prioridad vacía!");
			
			Entry<k,v> entry=null;
			try {
				entry=elems.first().element();
			} catch (EmptyListException e) {}
			return entry;
		}

		public Entry<k,v> removeMin() throws EmptyPriorityQueueException {
			if(elems.isEmpty())
				throw new EmptyPriorityQueueException ("EMPTY QUEUE");
/*			Entry<k,v> min=null;
			try{
			min=elems.remove(elems.first());
			}catch(EmptyListException | InvalidPositionException e){System.out.println("LISTA VACIA");}
			
			return min;*/
			try {
				return elems.remove(elems.first());
			} catch (InvalidPositionException | EmptyListException e) {
				e.printStackTrace();
				return null;
			}
		}

		public int size() {
			return elems.size();
		}

		public k checkKey (k key) throws InvalidKeyException
		{  	k clave;
		if(key == null)throw new InvalidKeyException("INVALID KEY");
			try{
			clave = (k)key;
		}catch (ClassCastException e){throw new InvalidKeyException("INVALID KEY");}
			
		return clave;
		}
	}