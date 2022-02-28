import java.util.Random;
public class TesterColeccion
{
    public static void main(String args[])
    {
        //---- Se crea una fabrica de 10 sectores ------
        SectoresFabrica fabrica = new SectoresFabrica(10);
        
        Robot r;
        Robot ra;
        //---- Robot #1 --------------------------------
        r = new Robot(1);
        for (int i=0; i<3; i++) {
            // Se simula el armado de autos para gastar energia y componentes
            r.armarAuto();
        }
        // Se asigna el Robot #1 a la fabrica
        fabrica.asignar(r);
        
        //---- Robot #2 --------------------------------
        r = new Robot(2);
        for (int i=0; i<2; i++) {
            // Se simula el armado de autos para gastar energia y componentes
            r.armarAuto();
        }
        // Se asigna el Robot #2 a la fabrica
        fabrica.asignar(r);
        
        //---- Robot #3 --------------------------------
        r = new Robot(3);
        fabrica.asignar(r);
        
        //---- Robot #4 --------------------------------
        ra = new RobotAlfa(4);
        ra.armarAuto();
        fabrica.asignar(ra);
        
        //---- Robot #5 --------------------------------
        r = new Robot(5);
        fabrica.asignar(r);

        //---- Robot #6 --------------------------------
        ra = new RobotAlfa(6);
        fabrica.asignar(ra);
        
        mostrarFabrica(fabrica);
        
        /**
         * Hasta aqui se deja como ejemplo la construccion y exhibicion de una fabrica con algunos robots comunes y robots Alfa
         * 
         * @todo: 
         *  + implementar casos de prueba para los ejercicios propuestos.
         *  + probarlos con otras configuraciones de fabricas propuestas por ustedes.
         */
        System.out.println("Hay dos robots consecutivos con energía máxima:" + fabrica.dosConsecutivosMaxEnergia());
        //Random rand = new Random();
        //int n = rand.nextInt(10);
        int n = 20;
        System.out.println("Nueva fábrica con los robots que pueden crear más de " + n + " autos");
        SectoresFabrica nueva = fabrica.robotsPuedenArmarNAutos(n);
        mostrarFabrica(nueva);
    }
    
    public static void mostrarFabrica(SectoresFabrica fabrica)
    {
        for (int i = 0; i < fabrica.cantSectores(); i++) {
            System.out.print("[ " + i + " ] => ");
            if (fabrica.sectorOcupado(i)) {
                System.out.println(fabrica.robotSector(i).toString());
            } else {
                System.out.println(" -- Vacio --");
            }       
        }
    }
}
