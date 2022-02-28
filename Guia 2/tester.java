import IPOO.*;
public class tester {
    public static void main (String[] args){
        Empleado emp1;
        int leg, cH;
        float vH;
        
        System.out.println("Ingrese el número de legajo, la cantidad de horas de trabajo y el monto percibido por cada hora");
            leg = ES.leerEntero();
            cH = ES.leerEntero();
            vH = ES.leerFloat();
            
        //Tester 1    
        emp1 = new Empleado(leg, cH, vH);
        System.out.println("El número de legajo es " + emp1.obtenerLegajo());
        System.out.println("El sueldo del empleado es " + emp1.obtenerSueldo());
        
        //Tester 2
        emp1 = new Empleado(leg);
        emp1.establecerCantHoras(cH);
        emp1.establecerValorHora(vH);
        System.out.println("El número de legajo es " + emp1.obtenerLegajo());
        System.out.println("El sueldo del empleado es " + emp1.obtenerSueldo());
    }
}