import java.util.*;
import java.text.DecimalFormat;

public class TestVector
{
    public static void main(String[] args)
    {
        Vector v1, v2, v3;
        int max = 6;
  
        v1 = generaVector(max);
        System.out.print("Vector v1 => ");
        mostrarVector(v1);

        v2 = generaVector(max);
        System.out.print("Vector v2 => ");
        mostrarVector(v2);
        
        //---------------------------------------------------------------------------------------------
        //---- Test producto escalar
        //---------------------------------------------------------------------------------------------
        if (v1.cantElems() == v2.cantElems()) {
            System.out.println("Producto escalar v1 * v2 => " + v1.prodEscalar(v2)); 
        } else {
            System.out.println("No se puede calcular el producto escalar dado que la cantidad de elementos no es consistente"); 
        }
        
        //---------------------------------------------------------------------------------------------
        //---- Test suma
        //---------------------------------------------------------------------------------------------
        if (v1.cantElems() == v2.cantElems()) {
            v3 = v1.suma(v2);
            System.out.print("Suma v1 + v2 => "); 
            mostrarVector(v3);
        } else {
            System.out.println("No se puede calcular la suma dado que la cantidad de elementos no es consistente"); 
        }
        
        //---------------------------------------------------------------------------------------------
        //---- Test escalar X Vector
        //---------------------------------------------------------------------------------------------
        int esc = 2;
        v3 = v1.escalarXVector(esc) ;
        System.out.print("Escalar X vector (" + esc + " * v1) => "); 
        mostrarVector(v3);

        /**
         * @todo: completar el tester para los metodos implementados
         */
    }
    
    //--------------------------------------------------------------------------------------------------
    //---- Auxiliares ----------------------------------------------------------------------------------
    //--------------------------------------------------------------------------------------------------
    
    /**
     * Crea un objeto Vector y lo inicializa con valores aleatorios
     */
    private static Vector generaVector(int max)
    {
        // Se crea el objeto de clase Vector
        Vector v = new Vector(max);
        // Se lo inicializa con números aleatorios
        Random gen = new Random();
        float elem;
        for (int i = 0; i < v.cantElems(); i++) {
            elem = gen.nextFloat() * 10;
            v.establecerElem(i, elem);
        }
        // Se retorna el objeto creado e inicializado
        return v;
    }
    
    /**
     * Muestra por pantalla el contenido de un objeto de clase Vector
     */
    private static void mostrarVector(Vector v)
    {
        // Objeto para formatar en dos decimales al mostrar
        DecimalFormat df = new DecimalFormat("0.00"); 
        System.out.print("< ");
        for (int i = 0; i < v.cantElems(); i++) {
            System.out.print(df.format(v.obtenerElem(i)) + " ");
        }
        System.out.println(">");
    }
}
