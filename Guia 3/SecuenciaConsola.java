import IPOO.*;
public class SecuenciaConsola
{
    public static int primer (int n)
    {
        int i = 0;
        boolean seguir = true;
        int s = 0;
        for (i = 0; i < n && seguir ; i++)
        {
            s = ES.leerEntero();
            if (s > 100)
                seguir = false;              
        }
        if (s < 100) s = 0;
        return s;
    }
    
    public static int ultimaPosicion (int n, int m)
    {
        int pos = 0;
        int i = 0;
        int s;
        for (i = 0; i < n; i++)
        {
            s = ES. leerEntero();
            if(s == m)
                pos = i;
        }
        return pos;
    }
    
    public static int sumaSec (int n)
    {
        int suma = 0;
        int i;
        int s;
        for (i = 0; i < n; i++)
        {
            s = ES.leerEntero();
            suma += s;            
        }
        return suma;
    }
    
    public static boolean estaNum (int n, int num)
    {
        boolean esta = false;
        int i;
        int s;
        for (i = 0; i < n && !esta; i++)
        {
            s = ES.leerEntero();
            if (s == num)
                esta = true;
        }
        return esta;
    }
    
    public static boolean esCreciente (int n)
    {
        boolean creciente = true;
        int anterior = -1;
        int actual;
        int i;
        for (i = 0; i < n && creciente; i++)
        {
            actual = ES.leerEntero();
            if (actual <= anterior)
                creciente = false;
            else anterior = actual;
        }
        return creciente;
    }
    
    public static int contadorNum (int n, int num)
    {
        int cant = 0;
        int s;
        s = ES.leerEntero();
        if (n == 1)
        {
            if (s == num)
                cant = 1;
        } else {
            cant = contadorNum (n -1, num);
            if (s == num)
                cant++;
        }
        return cant;
    }
    
    public static int mayorNum (int n)
    {
        int mayor;
        int s = ES.leerEntero();
        if (n == 1)
            mayor = s;
        else {
            int mayorResto = mayorNum (n - 1);
            if (s > mayorResto)
                mayor = s;
            else 
                mayor = mayorResto;
            }
        return mayor;
    }
    
    public static int mayorPar (int n)
    {
        int mayorP = 0;
        int s;
        int i;
        for (i = 0; i < n; i++)
        {
            s = ES.leerEntero();
            if (s % 2 == 0 && s > mayorP)
                mayorP = s;
        }
        return mayorP;
    }
    
    public static int contarPerfectos (int n)
    {
        int s;
        int i;
        int perfectos = 0;
        for (i = 0; i < n; i++)
        {
            s = ES.leerEntero();
            if (ProcesadorNumero.esPerfecto(s))            
            perfectos++;
        }
        return perfectos;
    }
    
    public static boolean dosTodosImpares (int n)
    {
        int actual;
        int anterior = ES.leerEntero();
        int cont = 0;
        boolean dTI = false;
        int i;
        for (i = 0; i < n-1 && !dTI; i++)
        {
            actual = ES.leerEntero();
            if (ProcesadorNumero.todosImpares(anterior) && ProcesadorNumero.todosImpares(actual))
                cont ++;
            anterior = actual;
        }
        return (dTI);
    }
    
    public static int sumaDeProductos (int n) //Requiere que n > 0
    {
        int primero = ES.leerEntero();
        int suma;
        if (n == 1)
            suma = primero;
        else if (n == 2)
            suma = primero * ES.leerEntero();
        else {
            suma = sumaDeProductos (n-2);
            suma += primero * ES.leerEntero();
        }
        return suma;
    }
}
