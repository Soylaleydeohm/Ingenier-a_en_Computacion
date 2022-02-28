import java.awt.*;
import java.awt.event.*; 
import javax.swing.*; 
import javax.swing.border.LineBorder;

public class GUI_Surtidor extends JFrame
{
    //Atributos de instancia
    private Container panel;
    private Surtidor surtidor;
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
    public GUI_Surtidor()
    {
        super("Surtidor");
        setSize(500, 200);
        panel = getContentPane();
        panelUsuario = new JPanel();
        initPanelUsuario();
        panelPantalla = new JPanel();
        initPanelPantalla();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
        
    private void initPanelUsuario()
    {
        BoxLayout esteLayout = new BoxLayout(panelUsuario,BoxLayout.Y_AXIS);
        panelUsuario.setLayout(esteLayout);
        panelUsuario.setBorder(new LineBorder(Color.BLACK, 1));
        
        //Inicializo los atributos
        surtidor = new Surtidor();
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
        
        //Agrego los atributos a los paneles        
        panelUsuario.add(cargarGasoil);
        panelUsuario.add(cargarSuper);
        panelUsuario.add(cargarPremium);
        panelUsuario.add(valor);
        panelUsuario.add(comprar);
        panelUsuario.add(recargar);   
        
        panel.add(panelUsuario,BorderLayout.WEST);
    }
    
    private void initPanelPantalla()
    {
        panelPantalla.setLayout(new GridLayout(3,2));
               
        //Inicializo los atributos
        stockG = new JLabel("Stock Gasoil");
        stockS = new JLabel("Stock Super");
        stockP = new JLabel("Stock Premium");
        cantGasoil = new JTextField("" + surtidor.obtenerLitrosGasoil());
        cantGasoil.setEditable(false);
        cantSuper = new JTextField("" + surtidor.obtenerLitrosSuper());
        cantSuper.setEditable(false);
        cantPremium = new JTextField("" + surtidor.obtenerLitrosPremium());
        cantPremium.setEditable(false);           
                      
        //Agrego los atributos a los paneles
        panelPantalla.add(stockG);
        panelPantalla.add(cantGasoil);
        panelPantalla.add(stockS);
        panelPantalla.add(cantSuper);
        panelPantalla.add(stockP);
        panelPantalla.add(cantPremium);
                
        panel.add(panelPantalla,BorderLayout.CENTER);
    }
    
    private class OyenteComprar implements ActionListener {

        public void actionPerformed(ActionEvent event){  
            habilitarOpciones();
        }
    }
    
    private class OyenteRecargar implements ActionListener {

        public void actionPerformed(ActionEvent event){  
            surtidor.llenarDepositoGasoil();
            surtidor.llenarDepositoSuper();
            surtidor.llenarDepositoPremium();
            cantGasoil.setText("" + surtidor.obtenerLitrosGasoil());
            cantSuper.setText("" + surtidor.obtenerLitrosSuper());
            cantPremium.setText("" + surtidor.obtenerLitrosPremium());
        }
    }
    
    private class OyenteCuadro implements ActionListener {

        public void actionPerformed(ActionEvent event){  
            Integer cargar = (int)Integer.parseInt(valor.getText());
            // Agrego un panel de diálogo porque soy banana
            JOptionPane cartel = new JOptionPane();
            if(cargarGasoil.isSelected()) 
            {
                if(surtidor.obtenerLitrosGasoil() >= cargar)
                    surtidor.extraerGasoil(cargar);
                else
                    cartel.showMessageDialog(null, "No hay combustible suficiente");
            }
            if(cargarSuper.isSelected()) 
            {
                if(surtidor.obtenerLitrosSuper() >= cargar)
                    surtidor.extraerSuper(cargar);
                else
                    cartel.showMessageDialog(null, "No hay combustible suficiente");
            }
            if(cargarPremium.isSelected()) 
            {
                if(surtidor.obtenerLitrosPremium() >= cargar)
                    surtidor.extraerPremium(cargar);
                else
                    cartel.showMessageDialog(null, "No hay combustible suficiente");
            }
            cantGasoil.setText("" + surtidor.obtenerLitrosGasoil());
            cantSuper.setText("" + surtidor.obtenerLitrosSuper());
            cantPremium.setText("" + surtidor.obtenerLitrosPremium());
            deshabilitarOpciones();
        }
    }   
          
    private void habilitarOpciones()
    {
        cargarGasoil.setEnabled(true);
        cargarSuper.setEnabled(true);
        cargarPremium.setEnabled(true);
        valor.setEnabled(true);
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
