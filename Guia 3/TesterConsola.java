import IPOO.*;
public class TesterConsola
{
    public static void main (String[] args)
    {
        int n;
        int m;
        System.out.println("Ingrese la cantidad de números que tendrá la secuencia");
        n = ES.leerEntero();
        System.out.println("El primer número mayor que 100 en la secuencia es " + SecuenciaConsola.primer(n));
        System.out.println("Ingrese el número a encontrar en la secuencia");
        m = ES.leerEntero();
        if(SecuenciaConsola.ultimaPosicion(n, m) == 0)
            System.out.println("El número no se encuentra en la secuencia");
        else
            System.out.println("El número " + m + " se encuentra en la posición " + SecuenciaConsola.ultimaPosicion(n, m));
        System.out.println("La suma de los números de la secuencia es " + SecuenciaConsola.sumaSec(n));
        if(SecuenciaConsola.estaNum(n, m))
            System.out.println("El número " + m + " se encuentra en la secuencia");
        else
            System.out.println("El número " + m + " no se encuentra en la secuencia");
        if(SecuenciaConsola.esCreciente(n))
            System.out.println("La secuencia es creciente");
        else
            System.out.println("La secuencia no es creciente");
        System.out.println("El número " + m + " aparece " + SecuenciaConsola.contadorNum(n, m) + " veces.");
        System.out.println("El mayor número de la secuencia es " + SecuenciaConsola.mayorNum(n));
        System.out.println("El mayor número par de la secuencia es " + SecuenciaConsola.mayorPar(n));
        System.out.println("La cantidad de números perfectos de la secuencia es " + SecuenciaConsola.contarPerfectos(n));
        if(SecuenciaConsola.dosTodosImpares(n))
            System.out.println("La secuencia contiene dos números seguidos con todos los dígitos impares");
        else
            System.out.println("La secuencia contiene dos números seguidos con todos los dígitos impares");
        System.out.println("La suma de productos de la secuencia es " + SecuenciaConsola.sumaDeProductos(n));
    }
}
