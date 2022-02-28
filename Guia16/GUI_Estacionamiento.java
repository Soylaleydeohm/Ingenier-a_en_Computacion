import java.awt.*;
import java.awt.event.*; 
import javax.swing.*; 

public class GUI_Estacionamiento extends JFrame
{
    //Atributos de instancia
    private JButton [] botones;
    private JButton estacionarAuto;
    private Estacionamiento estacionamiento;
    private JPanel panelLugares;
    private JPanel panelBoton;
    
    //Constructor 
    public GUI_Estacionamiento (Estacionamiento e)
    {
        setSize(500, 800);
        initGUI(e);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    
    private void initGUI(Estacionamiento e)
    {
        estacionamiento = e;
        botones = new JButton [e.capacidad()];
        estacionarAuto = new JButton("Ingresar Auto");
        panelLugares = new JPanel();
        panelBoton = new JPanel();
        
        BoxLayout esteLayout = new BoxLayout(panelLugares,BoxLayout.Y_AXIS);
        panelLugares.setLayout(esteLayout);
        OyenteLugares oLugares = new OyenteLugares();
        for (int i = 0; i < botones.length; i++)
        {
           // botones[i] = new JButton(""+i);
           botones[i] = new JButton();
           botones[i].setActionCommand(""+i); 
           botones[i].addActionListener(oLugares);
            botones[i].setEnabled(false);
            botones[i].setIcon(new ImageIcon("free.gif"));
            panelLugares.add(botones[i]);
        }
        OyenteBoton oBoton = new OyenteBoton();
        estacionarAuto.addActionListener(oBoton);
        panelBoton.add(estacionarAuto);
        getContentPane().add(panelLugares, BorderLayout.WEST);
        getContentPane().add(panelBoton, BorderLayout.CENTER);
    }
    
    public class OyenteBoton implements ActionListener
    {
        public void actionPerformed (ActionEvent e)
        {
            botones[estacionamiento.primerDisponible()].setIcon(new ImageIcon("auto.gif"));
            botones[estacionamiento.primerDisponible()].setEnabled(true);
            estacionamiento.ocupar(estacionamiento.primerDisponible());
            if(estacionamiento.estaLleno())
            {
                estacionarAuto.setEnabled(false);
            }
        }
    }
    
    public class OyenteLugares implements ActionListener
    {
        public void actionPerformed (ActionEvent e)
        {
            //int m= Integer.parseInt(((JButton) e.getSource()).getText());
            int m = Integer.parseInt(e.getActionCommand());
            if (estacionamiento.estaOcupado(m))
            {
                botones[m].setIcon(new ImageIcon("free.gif"));
                estacionamiento.liberar(m);
                botones[m].setEnabled(false);
                estacionarAuto.setEnabled(true);
            }
        }
    }
}
