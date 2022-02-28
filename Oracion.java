
public class Oracion
{
    //Atributos de instancia 
    String oracion;
    
    //Constructor 
    public Oracion (String o)
    {
        oracion = o;
    }
    
    public String editarTexto()
    {
        int pl = 0;
        int pe = 0;
        String nueva = "";
        while (pl < oracion.length())
        {
            String o = "";
            while(oracion.charAt(pl) != ' ')
            {
                o += oracion.charAt(pl);
                pl++;
                pe++;
            }
            while ((pl < oracion.length()) && (pe < 150))
            {
                pl++;
                //Busco la longitud de la palabra siguiente
                int pp = 0;
                while(((pp + pl) < oracion.length()) && oracion.charAt(pp + pl) != ' ')
                {
                    pp++;
                }
                //Ahora corroboro si la palabra entra en el renglón
                if((pp + pe) < 150)
                {
                    o += " ";
                    pe++;
                    while((pl < oracion.length()) && oracion.charAt(pl) != ' ')
                    {
                        o += oracion.charAt(pl);
                        pl++;
                        pe++;
                    }
                }
                else
                {
                    o = justificar(o, pe);
                    pe = 150;
                }
            }
            nueva += o +(System.getProperty("line.separator"))+"";
            pe = 0;
        }
        return nueva;
    }
    
    private String justificar (String or, int p)
    {
        String oracJustificada = "";
        int cantEspacios = 150 - p;
        int espPorPalabra = cantEspacios/(contarPalabras(or)-1);
        int extra = cantEspacios - espPorPalabra;
        int i = 0;
        while (i < p)
        {
            while (i < p && or.charAt(i) != ' ')
            {
                oracJustificada += or.charAt(i);
                i++;
            }
            for(int j = 0; j < espPorPalabra; j++)
            {
                oracJustificada += " ";
            }
            if (extra > 0)
            {
                oracJustificada += " ";
                extra--;
            }
            oracJustificada += " ";
            i++;
        }
        return oracJustificada;
    }
    
    private int contarPalabras(String orac)
    {
        int contador = 0;
        int i = 0;
        while (i < orac.length())
        {
            while(i < orac.length() && orac.charAt(i)!= ' ')
            {
                i++;
            }
            contador ++;
            while(i < orac.length() && orac.charAt(i)== ' ')
            {
                i++;
            }
        }
        return contador;
    }
}
