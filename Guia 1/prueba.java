
public class prueba
{
 public static void main (String[] args)
    { 
        // Prueba #1 
        float x = 2; float y = 3;
        while ((y - x) == 1.0)
        { x = 2 * x;
          y = x + 1;
          System.out.println(x + " "+ y + " x - y " + (x-y));
        }
    }
}
