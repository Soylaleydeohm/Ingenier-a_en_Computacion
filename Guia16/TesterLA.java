
public class TesterLA
{
    public static void main() {
        PasajesReservados p = new PasajesReservados(10);
        p.insertar(new ReservaPasaje("1234", "German", 3, 5));
        p.insertar(new ReservaPasaje("1237", "Zurdo", 5, 8));
        p.insertar(new ReservaPasaje("1243", "Francisco", 7, 17));
        p.insertar(new ReservaPasaje("1258", "Ignacio", 9, 22));
        p.insertar(new ReservaPasaje("1263", "Blondie", 11, 28));
        
        GUI_LA pS = new GUI_LA(p);
        pS.setVisible(true);
    
    
    
    
    }
}
