
public class ReservaPasaje
{
    //Atributos de instancia
    private String codigo;
    private String pasajero;
    private int butaca;
    private boolean confirmada;
    private int fila;
    
    //Constructor
    public ReservaPasaje (String c, String p, int f, int b)
    {
        codigo = c;
        pasajero = p;
        butaca = b;
        fila = f;    
        confirmada = false;
    }
    
    //Comandos    
    public void confirmar()
    {
        confirmada = true;
    }
    
    //Consultas
    public String obtenerPasajero()
    {
        return pasajero;
    }
    
    public String obtenerCodigo()
    {
        return codigo;
    }
    
    public int obtenerButaca()
    {
        return butaca;
    }
    
    public int obtenerFila()
    {
        return fila;
    }
    
    public boolean obtenerConfirmada()
    {
        return confirmada;
    }
}
