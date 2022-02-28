
public class TesterEstacionamiento
{
    public static void main() {
        Estacionamiento est = new Estacionamiento(6);
       
        GUI_Estacionamiento e = new GUI_Estacionamiento(est);
        e.setVisible(true); 
       
    }
}

