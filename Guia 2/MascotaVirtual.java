
public class MascotaVirtual
{
    // Atributos de clase
    private static final int MAX_ENERGIA = 100;
    private static final int MIN_ENERGIA = 0;
    
    //Atributos de instancia
    private int energia;
    private boolean dormido;
    private int cantDesgaste;
    private int cantComer;
    
    //Constructor    
    public MascotaVirtual()
    {
        energia = MAX_ENERGIA;
        dormido = false;
        cantDesgaste = 0;
        cantComer = 0;        
    }
    
    //Comandos
    public boolean comer()
    {
        boolean comio = false;
        if (cantComer < 5 && !dormido && estaVivo())
        {
            energia += 30;
            cantComer++;
            cantDesgaste = 0;
            comio = true;            
        }
        if (cantComer == 5)
            energia = MIN_ENERGIA;
        if (energia > 100)
            energia = MAX_ENERGIA;
        return comio;
    }
    
    public boolean beber()
    {
        boolean bebio = false;
        if (cantComer < 5 && !dormido && estaVivo())
        {
            energia += 15;
            cantComer++;
            cantDesgaste = 0;
            bebio = true;            
        }
        if (cantComer == 5)
            energia = MIN_ENERGIA;
        if (energia > 100)
            energia = MAX_ENERGIA;
        return bebio;
    }
    
    public boolean dormir ()
    {
        if (estaVivo())
        {
            dormido = true;
            cantDesgaste = 0;
            cantComer = 0;            
        } else
            dormido = false;            
        return dormido;
    }
    
    public boolean despertar ()
    {
        boolean desperto = false;
        if (estaVivo() && dormido)
        {            
            desperto = true;
            energia += 25;            
        }
        return desperto;
    }
    
    public boolean caminar ()
    {
        boolean camino = false;
        if (cantDesgaste < 3 && !dormido && estaVivo())
        {
            camino = true;
            energia -= 15;
            cantDesgaste++;
            cantComer = 0;
        } else if (cantDesgaste == 3)
            dormir ();
        return camino;
    }
    
    public boolean correr ()
    {
        boolean corrio = false;
        if (cantDesgaste < 3 && !dormido && estaVivo())
        {
            corrio = true;
            energia -= 50;
            cantDesgaste++;
            cantComer = 0;
        } else if (cantDesgaste == 3)
            dormir ();
        return corrio;
    }
    
    public boolean saltar ()
    {
        boolean salto = false;
        if (cantDesgaste < 3 && !dormido && estaVivo())
        {
            salto = true;
            energia -= 5;
            cantDesgaste++;
            cantComer = 0;
        } else if (cantDesgaste == 3)
            dormir ();
        return salto;
    }
    
    //Consultas
    public int obtenerEnergia()
    {
        return energia;
    }
    
    public boolean estaDormido()
    {
        return dormido;
    }
    
    public int obtenerCantDesgaste()
    {
        return cantDesgaste;
    }
    
    public int obtenerCantComer()
    {
        return cantComer;        
    }
    
    public int obtenerHumor()
    {
        int humor;
        if (energia < 21)
            humor = 1;
        else if (energia < 41)
            humor = 2;
        else if (energia < 61)
            humor = 3;
        else if (energia < 81)
            humor = 4;
        else 
            humor = 5;
        return humor;
    }
    
    public boolean estaVivo()
    {
        boolean vivo = true;
        if (energia <= 0)
            vivo = false;
        return vivo;        
    }
}
