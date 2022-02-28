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
    }
    
    /**
     * @todo: implementar copy
     */
    
    //------------------------------------------------------------    
    //---- Consultas ---------------------------------------------
    //------------------------------------------------------------

    public int obtenerNum() {
        return num;
    }

    public int obtenerDen() {
        return den;
    }

    /**
     * @todo: implementar equals, clone y toString
     */

    /**
     * @todo: Implementar operaciones aritmeticas
     */
}
