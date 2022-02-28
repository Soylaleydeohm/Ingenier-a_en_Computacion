public class Robot
{
    //--------------------------------------------------------
    //---- Atributos de clase
    //--------------------------------------------------------

    protected static final int energiaMaxima = 5000;
    protected static final int energiaMinima = 100;

    //--------------------------------------------------------
    //---- Atributos de instancia
    //--------------------------------------------------------

    protected int nroSerie;
    protected int cantRecargas;
    protected int energia;
    protected int ruedas;
    protected int opticas;
    protected int chasisA;

    //--------------------------------------------------------
    //---- Constructor
    //--------------------------------------------------------

    public Robot (int nro)
    {
        nroSerie = nro;
        energia = energiaMaxima;
        ruedas = 100;
        opticas = 100;
        chasisA = 100;
    }

    //--------------------------------------------------------
    //---- Comandos
    //--------------------------------------------------------

    public void recargar()
    {
        energia = energiaMaxima;
        cantRecargas++;
    }

    public void armarAuto() 
    {
        /*
         * Requiere que se haya controlado si hay piezas disponibles
         */
        ruedas -= 4 ; 
        opticas -= 4;
        energia -= 70;
        chasisA--;
        /*
         * Controla  si es necesario recargar energia
         */
        if (energia < energiaMinima) {
            this.recargar(); 
        }
    } 

    //--------------------------------------------------------
    //---- Consultas
    //--------------------------------------------------------

    public int obtenerNroSerie()
    {
        return nroSerie;
    }

    public int obtenerEnergia()
    {
        return energia;
    }

    public int obtenerRuedas()
    {
        return ruedas;
    }

    public int obtenerOpticas()
    {
        return opticas;
    }

    public int obtenerChasisA()
    {
        return chasisA;
    }

    public String toString()
    {
        return "Nro. Serie: " + nroSerie + " - Energia: " + energia + " - Ruedas: " + ruedas + " - Opticas: " + opticas + " - Chasis de auto: " + chasisA;
    }

    public int vidaUtil()
    {
        return 1000-cantRecargas;
    }

    public int cantAutos() {
        /*
         * Calcula la cantidad de autos segun las piezas, no considera la energia requerida
         */
        int n;
        if (ruedas/4 < opticas/4) {
            if (ruedas/4 < chasisA) {
                n = (int) ruedas/4;
            }
            else  {
                n = chasisA;
            }
        } else {
            if (ruedas/4 < chasisA) {
                n = (int) opticas/4;
            }  else { 
                n = chasisA;
            }
        }
        return n;
    }

}