import IPOO.*;
public class TesterArchivos
{
    public static void main (String[] args)
    {
        int m;
        String ruta;
        System.out.println("Ingrese la ruta del archivo");
        ruta = ES.leerCadena();
        System.out.println("El primer número mayor que 100 en la secuencia es " + SecuenciaArchivos.primer(ruta));
        System.out.println("Ingrese el número a encontrar en la secuencia");
        m = ES.leerEntero();
        if(SecuenciaArchivos.ultimaPosicion(ruta, m) == 0)
            System.out.println("El número no se encuentra en la secuencia");
        else
            System.out.println("El número " + m + " se encuentra en la posición " + SecuenciaArchivos.ultimaPosicion(ruta, m));
        System.out.println("La suma de los números de la secuencia es " + SecuenciaArchivos.sumaSec(ruta));
        if(SecuenciaArchivos.estaNum(ruta, m))
            System.out.println("El número " + m + " se encuentra en la secuencia");
        else
            System.out.println("El número " + m + " no se encuentra en la secuencia");
        if(SecuenciaArchivos.esCreciente(ruta))
            System.out.println("La secuencia es creciente");
        else
            System.out.println("La secuencia no es creciente");
        System.out.println("El número " + m + " aparece " + SecuenciaArchivos.contadorNum(ruta, m) + " veces.");
        System.out.println("El mayor número de la secuencia es " + SecuenciaArchivos.mayorNum(ruta));
        System.out.println("El mayor número par de la secuencia es " + SecuenciaArchivos.mayorPar(ruta));
        System.out.println("La cantidad de números perfectos de la secuencia es " + SecuenciaArchivos.contarPerfectos(ruta));
        if(SecuenciaArchivos.dosTodosImpares(ruta))
            System.out.println("La secuencia contiene dos números seguidos con todos los dígitos impares");
        else
            System.out.println("La secuencia contiene dos números seguidos con todos los dígitos impares");
        //System.out.println("La suma de productos de la secuencia es " + SecuenciaArchivos.sumaDeProductos(ruta));
    }
}