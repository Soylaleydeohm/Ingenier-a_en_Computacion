import java.awt.*;
import java.awt.event.*; 
import javax.swing.*; 
//import javax.swing.border.LineBorder;

public class GUI_LA extends JFrame
{
    //Atributos de instancia
    //Atributos gráficos
    private JPanel panelCaja;
    private JPanel panelEtiqueta;
    private JPanel panelBotones;
    private JTextField texto;
    private JLabel etiqueta;
    private JButton bConf;
    private JButton bCanc;
    private JButton bSalir;
    private Container panel;
    //Atributos de la aplicación
    private PasajesReservados pReservados;
    
    //Constructor
    public GUI_LA(PasajesReservados pR)
    {
        setSize(350, 250);
        initGUI(pR);        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    
    private void initGUI(PasajesReservados pR)
    {
        panel = getContentPane();
        pReservados = pR;
        
        panelCaja = new JPanel();
        panelEtiqueta = new JPanel();
        panelBotones = new JPanel();
        texto = new JTextField();
        etiqueta = new JLabel();
        bConf = new JButton("Confirmar");
        bCanc = new JButton("Cancelar");
        bSalir = new JButton("Salir");
        
        OyenteTexto oTexto = new OyenteTexto();
        texto.setPreferredSize(new Dimension (200, 20));
        texto.addActionListener(oTexto);
        panelCaja.add(texto);
              
        panelEtiqueta.add(etiqueta);
        
        bConf.setEnabled(false);
        bCanc.setEnabled(false);
        bSalir.setEnabled(false);        
        OyenteConfirmar oConfirmar = new OyenteConfirmar();
        bConf.addActionListener(oConfirmar);
        OyenteCancelar oCancelar = new OyenteCancelar();
        bCanc.addActionListener(oCancelar);
        OyenteSalir oSalir = new OyenteSalir();
        bSalir.addActionListener(oSalir);
        panelBotones.add(bConf);
        panelBotones.add(bCanc);
        panelBotones.add(bSalir);
        
        panel.add(panelCaja, BorderLayout.NORTH);
        panel.add(panelEtiqueta, BorderLayout.CENTER);
        panel.add(panelBotones, BorderLayout.SOUTH);
    }
    
    public class OyenteTexto implements ActionListener
    {
        public void actionPerformed(ActionEvent e) {
            String m = texto.getText();
            if (pReservados.recuperarElemento(m) != null)
            {
                etiqueta.setText("Nombre del pasajero: " + pReservados.recuperarElemento(m).obtenerPasajero() + " - Fila: " + pReservados.recuperarElemento(m).obtenerFila() + " - Butaca: " + pReservados.recuperarElemento(m).obtenerButaca());
                if(!pReservados.recuperarElemento(m).obtenerConfirmada())
                {
                    habilitarBotones();
                } else { 
                    JOptionPane cartel = new JOptionPane();
                    cartel.showMessageDialog(null, "La reserva está confirmada");
                }
            } else {
                JOptionPane cartel = new JOptionPane();
                cartel.showMessageDialog(null, "No existe la reserva");
            }
            
        }
    }
        
    private void habilitarBotones()
    {
        bConf.setEnabled(true);
        bCanc.setEnabled(true);
        bSalir.setEnabled(true); 
    }
    
    private void deshabilitarBotones()
    {
        bConf.setEnabled(false);
        bCanc.setEnabled(false);
        bSalir.setEnabled(false);   
    }
    
    public class OyenteConfirmar implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            String m = (String) texto.getText();
            pReservados.recuperarElemento(m).confirmar();
            JOptionPane cartel = new JOptionPane();
            cartel.showMessageDialog(null, "La reserva está confirmada");
            bConf.setEnabled(false);
        }
    }
    
    public class OyenteCancelar implements ActionListener
    {
        public void actionPerformed (ActionEvent e)
        {
            String m = (String) texto.getText();
            pReservados.eliminar(pReservados.recuperarElemento(m));
            JOptionPane cartel = new JOptionPane();
            cartel.showMessageDialog(null, "La reserva se ha eliminado");
            texto.setText("");
            etiqueta.setText("");
            bConf.setEnabled(false);
            bCanc.setEnabled(false);
        }
    }
    
    public class OyenteSalir implements ActionListener
    {
        public void actionPerformed (ActionEvent e)
        {
            texto.setText("");
            etiqueta.setText("");
            deshabilitarBotones();
        }
    }
}
