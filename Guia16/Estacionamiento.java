public class Estacionamiento
{
    //Atributos de instancia
    private boolean [] lugares;
    private int cant;
    
    //Constructor
    public Estacionamiento (int capacidad)
    {
        lugares = new boolean[capacidad];
        cant = 0;
        for(int i = 0; i < capacidad; i++)
        {
            lugares [i] = false;
        }
    }
    
    //Comandos
    public void ocupar (int i)
    {
        lugares [i] = true;
        cant++;
    }
    
    public void liberar (int i)
    {
        lugares [i] = false;
        cant--;
    }
    
    //Consultas
    public int capacidad()
    {
        return lugares.length;
    }
    
    public boolean estaOcupado(int i)
    {
        return lugares[i];
    }
    
    public boolean estaLleno()
    {
        return (cant == lugares.length);
    }
    
    public int primerDisponible()
    {
        int disponible = 0;        
        while(disponible < lugares.length && lugares[disponible])
            disponible++;
        return disponible;
    }
}
