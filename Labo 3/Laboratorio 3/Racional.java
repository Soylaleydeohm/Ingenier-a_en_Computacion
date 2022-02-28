public class Racional
{
    //------------------------------------------------------------
    //---- Atributos ---------------------------------------------
    //------------------------------------------------------------
    private int num;
    private int den;

    //------------------------------------------------------------
    //---- Constructor -------------------------------------------
    //------------------------------------------------------------

    public Racional (int num, int den) { 
        // Requiere den > 0
        this.num = num;
        this.den = den;
        this.simplificar();
    }

    //------------------------------------------------------------    
    //---- Comandos ----------------------------------------------
    //------------------------------------------------------------

    public void establecerNum (int n) {
        /**
         * @todo: mantener la representación reducida
         */
        num = n;
    }

    public void establecerDen (int d) {
        // Requiere d >0
        /**
         * @todo: mantener la representación reducida
         */
        den = d;
    }

    private void simplificar()
    {
        /**
         * @todo: implementar la reducción del estado interno
         */
        int divisor;
        if (num != 0){            
            divisor = Util.mcd(num, den);
            num/= divisor;
            den/= divisor;
        }
    }
    
    /**
     * @todo: implementar copy
     */
    public void copy(Racional rac)
    {
        num = rac.obtenerNum();
        den = rac.obtenerDen();
    }
    
    //------------------------------------------------------------    
    //---- Consultas ---------------------------------------------
    //------------------------------------------------------------

    public int obtenerNum() 
    {
        return num;
    }

    public int obtenerDen() 
    {
        return den;
    }

    /**
     * @todo: implementar equals, clone y toString
     */
    
    public boolean equals(Racional rac)
    {
        /*Retorna true sí y solo sí el estado interno del objeto que recibe el mensaje mantiene los mismos valores que el estado interno del objeto rac. Requiere rac ligado. */
        return num == rac.obtenerNum() && den == rac.obtenerDen();        
    }
    
    public Racional clone ()
    {
        return new Racional(num, den);
    }
    
    public String toString()
    {
    return num+"/"+den;
    }

    /**
     * @todo: Implementar operaciones aritmeticas
     * suma(rac: Racional): Racional
     * resta(rac: Racional): Racional
     * multiplicacion(rac: Racional): Racional
     * cociente(rac: Racional): Racional
     */
    
    public Racional suma(Racional rac)
    {
        int nums, dens;
        nums = num * rac.obtenerDen() + den * rac.obtenerNum();
        dens = den * rac.obtenerDen();
        return new Racional(nums, dens);
    }
    
    public Racional resta(Racional rac)
    {
        int nums, dens;
        nums = num * rac.obtenerDen() - den * rac.obtenerNum();
        dens = den * rac.obtenerDen();
        return new Racional(nums, dens);
    }
    
    public Racional producto(Racional rac)
    {
        int nums, dens;
        nums = num * rac.obtenerNum();
        dens = den * rac.obtenerDen();
        return new Racional(nums, dens);
    }
    
    public Racional cociente(Racional rac)
    {
        int nums, dens;
        nums = num * rac.obtenerDen();
        dens = den * rac.obtenerNum();
        return new Racional(nums, dens);
    }
}
