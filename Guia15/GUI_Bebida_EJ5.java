//Importo paquetes
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.LineBorder;
public class GUI_Bebida_EJ5 extends JFrame
{
    /*Declarar los botones*/
    //Atributos de instancia
    private JButton botonCafe;
    private JButton botonJugo;
    private JPanel panelImagen;
    private JPanel panelBotones;
    private JLabel etiqueta;
    
    //Constructor
    public GUI_Bebida_EJ5()
    {   
        setLayout(new GridLayout(2,1));        
        botonCafe = new JButton ("Café");
        botonJugo = new JButton ("Jugo");
        etiqueta = new JLabel ();
        panelImagen = new JPanel();
        panelBotones = new JPanel();
        initGUI();
        setSize(300, 600);
    }
    
    private void initGUI()
    {        
        OyenteBotonCafe oyenteCafe = new OyenteBotonCafe();
        botonCafe.addActionListener(oyenteCafe);
        botonCafe.setMnemonic('C');
        panelBotones.add(botonCafe);
        OyenteBotonJugo oyenteJugo = new OyenteBotonJugo();
        botonJugo.addActionListener(oyenteJugo);
        botonJugo.setMnemonic('J');
        panelBotones.add(botonJugo);
        panelBotones.setBackground(Color.BLUE);
        panelBotones.setBorder(new LineBorder(Color.BLACK, 5));
        panelImagen.setBackground(Color.GREEN);
        panelImagen.setBorder(new LineBorder(Color.YELLOW, 5));  
        panelImagen.add(etiqueta);         
        getContentPane().add(panelImagen); 
        getContentPane().add(panelBotones);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    
    private class OyenteBotonCafe implements ActionListener
    {
        public void actionPerformed (ActionEvent e)
        {
            etiqueta.setIcon (new ImageIcon("Cafe.gif"));
            etiqueta.setBorder(new LineBorder(Color.PINK, 5));
        }
    }
    
    private class OyenteBotonJugo implements ActionListener
    {
        public void actionPerformed (ActionEvent e)
        {
            etiqueta.setIcon (new ImageIcon("Jugo.gif"));
            etiqueta.setBorder(new LineBorder(Color.GRAY, 5));
        }
    }
    
}