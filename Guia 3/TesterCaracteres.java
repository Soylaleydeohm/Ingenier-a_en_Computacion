import IPOO.*;
public class TesterCaracteres
{
    public static void main (String[] args)
    {
        int n;
        char ch;        
        System.out.println("Ingrese la cantidad de caracteres que tendrá la cadena");
        n = ES.leerEntero();
        if(SecuenciaCaracteres.dosVocales(n))
            System.out.println("La secuencia tiene dos vocales seguidas");
        else
            System.out.println("La secuencia no tiene dos vocales seguidas");
        if(SecuenciaCaracteres.todasLetras(n))
            System.out.println("Todos los caracteres de la secuencia son letras");
        else
            System.out.println("No todos los caracteres de la secuencia son letras");
        System.out.println("Ingrese el caracter a buscar");
        ch = ES.leerChar();
        System.out.println("La secuencia tiene " + SecuenciaCaracteres.contadorChar(n, ch) + " apariciones de " + ch);
        if(SecuenciaCaracteres.tieneAlgunReflejo(n))
            System.out.println("Tiene algún reflejo");
        else
            System.out.println("No tiene algún reflejo");
        System.out.println("La secuencia explosiva desde el centro es " + SecuenciaCaracteres.explosiva(n));
    }
}
