
public class RobotBeta extends Robot
{
    //--------------------------------------------------------
    //---- Atributos de instancia
    //--------------------------------------------------------

    private int chasisAv;
    private int alas;

    //--------------------------------------------------------
    //---- Constructor
    //--------------------------------------------------------

    public RobotBeta (int nro)
    {
        super(nro);
        chasisAv = 200;
        alas = 400;
    }

    //--------------------------------------------------------
    //---- Comandos
    //--------------------------------------------------------

    public void armarAvion() {
        /*
         * Requiere que se haya controlado si hay piezas disponibles
         */
        ruedas -= 3 ; 
        opticas -= 2;
        alas -= 2;
        energia -= 100;
        chasisAv --;
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
        return super.toString() + " - Chasis de avion: " + chasisAv + " - Alas: " + alas;
    }
    
    public int vidaUtil()
    {
        return 1000 - 2*cantRecargas;
    }

    public int cantAviones()
    {
        /*
         * Calcula la cantidad de aviones segun las piezas, no considera la energia requerida
         */
        int n;
        if (ruedas / 3 < opticas / 2) {
            if (ruedas / 3 < chasisAv) {
                if (ruedas / 3 < alas / 2)
                    n = (int) ruedas / 3;
                else 
                    n = (int) alas / 2;
            } else {
                if (alas / 2 < chasisAv)
                    n = (int) alas / 2;
                else 
                    n = chasisAv;
            }
        } else {
            if (ruedas / 3 < chasisAv) {
                if (ruedas / 3 < alas / 2)
                    n = (int) ruedas / 3;
                else 
                    n = (int) alas / 2;
            } else {
                if (alas / 2 < chasisAv)
                    n = (int) alas / 2;
                else 
                    n = chasisAv;
            }
        }
        return n;
    }

}
