
public class Ejercicio2
{
    public static void main(String[] args)
    {
        Color S1, S2, S3, S4, S5;
        S1 = new Color ();
        S1.establecerRojo(100);
        S1.establecerAzul(90);
        S1.establecerVerde(120);
        S2 = new Color ();
        S2.establecerRojo(55);
        S2.establecerAzul(110);
        S2.establecerVerde(100);
        S3 = new Color ();
        S3.establecerRojo(110);
        S3.establecerAzul(110);
        S3.establecerVerde(100);
        S4 = S1;
        S1 = S3;
        S2 = S1;
        S1 = new Color ();
        S1.establecerRojo(80);
        S1.establecerAzul(80);
        S1.establecerVerde(80);
        S2 = S1.clone();
        System.out.println(S1 == S2);
        System.out.println(S1.equals(S2));
        S3.copy(S1);
        System.out.println(S1 == S3);
        System.out.println(S1.equals(S3));
        S4 = S1;
        System.out.println(S1 == S4);
        System.out.println(S1.equals(S4));
    }
}
