import IPOO.*;
public class OracionString
{
    public static int cantLetras()
    {
        String s = ES.leerCadena();
        int i;
        int cL = 0;
        for (i = 0; i < s.length(); i++)
        {
            if (esLetra(s.charAt(i)))
                cL++;                
        }
        return cL;
    }
    
    private static boolean esLetra(char c)
    {
        return ((c >= 65 && c <= 90)||(c >= 97 && c <= 122));
    }
    
    public static int cantPalabras ()
    {
         String s = ES.leerCadena();
         int i;
         int c = 1; //Asumo que la cadena tiene al menos una palabra
         for (i = 0; i < s.length(); i++)
         {
             if (s.charAt(i) == ' ') //Si inicio a c en 0, puedo comparar tmb con '.'
                c++;
         }
         return c;
    }
    
    public static int cantPalabrasLetra (char ch)
    {
        int i;
        int contador = 0;
        String s = ES.leerCadena();
        if (s.charAt(0) == ch)
            contador = 1;
        for (i = 1; i < s.length(); i++)
        {
            if (s.charAt(i) == ' ')
            {
                i++;
                if (s.charAt(i) == ch)
                    contador++;
            }
        }
        return contador;
    }
    
    public static int palabraMasLarga()
    {
        int pML = 0;
        int i = 0;
        int contador = 0;
        String s = ES.leerCadena();
        for(i = 0; i < s.length(); i++)
        {
            if (esLetra(s.charAt(i)))
                contador++;
            else 
                contador = 0;
            if (pML < contador)
                pML = contador;                
        }
        return pML;
    }
}
