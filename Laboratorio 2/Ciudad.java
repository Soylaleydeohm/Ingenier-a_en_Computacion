public class Ciudad
{
    //-------------------------------------------------------------
    //---- Atributos ----------------------------------------------
    //-------------------------------------------------------------

    private int CP;
    private int poblacion;
    private float superficie;

    //-------------------------------------------------------------
    //---- Constructores ------------------------------------------
    //-------------------------------------------------------------
    
    public Ciudad ( int c) 
    { 
    	CP = c;
    }
    
    public Ciudad (int c, int p, float s) 
    {
    	CP = c; 
    	poblacion = p; 
    	superficie = s; 
    }

    //-------------------------------------------------------------
    //---- Comandos -----------------------------------------------
    //-------------------------------------------------------------

    public void establecerPoblacion(int p) 
    { 
    	poblacion = p;
    }
    
	/**
	 * Completar la implementacion de los comandos:
	 *   + establecerSuperficie (sup: real)
	 *   + aumentarPoblacion (cre: entero)
	 */
	
    //-------------------------------------------------------------
    //---- Consultas ----------------------------------------------
    //-------------------------------------------------------------
    
    public int obtenerCP()
    {
        return CP;
    }
	
	/**
	 * Completar la implementacion de las consultas:
	 *   + obtenerPoblacion(): entero
	 *   + obtenerSuperficie(): real
	 *   + obtenerDensidad(): real
	 *   + toString(): String	 
	 */
    
}
