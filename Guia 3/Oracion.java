import IPOO.*;
public class Oracion
{
    public static int cantLetras()
    {
        char s = ES.leerChar();
        int cL = 0;
        while (s != '.')
        {
            if (esLetra(s))
                cL++; 
            s = ES.leerChar();
        }
        return cL;
    }
    
    private static boolean esLetra(char c)
    {
        return ((c >= 65 && c <= 90)||(c >= 97 && c <= 122));
    }
    
    public static int cantPalabras ()
    {
         char s = ES.leerChar();
         int c = 1; //Asumo que la cadena tiene al menos una palabra
         while (s != '.')
         {
             if (s == ' ') //Si inicio a c en 0, puedo comparar tmb con '.'
                c++;
             s = ES.leerChar();
         }
         return c;
    }
    
    public static int cantPalabrasLetra (char ch)
    {
        int contador = 0;
        char s = ES.leerChar();
        if (s == ch)
            contador = 1;
        while (s != '.')
        {
            if (s == ' ')
            {
                s = ES.leerChar();
                if (s == ch)
                    contador++;
            }
            s = ES.leerChar();
        }
        return contador;
    }
    
    public static int palabraMasLarga()
    {
        int pML = 0;
        int contador = 0;
        char s = ES.leerChar();
        while (s != '.')
        {
            if (esLetra(s))
                contador++;
            else 
                contador = 0;
            if (pML < contador)
                pML = contador;    
            s = ES.leerChar();
        }
        return pML;
    }
}
