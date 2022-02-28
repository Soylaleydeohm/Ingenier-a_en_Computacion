public class SectoresFabrica
{
    protected Robot[] T;

    //--------------------------------------------------------
    //---- Constructor
    //--------------------------------------------------------

    public SectoresFabrica(int max) 
    {
        /*
         * Crea un arreglo con max elementos, y lo inicializa con null en cada componente
         * Cada elemento representa un sector de la fábrica
         */
        T = new Robot [max];
        for (int i = 0; i < max; i++) {
            T[i] = null;
        }
    }

    //--------------------------------------------------------
    //---- Comandos
    //--------------------------------------------------------

    public void asignar (Robot r) 
    {
        /*
         * Busca el primer sector libre y asigna el robot r al sector. 
         * Requiere que haya un sector libre
         */
        int i = 0;
        while (T[i] != null) {
            i++; 
        }
        T[i] = r;
    }

    public void asignar(Robot r, int s) 
    {
        /*
         * Asigna el robot r al sector s. 
         * Requiere 0 <= s < cantSectores() 
         */
        T[s] = r;   
    }

    public void desasignar(int s) 
    {
        /*
         * Elimina la asignacion del robot r del sector s. 
         * Requiere 0 <= s < cantSectores()
         */
        T[s] = null;   
    }

    public void desasignar(Robot r) 
    {
        /*
         * Elimina la asignacion del robot r de todos los sectores a los que esta asignado
         */
        int i = 0; 
        while (i < cantSectores()) {
            if (T[i] == r) {
                T[i] = null;
            }
            i++; 
        }
    }

    //--------------------------------------------------------
    //---- Consultas
    //--------------------------------------------------------

    public boolean sectorOcupado(int s)
    {
        /*
         * Determina si un sector esta ocupado por un robot.
         * Requiere 0 <= s < cantSectores()
         */
        return T[s] != null;
    }
    
    public int cantSectores()
    {
        return T.length;
    }

    public int cantSectoresOcupados()
    {
        int i = 0; 
        int cant = 0;
        while (i < cantSectores()) {
            if (T[i] != null) {
                cant++;
            }
            i++; 
        }
        return cant;
    }

    public boolean todosOcupados()
    {
        int i = 0; 
        boolean hayNulo= false;
        while (i < cantSectores() && !hayNulo ) {
            hayNulo = (T[i] == null);
            i++; 
        }
        return !hayNulo;
    }

    public boolean estaRobot(Robot r)
    {
        /* 
         * Decide si algun sector tiene asignado un robot con la misma identidad que r 
         */
        int i = 0; 
        boolean esta = false;
        while (i < cantSectores() && !esta ){
            esta = (T[i] == r);
            i++; 
        }
        return esta;
    } 

    public boolean existeSector(int s)
    {
        return (s >= 0) && (s < cantSectores());
    }

    public Robot robotSector(int s)
    {
        /*
         * Retorna el Robot en un sector s. 
         * Requiere 0 <= s < cantSectores()
         */
        return T[s];
    }

    public int cantMasAutos(int a)
    {
        /*
         * Cuenta la cantidad de sectores asignados a robots que pueden armar mas de "a" autos
         */
        int cont =0;
        for (int i=0;i<cantSectores();i++) {
            if (T[i] != null) {
                if(T[i].cantAutos() > a) {
                    cont++;
                }
            }
        }
        return cont;
    }
    
    /**
     * 
     * @todo: Implementar las siguientes consultas:
     * 
     *  + dosConsecutivosMaxEnergia(): boolean
     *     |_ determina si existen dos robots en posiciones consecutivas con la energía igual al maximo. 
     *      
     *  + robotsPuedenArmarNAutos(n: entero): SectoresFabrica
     *     |_ genera una nueva tabla con los robots que pueden armar mas de n autos con las piezas que tienen disponibles.
     *
     */
    
    public boolean dosConsecutivosMaxEnergia()
    {
        boolean dos = false;
        int i = 0;
        while (i < (T.length - 1) && !dos)
        {
            if (T[i] != null && T[i + 1] != null)
            {
                if (T[i].obtenerEnergia() == Robot.obtenerEnergiaMax()) //Porque es método estático
                    dos = (T[i].obtenerEnergia() == T[i + 1].obtenerEnergia());
            }
            i++;
        }
        return dos;
    }
    
    public SectoresFabrica robotsPuedenArmarNAutos (int n)
    {
        SectoresFabrica nueva = new SectoresFabrica(T.length);
        for (int i = 0; i < T.length; i++)
        {
            if (T[i] != null)
            {
                if (T[i].cantAutos() > n)
                    nueva.asignar(T[i], i);
            }
        }
        return nueva;
    }

}