public class Fabrica
{
    protected Robot[] C;
    protected int cant;

    //--------------------------------------------------------
    //---- Constructor
    //--------------------------------------------------------

    public Fabrica(int max) 
    {
        /*
         * Crea un arreglo con max elementos, y lo inicializa con null en cada componente
         */
        C = new Robot[max];
        for (int i = 0; i < max; i++) {
            C[i] = null;
        }
        cant = 0;
    }

    //--------------------------------------------------------
    //---- Comandos
    //--------------------------------------------------------

    /**
     * Es responsabilidad del cliente controlar que haya lugar antes de asignar un Robot.
     */
    public void asignar (Robot r) 
    {
        C[cant++] = r;
    }

    
    public void desasignar(Robot r) 
    {
        boolean encontre = false;
        for (int i = 0; i < cant; i++)
        {
            if (C[i].obtenerNroSerie() == r.obtenerNroSerie())
            {
                C[i] = null;
                encontre = true;
                cant--;
            }
            if(encontre)
            {
                C[i] = C[i + 1];
            }
        }
        C[cant] = null;
    }
    

    //--------------------------------------------------------
    //---- Consultas
    //--------------------------------------------------------
    
    public int capacidadTotal()
    {
        return C.length;
    }

    public int capacidadOcupada()
    {
        return cant;
    }

    public boolean estaRobot(Robot r)
    {
        int i = 0; 
        boolean esta = false;
        while (i < cant && !esta ){
            esta = (C[i] == r);
            i++; 
        }
        return esta;
    } 
    
    /**
     * El cliente es responsable de validar que la posicion sea valida
     * 0 <= pos < capacidadOcupada()
     */
    public Robot robotEnPosicion(int pos)
    {
        return C[pos];
    }
    
    /**
     * 
     * @todo: Implementar las siguientes consultas:
     * 
     *  + existenNRobotsVU(n: int, vu: int): boolean
     *     |_ decide si existen n robots con una vida util mayor a vu.
     *      
     *  + equals(otra: Fabrica): boolean
     *     |_ decide si dos colecciones son iguales, comparando los elementos por identidad (nroSerie)
     *
     */
    public boolean existenNRobotsVU(int n, int vu)
    {
        boolean encontre = false;
        int nRobots = 0;
        for (int i = 0; i < cant && !encontre; i++)
        {
            if (C[i].vidaUtil() > vu)
                nRobots++;
            else 
                nRobots = 0;
            encontre = (nRobots >= n);
        }
        return encontre;
    }
    
    public boolean equals (Fabrica otra)
    {
        boolean iguales = (cant == otra.capacidadOcupada());
        if (iguales)
        {
            for (int i = 0; i < cant && iguales; i++)
            {
                iguales = (C[i].obtenerNroSerie() == robotEnPosicion(i).obtenerNroSerie());
            }
        }
        return iguales;
    }
}
