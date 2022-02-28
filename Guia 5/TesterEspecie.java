import java.util.Random;
import IPOO.*;
public class TesterEspecie
{
    public static void main (String[] args)
    {
        Random ran = new Random();
        String name;
        float rit;
        int h;
        int m;
        Especie e;
        System.out.println("Ingrese el nombre de la especie");
        name = ES.leerCadena();
        e = new Especie (name);
        System.out.println("Ingrese el ritmo de crecimiento de la especie");
        rit = ES.leerFloat();
        e.establecerRitmo(rit);
        System.out.println("Establezco aleatoriamente la cantidad de machos y de hembras de la especie");
        h = ran.nextInt();
        m = ran.nextInt();
        e.establecerHembras(h);
        e.establecerMachos(m);
        System.out.println(e.toString());
        System.out.println("Actualice la cantidad de hembras, machos y el ritmo de crecimiento de la especie");
        h = ES.leerEntero();
        m = ES.leerEntero();
        rit = ES.leerFloat();
        e.actualizarHembras(h);
        e.actualizarMachos(m);
        e.actualizarRitmo(rit);
        System.out.println(e.toString() + " - Población actual total: " + e.poblacionActual() + " - Población estimada en 10 años: " + e.poblacionEstimada(10) + " - Riesgo de la especie: " + e.riesgo() + " - Esta especie tiene más hembras que machos en su población: " + e.masHembras());
    }
}
