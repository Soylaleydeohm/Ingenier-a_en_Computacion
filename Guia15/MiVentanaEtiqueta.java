
import javax.swing.*; 
class MiVentanaEtiqueta extends JFrame{
//Objeto gráfico
    private JLabel etiqueta;
//Constructor
    public MiVentanaEtiqueta () {        
      setSize(300, 300);
      etiqueta= new JLabel("Café");
      etiqueta.setIcon (new ImageIcon("Cafe.gif"));
      getContentPane().add(etiqueta); 
      setDefaultCloseOperation(EXIT_ON_CLOSE);
 }
}
