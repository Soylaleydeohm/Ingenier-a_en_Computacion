public class RobotAlfa extends Robot
{
    //--------------------------------------------------------
    //---- Atributos de instancia
    //--------------------------------------------------------

    private int chasisC;

    //--------------------------------------------------------
    //---- Constructor
    //--------------------------------------------------------

    public RobotAlfa (int nro)
    {
        super(nro);
        chasisC = 100;
    }

    //--------------------------------------------------------
    //---- Comandos
    //--------------------------------------------------------

    public void armarAuto() {
        /*
         * Requiere que se haya controlado si hay piezas disponibles
         */
        super.armarAuto();
        ruedas -= 1; 
        opticas -=1;
    } 

    public void armarCamion() {
        /*
         * Requiere que se haya controlado si hay piezas disponibles
         */
        ruedas -= 6 ; 
        opticas -=6;
        energia -= 80;
        chasisC --;
        /*
         * Controla  si es necesario recargar  energia
         */
        if (energia < energiaMinima) {
            this.recargar(); 
        }
    } 

    //--------------------------------------------------------
    //---- Consultas
    //--------------------------------------------------------

    public String toString()
    {
        return super.toString() + " - Chasis de camion: " + chasisC;
    }
    
    public int vidaUtil()
    {
        return 5000 - cantRecargas;
    }

    public int cantAutos()
    {
        /*
         * Calcula la cantidad de autos segun las piezas, no considera la energia requerida
         */
        int n;
        if (ruedas / 5 < opticas / 5) {
            if (ruedas/5 < chasisA) {
                n = (int) ruedas / 5;
            } else {
                n = chasisA;
            }
        } else {
            if (ruedas / 5 < chasisA) {
                n = (int) opticas/5;
            } else {
                n = chasisA;
            }
        }
        return n;
    }

    public int cantCamiones()
    {
        /*
         * Calcula la cantidad de camiones segun las piezas, no considera la energia requerida
         */
        int n;
        if (ruedas / 6 < opticas / 5) {
            if (ruedas / 6 < chasisC) {
                n = (int) ruedas/6;
            } else {
                n = chasisC;
            }
        } else {
            if (ruedas / 6 < chasisC) {
                n = (int) opticas/6;
            } else {
                n = chasisC;
            }
        }
        return n;
    }

}