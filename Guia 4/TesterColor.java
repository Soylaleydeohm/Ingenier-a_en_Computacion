import IPOO.*;
public class TesterColor
{
    public static void main (String[] args)
    {
        Color color = new Color();
        int r, a, v, t;
        System.out.println("Color : rojo " + color.obtenerRojo() + " azul " + color.obtenerAzul() + " verde " + color.obtenerVerde());
        System.out.println("Ingrese cuánto variar a las tres componentes");
        t = ES.leerEntero();
        color.variar(t);
        System.out.println(color.toString());
        //Variamos la composición
        System.out.println("Ingrese cuánto variar de rojo, cuánto de azul y cuánto de verde. Puede probar con r = 260, a = -260 y v = 15, para verificar si funcionan los métodos de control");
        r = ES.leerEntero();
        a = ES.leerEntero();
        v = ES.leerEntero();
        color.variarRojo(r);
        color.variarAzul(a);
        color.variarVerde(v);
        System.out.println(color.toString());
        Color colorComp = color.complemento();
        System.out.println("Complementario: " + colorComp.toString());
        if (color.esRojo())
            System.out.println("El primer color es rojo");
        else
            System.out.println("El primer color no es rojo");
            if (color.esGris())
            System.out.println("Ambos colores son grises");
        else
            System.out.println("Ninguno de los colores son grises");
        System.out.println("Creamos el color negro");
        Color colorNegro = new Color();
        colorNegro.establecerRojo(0);
        colorNegro.establecerAzul(0);
        colorNegro.establecerVerde(0);
        System.out.println("El color creado es negro: " + colorNegro.esNegro());
        System.out.println("Creamos un clon del color complemento");
        Color clon = colorComp.clone();
        System.out.println("Color creado " + clon.toString());
        System.out.println("Copiaremos al color principal en el color creado recientemente");
        clon.copy(color);
        System.out.println("Color copiado " + clon.toString());
        System.out.println("Color principal y complemento son iguales: " + color.equals(colorComp));
        System.out.println("Color principal y nuevo son iguales: " + color.equals(clon));
    }
}
