import java.awt.*;
import java.awt.event.*; 
import javax.swing.*; 

public class GUI_SpaceObject extends JFrame
{
    //Atributos de instancia
    private JPanel panelOpciones;
    private JPanel panelImagen;
    private JPanel panelInfo;
    private JPanel panelSalida;
    private JPanel panel1;
    private JPanel panelIntro;
    private JPanel panelComboBox;
    private JPanel panelComentario;
    private JPanel panelLista;
    private JPanel panel2;  
    private JRadioButton botonNeb;
    private JRadioButton botonGal;
    private JRadioButton botonCum;
    private JRadioButton botonMessier;
    private JRadioButton botonTodo;
    private ButtonGroup group; 
    private JComboBox spaceObject;  
    private JComboBox nebObject;  
    private JComboBox cumObject;  
    private JComboBox galObject;  
    private JComboBox messierObject;
    private JLabel etiqueta;
    private JTextArea textoIntro;
    private JTextArea textoInfo;
    private JLabel name;
    private JLabel type;
    private JLabel distanceZ;
    private JLabel distanceNED;
    private JLabel messier;
    private JLabel cons;
    private JLabel desc;
    private JLabel aDesc;
    private JLabel mayorDiam;
    private JLabel menorDiam;
    private JLabel redshift;
    private JLabel vName;
    private JLabel vType;
    private JLabel vDistanceZ;
    private JLabel vDistanceNED;
    private JLabel vMessier;
    private JLabel vConst;
    private JLabel vDesc;
    private JLabel vADesc;
    private JLabel vMayorDiam;
    private JLabel vMenorDiam;
    private JLabel vRedshift;
    private JButton boton;
    private JButton anterior;
    private JButton siguiente;
    
    private Lista objetos;
    
    //Constructor
    public GUI_SpaceObject(Lista o)
    {
        super("Objetos Celestes");
        setSize(1300, 650);
        initGUI(o);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    
    private void initGUI(Lista o)
    {
        objetos = o;        
        panelOpciones = new JPanel();
        panelImagen = new JPanel();        
        panelInfo = new JPanel();
        panelSalida = new JPanel();
        panel1 = new JPanel();
        panelIntro = new JPanel();
        panelComentario = new JPanel();
        panelComboBox = new JPanel(); 
        panelLista = new JPanel();
        panel2 = new JPanel();
        
        crearPanel1();  
        
        //PanelImagen
        etiqueta = new JLabel();
        panelImagen.add(etiqueta);
        
        //Panel2 
        crearPanelInfo();
        
        //PanelSalida
        anterior = new JButton();
        anterior.setIcon(new ImageIcon("ant.jpg"));
        anterior.setPreferredSize(new Dimension (68, 68));
        boton = new JButton("Volver");
        siguiente = new JButton();
        siguiente.setIcon(new ImageIcon("sig.jpg"));
        siguiente.setPreferredSize(new Dimension (68, 68));
        Oyente oyenteB = new Oyente();
        boton.addActionListener(oyenteB);     
        OyenteAnt oyenteA = new OyenteAnt();
        anterior.addActionListener(oyenteA);  
        OyenteSig oyenteS = new OyenteSig();
        siguiente.addActionListener(oyenteS);  
        anterior.setEnabled(false);
        siguiente.setEnabled(false);
        panelSalida.add(anterior);
        panelSalida.add(boton);
        panelSalida.add(siguiente);
        
        panel1.setVisible(true);
        panel2.setVisible(false);

        panel2.setLayout(new GridLayout(1,2));
        
        panelOpciones.setBackground(Color.BLACK);
        panel1.setBackground(Color.BLACK);
        panelIntro.setBackground(Color.BLACK);
        panelComboBox.setBackground(Color.BLACK);
        panelComentario.setBackground(Color.BLACK);
        panelLista.setBackground(Color.BLACK);
        panelImagen.setBackground(Color.BLACK);
        panelInfo.setBackground(Color.BLACK);
        panelSalida.setBackground(Color.BLACK);
        panel2.setBackground(Color.BLACK);    
        getContentPane().setBackground(Color.BLACK);

        panel2.add(panelInfo);
        panel2.add(panelImagen);
        getContentPane().add(panel1, BorderLayout.NORTH);
        getContentPane().add(panel2, BorderLayout.CENTER);
        getContentPane().add(panelSalida, BorderLayout.SOUTH);
    }
    
    private void crearPanel1()
    {
        BoxLayout esteLayout = new BoxLayout(panel1,BoxLayout.Y_AXIS);
        panel1.setLayout(esteLayout);
        
        textoIntro = new JTextArea();
        textoIntro.setForeground(Color.WHITE);
        textoIntro.setBackground(Color.BLACK);
        Oracion texto;            
        texto = new Oracion("El Nuevo Catálogo General (NGC) - (cuyo nombre completo es Nuevo Catálogo General de Nebulosas y Cúmulos de Estrellas, en inglés New General Catalogue of Nebulae and Clusters of Stars), en contraposición al antiguo Catálogo General, es el catálogo de objetos de cielo profundo más conocido en la astronomía amateur. Contiene 7.840 objetos difusos tales como nubes estelares, nebulosas planetarias y galaxias, la totalidad de objetos del cielo profundo conocidos a finales del siglo XIX.");
        textoIntro.setText(texto.editarTexto());
        textoIntro.setFont(new Font("Courier New", Font.BOLD, 14));
        panelIntro.add(textoIntro);
        
        botonNeb = new JRadioButton("Nebulosa");
        botonGal = new JRadioButton("Galaxia");
        botonCum = new JRadioButton("Cumulo");
        botonMessier = new JRadioButton("Objetos Messier");
        botonTodo = new JRadioButton("Todo");
        group = new ButtonGroup();
        group.add(botonNeb);
        group.add(botonGal);
        group.add(botonCum);
        group.add(botonMessier);
        group.add(botonTodo);        
        
        textoInfo = new JTextArea(); 
        textoInfo.setForeground(Color.WHITE);
        textoInfo.setBackground(Color.BLACK);
        
        spaceObject = new JComboBox();
        nebObject = new JComboBox();
        cumObject = new JComboBox();
        galObject = new JComboBox();
        messierObject = new JComboBox();
        crearComboBox();        
        
        OyenteOp oyenteOp = new OyenteOp();
        botonNeb.addActionListener(oyenteOp); 
        botonGal.addActionListener(oyenteOp); 
        botonCum.addActionListener(oyenteOp); 
        botonMessier.addActionListener(oyenteOp); 
        botonTodo.addActionListener(oyenteOp);            
        
        botonNeb.setForeground(Color.WHITE);
        botonGal.setForeground(Color.WHITE);
        botonCum.setForeground(Color.WHITE);
        botonMessier.setForeground(Color.WHITE);
        botonTodo.setForeground(Color.WHITE);
        botonNeb.setBackground(Color.BLACK);
        botonGal.setBackground(Color.BLACK);
        botonCum.setBackground(Color.BLACK); 
        botonMessier.setBackground(Color.BLACK); 
        botonTodo.setBackground(Color.BLACK);
              
        panelOpciones.add(botonNeb);
        panelOpciones.add(botonCum);
        panelOpciones.add(botonGal);
        panelOpciones.add(botonMessier);
        panelOpciones.add(botonTodo);   
  
        panelComentario.add(textoInfo);
        
        panelComboBox.add(spaceObject);
        panelComboBox.add(nebObject);
        panelComboBox.add(galObject);
        panelComboBox.add(cumObject);
        panelComboBox.add(messierObject);
        
        panelComboBox.setVisible(false);
        
        panel1.add(panelIntro);
        panel1.add(panelOpciones);
        panel1.add(panelComentario);
        panel1.add(panelComboBox);
        
    }
    
    private void crearComboBox()
    {
        for (int i = 0; i < objetos.obtenerCantidad(); i++)
        {
            if((objetos.obtenerElemento(i).obtenerTipo()).equals("Nebulosa"))
                nebObject.addItem("" + objetos.obtenerElemento(i).obtenerNombre());
        }  

        for (int i = 0; i < objetos.obtenerCantidad(); i++)
        {
            if((objetos.obtenerElemento(i).obtenerTipo()).equals("Cumulo"))
                cumObject.addItem("" + objetos.obtenerElemento(i).obtenerNombre());
        }

        for (int i = 0; i < objetos.obtenerCantidad(); i++)
        {
            if((objetos.obtenerElemento(i).obtenerTipo()).equals("Galaxia"))
                galObject.addItem("" + objetos.obtenerElemento(i).obtenerNombre());
        }
        
        for (int i = 0; i < objetos.obtenerCantidad(); i++)
        {
            if(objetos.obtenerElemento(i) instanceof ObjetoMessier)
                messierObject.addItem("" + objetos.obtenerElemento(i).obtenerNombre());
        }

        for (int i = 0; i < objetos.obtenerCantidad(); i++)
        {
            spaceObject.addItem("" + objetos.obtenerElemento(i).obtenerNombre());
        }
        
        OyenteComboSpace oyente = new OyenteComboSpace ();
        OyenteComboNeb oyenteN = new OyenteComboNeb ();
        OyenteComboCum oyenteC = new OyenteComboCum ();
        OyenteComboGal oyenteG = new OyenteComboGal ();
        OyenteComboMessier oyenteM = new OyenteComboMessier ();
        nebObject.addActionListener(oyenteN);
        cumObject.addActionListener(oyenteC);
        galObject.addActionListener(oyenteG);
        messierObject.addActionListener(oyenteM);
        spaceObject.addActionListener(oyente);
            
        nebObject.setVisible(false);
        cumObject.setVisible(false);
        galObject.setVisible(false);
        messierObject.setVisible(false);
        spaceObject.setVisible(false);
    }
    
    private void crearPanelInfo()
    {
        panelInfo.setLayout(new GridLayout(12,2));  

        name = new JLabel("Nombre del objeto");
        type = new JLabel("Tipo de objeto");
        distanceZ = new JLabel("Distancia a la Tierra (miles de años luz - redshift)");
        messier = new JLabel("Nombre en catálogo Messier");
        distanceNED = new JLabel("Distancia a la Tierra (miles de años luz - NED)");
        cons = new JLabel("Constelación");
        desc = new JLabel("Descubierto por");
        aDesc = new JLabel("Año de descubrimiento");
        mayorDiam = new JLabel("Mayor diámetro");
        menorDiam = new JLabel("Menor diámetro");
        redshift = new JLabel("Redshift");       
        vName = new JLabel();
        vType = new JLabel();
        vDistanceZ = new JLabel();
        vMessier = new JLabel();
        vDistanceNED = new JLabel();
        vConst = new JLabel();
        vDesc = new JLabel();
        vADesc = new JLabel();
        vMayorDiam = new JLabel();
        vMenorDiam = new JLabel();
        vRedshift = new JLabel();
        
        name.setForeground(Color.WHITE);
        type.setForeground(Color.WHITE);
        distanceZ.setForeground(Color.WHITE);
        messier.setForeground(Color.WHITE);
        distanceNED.setForeground(Color.WHITE);
        cons.setForeground(Color.WHITE);
        desc.setForeground(Color.WHITE);
        aDesc.setForeground(Color.WHITE);
        mayorDiam.setForeground(Color.WHITE);
        menorDiam.setForeground(Color.WHITE);
        redshift.setForeground(Color.WHITE);
        
        vName.setForeground(Color.WHITE);
        vType.setForeground(Color.WHITE);
        vDistanceZ.setForeground(Color.WHITE);
        vMessier.setForeground(Color.WHITE);
        vDistanceNED.setForeground(Color.WHITE);
        vConst.setForeground(Color.WHITE);
        vDesc.setForeground(Color.WHITE);
        vADesc.setForeground(Color.WHITE);
        vMayorDiam.setForeground(Color.WHITE);
        vMenorDiam.setForeground(Color.WHITE);
        vRedshift.setForeground(Color.WHITE);
        vName.setBackground(Color.BLACK);
        vType.setBackground(Color.BLACK);
        vDistanceZ.setBackground(Color.BLACK);
        vMessier.setBackground(Color.BLACK);    
        vDistanceNED.setBackground(Color.BLACK);   
        vConst.setBackground(Color.BLACK);   
        vDesc.setBackground(Color.BLACK);   
        vADesc.setBackground(Color.BLACK);   
        vMayorDiam.setBackground(Color.BLACK);   
        vMenorDiam.setBackground(Color.BLACK);   
        vRedshift.setBackground(Color.BLACK);   
        
        panelInfo.add(name);
        panelInfo.add(vName);
        panelInfo.add(type);
        panelInfo.add(vType);
        panelInfo.add(distanceZ);      
        panelInfo.add(vDistanceZ);
        panelInfo.add(distanceNED);
        panelInfo.add(vDistanceNED);
        panelInfo.add(cons);
        panelInfo.add(vConst);
        panelInfo.add(desc);
        panelInfo.add(vDesc);
        panelInfo.add(aDesc);
        panelInfo.add(vADesc);
        panelInfo.add(mayorDiam);
        panelInfo.add(vMayorDiam);
        panelInfo.add(menorDiam);
        panelInfo.add(vMenorDiam);
        panelInfo.add(redshift);
        panelInfo.add(vRedshift);
        panelInfo.add(messier);      
        panelInfo.add(vMessier);
    }
    
    private void ocultarComboBox()
    {
        nebObject.setVisible(false);
        cumObject.setVisible(false);
        galObject.setVisible(false);
        spaceObject.setVisible(false); 
        messierObject.setVisible(false); 
        panelComboBox.setVisible(false);
    }
    
    private class OyenteOp implements ActionListener {
        public void actionPerformed(ActionEvent event){  
            String m = (String) event.getActionCommand();
            Oracion text;
            panelComboBox.setVisible(true);
            nebObject.setVisible(false);
            cumObject.setVisible(false);
            galObject.setVisible(false);
            messierObject.setVisible(false);
            spaceObject.setVisible(false); 
            if(m.equals("Nebulosa")) 
            {                
                nebObject.setVisible(true);                
                textoInfo.setVisible(true);
                text = new Oracion("Las nebulosas son regiones del medio interestelar constituidas por gases (principalmente hidrógeno y helio) además de elementos químicos en forma de polvo cósmico. Tienen una importancia cosmológica notable porque muchas de ellas son los lugares donde nacen las estrellas por fenómenos de condensación y agregación de la materia; en otras ocasiones se trata de los restos de estrellas ya extintas o en extinción.");
                textoInfo.setText(text.editarTexto());
            }
            else if(m.equals("Cumulo")) 
            {
                cumObject.setVisible(true);                
                textoInfo.setVisible(true);
                text = new Oracion("Un cúmulo estelar es un grupo de estrellas atraídas entre sí por su gravedad mutua. La clasificación tradicional incluye dos tipos de cúmulos estelares: los cúmulos globulares y los cúmulos abiertos (o galácticos). Los cúmulos globulares son agrupaciones densas de centenares de miles o millones de estrellas viejas (más de mil millones de años), mientras que los cúmulos abiertos contienen generalmente centenares o millares de estrellas jóvenes (menos de cien millones de años) o de edad intermedia (entre cien millones y mil millones de años). Los cúmulos abiertos son disgregados a lo largo del tiempo por su interacción gravitatoria con nubes moleculares en su movimiento por la galaxia mientras que los cúmulos globulares, más densos, son más estables frente a su disgregación (aunque, a largo plazo, también acaban siendo destruidos).");
                textoInfo.setText(text.editarTexto());
            }
            else if(m.equals("Galaxia")) 
            {
                galObject.setVisible(true);                
                textoInfo.setVisible(true);
                text = new Oracion("Una galaxia es un conjunto de estrellas, nubes de gas, planetas, polvo cósmico, materia oscura y energía unidos gravitatoriamente. La cantidad de estrellas que forman una galaxia es incontable, desde las galaxias enanas, con 10^7, hasta las galaxias gigantes, con 10^14 estrellas. Formando parte de una galaxia existen subestructuras como las nebulosas, los cúmulos estelares y los sistemas estelares múltiples. Se estima que existen más de cien mil millones de galaxias en el universo observable. La mayoría de las galaxias tienen un diámetro entre cien y cien mil parsecs y están usualmente separadas por distancias del orden de un millón de parsecs. El espacio intergaláctico está compuesto por un tenue gas cuya densidad media no supera un átomo por metro cúbico. Se especula que la materia oscura constituye el 90% de la masa en la mayoría de las galaxias. Sin embargo, la naturaleza de este componente no está demostrada, y de momento aparece solo como un recurso teórico para sustentar la estabilidad observada en las galaxias. La materia oscura fue propuesta inicialmente en 1933 por el astrónomo suizo Fritz Zwicky, pues la rotación observada en las galaxias indicaba la presencia de una gran cantidad de materia que no emitía luz.");
                textoInfo.setText(text.editarTexto());
            }else if(m.equals("Objetos Messier")) 
            {
                messierObject.setVisible(true);                
                textoInfo.setVisible(true);
                text = new Oracion("El Catálogo Messier es una lista de 110 objetos astronómicos confeccionada por el astrónomo francés Charles Messier y publicada originalmente (103 entradas) entre 1774 y 1781. Su título formal es «Catálogo de Nebulosas y Cúmulos de Estrellas r, que se observan entre las estrellas fijas sobre el horizonte de París» (en francés, «Catalogue des Nébuleuses et des amas d'Étoiles, que l'on découvre parmi les Étoiles fixes sur l'horizon de Paris»). Messier se dedicaba a la búsqueda de cometas, y la presencia de objetos difusos fijos en el cielo le resultaba un problema, pues podían confundirse con aquellos en los telescopios de su tiempo. Por este motivo decidió él mismo armar una lista que le simplificara el trabajo, y contaría con la ayuda de Pierre Méchain en su parte final. Su catálogo resultó una reunión de objetos astronómicos de naturaleza muy diferente, como nebulosas, cúmulos de estrellas abiertos y globulares, y galaxias. Por ejemplo, M1 (La Nebulosa del Cangrejo) es un remanente de supernova, M45 (Las Pléyades) es un cúmulo abierto, y M31 es la gran galaxia de Andrómeda. Dado que Messier vivía en Francia, la lista contiene objetos visibles sobre todo desde el hemisferio norte. La primera edición del catálogo (1774) incluía sólo 45 objetos (M1 a M45); un primer suplemento (1780) adicionaba las entradas M46 a M70, y la lista final de Messier (1781) incluía hasta M103. Más de un siglo después, otros astrónomos, usando notas en los textos de Messier, extendieron la lista hasta 110, que es el número final (M1 a M110). Muchos de estos objetos siguen siendo conocidos por su número en el catálogo Messier, otros son más conocidos por su número en el catálogo NGC (New General Catalogue).");
                textoInfo.setText(text.editarTexto());
            }else if(m.equals("Todo")){
                spaceObject.setVisible(true);                 
                textoInfo.setVisible(false);
            }    
        }       
    }       
   
    public class OyenteComboSpace implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String m = (String) spaceObject.getSelectedItem();
            if(m.equals("NGC1"))
            {
                anterior.setEnabled(false);
                siguiente.setEnabled(true);
            } else if (m.equals("NGC7840"))
            {
                anterior.setEnabled(true);
                siguiente.setEnabled(false);
            } else 
            {
                anterior.setEnabled(true);
                siguiente.setEnabled(true);
            }
            panel2.setVisible(true);
            panel1.setVisible(false);
            vName.setText(objetos.obtenerElemento(m).obtenerNombre());
            vType.setText(objetos.obtenerElemento(m).obtenerTipo());
            vDistanceZ.setText(objetos.obtenerElemento(m).obtenerDistanciaZ());
            vDistanceNED.setText(objetos.obtenerElemento(m).obtenerDistanciaNED());
            vConst.setText(objetos.obtenerElemento(m).obtenerConstelacion());
            vDesc.setText(objetos.obtenerElemento(m).obtenerDesc());
            vADesc.setText(objetos.obtenerElemento(m).obtenerADesc());
            vMayorDiam.setText(objetos.obtenerElemento(m).obtenerMayorDiam());
            vMenorDiam.setText(objetos.obtenerElemento(m).obtenerMenorDiam());
            vRedshift.setText(objetos.obtenerElemento(m).obtenerRedshift());
            if(objetos.obtenerElemento(m) instanceof ObjetoMessier)
            {
                ObjetoMessier o = (ObjetoMessier) objetos.obtenerElemento(m);
                vMessier.setText(o.obtenerNombreMessier());
                messier.setVisible(true);
                vMessier.setVisible(true);
            } else
            {
                messier.setVisible(false);
                vMessier.setVisible(false);
            }
            etiqueta.setIcon(new ImageIcon("fotos/"+vName.getText()+".jpg"));    
            spaceObject.setSelectedIndex(0);
        }
    }
    
    public class OyenteComboMessier implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String m = (String) messierObject.getSelectedItem();
            panel2.setVisible(true);
            panel1.setVisible(false);
            anterior.setEnabled(true);
            siguiente.setEnabled(true);
            vName.setText(objetos.obtenerElemento(m).obtenerNombre());
            vType.setText(objetos.obtenerElemento(m).obtenerTipo());
            vDistanceZ.setText(objetos.obtenerElemento(m).obtenerDistanciaZ());
            vDistanceNED.setText(objetos.obtenerElemento(m).obtenerDistanciaNED());
            vConst.setText(objetos.obtenerElemento(m).obtenerConstelacion());
            vDesc.setText(objetos.obtenerElemento(m).obtenerDesc());
            vADesc.setText(objetos.obtenerElemento(m).obtenerADesc());
            vMayorDiam.setText(objetos.obtenerElemento(m).obtenerMayorDiam());
            vMenorDiam.setText(objetos.obtenerElemento(m).obtenerMenorDiam());
            vRedshift.setText(objetos.obtenerElemento(m).obtenerRedshift());
                
            ObjetoMessier o = (ObjetoMessier) objetos.obtenerElemento(m);
            vMessier.setText(o.obtenerNombreMessier());
            messier.setVisible(true);
            vMessier.setVisible(true);
            etiqueta.setIcon(new ImageIcon("fotos/"+vName.getText()+".jpg"));  
            messierObject.setSelectedIndex(0);
        }
    }
           
        public class OyenteComboNeb implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String m = (String) nebObject.getSelectedItem();
            anterior.setEnabled(true);
            siguiente.setEnabled(true);
            panel2.setVisible(true);
            panel1.setVisible(false);
            vName.setText(objetos.obtenerElemento(m).obtenerNombre());
            vType.setText(objetos.obtenerElemento(m).obtenerTipo());
            vDistanceZ.setText(objetos.obtenerElemento(m).obtenerDistanciaZ());
            vDistanceNED.setText(objetos.obtenerElemento(m).obtenerDistanciaNED());
            vConst.setText(objetos.obtenerElemento(m).obtenerConstelacion());
            vDesc.setText(objetos.obtenerElemento(m).obtenerDesc());
            vADesc.setText(objetos.obtenerElemento(m).obtenerADesc());
            vMayorDiam.setText(objetos.obtenerElemento(m).obtenerMayorDiam());
            vMenorDiam.setText(objetos.obtenerElemento(m).obtenerMenorDiam());
            vRedshift.setText(objetos.obtenerElemento(m).obtenerRedshift());
            if(objetos.obtenerElemento(m) instanceof ObjetoMessier)
            {
                ObjetoMessier o = (ObjetoMessier) objetos.obtenerElemento(m);
                vMessier.setText(o.obtenerNombreMessier());
                messier.setVisible(true);
                vMessier.setVisible(true);
            } else
            {
                messier.setVisible(false);
                vMessier.setVisible(false);
            }
            etiqueta.setIcon(new ImageIcon("fotos/"+vName.getText()+".jpg"));            
            nebObject.setSelectedIndex(0);
        }
    }
    
    public class OyenteComboGal implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String m = (String) galObject.getSelectedItem();
            if(m.equals("NGC1"))
            {
                anterior.setEnabled(false);
                siguiente.setEnabled(true);
            } else if (m.equals("NGC7840"))
            {
                anterior.setEnabled(true);
                siguiente.setEnabled(false);
            } else 
            {
                anterior.setEnabled(true);
                siguiente.setEnabled(true);
            }
            panel2.setVisible(true);
            panel1.setVisible(false);
            vName.setText(objetos.obtenerElemento(m).obtenerNombre());
            vType.setText(objetos.obtenerElemento(m).obtenerTipo());
            vDistanceZ.setText(objetos.obtenerElemento(m).obtenerDistanciaZ());
            vDistanceNED.setText(objetos.obtenerElemento(m).obtenerDistanciaNED());
            vConst.setText(objetos.obtenerElemento(m).obtenerConstelacion());
            vDesc.setText(objetos.obtenerElemento(m).obtenerDesc());
            vADesc.setText(objetos.obtenerElemento(m).obtenerADesc());
            vMayorDiam.setText(objetos.obtenerElemento(m).obtenerMayorDiam());
            vMenorDiam.setText(objetos.obtenerElemento(m).obtenerMenorDiam());
            vRedshift.setText(objetos.obtenerElemento(m).obtenerRedshift());
            if(objetos.obtenerElemento(m) instanceof ObjetoMessier)
            {
                ObjetoMessier o = (ObjetoMessier) objetos.obtenerElemento(m);
                vMessier.setText(o.obtenerNombreMessier());
                messier.setVisible(true);
                vMessier.setVisible(true);
            } else
            {
                messier.setVisible(false);
                vMessier.setVisible(false);
            }
            etiqueta.setIcon(new ImageIcon("fotos/"+vName.getText()+".jpg"));
            galObject.setSelectedIndex(0);
           }
    }
    
        public class OyenteComboCum implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String m = (String) cumObject.getSelectedItem();
            anterior.setEnabled(true);
            siguiente.setEnabled(true);
            panel2.setVisible(true);
            panel1.setVisible(false);
            vName.setText(objetos.obtenerElemento(m).obtenerNombre());
            vType.setText(objetos.obtenerElemento(m).obtenerTipo());
            vDistanceZ.setText(objetos.obtenerElemento(m).obtenerDistanciaZ());
            vDistanceNED.setText(objetos.obtenerElemento(m).obtenerDistanciaNED());
            vConst.setText(objetos.obtenerElemento(m).obtenerConstelacion());
            vDesc.setText(objetos.obtenerElemento(m).obtenerDesc());
            vADesc.setText(objetos.obtenerElemento(m).obtenerADesc());
            vMayorDiam.setText(objetos.obtenerElemento(m).obtenerMayorDiam());
            vMenorDiam.setText(objetos.obtenerElemento(m).obtenerMenorDiam());
            vRedshift.setText(objetos.obtenerElemento(m).obtenerRedshift());
            if(objetos.obtenerElemento(m) instanceof ObjetoMessier)
            {
                ObjetoMessier o = (ObjetoMessier) objetos.obtenerElemento(m);
                vMessier.setText(o.obtenerNombreMessier());
                messier.setVisible(true);
                vMessier.setVisible(true);
            } else
            {
                messier.setVisible(false);
                vMessier.setVisible(false);
            }
            etiqueta.setIcon(new ImageIcon("fotos/"+vName.getText()+".jpg"));
            cumObject.setSelectedIndex(0);
        }
    }
       
    private class Oyente implements ActionListener {
        public void actionPerformed(ActionEvent event){  
            panel2.setVisible(false);
            panel1.setVisible(true);
            anterior.setEnabled(false);
            siguiente.setEnabled(false);
            textoInfo.setText("");
            ocultarComboBox();
            group.clearSelection();
        }
    }
    
    private class OyenteAnt implements ActionListener {
        public void actionPerformed(ActionEvent event){  
            int nuevaPos = Integer.parseInt(vName.getText().substring(3))-2;
            vName.setText(objetos.obtenerElemento(nuevaPos).obtenerNombre());
            vType.setText(objetos.obtenerElemento(nuevaPos).obtenerTipo());
            vDistanceZ.setText(objetos.obtenerElemento(nuevaPos).obtenerDistanciaZ());
            vDistanceNED.setText(objetos.obtenerElemento(nuevaPos).obtenerDistanciaNED());
            vConst.setText(objetos.obtenerElemento(nuevaPos).obtenerConstelacion());
            vDesc.setText(objetos.obtenerElemento(nuevaPos).obtenerDesc());
            vADesc.setText(objetos.obtenerElemento(nuevaPos).obtenerADesc());
            vMayorDiam.setText(objetos.obtenerElemento(nuevaPos).obtenerMayorDiam());
            vMenorDiam.setText(objetos.obtenerElemento(nuevaPos).obtenerMenorDiam());
            vRedshift.setText(objetos.obtenerElemento(nuevaPos).obtenerRedshift());
            if(objetos.obtenerElemento(nuevaPos) instanceof ObjetoMessier)
            {
                ObjetoMessier o = (ObjetoMessier) objetos.obtenerElemento(nuevaPos);
                vMessier.setText(o.obtenerNombreMessier());
                messier.setVisible(true);
                vMessier.setVisible(true);
            } else
            {
                messier.setVisible(false);
                vMessier.setVisible(false);
            }
            etiqueta.setIcon(new ImageIcon("fotos/"+vName.getText()+".jpg"));
            if(nuevaPos == 0)
                anterior.setEnabled(false);
                else anterior.setEnabled(true); 
            if(nuevaPos == 7839)
                siguiente.setEnabled(false);
                else siguiente.setEnabled(true);
        }
    }
    
    private class OyenteSig implements ActionListener {
        public void actionPerformed(ActionEvent event){  
            int nuevaPos = Integer.parseInt(vName.getText().substring(3));                          
            vName.setText(objetos.obtenerElemento(nuevaPos).obtenerNombre());
            vType.setText(objetos.obtenerElemento(nuevaPos).obtenerTipo());
            vDistanceZ.setText(objetos.obtenerElemento(nuevaPos).obtenerDistanciaZ());
            vDistanceNED.setText(objetos.obtenerElemento(nuevaPos).obtenerDistanciaNED());
            vConst.setText(objetos.obtenerElemento(nuevaPos).obtenerConstelacion());
            vDesc.setText(objetos.obtenerElemento(nuevaPos).obtenerDesc());
            vADesc.setText(objetos.obtenerElemento(nuevaPos).obtenerADesc());
            vMayorDiam.setText(objetos.obtenerElemento(nuevaPos).obtenerMayorDiam());
            vMenorDiam.setText(objetos.obtenerElemento(nuevaPos).obtenerMenorDiam());
            vRedshift.setText(objetos.obtenerElemento(nuevaPos).obtenerRedshift());
            if(objetos.obtenerElemento(nuevaPos) instanceof ObjetoMessier)
            {
                ObjetoMessier o = (ObjetoMessier) objetos.obtenerElemento(nuevaPos);
                vMessier.setText(o.obtenerNombreMessier());
                messier.setVisible(true);
                vMessier.setVisible(true);
            } else
            {
                messier.setVisible(false);
                vMessier.setVisible(false);
            }
            etiqueta.setIcon(new ImageIcon("fotos/"+vName.getText()+".jpg"));
            if(nuevaPos == 0)
                anterior.setEnabled(false);
                else anterior.setEnabled(true); 
            if(nuevaPos == 7839)
                siguiente.setEnabled(false);
                else siguiente.setEnabled(true);
        }
    }
      
}
