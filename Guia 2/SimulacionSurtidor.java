import IPOO.*;
import java.util.Random;
public class SimulacionSurtidor{    
    public static void main (String[] args){        
        int n, i, rand, cG, cS, cP;
        Random gen = new Random();
        Surtidor surt = new Surtidor();
        System.out.println("Ingrese la cantidad de veces que desea realizar la iteración");
        n = ES.leerEntero();
        /*for (i = 0; i < n; i++){
            System.out.println("Combustible disponible en cada depósito: Gasoil: "+surt.obtenerLitrosGasoil()+" lts; Nafta Super: "+surt.obtenerLitrosSuper()+" lts; Nafta Premium 2000: "+surt.obtenerLitrosPremium()+" lts.");
            rand = gen.nextInt(32);
            if (rand < 10){
                System.out.println("Ingrese los litros de Gasoil a cargar");
                cG = ES.leerEntero;                
                surt.extraerGasoil(cG);
            } else if (rand < 20) {
                System.out.println("Ingrese los litros de Nafta Super a cargar");
                cS = ES.leerEntero;                
                surt.extraerSuper(cS);
            } else if (rand < 30) {
                System.out.println("Ingrese los litros de Nafta Premium 2000 a cargar");
                cP = ES.leerEntero;                
                surt.extraerPremium(cP);
            } else if (rand == 31) {
                surt.llenarDepositoGasoil();
            }else if (rand == 32) {
                surt.llenarDepositoSuper();
            }else {
                surt.llenarDepositoPremium();
            }
            System.out.println("Combustible disponible en cada depósito luego de la operación: Gasoil: "+surt.obtenerLitrosGasoil()+" lts; Nafta Super: "+surt.obtenerLitrosSuper()+" lts; Nafta Premium 2000: "+surt.obtenerLitrosPremium()+" lts.");            
        }*/
        for (i = 0; i < n; i++){
            System.out.println("Combustible disponible en cada depósito: Gasoil: "+surt.obtenerLitrosGasoil()+" lts; Nafta Super: "+surt.obtenerLitrosSuper()+" lts; Nafta Premium 2000: "+surt.obtenerLitrosPremium()+" lts.");
            rand = gen.nextInt(32);
            if (rand < 10){                
                cG = 500;                
                surt.extraerGasoil(cG);
            } else if (rand < 20) {                
                cS = 500;                
                surt.extraerSuper(cS);
            } else if (rand < 30) {                
                cP = 500;                
                surt.extraerPremium(cP);
            } else if (rand == 31) {
                surt.llenarDepositoGasoil();
            }else if (rand == 32) {
                surt.llenarDepositoSuper();
            }else {
                surt.llenarDepositoPremium();
            }
            System.out.println("Combustible disponible en cada depósito luego de la operación: Gasoil: "+surt.obtenerLitrosGasoil()+" lts; Nafta Super: "+surt.obtenerLitrosSuper()+" lts; Nafta Premium 2000: "+surt.obtenerLitrosPremium()+" lts.");            
        }
    }    
}