import java.util.Random;
import IPOO.*;
public class TesterLangostas
{
    public static void main(String[] args)
    {
        int i, rand;
        Random gen = new Random();
        ColoniaLangostasMutantes colonia = new ColoniaLangostasMutantes();
        rand = gen.nextInt();
        System.out.println(rand);
        for(i = 0; i < rand; i++)
        {
            System.out.println("Situación antes de la reproducción" + colonia.toString());
            colonia.reproduccionEnLaColonia();
            System.out.println("Situación luego de la reproducción" + colonia.toString());
        }
    }
}
