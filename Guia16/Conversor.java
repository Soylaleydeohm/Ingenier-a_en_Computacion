import java.awt.*;
import java.awt.event.*; 
import javax.swing.*; 

public class Conversor extends JFrame
{
    private JLabel etiquetaMts;
    private JLabel etiquetaKms;
    private JTextField entrada, salida;
    private Container panel;

    public Conversor() 
    {
        setSize(400, 100);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        initGUI ();
    }

    private void initGUI()
    {   
        panel = getContentPane();
        panel.setLayout(new GridLayout(2,2));
        etiquetaMts = new JLabel ("Metros: ");
        etiquetaKms = new JLabel ("Kilometros: ");
        
        entrada = new JTextField();
        salida = new JTextField();
        salida.setEditable(false);
        // Agregamos todo al contenedor, al que le pusimos "panel":
        panel.add(etiquetaMts);
        panel.add(entrada);
        panel.add(etiquetaKms);
        panel.add(salida);
        // Oiga
        Oyente oyente = new Oyente();
        entrada.addActionListener(oyente);
        //Modificación Ej 4
        salida.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                entrada.setText("");
                salida.setText("");
            }
        });
    }
    
    private class Oyente implements ActionListener {

        public void actionPerformed(ActionEvent event){  
            Float cuenta = ((float)Integer.parseInt(entrada.getText()))/1000;
            salida.setText(cuenta.toString());
        }
    }      
      
    
}
