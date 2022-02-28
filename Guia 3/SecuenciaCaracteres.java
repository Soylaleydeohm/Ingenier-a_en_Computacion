import IPOO.*;
public class SecuenciaCaracteres
{
    public static boolean dosVocales (int n)
    {
        char lAnt;
        char lAct;
        boolean dV = false;
        int i;
        lAnt = ES.leerChar();
        for (i = 0; i < n-1 && !dV; i++)
        {
            lAct = ES.leerChar();
            dV = esVocal(lAnt) && esVocal(lAct);
            lAnt = lAct;
        }
        return dV;
    }
    
    //Método auxiliar tiene que ser privado
    private static boolean esVocal(char v)
    {
        return (v == 'a' ||v == 'e' ||v == 'i' ||v == 'o' ||v == 'u' ||v == 'A' ||v == 'E' ||v == 'I' ||v == 'O' ||v == 'U');
    }
    
    public static int contadorChar (int n, char ch)
    {
        int i = 0;
        int contador = 0;
        char c;
        for (i = 0; i < n; i++)
        {
            c = ES.leerChar();
            if (c == ch)
                contador ++;
        }
        return contador;
    }
    
    public static boolean todasLetras (int n)
    {
        boolean son = true;
        int i;
        char s;
        for (i = 0; i < n && son; i++)
        {
            s = ES.leerChar();
            if(!((s >= 65 && s <= 90) ||(s >= 97 && s <= 122)))
            son = false;
        }
        return son;
    }
    
    public static int maxDistancia (int n)
    {
        int maxdis = -1;
        boolean existe = false;
        int i = 0;
        char s;
        while (!existe && i < n)
        {
            s = ES.leerChar();
            existe = esVocal(s);
            i++;
        }
        if (existe)
        {
            maxdis = 0;
            int dis = 0;
            while (i < n)
            {
                s = ES.leerChar();
                dis += 1;
                if (esVocal(s))
                    if (dis > maxdis)
                    {
                        maxdis = dis;
                        dis = 0;
                    }
            }
        }
        return maxdis;
    }
    
    public static boolean tieneAlgunReflejo (int n)
    {
        char primero;
        char s;
        int i;
        boolean salida = false;
        if (n > 0)
        {
            primero = ES.leerChar();
            if (n == 2)
            {
                if (primero == ES.leerChar())
                    salida = true;
                } else {
                    salida = (tieneAlgunReflejo(n-2) || primero == ES.leerChar());
                }
        }
        return salida;
    }
    
    public static String explosiva (int n)//Requiere n > 0
    {
        String s;
        if (n == 2)
            s = "" + ES.leerChar() + ES.leerChar();
        else {
            char ch = ES.leerChar();
            s = explosiva(n-2) + ch + ES.leerChar();
        }
        return s;        
    }
}
