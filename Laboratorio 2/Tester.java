import IPOO.*;
import java.util.*;

public class Tester
{
    public static void main (String args[])
    {
        int errores = 0;
        
        System.out.print("Ingrese el modo de testeo (a)utomatico / (m)anual: ");
        char modo = ES.leerChar();
        while ((modo != 'a') && (modo != 'm')) {
            // Este ciclo asegura que solo se elegira una opcion valida
            System.out.print("Ingrese el modo de testeo (a)utomatico / (m)anual: ");
            modo = ES.leerChar();
        }

        System.out.println("------------------------------------------");
        
        int CP;
        int poblacion;
        float superficie;
        Random gen = new Random();
        Ciudad ciudad;
        
        // Se obtienen los valores de testeo segun el modo elegido
        if (modo == 'a') {
            // Modo de testeo con valores automaticos
            CP = gen.nextInt(10000);
            poblacion = gen.nextInt(100000);
            superficie = gen.nextFloat() * 1000;

            System.out.println("VALORES ALEATORIOS GENERADOS");
            System.out.println("Codigo Postal: " + CP);
            System.out.println("Poblacion: " + poblacion);
            System.out.println("Superficie: " + superficie);            
        } else {
            // Modo de testeo con valores ingresados manualmente 
            System.out.print("Ingrese el Codigo Postal: ");
            CP = ES.leerEntero();
            System.out.print("Ingrese la poblacion: ");
            poblacion = ES.leerEntero();
            System.out.print("Ingrese la superficie: ");
            superficie = ES.leerFloat();
        }
                
        System.out.println("------------------------------------------");
        
        // Se crea un objeto ciudad usando el constructor de un parametro
        System.out.println("TEST DE CONSTRUCTOR DE UN PARAMETRO Y COMANDOS 'ESTABLECER'");
        ciudad = new Ciudad(CP);
        ciudad.establecerPoblacion(poblacion);
        ciudad.establecerSuperficie(superficie);
        
        // Se testean las consultas triviales
        int CP2 = ciudad.obtenerCP();
        int poblacion2 = ciudad.obtenerPoblacion();
        float superficie2 = ciudad.obtenerSuperficie();
        
        System.out.println("CONSULTAS TRIVIALES");
        System.out.print("Codigo Postal: " + CP2);
        if (CP == CP2) {
            System.out.println(" - OK");
        } else {
            System.out.println(" - ERROR");
            errores++;
        }
        System.out.print("Poblacion: " + poblacion2);
        if (poblacion == poblacion2) {
            System.out.println(" - OK");
        } else {
            System.out.println(" - ERROR");
            errores++;
        }
        System.out.print("Superficie: " + superficie2);
        if (superficie == superficie2) {
            System.out.println(" - OK");
        } else {
            System.out.println(" - ERROR");
            errores++;
        }   
        System.out.println("------------------------------------------");
        
        // Se crea un objeto ciudad usando el constructor de tres parametros
        System.out.println("TEST DE CONSTRUCTOR DE TRES PARAMETROS");
        ciudad = new Ciudad(CP, poblacion, superficie);
        
        // Se testean las consultas triviales
        CP2 = ciudad.obtenerCP();
        poblacion2 = ciudad.obtenerPoblacion();
        superficie2 = ciudad.obtenerSuperficie();
        
        System.out.println("CONSULTAS TRIVIALES");
        System.out.print("Codigo Postal: " + CP2);
        if (CP == CP2) {
            System.out.println(" - OK");
        } else {
            System.out.println(" - ERROR");
            errores++;
        }
        System.out.print("Poblacion: " + poblacion2);
        if (poblacion == poblacion2) {
            System.out.println(" - OK");
        } else {
            System.out.println(" - ERROR");
            errores++;
        }
        System.out.print("Superficie: " + superficie2);
        if (superficie == superficie2) {
            System.out.println(" - OK");
        } else {
            System.out.println(" - ERROR");
            errores++;
        }  
        System.out.println("------------------------------------------");

        // Test de densidad
        System.out.println("TEST DE DENSIDAD");
        if (ciudad.obtenerSuperficie() == 0) {
            // No se puede obtener la densidad si la superficie de la ciudad es 0
            System.out.println("ERROR: No se puede obtener la densidad si la superficie de la ciudad es 0");
            errores++;
        } else {
            float densidad = ciudad.obtenerDensidad();
            System.out.println("Densidad: " + densidad);
        }
        System.out.println("------------------------------------------");
        
        // Test de incrementar poblacion
        System.out.println("TEST DE INCREMENTO DE POBLACION");
        int cre;
        if (modo == 'a') {
            // Modo de testeo con valores automaticos
            cre = gen.nextInt(101) - 50; // Se genera un valor dentro del rango [-50,50]
        } else {
            // Modo de testeo con valores ingresados manualmente 
            System.out.print("Ingrese el valor de poblacion a incrementar (puede ser un valor negativo): ");
            cre = ES.leerEntero();
        }
        
        poblacion = ciudad.obtenerPoblacion();
        System.out.println("Valor anterior de poblacion: " + poblacion);
        System.out.println("Sumando " + cre + " habitantes...");
        ciudad.aumentarPoblacion(cre);
        poblacion2 = ciudad.obtenerPoblacion();
        System.out.println("Nuevo valor poblacion: " + poblacion2);
        
        if ((poblacion2 - cre) == poblacion) {
            System.out.println("OK");
        } else {
            System.out.println("ERROR: Poblacion negativa");
            errores++;
        }
        System.out.println("------------------------------------------");
		
		// Test de incrementar poblacion 2
        System.out.println("TEST DE INCREMENTO DE POBLACION CON UN VALOR NEGATIVO MUY ALTO");
        int cre2 = -999999999;
        ciudad.aumentarPoblacion(cre2);
        poblacion = ciudad.obtenerPoblacion();
        System.out.println("Nuevo valor poblacion: " + poblacion);
        
        if (poblacion == 0) {
            System.out.println("OK");
        } else {
            System.out.println("ERROR: Poblacion negativa");
            errores++;
        }
        System.out.println("------------------------------------------");
        
        if (errores == 0) {
            System.out.println("TESTEO SIN ERRORES!");
        } else if (errores == 1) {
            System.out.println("SE HA REGISTRADO UN (1) ERROR");
        } else {
            System.out.println("SE HAN REGISTRADO " + errores + " ERRORES");
        }
    }
}
