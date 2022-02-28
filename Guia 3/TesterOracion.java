import IPOO.*;
public class TesterOracion
{
    public static void main (String[] args)
    {
        char ch;
        System.out.println("Ingrese la oración");
        System.out.println("La cantidad de letras en la oración es " + Oracion.cantLetras());
        System.out.println("Ingrese la oración");
        System.out.println("La cantidad de palabras en la oración es " + Oracion.cantPalabras());
        System.out.println("Ingrese el caracter a buscar y luego la oración");
        ch = ES.leerChar();
        System.out.println("La cantidad de palabras en la oración que comienzan con el caracter " + ch + " es " + Oracion.cantPalabrasLetra(ch));
        System.out.println("Ingrese la oración");
        System.out.println("La palabra más larga de la oración contiene " + Oracion.palabraMasLarga() + " caracteres.");
    }
}
