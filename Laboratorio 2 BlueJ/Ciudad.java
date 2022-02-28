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
    
       public void establecerSuperficie (float sup){
       superficie = sup;
       }
    
    public void aumentarPoblacion (int cre){
       if (poblacion + cre > 0)
            poblacion += cre;
       else
            poblacion = 0;
       }
       
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
    
    public int obtenerPoblacion(){
        return poblacion;
    }
    
    public float obtenerSuperficie(){
        return superficie;
    }
    
    public float obtenerDensidad(){
        float densidad;
        densidad = poblacion/superficie;
        return densidad;
    }
    
    public String toString(){
        String cadena;
        cadena = "Codigo Postal: " + CP + " - Población: " + poblacion + " habitantes - Superficie: " + superficie + " Km2";
        return cadena;
    }
}
