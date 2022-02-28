
public class ProcesadorNumero
{
    public static int sumaDig(int n)
    {
        int suma = 0;
        while (n > 0)
        {
            suma += n%10;
            n /= 10;
        }
        return suma;
    }
    
    public static boolean estaDig (int n, int d)
    {
        boolean esta = false;
        while (n > 0 && !esta)
        {
            if (n % 10 == d)
                esta = true;
            n /= 10;
        }
        return esta;
    }
    
    public static boolean esCreciente (int n)
    {
        boolean es = true;
        int a, b;
        while (n >= 10 && es == true) //Cuando n es menor a 10, ya chequeó la validez en el while anterior
        {
            a = n % 10;
            n /= 10;
            b = n % 10;
            if (a < b)
                es = false;
        }
        return es;
    }
    
    public static boolean esPerfecto (int n)
    {
        int i;
        int suma = 0;
        boolean es = false;
        for (i = 1; i <= n/2; i++)
        {
            if (n % i == 0)
                suma += i;
        }
        if (n == suma)
            es = true;
        return es;
    }
    
    public static int contadorDig (int n, int d)
    {
        int i = 0;
        if (n < 10){
            if (n == d)
                i = 1;
        }else 
            if (n % 10 == d)
                i = 1 + contadorDig(n/10, d);
            else
                i = contadorDig(n/10, d);
        return i;
    }
    
    public static int mayorDigito (int n)
    {
        int mD = 0;
        int aux;
        if (n < 10)
            mD = n;
        else 
        {
            aux = mayorDigito (n / 10);
            if (n % 10 > aux)
                mD = n % 10;
            else
                mD = aux;
        }            
        return mD;
    }
    
    public static boolean todosImpares  (int n)
    {
        boolean es;
        if (n < 10)
        {
            if (n % 2 == 0)
                es = false;
            else 
                es = true;
        } else if (n % 2 == 0)
            es = false;
        else 
            es = todosImpares (n / 10);
        return es;           
    }
}
