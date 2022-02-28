//Importo paquetes
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.LineBorder;
public class GUI_DOS_Bebidas_EJ7 extends JFrame
{
    /*Declarar los botones*/
    //Atributos de instancia
    private JButton botonCafe;
    private JButton botonJugo;
    private JPanel panelContador;
    private JPanel panelBotones;
    private JLabel etiquetaC;
    private JLabel etiquetaJ;
    private int cantC;
    private int cantJ;
    
    //Constructor
    public GUI_DOS_Bebidas_EJ7()
    {   
        setLayout(new GridLayout(2,1));        
        botonCafe = new JButton ("Café");
        botonJugo = new JButton ("Jugo");
        etiquetaC = new JLabel ();
        etiquetaJ = new JLabel ();
        panelContador = new JPanel();
        panelBotones = new JPanel();
        cantC = 0;
        cantJ = 0;
        initGUI();
        setSize(200, 200);
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
        panelContador.setLayout(new GridLayout(1,2));
        //etiquetaC.setHorizontalTextPosition(50);
        //etiquetaJ.setHorizontalTextPosition(150);
        panelContador.add(etiquetaC);     
        panelContador.add(etiquetaJ); 
        getContentPane().add(panelContador); 
        getContentPane().add(panelBotones);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    
    private class OyenteBotonCafe implements ActionListener
    {
        public void actionPerformed (ActionEvent e)
        {
            cantC++;
            etiquetaC.setText ("" + cantC);
            etiquetaJ.setText ("" + cantJ);
        }
    }
    
    private class OyenteBotonJugo implements ActionListener
    {
        public void actionPerformed (ActionEvent e)
        {
            cantJ++;
            etiquetaC.setText ("" + cantC);
            etiquetaJ.setText ("" + cantJ);
        }
    }
    
}