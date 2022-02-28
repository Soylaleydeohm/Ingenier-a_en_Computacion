import IPOO.*;
import java.util.*;

public class TesterRacionales
{
    public static void main (String args[])
    {
        System.out.print("Ingrese el modo de testeo (a)utomatico / (m)anual / valores (f)ijos: ");
        char modo = ES.leerChar();
        while ((modo != 'a') && (modo != 'm') && (modo != 'f')) {
            // Este ciclo asegura que solo se elegira una opcion valida
            System.out.print("Ingrese el modo de testeo (a)utomatico / (m)anual / valores (f)ijos: ");
            modo = ES.leerChar();
        }

        System.out.println("------------------------------------------");
        
        Racional rac1, rac2, rac3;
        Random gen = new Random();
        int num1, num2, den1, den2;
        
        // Se obtienen los valores de testeo segun el modo elegido
        if (modo == 'a') {
            // Modo de testeo con valores automaticos (aleatorios)
            /**
             * @todo - completar con valores generados aleatoriamente
             * Se debe controlar que el denominador no sea cero
             */
            num1 = gen.nextInt();
            den1 = gen.nextInt();
            while (den1 == 0)
            {
                den1 = gen.nextInt();
            }
            num2 = gen.nextInt();
            den2 = gen.nextInt();
            while (den2 == 0)
            {
                den2 = gen.nextInt();
            }
            rac1 = new Racional(num1,den1);
            System.out.println("RAC1: " + rac1.toString());
            rac2 = new Racional(num2,den2);
            System.out.println("RAC2: " + rac2.toString());
        } else if (modo == 'f')  {
            // Modo de testeo con valores fijos
            rac1 = new Racional(1,2);
            System.out.println("RAC1: " + rac1.toString());
            rac2 = new Racional(3,6);
            System.out.println("RAC2: " + rac2.toString());
        }
         else {
            // Modo de testeo con valores ingresados manualmente 
            /**
             * @todo - completar con valores ingresados manualmente
             * Se debe controlar que el denominador no sea cero
             */
            System.out.println("Ingrese los valores de numerador y denominador del primer número racional");
            num1 = ES.leerEntero();
            den1 = ES.leerEntero();
            rac1 = new Racional(num1,den1);
            System.out.println("RAC1: " + rac1.toString());            
            System.out.println("Ingrese los valores de numerador y denominador del segundo número racional");
            num2 = ES.leerEntero();
            den2 = ES.leerEntero();
            rac2 = new Racional(num2,den2);
            System.out.println("RAC2: " + rac2.toString());
        }
        
        System.out.println();
        System.out.println("------------------------------------------");
        System.out.println("-- Test de operaciones aritméticas -------");
        System.out.println("------------------------------------------");
        
        System.out.println("TEST DE suma");
        
        rac3 = rac1.suma(rac2);
       System.out.println(rac1.toString() + " + " + rac2.toString() + " = " + rac3.toString());
        
        rac3 = rac2.suma(rac1);
        System.out.println(rac2.toString() + " + " + rac1.toString() + " = " + rac3.toString());

        System.out.println("------------------------------------------");

        System.out.println("TEST DE resta");
        
        rac3 = rac1.resta(rac2);
        System.out.println(rac1.toString() + " - " + rac2.toString() + " = " + rac3.toString());
                rac3 = rac2.resta(rac1);
        System.out.println(rac2.toString() + " - " + rac1.toString() + " = " + rac3.toString());

        System.out.println("------------------------------------------");

        System.out.println("TEST DE producto");
        
        rac3 = rac1.producto(rac2);
        System.out.println(rac1.toString() + " * " + rac2.toString() + " = " + rac3.toString());
        
        rac3 = rac2.producto(rac1);
        System.out.println(rac2.toString() + " * " + rac1.toString() + " = " + rac3.toString());

        System.out.println("------------------------------------------");
        
        System.out.println("TEST DE cociente");
        
        if (rac2.obtenerDen() == 0) {
            System.out.println("No se puede dividir por " + rac2.toString() + " porque el numerador es 0");
        } else {
            rac3 = rac1.cociente(rac2);
            System.out.println(rac1.toString() + " / " + rac2.toString() + " = " + rac3.toString());
        }
            
        if (rac1.obtenerDen() == 0) {
            System.out.println("No se puede dividir por " + rac1.toString() + " porque el numerador es 0");
        } else {
            rac3 = rac2.cociente(rac1);
            System.out.println(rac2.toString() + " / " + rac1.toString() + " = " + rac3.toString());
        }

        System.out.println();
        System.out.println("------------------------------------------");
        System.out.println("-- Test de utilidades --------------------");
        System.out.println("------------------------------------------");
        System.out.println();
        
        System.out.println("TEST DE equals");
        
        System.out.println("RAC1: " + rac1.toString());
        System.out.println("RAC2: " + rac2.toString());
        System.out.println("RAC3: " + rac3.toString());
        
        System.out.println("RAC1 equals RAC2 => " +  rac1.equals(rac2));
        System.out.println("RAC1 equals RAC3 => " +  rac1.equals(rac3));
        System.out.println("RAC2 equals RAC3 => " +  rac2.equals(rac3));
        
        /**
         * @todo: agregar tests para las funciones faltantes
         */
        
        System.out.println("TEST DE clone");
        
        rac3 = rac1.clone();
        
        System.out.println("RAC1 clonado en RAC3 => " +  rac3);
        System.out.println("RAC1 equals RAC3 => " +  rac1.equals(rac3));
        System.out.println("RAC2 equals RAC3 => " +  rac2.equals(rac3));
        
        rac3 = rac2.clone();
        
        System.out.println("RAC2 clonado en RAC3 => " +  rac3);        
        System.out.println("RAC1 equals RAC3 => " +  rac1.equals(rac3));
        System.out.println("RAC2 equals RAC3 => " +  rac2.equals(rac3));
        
    }
}
