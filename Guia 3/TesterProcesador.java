import IPOO.*;
public class TesterProcesador
{
    public static void main (String[] args)
    {
        int N, suma, d, contador, mayorD;
        boolean esta, creciente, perfecto, impares;
        System.out.println("Ingrese el número a evaluar");
        N = ES.leerEntero();
        System.out.println("Ingrese el dígito a comparar con el número ingresado");
        d = ES.leerEntero();
        suma = ProcesadorNumero.sumaDig(N);
        System.out.println("La suma de los dígitos de "+N+" es "+suma);
        esta = ProcesadorNumero.estaDig(N, d);  
        if (esta == true)
            System.out.println("El dígito "+d+" está presente en el número "+N);
        else 
            System.out.println("El dígito "+d+" no está presente en el número "+N);
        creciente = ProcesadorNumero.esCreciente(N);
        if (creciente == true)
            System.out.println("El número "+N+" es creciente");
        else 
            System.out.println("El número "+N+" no es creciente");
        perfecto = ProcesadorNumero.esPerfecto(N);
        if (perfecto == true)
            System.out.println("El número "+N+" es perfecto");
        else 
            System.out.println("El número "+N+" no es perfecto");
        contador = ProcesadorNumero.contadorDig(N, d);
        System.out.println("El dígito "+d+" está presente "+contador+" veces en el número "+N);
        mayorD = ProcesadorNumero.mayorDigito(N);
        System.out.println("El mayor dígito presente en el número "+N+" es "+mayorD);
        impares = ProcesadorNumero.todosImpares(N);
        if (impares == true)
            System.out.println("Todos los dígitos en el número "+N+" son impares");
        else 
            System.out.println("No todos los dígitos en el número "+N+" son impares");
    }
}
