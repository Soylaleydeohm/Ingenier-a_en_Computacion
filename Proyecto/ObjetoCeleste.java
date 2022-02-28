
public class ObjetoCeleste
{
    //Atributos de instancia
    protected String nombre;
    protected String constelacion;
    protected String descubierto;
    protected String aDescubierto;
    protected String tipo;
    protected String mayorDiam;
    protected String menorDiam;
    protected String redshift;
    protected String distanciaZ;
    protected String distanciaNED;  
    
    //constructor
    public ObjetoCeleste(String name, String cons, String desc, String aDesc, String type, String x, String y, String z, String distZ, String distNED)
    {
        nombre = name;
        constelacion = cons;
        descubierto = desc;
        aDescubierto = aDesc;
        tipo = type;
        mayorDiam = x;
        menorDiam = y;
        redshift = z;
        distanciaZ = distZ;
        distanciaNED = distNED;  
    }
    
    //Consultas 
    public String obtenerNombre()
    {
        return nombre;
    }
    
    public String obtenerTipo()
    {
        return tipo;
    }
    
    public String obtenerDistanciaZ()
    {
        return distanciaZ;
    }
    
    public String obtenerConstelacion()
    {
        return constelacion;
    }
    
    public String obtenerDesc()
    {
        return descubierto;
    }
    
    public String obtenerADesc()
    {
        return aDescubierto;
    }
    
    public String obtenerDistanciaNED()
    {
        return distanciaNED;
    }
    
        public String obtenerMayorDiam()
    {
        return mayorDiam;
    }
    
    public String obtenerMenorDiam()
    {
        return menorDiam;
    }
    
    public String obtenerRedshift()
    {
        return redshift;
    }
    

}
