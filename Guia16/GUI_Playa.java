import java.awt.*;
import java.awt.event.*; 
import javax.swing.*; 
import javax.swing.border.LineBorder;

public class GUI_Playa extends JFrame
{
    //Atributos de instancia
    private Container panel;
    private JPanel panelSuperior;
    private JPanel panelInferior;
    private JComboBox comboNumeros;
    private Playa playa;
    private JRadioButton cargarGasoil;
    private JRadioButton cargarSuper;
    private JRadioButton cargarPremium;
    private JTextField valor;
    private JButton comprar;
    private JButton recargar;
    private JLabel stockG;
    private JLabel stockS;
    private JLabel stockP;
    private JTextField cantGasoil;
    private JTextField cantSuper;
    private JTextField cantPremium;
    private JPanel panelUsuario;
    private JPanel panelPantalla;
    private ButtonGroup group;

    //Constructor
    public GUI_Playa(Playa p)
    {
        setSize(350, 250);
        initGUI(p);        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private void initGUI(Playa p)
    {
        panel = getContentPane();
        panelSuperior = new JPanel();        
        panelInferior = new JPanel();
        playa = p;
        panelUsuario = new JPanel();
        panelPantalla = new JPanel();

        //Panel Superior
        comboNumeros = new JComboBox();
        for (int i = 0; i < p.obtenerCantidad(); i++)
            comboNumeros.addItem(i+1);
        comboNumeros.setSelectedIndex(0);
        OyenteCombo oyente = new OyenteCombo ();
        comboNumeros.addActionListener(oyente);        
        panelSuperior.add(comboNumeros);

        //Panel Inferior
        initPanelUsuario();
        initPanelPantalla();
        panelInferior.add(panelUsuario,BorderLayout.WEST);
        panelInferior.add(panelPantalla,BorderLayout.CENTER);
        panelInferior.setVisible(false);

        panel.add(panelSuperior,BorderLayout.NORTH);
        panel.add(panelInferior,BorderLayout.CENTER);
    }

    private void initPanelUsuario()
    {
        BoxLayout esteLayout = new BoxLayout(panelUsuario,BoxLayout.Y_AXIS);
        panelUsuario.setLayout(esteLayout);
        panelUsuario.setBorder(new LineBorder(Color.BLACK, 1));

        //Inicializo los atributos
        group = new ButtonGroup();
        cargarGasoil = new JRadioButton("Gasoil");
        cargarSuper = new JRadioButton("Super");
        cargarPremium = new JRadioButton("Premium");
        group.add(cargarGasoil);
        group.add(cargarSuper);
        group.add(cargarPremium);
        valor = new JTextField("<Valor>");
        comprar = new JButton("Comprar");
        recargar = new JButton("Recargar");

        cargarGasoil.setEnabled(false);
        cargarSuper.setEnabled(false);
        cargarPremium.setEnabled(false);
        valor.setEnabled(false);

        //Oyentes
        OyenteComprar oyenteC = new OyenteComprar();
        comprar.addActionListener(oyenteC);
        OyenteRecargar oyenteR = new OyenteRecargar();
        recargar.addActionListener(oyenteR);
        OyenteCuadro oyenteCuad = new OyenteCuadro();
        valor.addActionListener(oyenteCuad); 
        OyenteRButton oyenteRB = new OyenteRButton();
        cargarGasoil.addActionListener(oyenteRB);
        cargarSuper.addActionListener(oyenteRB);
        cargarPremium.addActionListener(oyenteRB);

        //Agrego los atributos a los paneles        
        panelUsuario.add(cargarGasoil);
        panelUsuario.add(cargarSuper);
        panelUsuario.add(cargarPremium);
        panelUsuario.add(valor);
        panelUsuario.add(comprar);
        panelUsuario.add(recargar);   
    }

    private void initPanelPantalla()
    {
        panelPantalla.setLayout(new GridLayout(3,2));
        //Inicializo los atributos
        stockG = new JLabel("Stock Gasoil");
        stockS = new JLabel("Stock Super");
        stockP = new JLabel("Stock Premium");
        cantGasoil = new JTextField("");
        cantGasoil.setEditable(false);
        cantSuper = new JTextField("");
        cantSuper.setEditable(false);
        cantPremium = new JTextField("");
        cantPremium.setEditable(false);           

        //Agrego los atributos a los paneles
        panelPantalla.add(stockG);
        panelPantalla.add(cantGasoil);
        panelPantalla.add(stockS);
        panelPantalla.add(cantSuper);
        panelPantalla.add(stockP);
        panelPantalla.add(cantPremium);

    }

    public class OyenteCombo implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            int m = (int)comboNumeros.getSelectedItem();
            habilitarPanelInferior(m);
            comboNumeros.setEnabled(false);
        }
    }
    
    private void habilitarPanelInferior(int m)
    {
        panelInferior.setVisible(true);
        modificarPanelPantalla();
    }   
   
    private void modificarPanelPantalla()
    {        
        int n = ((int)comboNumeros.getSelectedItem())-1;
        cantGasoil.setText("" + playa.obtenerSurtidor(n).obtenerLitrosGasoil());
        cantSuper.setText("" + playa.obtenerSurtidor(n).obtenerLitrosSuper());
        cantPremium.setText("" + playa.obtenerSurtidor(n).obtenerLitrosPremium());
    }

    private class OyenteComprar implements ActionListener {

        public void actionPerformed(ActionEvent event){  
            habilitarOpciones();
        }
    }

    private class OyenteRecargar implements ActionListener {

        public void actionPerformed(ActionEvent event){  
            playa.LlenarDepositosGasoil();
            playa.LlenarDepositosSuper();
            playa.LlenarDepositosPremium();
            modificarPanelPantalla();
            comboNumeros.setEnabled(true);
        }
    }

    private class OyenteCuadro implements ActionListener {
        public void actionPerformed(ActionEvent event){              
            Integer cargar = (int)Integer.parseInt(valor.getText());
            int n = ((int)comboNumeros.getSelectedItem())-1;
            // Agrego un panel de diálogo porque soy banana
            JOptionPane cartel = new JOptionPane();
            if(cargarGasoil.isSelected()) 
            {
                if(playa.obtenerSurtidor(n).obtenerLitrosGasoil() >= cargar)
                    playa.obtenerSurtidor(n).extraerGasoil(cargar);
                else
                    cartel.showMessageDialog(null, "No hay combustible suficiente");
            }
            if(cargarSuper.isSelected()) 
            {
                if(playa.obtenerSurtidor(n).obtenerLitrosSuper() >= cargar)
                    playa.obtenerSurtidor(n).extraerSuper(cargar);
                else
                    cartel.showMessageDialog(null, "No hay combustible suficiente");
            }
            if(cargarPremium.isSelected()) 
            {
                if(playa.obtenerSurtidor(n).obtenerLitrosPremium() >= cargar)
                    playa.obtenerSurtidor(n).extraerPremium(cargar);
                else
                    cartel.showMessageDialog(null, "No hay combustible suficiente");
            }
            group.clearSelection();
            deshabilitarOpciones();
            panelInferior.setVisible(false);
            comboNumeros.setEnabled(true);
             
            valor.setText("<Valor>");
        }
    }
    
    public class OyenteRButton implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if(cargarGasoil.isSelected()||cargarSuper.isSelected()||cargarPremium.isSelected())   
                valor.setEnabled(true);
        }
    }
        private void habilitarOpciones()
        {
            cargarGasoil.setEnabled(true);
            cargarSuper.setEnabled(true);
            cargarPremium.setEnabled(true);
            comprar.setEnabled(false);
            recargar.setEnabled(false);
        }

        private void deshabilitarOpciones()
        {
            cargarGasoil.setEnabled(false);
            cargarSuper.setEnabled(false);
            cargarPremium.setEnabled(false);           
            valor.setEnabled(false);
            comprar.setEnabled(true); 
            recargar.setEnabled(true);
        }

    
}
