import java.util.Random;
public class TesterTamagotchi
{
    public static void main (String[] args)
    {
        MascotaVirtual tam = new MascotaVirtual();
        System.out.println("Energía: "+tam.obtenerEnergia()+" - Humor: "+tam.obtenerHumor()+" - Vive: "+tam.estaVivo());
        int rnd, i, N;
        Random gen1 = new Random();
        Random gen2 = new Random();
        N = gen1.nextInt(30); //Cantidad de actividades
        for (i = 0; i < N; i++)
        {
            rnd = gen2.nextInt(7);
            System.out.println(rnd);
            if (rnd == 0)
                tam.comer();
            else if (rnd == 1)
                tam.beber();
            else if (rnd == 2)
                tam.dormir();
            else if (rnd == 3)
                tam.despertar();
            else if (rnd == 4)
                tam.caminar();
            else if (rnd == 5)
                tam.correr();
            else
                tam.saltar();
            System.out.println("Energía: "+tam.obtenerEnergia()+" - Humor: "+tam.obtenerHumor()+" - Vive: "+tam.estaVivo());
        }
    }
}
