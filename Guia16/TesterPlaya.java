
public class TesterPlaya
{
    public static void main() {
        Playa p = new Playa(10);
        p.agregarSurtidor();
        p.agregarSurtidor();
        p.agregarSurtidor();
        p.agregarSurtidor();
        p.agregarSurtidor();
        p.agregarSurtidor();
        
        GUI_Playa pS = new GUI_Playa(p);
        pS.setVisible(true);
    
    
    
    
    }
}
