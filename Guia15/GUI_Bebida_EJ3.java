
//Importo paquetes
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.LineBorder;
public class GUI_Bebida_EJ3 extends JFrame
{
    /*Declarar los botones*/
    //Atributos de instancia
    private JButton botonCafe;
    private JButton botonJugo;
    private JPanel panel;
    private JLabel etiqueta;
    
    //Constructor
    public GUI_Bebida_EJ3()
    {                
        botonCafe = new JButton ("Café");
        botonJugo = new JButton ("Jugo");
        etiqueta = new JLabel ();
        panel = new JPanel();
        initGUI();
        setSize(600, 300);
    }
    
    private void initGUI()
    {        
        panel.setLayout(new GridLayout()); 
        OyenteBotonCafe oyenteCafe = new OyenteBotonCafe();
        botonCafe.addActionListener(oyenteCafe);
        botonCafe.setMnemonic('C');
        botonCafe.setBorder(new LineBorder(Color.PINK, 5));
        panel.add(botonCafe);
        OyenteBotonJugo oyenteJugo = new OyenteBotonJugo();
        botonJugo.addActionListener(oyenteJugo);
        botonJugo.setMnemonic('J');
        botonJugo.setBorder(new LineBorder(Color.GRAY, 5));
        panel.add(botonJugo);
        panel.add(etiqueta);
        getContentPane().add(panel);  
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    
    private class OyenteBotonCafe implements ActionListener
    {
        public void actionPerformed (ActionEvent e)
        {
            etiqueta.setIcon (new ImageIcon("Cafe.gif"));
        }
    }
    
    private class OyenteBotonJugo implements ActionListener
    {
        public void actionPerformed (ActionEvent e)
        {
            etiqueta.setIcon (new ImageIcon("Jugo.gif"));
        }
    }
    
}
