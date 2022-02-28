//Importo paquetes
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.LineBorder;
public class GUI_Bebida extends JFrame
{
    /*Declarar los botones*/
    //Atributos de instancia
    private JButton botonCafe;
    private JButton botonJugo;
    private JPanel panelImagen;
    private JPanel panelBotones;
    private JLabel etiqueta;
    
    //Constructor
    public GUI_Bebida()
    {   
        setLayout(new GridLayout(1,2));        
        botonCafe = new JButton ("Café");
        botonJugo = new JButton ("Jugo");
        etiqueta = new JLabel ();
        panelImagen = new JPanel();
        panelBotones = new JPanel();
        initGUI();
        setSize(600, 300);
    }
    
    private void initGUI()
    {        
        OyenteBotonCafe oyenteCafe = new OyenteBotonCafe();
        botonCafe.addActionListener(oyenteCafe);
        botonCafe.setMnemonic('C');
        botonCafe.setBorder(new LineBorder(Color.PINK, 5));
        panelBotones.add(botonCafe);
        OyenteBotonJugo oyenteJugo = new OyenteBotonJugo();
        botonJugo.addActionListener(oyenteJugo);
        botonJugo.setMnemonic('J');
        botonJugo.setBorder(new LineBorder(Color.GRAY, 5));
        panelBotones.setBackground(Color.BLUE);
        panelImagen.setBackground(Color.GREEN);
        panelBotones.add(botonJugo);
        //etiqueta.setHorizontalAlignment(JLabel.CENTER);
        //etiqueta.setVerticalAlignment(JLabel.CENTER);
        panelImagen.add(etiqueta);
        getContentPane().add(panelBotones); 
        getContentPane().add(panelImagen);  
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
