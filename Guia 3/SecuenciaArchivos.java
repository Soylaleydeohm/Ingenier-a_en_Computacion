import IPOO.*;
import java.io.*;
public class SecuenciaArchivos
{
        public static int primer (String ruta)
    {
        int num = 0;
        boolean seguir = true;
        String s;
        try{
            BufferedReader in = new BufferedReader (new FileReader(ruta));
            while((s = in.readLine()) != null&& seguir)                  
            {
                num = Integer.parseInt(s.trim());
                if (num > 100)
                    seguir = false;              
            }
            if (num < 100) num = 0;
        }
        catch (IOException err)
        {
            System.out.println("Error al leer el archivo");
        }
        return num;
    }
    
    public static int ultimaPosicion (String ruta, int m)
    {
        int pos = 0;
        int i = 0;
        int num;
        String s;
        try{
            BufferedReader in = new BufferedReader (new FileReader(ruta));
            for (i = 0; (s = in.readLine()) != null; i++)
            {
                num = Integer.parseInt(s.trim());
                if(num == m)
                    pos = i;
                }
        }
        catch (IOException err)
        {
            System.out.println("Error al leer el archivo");
        }
        return pos;
    }
    
    public static int sumaSec (String ruta)
    {
        int suma = 0;
        int num;
        String s;
        try{
            BufferedReader in = new BufferedReader (new FileReader(ruta));
            while ((s = in.readLine()) != null)
            {
                num = Integer.parseInt(s.trim());
                suma += num;
            }
        }
        catch (IOException err)
        {
            System.out.println("Error al leer el archivo");
        }
        return suma;
    }
    
    public static boolean estaNum (String ruta, int m)
    {
        boolean esta = false;
        int num;
        String s;
        try{
            BufferedReader in = new BufferedReader (new FileReader(ruta));
            while ((s = in.readLine()) != null && !esta)
            {
                num = Integer.parseInt(s.trim());
                if(num == m)
                    esta = true;
            }
        }
        catch (IOException err)
        {
            System.out.println("Error al leer el archivo");
        }
        return esta;
    }
    
    public static boolean esCreciente (String ruta)
    {
        boolean creciente = true;
        int anterior = -1;
        int actual;
        String s;
        try{
            BufferedReader in = new BufferedReader (new FileReader(ruta));
            while ((s = in.readLine()) != null && creciente)
            {
                actual = Integer.parseInt(s.trim());
                if(actual <= anterior)
                    creciente = false;
                else
                    anterior = actual;
            }
        }
        catch (IOException err)
        {
            System.out.println("Error al leer el archivo");
        }
        return creciente;
    }
    
    public static int contadorNum (String ruta, int n)
    {
        int cant = 0;
        int num;
        String s;
        try{
            BufferedReader in = new BufferedReader (new FileReader(ruta));
            if ((s = in.readLine()) != null)
            {
                num = Integer.parseInt(s.trim());
                if(num == n)
                    cant = contadorNum(ruta, n) + 1;
            }
        }
        catch (IOException err)
        {
            System.out.println("Error al leer el archivo");
        }
        return cant;
    }
    
    public static int mayorNum (String ruta)
    {
        int mayor = 0;
        String s;
        int num;
        try{
            BufferedReader in = new BufferedReader (new FileReader(ruta));
            while ((s = in.readLine()) != null)
            {
                num = Integer.parseInt(s.trim());
                if(num > mayor)
                    mayor = num;
            }
        }
        catch (IOException err)
        {
            System.out.println("Error al leer el archivo");
        }
        return mayor;
    }
    
    public static int mayorPar (String ruta)
    {
        int mayorP = 0;
        String s;
        int num;
        try{
            BufferedReader in = new BufferedReader (new FileReader(ruta));
            while ((s = in.readLine()) != null)
            {
                num = Integer.parseInt(s.trim());
                if(num % 2 == 0 && num > mayorP)
                    mayorP = num;
            }
        }
        catch (IOException err)
        {
            System.out.println("Error al leer el archivo");
        }
        return mayorP;
    }
    
    public static int contarPerfectos (String ruta)
    {
        String s;
        int num;
        int perfectos = 0;
        try{
            BufferedReader in = new BufferedReader (new FileReader(ruta));
            while ((s = in.readLine()) != null)
            {
                num = Integer.parseInt(s.trim());
                if(ProcesadorNumero.esPerfecto(num))
                    perfectos++;
            }
        }
        catch (IOException err)
        {
            System.out.println("Error al leer el archivo");
        }
        return perfectos;
    }
    
    public static boolean dosTodosImpares (String ruta)
    {
        int actual;
        int anterior;
        int cont = 0;
        boolean dTI = false;
        String s;
        try{
            BufferedReader in = new BufferedReader (new FileReader(ruta));
            s = in.readLine();
            anterior = Integer.parseInt(s.trim());
            while ((s = in.readLine()) != null && !dTI)
            {
                actual = Integer.parseInt(s.trim());
                if(ProcesadorNumero.todosImpares(anterior) && ProcesadorNumero.todosImpares(actual))
                    dTI = true;
                else 
                    anterior = actual;
            }
        }
        catch (IOException err)
        {
            System.out.println("Error al leer el archivo");
        }
        return (dTI);
    }
    
    //Suma de productos no se puede implementar porque no puedo leer hasta la mitad del archivo.
    /*public static int sumaDeProductos (String ruta) //Requiere que n > 0
    {
        int primero;
        int suma = 0;
        String s;
        try{
            BufferedReader in = new BufferedReader (new FileReader(ruta));
            s = in.readLine();
            primero = Integer.parseInt(s.trim());
            while ((s = in.readLine()) != null)
            {
                suma = sumaDeProductos(ruta);
                s = in.readLine();
                int ultimo = Integer.parseInt(s.trim());
                suma += primero*ultimo;
            }
        }
        catch (IOException err)
        {
            System.out.println("Error al leer el archivo");
        }
        return suma;
    }*/
}
