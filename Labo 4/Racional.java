public class Racional
{
    //----------------------------------------------------------------------------------------------
    //---- Atributos -------------------------------------------------------------------------------
    //----------------------------------------------------------------------------------------------

    private int num;
    private int den;

    //----------------------------------------------------------------------------------------------
    //---- Constructor -----------------------------------------------------------------------------
    //----------------------------------------------------------------------------------------------
    
    public Racional (int num, int den) 
    { 
        this.num = num;
        this.den = den;
        this.simplificar();
    }

    //----------------------------------------------------------------------------------------------
    //---- Comandos --------------------------------------------------------------------------------
    //----------------------------------------------------------------------------------------------

    public void establecerNum (int n)
    {
        num = n;
        this.simplificar();
    }

    public void establecerDen (int d)
    {
        den = d;
        this.simplificar();
    }
	
	public void copy(Racional r)
	{
		num = r.obtenerNum();
		den = r.obtenerDen();
	}
    
    private void simplificar()
    {
        if (num != 0) {
			int mcd = Util.mcd(num, den);
			num /= mcd;
			den /= mcd;
		}
    }
    
    //----------------------------------------------------------------------------------------------
    //---- Consultas -------------------------------------------------------------------------------
    //----------------------------------------------------------------------------------------------
    
    public int obtenerNum()
    {
        return num;
    }
    
    public int obtenerDen()
    {
        return den;
    }
    
    public String toString()
    {
        if ((den == 1) || (num == 0)) {
            return num + "";
        } else {
            return num + "/" + den;
        }
    }
    
    public boolean equals(Racional r)
    {
        return (num == r.obtenerNum()) && (den == r.obtenerDen());
    }
	
	public Racional clone()
	{
		return new Racional(num, den);
	}
    
    //----------------------------------------------------------------------------------------------
    //---- Operaciones aritmeticas -----------------------------------------------------------------
    //----------------------------------------------------------------------------------------------
    
    public Racional suma(Racional rac)
    {
        int n = num * rac.obtenerDen() + rac.obtenerNum() * den;
        int d = rac.obtenerDen() * den;
        return new Racional(n, d); // El constructor lo simplifica de ser necesario.
    }
    
    public Racional resta(Racional rac)
    {
        int n = num * rac.obtenerDen() - rac.obtenerNum() * den;
        int d = rac.obtenerDen() * den;
        return new Racional(n, d); // El constructor lo simplifica de ser necesario.
    }
    
    public Racional producto(Racional rac)
    {
        int n = num * rac.obtenerNum();
        int d = rac.obtenerDen() * den;
        return new Racional(n, d); // El constructor lo simplifica de ser necesario.
    }
    
    public Racional cociente(Racional rac)
    {
		int n;
		int d;
		if (rac.obtenerNum() == 0) {
			// Caso especial: como no puede ser cero el resuldato del denominador, 
			// tomamos la decision de fijar el resultado en 0/1
			n = 0;
			d = 1;
		} else { 
		    n = num * rac.obtenerDen();
			d = rac.obtenerNum() * den;
		}	
        return new Racional(n, d); // El constructor lo simplifica de ser necesario.
    }

}
