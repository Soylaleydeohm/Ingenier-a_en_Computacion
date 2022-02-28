public class Tester
{
    public static void main(String args[])
    {
        //---- Se crea una fabrica con capacidad para 10 robots ------
        Fabrica fabrica = new Fabrica(10);
        
        Robot r;
        
        //---- Robot #1 --------------------------------
        r = new Robot(1);
        for (int i=0; i<3; i++) {
            // Se simula el armado de autos para gastar energia y componentes
            r.armarAuto();
        }
        // Se asigna el Robot #1 a la fabrica
        fabrica.asignar(r);
        
        //---- Robot #2 --------------------------------
        r = new RobotAlfa(2);
        for (int i=0; i<2; i++) {
            // Se simula el armado de autos para gastar energia y componentes
            r.armarAuto();
        }
        // Se asigna el Robot #2 a la fabrica
        fabrica.asignar(r);
        
        //---- Robot #3 --------------------------------
        r = new RobotBeta(3);
        for (int i=0; i<3; i++) {
            // Se simula el armado de autos para gastar energia y componentes
            r.armarAuto();
        }
        // Se asigna el Robot #3 a la fabrica
        fabrica.asignar(r);
        
        //---- Robot #4 --------------------------------
        RobotAlfa ra = new RobotAlfa(4);
        for (int i=0; i<4; i++) {
            // Se simula el armado de camiones para gastar energia y componentes
            ra.armarCamion();
        }
        // Se asigna el Robot #4 a la fabrica
        fabrica.asignar(ra);
        
        //---- Robot #5 --------------------------------
        RobotBeta rb = new RobotBeta(5);
        for (int i=0; i<3; i++) {
            // Se simula el armado de aviones para gastar energia y componentes
            rb.armarAvion();
        }
        // Se asigna el Robot #5 a la fabrica
        fabrica.asignar(rb);
        
        mostrarFabrica(fabrica);
        
        ///// Cantidad disponible ///
        System.out.println( "El robot en la posición 2 puede armar " + r.cantAutos() + " autos." );
        System.out.println( "El robot en la posición 3 puede armar " + ra.cantAutos() + " autos." );
        System.out.println( "El robot en la posición 3 puede armar " + ra.cantCamiones() + " camiones." );
        System.out.println( "El robot en la posición 4 puede armar " + rb.cantAutos() + " autos." );
        System.out.println( "El robot en la posición 4 puede armar " + rb.cantAviones() + " aviones." );
        
        fabrica.desasignar(r);
        
        mostrarFabrica(fabrica);
        
        /**
         * @todo: 
         *  + Crear mas robots (algunos de clase RobotBeta), hacerlos consumir energia de acuerdo al caso de prueba definido
         *    y asignarlos a la fabrica y probar los metodos:
         *      - desasignar(r: Robot)
         *      - existenNRobotsVU(n: int, vu: int): boolean
         *  + Crear otra fabrica para poder probar:
         *      - equals(otra: Fabrica): boolean
         *    Tener en cuenta a la hora de armar el caso de prueba en este punto que la comparacion es por identidad!
         */
        
        System.out.println("Hay al menos 3 robots con vida útil mayor a 100:" + fabrica.existenNRobotsVU(3,100));
        System.out.println("Hay al menos 6 robots con vida útil mayor a 100:" + fabrica.existenNRobotsVU(6,100));
        System.out.println("Hay al menos 2 robots con vida útil mayor a 300:" + fabrica.existenNRobotsVU(3,300));
        System.out.println("Hay al menos 5 robots con vida útil mayor a 100:" + fabrica.existenNRobotsVU(5,100));
        System.out.println("Hay al menos 1 robot con vida útil mayor a 4700:" + fabrica.existenNRobotsVU(1,4700));
        System.out.println("Hay al menos 1 robot con vida útil mayor a 5000:" + fabrica.existenNRobotsVU(1,5000));
        
        
        
        
        ///////////// Nueva fábrica   ///////////
        
        Fabrica fabrica1 = new Fabrica(10);
        
      
        //---- Robot #1 --------------------------------
        r = new Robot(1);
        for (int i=0; i<3; i++) {
            // Se simula el armado de autos para gastar energia y componentes
            r.armarAuto();
        }
        // Se asigna el Robot #1 a la fabrica
        fabrica1.asignar(r);
        
        //---- Robot #2 --------------------------------
        r = new RobotAlfa(2);
        for (int i=0; i<2; i++) {
            // Se simula el armado de autos para gastar energia y componentes
            r.armarAuto();
        }
        // Se asigna el Robot #2 a la fabrica
        fabrica1.asignar(r);
        
        //---- Robot #3 --------------------------------
        r = new RobotBeta(3);
        for (int i=0; i<3; i++) {
            // Se simula el armado de autos para gastar energia y componentes
            r.armarAuto();
        }
        // Se asigna el Robot #3 a la fabrica
        fabrica1.asignar(r);
        
        //---- Robot #4 --------------------------------
        ra = new RobotAlfa(4);
        for (int i=0; i<4; i++) {
            // Se simula el armado de camiones para gastar energia y componentes
            ra.armarCamion();
        }
        // Se asigna el Robot #4 a la fabrica
        fabrica1.asignar(ra);
        
        //---- Robot #5 --------------------------------
        rb = new RobotBeta(5);
        for (int i=0; i<3; i++) {
            // Se simula el armado de aviones para gastar energia y componentes
            rb.armarAvion();
        }
        // Se asigna el Robot #5 a la fabrica
        fabrica1.asignar(rb);
        
        //mostrarFabrica(fabrica1);
        
        ///////////// Nueva fábrica 2  ///////////
        
        Fabrica fabrica2 = new Fabrica(10);
        
        //---- Robot #1 --------------------------------
        r = new Robot(1);
        for (int i=0; i<3; i++) {
            // Se simula el armado de autos para gastar energia y componentes
            r.armarAuto();
        }
        // Se asigna el Robot #1 a la fabrica
        fabrica2.asignar(r);
        
        //---- Robot #2 --------------------------------
        r = new RobotAlfa(2);
        for (int i=0; i<2; i++) {
            // Se simula el armado de autos para gastar energia y componentes
            r.armarAuto();
        }
        // Se asigna el Robot #2 a la fabrica
        fabrica2.asignar(r);
        
        //---- Robot #3 --------------------------------
        r = new RobotBeta(3);
        for (int i=0; i<3; i++) {
            // Se simula el armado de autos para gastar energia y componentes
            r.armarAuto();
        }
        // Se asigna el Robot #3 a la fabrica
        fabrica2.asignar(r);
        
        //---- Robot #4 --------------------------------
        ra = new RobotAlfa(4);
        for (int i=0; i<4; i++) {
            // Se simula el armado de camiones para gastar energia y componentes
            ra.armarCamion();
        }
        // Se asigna el Robot #4 a la fabrica
        fabrica2.asignar(ra);      
      
        mostrarFabrica(fabrica2);
        
        ///////////// Nueva fábrica 3  ///////////
        
        Fabrica fabrica3 = new Fabrica(10);
        
        //---- Robot #1 --------------------------------
        r = new Robot(1);
        for (int i=0; i<3; i++) {
            // Se simula el armado de autos para gastar energia y componentes
            r.armarAuto();
        }
        // Se asigna el Robot #1 a la fabrica
        fabrica3.asignar(r);
        
        //---- Robot #2 --------------------------------
        r = new RobotAlfa(2);
        for (int i=0; i<2; i++) {
            // Se simula el armado de autos para gastar energia y componentes
            r.armarAuto();
        }
        // Se asigna el Robot #2 a la fabrica
        fabrica3.asignar(r);
        
        //---- Robot #3 --------------------------------
        ra = new RobotAlfa(4);
        for (int i=0; i<4; i++) {
            // Se simula el armado de camiones para gastar energia y componentes
            ra.armarCamion();
        }
        // Se asigna el Robot #3 a la fabrica
        fabrica3.asignar(ra);
        
        //---- Robot #4 --------------------------------
        rb = new RobotBeta(5);
        for (int i=0; i<3; i++) {
            // Se simula el armado de aviones para gastar energia y componentes
            rb.armarAvion();
        }
        // Se asigna el Robot #4 a la fabrica
        fabrica3.asignar(rb);
        
        //mostrarFabrica(fabrica3);
        
        System.out.println("Fábrica 1 igual a fábrica 2:" + fabrica.equals(fabrica1));
        System.out.println("Fábrica 1 igual a fábrica 3:" + fabrica.equals(fabrica2));
        System.out.println("Fábrica 1 igual a fábrica 4:" + fabrica.equals(fabrica3));
        System.out.println("Fábrica 2 igual a fábrica 3:" + fabrica1.equals(fabrica2));
        System.out.println("Fábrica 2 igual a fábrica 4:" + fabrica1.equals(fabrica3));
        System.out.println("Fábrica 3 igual a fábrica 4:" + fabrica2.equals(fabrica3));
                      
        
    }
    
    public static void mostrarFabrica(Fabrica fabrica)
    {
        for (int i = 0; i < fabrica.capacidadOcupada(); i++) {
            System.out.print("[ " + i + " ] => ");
            System.out.println(fabrica.robotEnPosicion(i).toString());  
        }
        
        for (int i = fabrica.capacidadOcupada(); i < fabrica.capacidadTotal(); i++) {
            System.out.print("[ " + i + " ] => ");
            System.out.println("-- Vacio --");
        }
    }
}