import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class GUI_Combo extends JFrame
{
    //----------------------------------------------------------------------
    //---- Atributos de la aplicación --------------------------------------
    //----------------------------------------------------------------------
    private Combo miCombo;
    private int cantVendidos;

    //----------------------------------------------------------------------
    //---- Objetos Gráficos ------------------------------------------------
    //----------------------------------------------------------------------
    private JButton boton;
    private JLabel etiqueta;
    private JPanel panelCombo;    


    public GUI_Combo(Combo s)
    {
        super("Combo");
        cantVendidos = 0;
        miCombo = s;      

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(new Dimension(500, 350));

        inicializarPanelCombo();

        // Agrego el panel del combo al panel de contenido
        getContentPane().add(panelCombo);

        setVisible(true);
    }

    private void inicializarPanelCombo()
    {
        panelCombo = new JPanel();
        
        panelCombo.setLayout(new BorderLayout());
        
        // Creación del botón
        boton = new JButton();
        boton.setIcon(new ImageIcon(miCombo.getNombre()+".jpg"));
        boton.setText(miCombo.getNombre()+ ": " + miCombo.getDescripcion());
        boton.setHorizontalTextPosition(JButton.CENTER);
        boton.setVerticalTextPosition(JButton.BOTTOM);
        panelCombo.add(boton, BorderLayout.NORTH);
        Oyente oyente = new Oyente();
        boton.addActionListener(oyente);
        
        // Creación de la etiqueta
        etiqueta = new JLabel();
        etiqueta.setText(" $" + miCombo.getPrecio() + " - quedan " + miCombo.getCantidad() + " - recaudado: $" + (cantVendidos * miCombo.getPrecio()));
        etiqueta.setHorizontalTextPosition(JLabel.CENTER);
        etiqueta.setHorizontalAlignment(JLabel.CENTER);
        etiqueta.setVerticalTextPosition(JLabel.TOP); 
        panelCombo.add(etiqueta, BorderLayout.CENTER);
    }

    /**
     * @todo: implementar un oyente que ejecute las siguientes acciones al presionar el botón:
     *   + vender una unidad del combo
     *   + actualizar la etiqueta de información
     *   + si ya no quedan unidades disponibles, deshabilitar el botón
     */
    private class Oyente implements ActionListener
    {
        public void actionPerformed(ActionEvent event)   {
            miCombo.vender();  
            cantVendidos++;
            etiqueta.setText(" $" + miCombo.getPrecio() + " - quedan " + miCombo.getCantidad() + " - recaudado: $" + (cantVendidos * miCombo.getPrecio()));
            if(miCombo.getCantidad() == 0)
                boton.setEnabled(false);
        }
    }
}