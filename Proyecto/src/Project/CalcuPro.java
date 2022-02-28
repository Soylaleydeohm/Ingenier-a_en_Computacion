package Project;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

import TDALista.ListaDoblementeEnlazada;
import TDALista.PositionList;

import javax.swing.JTextArea;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.awt.Color;
import java.awt.Font;
import java.awt.FlowLayout;
import javax.swing.JButton;
/**
 * Class CalcuPro
 * @author VirginiaAraceli
 */
public class CalcuPro {

	private JFrame frame;
	private JTextField txtA;
	private JTextField textField;
	private JTextField textField_1;
	private JTextArea txtpnVariable;
	private JTextArea txtpnValor;
	private JTextPane textArbol;
	private JLabel label;
	private JLabel label_1;
	private JLabel lblNewLabel;
	private JLabel label_2;
	private JLabel label_4;
	private JLabel label_6;
	private JLabel label_8;
	private JLabel label_10;
	private Programa calcu;

	/**
	 * Inicia la aplicación.
	 * @param args argumento.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CalcuPro window = new CalcuPro();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Crea la interfaz visual.
	 */
	public CalcuPro() {
		initialize();	
		calcu = new Programa();
	}

	/**
	 * Inicializa los contenidos de la interfaz visual.
	 */
	private void initialize() {
		frame = new JFrame("CalcuPro by Virshi");
		frame.setBounds(100, 100, 600, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 218, 185));
		frame.getContentPane().add(panel, BorderLayout.NORTH);
		
		JLabel lblIngreseVariable = new JLabel("Ingrese variable");
		panel.add(lblIngreseVariable);
		
		txtA = new JTextField();
		Oyente1 oyente1 = new Oyente1();
		txtA.addActionListener(oyente1);
		panel.add(txtA);
		txtA.setColumns(10);
		
		JLabel lblIngreseValor = new JLabel("Ingrese valor");
		panel.add(lblIngreseValor);
		
		textField = new JTextField();
		textField.setEnabled(false);
		Oyente2 oyente2 = new Oyente2();
		textField.addActionListener(oyente2);
		panel.add(textField);
		textField.setColumns(10);
		
		JScrollPane scroll = new JScrollPane();
		JPanel panel_3 = new JPanel();
		panel_3.setForeground(new Color(255, 218, 185));
		panel_3.setBackground(new Color(255, 218, 185));
		scroll.setViewportView(panel_3);
		frame.getContentPane().add(scroll, BorderLayout.EAST);
		
		txtpnVariable = new JTextArea();
		txtpnVariable.setFont(new Font("Segoe UI Emoji", Font.BOLD, 13));
		txtpnVariable.setForeground(Color.RED);
		txtpnVariable.setBackground(new Color(255, 218, 185));
		txtpnVariable.setText("Variable");
		panel_3.add(txtpnVariable);
		
		txtpnValor = new JTextArea();
		txtpnValor.setFont(new Font("Segoe UI Emoji", Font.BOLD, 13));
		txtpnValor.setForeground(Color.RED);
		txtpnValor.setBackground(new Color(255, 218, 185));
		txtpnValor.setText("Valor");
		panel_3.add(txtpnValor);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(255, 218, 185));
		panel_4.setForeground(Color.BLACK);
		frame.getContentPane().add(panel_4, BorderLayout.CENTER);
		
		JLabel lblOperadoresReconocidos = new JLabel((String) null);
		
		JTextArea txtrOperadoresReconocidos = new JTextArea();
		txtrOperadoresReconocidos.setFont(new Font("Monospaced", Font.BOLD, 13));
		txtrOperadoresReconocidos.setBackground(new Color(255, 218, 185));
		txtrOperadoresReconocidos.setForeground(new Color(0, 0, 0));
		txtrOperadoresReconocidos.setEditable(false);
		txtrOperadoresReconocidos.setText("Operadores reconocidos: +, -, *, / y ^.  Recuerde que \r\ns\u00F3lo puede utilizar las variables ingresadas previamente. \r\nLa operaci\u00F3n debe estar totalmente parentizada.");
		
		JLabel lblIngreseOperacin = new JLabel("Ingrese operaci\u00F3n");
		
		textField_1 = new JTextField();
		Oyente3 oyente3 = new Oyente3();
		textField_1.addActionListener(oyente3);
		textField_1.setColumns(10);
		
		JLabel lblExpresinPrefijo = new JLabel("Expresi\u00F3n prefijo");
		lblExpresinPrefijo.setHorizontalAlignment(SwingConstants.LEFT);
		
		lblNewLabel = new JLabel("0");
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		
		JLabel lblExpresinInfijo = new JLabel("Expresi\u00F3n infijo");
		
		label = new JLabel("0");
		
		JLabel lblExpresinPostfijo = new JLabel("Expresi\u00F3n postfijo");
		
		label_1 = new JLabel("0");
		
		JLabel lblResultado = new JLabel("Resultado");
		
		label_2 = new JLabel("0");
		
		textArbol = new JTextPane();
		StyledDocument doc = textArbol.getStyledDocument();
		SimpleAttributeSet center = new SimpleAttributeSet();
		StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
		doc.setParagraphAttributes(0, doc.getLength(), center, false);
		textArbol.setEditable(false);
		textArbol.setBackground(Color.PINK);
		
		JLabel lblRepresentacinDelrbol = new JLabel("Representaci\u00F3n del \u00E1rbol si todas las hojas tienen  la misma profundidad.");
		
		JButton btnReemplazarExpresiones = new JButton("Reemplazar expresiones");
		Oyente4 oyente4 = new Oyente4();
		btnReemplazarExpresiones.addActionListener(oyente4);
		
		GroupLayout gl_panel_4 = new GroupLayout(panel_4);
		gl_panel_4.setHorizontalGroup(
			gl_panel_4.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_4.createSequentialGroup()
					.addContainerGap()
					.addComponent(txtrOperadoresReconocidos, GroupLayout.PREFERRED_SIZE, 484, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_panel_4.createSequentialGroup()
					.addGap(42)
					.addComponent(textArbol, GroupLayout.PREFERRED_SIZE, 409, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_panel_4.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblRepresentacinDelrbol))
				.addGroup(gl_panel_4.createSequentialGroup()
					.addGap(10)
					.addGroup(gl_panel_4.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_4.createSequentialGroup()
							.addGap(10)
							.addGroup(gl_panel_4.createParallelGroup(Alignment.LEADING)
								.addComponent(lblResultado)
								.addGroup(gl_panel_4.createSequentialGroup()
									.addGroup(gl_panel_4.createParallelGroup(Alignment.LEADING)
										.addComponent(lblExpresinInfijo)
										.addComponent(lblExpresinPrefijo))
									.addGap(16)
									.addGroup(gl_panel_4.createParallelGroup(Alignment.LEADING, false)
										.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(label, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(label_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(label_2, GroupLayout.DEFAULT_SIZE, 173, Short.MAX_VALUE)))
								.addComponent(lblExpresinPostfijo)
								.addGroup(gl_panel_4.createSequentialGroup()
									.addComponent(lblIngreseOperacin)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, 176, GroupLayout.PREFERRED_SIZE))))
						.addComponent(lblOperadoresReconocidos)))
				.addGroup(gl_panel_4.createSequentialGroup()
					.addContainerGap()
					.addComponent(btnReemplazarExpresiones))
		);
		gl_panel_4.setVerticalGroup(
			gl_panel_4.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_4.createSequentialGroup()
					.addGap(4)
					.addComponent(txtrOperadoresReconocidos, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(gl_panel_4.createParallelGroup(Alignment.LEADING)
						.addComponent(lblOperadoresReconocidos)
						.addGroup(gl_panel_4.createSequentialGroup()
							.addGroup(gl_panel_4.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblIngreseOperacin)
								.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(17)
							.addGroup(gl_panel_4.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblExpresinPrefijo)
								.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panel_4.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblExpresinInfijo)
								.addComponent(label))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panel_4.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblExpresinPostfijo)
								.addComponent(label_1))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panel_4.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblResultado)
								.addComponent(label_2))))
					.addGap(2)
					.addComponent(btnReemplazarExpresiones)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblRepresentacinDelrbol, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(textArbol, GroupLayout.PREFERRED_SIZE, 248, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(22, Short.MAX_VALUE))
		);
		panel_4.setLayout(gl_panel_4);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 218, 185));
		frame.getContentPane().add(panel_1, BorderLayout.SOUTH);
		
		JLabel lblAlturaDelrbol = new JLabel("Altura del \u00E1rbol");
		lblAlturaDelrbol.setHorizontalAlignment(SwingConstants.TRAILING);
		
		label_4 = new JLabel("0");
		label_4.setHorizontalAlignment(SwingConstants.TRAILING);
		
		JLabel lblNroDeHojas = new JLabel("Hojas del \u00E1rbol");
		lblNroDeHojas.setHorizontalAlignment(SwingConstants.TRAILING);
		
		label_6 = new JLabel("0");
		label_6.setHorizontalAlignment(SwingConstants.TRAILING);
		
		JLabel lblNroDeNodos = new JLabel("Nodos del \u00E1rbol");
		lblNroDeNodos.setHorizontalAlignment(SwingConstants.TRAILING);
		
		label_8 = new JLabel("0");
		label_8.setHorizontalAlignment(SwingConstants.TRAILING);
		
		JLabel lblNroDeNodos_1 = new JLabel("Nodos internos del \u00E1rbol");
		lblNroDeNodos_1.setHorizontalAlignment(SwingConstants.TRAILING);
		
		label_10 = new JLabel("0");
		label_10.setHorizontalAlignment(SwingConstants.TRAILING);
		panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		panel_1.add(lblAlturaDelrbol);
		panel_1.add(label_4);
		panel_1.add(lblNroDeHojas);
		panel_1.add(label_6);
		panel_1.add(lblNroDeNodos);
		panel_1.add(label_8);
		panel_1.add(lblNroDeNodos_1);
		panel_1.add(label_10);
	}
	
	/**
	 * Al ingresar un nombre de variable, habilita el ingreso del valor de la variable e imposibilita cambiar el nombre.
	 */
	
	private class Oyente1 implements ActionListener {
        public void actionPerformed(ActionEvent event){  
            textField.setEnabled(true);
            txtA.setEnabled(false);
        }
    }
	
	/**
	 * Guarda y muestra la variable ingresada con su respectivo valor. Permite reemplazar el valor de una variable ingresada previamente.
	 *
	 */
	
	private class Oyente2 implements ActionListener {
        @SuppressWarnings("static-access")
		public void actionPerformed(ActionEvent event){          	        	
        	try {
				calcu.insertarVariable(txtA.getText(), Float.parseFloat(textField.getText()));
				txtpnVariable.append(System.getProperty("line.separator")+txtA.getText());
		        txtpnValor.append(System.getProperty("line.separator")+Float.parseFloat(textField.getText()));
			} catch (NumberFormatException e) {
				JOptionPane cartel = new JOptionPane();
                cartel.showMessageDialog(null, "La expresión ingresada es inválida");
			} catch (InvalidVariableException e) {
				int choice = JOptionPane.showOptionDialog(null, 
					 "¿Desea reemplazar la variable " + txtA.getText() + "?", 
					 "¿Reemplazar?", 
					 JOptionPane.YES_NO_OPTION, 
					 JOptionPane.QUESTION_MESSAGE, 
					 null, null, null);
				  if (choice == JOptionPane.YES_OPTION){
					  calcu.reemplazarVariable(txtA.getText(), Float.parseFloat(textField.getText()));
					  txtpnVariable.setText("Variable");
					  txtpnValor.setText("Valor");
					  Iterable<String> itVar = calcu.obtenerVariables();
					  Iterator<String> iteVar = itVar.iterator();
					  while(iteVar.hasNext()){
						  txtpnVariable.append(System.getProperty("line.separator")+iteVar.next());
					  }
					  Iterable<Float> itVal = calcu.obtenerValores();
					  Iterator<Float> iteVal = itVal.iterator();
					  while(iteVal.hasNext()){
						  txtpnValor.append(System.getProperty("line.separator")+iteVal.next());
					  }
				  }
			}
        	txtA.setText("");
        	textField.setText("");
        	textField.setEnabled(false);
        	txtA.setEnabled(true);
        }
    }
	
	/**
	 * Calcula la expresión aritmética ingresada, muestra el árbol binario que se genera para resolver la misma y su altura, cantidad de hojas, de nodos y de nodos internos.
	 * Muestra la expresión en prefijo, postfijo e infijo. 
	 */
	
	private class Oyente3 implements ActionListener {
        @SuppressWarnings("static-access")
		public void actionPerformed(ActionEvent event){   
        	try {        		
        		String result = "" + calcu.calcular(textField_1.getText());
				label_2.setText(calcu.infijoString()+" = "+result);					
				label.setText(calcu.infijoString());
				lblNewLabel.setText(calcu.prefijoString());
				textArbol.setText(calcu.mostrarArbol());
				label_1.setText(calcu.postfijoString());
	        	label_4.setText(""+calcu.alturaArbol());
	        	label_6.setText(""+calcu.hojasArbol());
	        	label_8.setText(""+calcu.nodosArbol());
	        	label_10.setText(""+calcu.nodosInternosArbol());
        	} catch (ExpresionInvalidaException e) {
				JOptionPane cartel = new JOptionPane();
                cartel.showMessageDialog(null, "La expresión ingresada es inválida");
			} catch (DivisionPorCeroException e) {
				JOptionPane cartel = new JOptionPane();
                cartel.showMessageDialog(null, e.getMessage());
			} catch (InvalidVariableException e) {
				JOptionPane cartel = new JOptionPane();
				cartel.showMessageDialog(null, "La variable no se encuentra guardada.");
			}
        }
    }

	/**
     * Permite modificar los nodos de altura 1 que no sean la raíz por otra variable para simplificar la expresión, guardando y mostrando la variable y el valor obtenido.
	 * Muestra el nuevo árbol binario que se genera y su altura, cantidad de hojas, de nodos y de nodos internos.
	 */

	private class Oyente4 implements ActionListener {
	    @SuppressWarnings("static-access")
		public void actionPerformed(ActionEvent event){   	     		
	    		JOptionPane cartel = new JOptionPane();
	        	PositionList<String> l = new ListaDoblementeEnlazada<String>();
	    		for(int i = 0; i < calcu.nH1(); i++){
	    			String s = cartel.showInputDialog("Ingrese variable. No puede utilizar una previamente guardada.");
	        		l.addLast(s);        		
				}      	
	    		try {
					calcu.crearVariablesH1(l);
				} catch (ReemplazoInvalidoException e) {
					JOptionPane cartel2 = new JOptionPane();
					cartel2.showMessageDialog(null, "No puede reemplazar una variable en esta instancia.");
				}
				label.setText(calcu.infijoString());
				lblNewLabel.setText(calcu.prefijoString());
				label_1.setText(calcu.postfijoString());
				txtpnVariable.setText("Variable");
				txtpnValor.setText("Valor");
				Iterable<String> itVar = calcu.obtenerVariables();
				Iterator<String> iteVar = itVar.iterator();
				while(iteVar.hasNext()){
					txtpnVariable.append(System.getProperty("line.separator")+iteVar.next());
				}
				Iterable<Float> itVal = calcu.obtenerValores();
				Iterator<Float> iteVal = itVal.iterator();
				while(iteVal.hasNext()){
					txtpnValor.append(System.getProperty("line.separator")+iteVal.next());
				}
				textArbol.setText(calcu.mostrarArbol());
				label_4.setText(""+calcu.alturaArbol());
	        	label_6.setText(""+calcu.hojasArbol());
	        	label_8.setText(""+calcu.nodosArbol());
	        	label_10.setText(""+calcu.nodosInternosArbol());
	    }
	}
}
