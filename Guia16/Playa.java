
public class Playa
{
    //Atributos de instancia
    private Surtidor [] surtidores;
    private int n;
    
    //Constructor
    public Playa (int cap)
    {
        surtidores = new Surtidor[cap];
        n = 0;
    }
    
    //Comandos
    
    public void agregarSurtidor()
    {
        surtidores[n] = new Surtidor();
        n++;
    }
    
    public void LlenarDepositosGasoil()
    {
        for (int i = 0; i < n; i++)
        {
            surtidores[i].llenarDepositoGasoil();
        }
    }
    
    public void LlenarDepositosSuper()
    {
        for (int i = 0; i < n; i++)
        {
            surtidores[i].llenarDepositoSuper();
        }
    }
    
    public void LlenarDepositosPremium()
    {
        for (int i = 0; i < n; i++)
        {
            surtidores[i].llenarDepositoPremium();
        }
    }
    
    //Consultas    
    public Surtidor obtenerSurtidor(int p)
    {
        return surtidores[p];
    }
    
    public int obtenerCantidad()
    {
        return n;
    }
}
