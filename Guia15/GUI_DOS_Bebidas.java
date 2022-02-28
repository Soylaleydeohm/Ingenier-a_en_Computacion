//Importo paquetes
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.LineBorder;
public class GUI_DOS_Bebidas extends JFrame
{
    /*Declarar los botones*/
    //Atributos de instancia
    private JButton botonCafe;
    private JButton botonJugo;
    private JPanel panelImagen;
    private JPanel panelBotones;
    private JLabel etiquetaC;
    private JLabel etiquetaJ;
    
    //Constructor
    public GUI_DOS_Bebidas()
    {   
        setLayout(new GridLayout(2,1));        
        botonCafe = new JButton ("Café");
        botonJugo = new JButton ("Jugo");
        etiquetaC = new JLabel ();
        etiquetaJ = new JLabel ();
        panelImagen = new JPanel();
        panelBotones = new JPanel();
        initGUI();
        setSize(500, 600);
    }
    
    private void initGUI()
    {        
        OyenteBotonCafe oyenteCafe = new OyenteBotonCafe();
        botonCafe.addActionListener(oyenteCafe);
        panelBotones.add(botonCafe);
        OyenteBotonJugo oyenteJugo = new OyenteBotonJugo();
        botonJugo.addActionListener(oyenteJugo);
        panelBotones.add(botonJugo);
        panelBotones.setBackground(Color.BLUE);
        panelImagen.setBackground(Color.BLACK);
        panelImagen.setLayout(new GridLayout(1,2));
        panelImagen.add(etiquetaC);     
        panelImagen.add(etiquetaJ); 
        getContentPane().add(panelImagen); 
        getContentPane().add(panelBotones);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    
    private class OyenteBotonCafe implements ActionListener
    {
        public void actionPerformed (ActionEvent e)
        {
            etiquetaC.setIcon (new ImageIcon("Cafe.gif"));
            etiquetaJ.setIcon (new ImageIcon("Circulo.gif"));
        }
    }
    
    private class OyenteBotonJugo implements ActionListener
    {
        public void actionPerformed (ActionEvent e)
        {
            etiquetaC.setIcon (new ImageIcon("Circulo.gif"));
            etiquetaJ.setIcon (new ImageIcon("Jugo.gif"));
        }
    }
    
}