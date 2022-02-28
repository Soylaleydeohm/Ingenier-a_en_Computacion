
public class PasajesReservados
{
    //Atributos de instancia
    private ReservaPasaje T [];
    private int cantPasajes;
    
    //Constructor
    public PasajesReservados(int n)
    {
        T = new ReservaPasaje[n];
        cantPasajes = 0;
    }
    
    //Comandos
    public void insertar (ReservaPasaje r)
    {
        T[cantPasajes] = r;
        cantPasajes++;
    }
    
    public void eliminar (ReservaPasaje r)
    {
        int i = 0;
        boolean encontre = false;
        while(i < cantPasajes && !encontre)
        {
            encontre = (T[i] == r);    
            i++;
        }
        if(encontre)
        {
            T[i-1] = null;
            correrUno(i-1);
        }
    }
    
    private void correrUno(int n)
    {
        for (int i = n; i < cantPasajes-1; i++)
        {
            T[i] = T[i+1];
        }
        T[cantPasajes-1] = null;
        cantPasajes--;
    }
    
    //Consultas
    public boolean estaLlena()
    {
        return (T.length == cantPasajes);
    }
    
    public boolean hayReservas()
    {
        return (cantPasajes > 0);
    }
    
    public ReservaPasaje obtenerElemento(int p)
    {
        return T[p];
    }
    
    public ReservaPasaje recuperarElemento (String p)
    {
        ReservaPasaje rP = null;
        boolean encontre = false;
        int i = 0;
        while (i < cantPasajes && !encontre)
        {
            encontre = (T[i].obtenerCodigo().equals(p));
            i++;
        }
        if (encontre)
            rP = T[i-1];
        return rP;
    }
}
