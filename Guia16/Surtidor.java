
public class Surtidor
{
    //Atributos de clase
    private int maximaCarga = 2000;
    
    //Atributos de instancia
    private int cantGasoil;
    private int cantSuper;
    private int cantPremium;
    
    //Constructor
    public Surtidor()
    {
        cantGasoil = maximaCarga;
        cantSuper = maximaCarga;
        cantPremium = maximaCarga;        
    }
    
    //Comandos
    public void llenarDepositoGasoil()
    {
        cantGasoil = maximaCarga;
    }
    
    public void llenarDepositoSuper()
    {
        cantSuper = maximaCarga;
    }
    
    public void llenarDepositoPremium()
    {
        cantPremium = maximaCarga;
    }
    
    public void extraerGasoil(int l)
    {
        cantGasoil -= l;
    }
    
    public void extraerSuper(int l)
    {
        cantSuper -= l;
    }
    
    public void extraerPremium(int l)
    {
        cantPremium -= l;
    }
    
    //Consultas
    
    public int obtenerLitrosGasoil()
    {
        return cantGasoil;
    }
    
    public int obtenerLitrosSuper()
    {
        return cantSuper;
    }
    
    public int obtenerLitrosPremium()
    {
        return cantPremium;
    }
   
}
