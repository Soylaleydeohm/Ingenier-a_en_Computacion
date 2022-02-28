import javax.swing.JPanel;
import javax.swing.WindowConstants;
import javax.swing.border.LineBorder;
import javax.swing.SwingUtilities;
public class VentanaPaneles extends javax.swing.JFrame {
  private JPanel panelIzquierda;
  private JPanel panelDerecha;
  private JPanel panelCentral;
  public VentanaPaneles() {
    super();
    initGUI();
  }
  private void initGUI() {
    setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    getContentPane().setLayout(null);
    //crear, inicializar y agregar el panel izquierdo
    panelIzquierda = new JPanel();
    getContentPane().add(panelIzquierda);
    panelIzquierda.setBounds(12, 12, 126, 249);
    /*public void setBounds(int x, int y, int width, int height)
    The new location of the top-left corner is specified by x and y, and the new size is specified by width and height.*/
    panelIzquierda.setBackground(new java.awt.Color(128,255,255));
    //crear, inicializar y agregar el panel derecho
    panelDerecha = new JPanel();
    getContentPane().add(panelDerecha);
    panelDerecha.setBounds(250, 12, 126, 249);
    panelDerecha.setBackground(new java.awt.Color(0,255,128));
    //crear, inicializar y agregar el panel central
    panelCentral = new JPanel();
    getContentPane().add(panelCentral);
    panelCentral.setBounds(145, 12, 100, 249);
    panelCentral.setBorder(new LineBorder(new java.awt.Color(0,0,0), 1, false));
    pack();
    setSize(400, 300);
  }
}
