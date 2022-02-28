import java.io.*;

class Main 
{
    public static void main(String args [])
    {
        // Atributos para inicializar el combo
        String nombre = "Combo Junior";
        String descr = "Hamburguesa, papas y gaseosa pequeñas";
        int precio = 40;
        int cantidad = 8;
        
        // Creación del Combo
        Combo miCombo = new Combo(nombre, precio, cantidad, descr);
        
        // Creación de la GUI
        GUI_Combo ventana = new GUI_Combo(miCombo);
    }
}
