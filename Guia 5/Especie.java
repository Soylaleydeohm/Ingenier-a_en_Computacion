
public class Especie
{
    //Atributos de instancia 
    private String nombre;
    private int machos;
    private int hembras;
    private float ritmo;
    
    //Constructor
    public Especie (String nom)
    {
        nombre = nom;
        machos = 0;
        hembras = 0;
        ritmo = 0;        
    }
    
    //Comandos 
    public void establecerHembras(int h)
    {
        hembras = h;
    }
    
    public void establecerMachos (int m)
    {
        machos = m;       
    }
    
    public void establecerRitmo (float r)
    {
        ritmo = r;
    }
    
    public void actualizarHembras (int h)
    {
        hembras += h;
        if (hembras < 0)
            hembras = 0;            
    }
    
    public void actualizarMachos (int m)
    {
        machos += m;
        if (machos < 0)
            machos = 0;
    }
    
    public void actualizarRitmo (float r)
    {
        ritmo += r;
    }
    
    //Consultas
    public int poblacionActual()
    {
        return machos+hembras;
    }
    
    public int poblacionEstimada (int anios)
    {
        int rit = (int) ritmo;//Casting
        int pE = poblacionActual() + rit*anios;
        if (pE < 0)
            pE = 0;
        return pE;
    }
    
    public int anios(int pob)
    {
        int rit = (int) ritmo;//Casting
        int a = (pob - poblacionActual())/rit;
        return a;
    }
    
    public String riesgo()
    {
        String rExt;
        if (ritmo > 0)
            rExt = "verde";
        else if (ritmo == 0)
            rExt = "amarillo";
        else 
            rExt = "rojo";
        return rExt;
    }
    
    public boolean masHembras()
    {
        return (hembras > machos);
    }
    
    public Especie mayorRitmo(Especie est)
    {
        Especie esp;
        if (ritmo > est.obtenerRitmo())
            esp = this;
        else 
            esp = est;
        return esp;
    }
    
    public float obtenerRitmo()
    {
        return ritmo;
    }
    
    public String toString()
    {
        return "Esta especie tiene " + hembras + " hembras y " + machos + " machos. El ritmo de crecimiento es " + ritmo + ".";
    }
}
