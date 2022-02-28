package parquimetros;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.WindowConstants;
import javax.swing.border.BevelBorder;

import quick.dbtable.DBTable;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

public class VentanaAdmin extends JFrame {

	private JPanel pnlConsulta;
	private JTextArea txtConsulta;
	private JButton botonBorrar;
	private JButton btnEjecutar;
	private DBTable tabla;    
	private JScrollPane scrConsulta;
	private Connection conexion;
	private Logica l;

	public VentanaAdmin(Connection c){
		super();
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				desconectarTablaBD();
				new VentanaInicio().setVisible(true);
			}
		});
		
		l = new Logica();
		conexion = c;
		armarGUI();
	}

	private void armarGUI() {
		try {
			setPreferredSize(new Dimension(800, 600));
			this.setBounds(0, 0, 800, 600);
			BorderLayout thisLayout = new BorderLayout();
			this.setTitle("Consultas");
			getContentPane().setLayout(thisLayout);
			this.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);

			{
				pnlConsulta = new JPanel();
				getContentPane().add(pnlConsulta, BorderLayout.NORTH);
				{
					scrConsulta = new JScrollPane();
				}
				{
					btnEjecutar = new JButton();
					btnEjecutar.setText("Ejecutar");
					btnEjecutar.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent evt) {
							btnEjecutarActionPerformed(evt);
						}
					});
				}
				{
					botonBorrar = new JButton();
					botonBorrar.setText("Borrar");
					{
						txtConsulta = new JTextArea();
						txtConsulta.setTabSize(3);
						txtConsulta.setColumns(80);
						txtConsulta.setBorder(BorderFactory.createEtchedBorder(BevelBorder.LOWERED));
						txtConsulta.setText("SELECT *\n" +
								"FROM ubicaciones \n" +
								"WHERE altura > 100 AND altura <800 \n" +
								"ORDER BY calle");
						txtConsulta.setFont(new java.awt.Font("Monospaced",0,12));
						txtConsulta.setRows(10);
					}

					JButton btnNewButton = new JButton("Mostrar tablas");
					btnNewButton.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							VentanaTablas vent = new VentanaTablas(tabla.getConnection());
							vent.setVisible(true);
						}
					});

					GroupLayout gl_pnlConsulta = new GroupLayout(pnlConsulta);
					gl_pnlConsulta.setHorizontalGroup(
							gl_pnlConsulta.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_pnlConsulta.createSequentialGroup()
									.addContainerGap()
									.addComponent(txtConsulta, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addGroup(gl_pnlConsulta.createParallelGroup(Alignment.LEADING)
											.addGroup(gl_pnlConsulta.createSequentialGroup()
													.addGap(12)
													.addComponent(scrConsulta, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
											.addGroup(gl_pnlConsulta.createSequentialGroup()
													.addGap(57)
													.addGroup(gl_pnlConsulta.createParallelGroup(Alignment.TRAILING, false)
															.addComponent(btnEjecutar, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 79, Short.MAX_VALUE)
															.addComponent(botonBorrar, GroupLayout.DEFAULT_SIZE, 79, Short.MAX_VALUE)))
											.addGroup(gl_pnlConsulta.createSequentialGroup()
													.addGap(39)
													.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 119, GroupLayout.PREFERRED_SIZE)))
									.addGap(62))
							);
					gl_pnlConsulta.setVerticalGroup(
							gl_pnlConsulta.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_pnlConsulta.createSequentialGroup()
									.addGap(5)
									.addGroup(gl_pnlConsulta.createParallelGroup(Alignment.BASELINE)
											.addComponent(scrConsulta, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
											.addComponent(txtConsulta, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
							.addGroup(gl_pnlConsulta.createSequentialGroup()
									.addGap(20)
									.addComponent(btnEjecutar)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(botonBorrar)
									.addGap(45)
									.addComponent(btnNewButton))
							);
					pnlConsulta.setLayout(gl_pnlConsulta);
					botonBorrar.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent arg0) {
							txtConsulta.setText("");            			
						}
					});
				}	
			}
			{
				// crea la tabla y la conecta con la BD  
				tabla = new DBTable();
				conectarTablaBD();
				
				// Agrega la tabla al frame (no necesita JScrollPane como Jtable)
				getContentPane().add(tabla, BorderLayout.CENTER);           

				// setea la tabla para sólo lectura (no se puede editar su contenido)  
				tabla.setEditable(false); 
				
				setLocationRelativeTo(null); //Centra la ventana

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	private void conectarTablaBD(){
		if(conexion != null)
			tabla.setConnection(conexion);
		else{
			JOptionPane.showMessageDialog(this,
					"Imposible conectarse con la BD. El programa se cerrara, vuelva a intentarlo." + "\n", 
					"Error de conexion",
					JOptionPane.ERROR_MESSAGE);
			System.exit(-1);
		}
	}

	private void desconectarTablaBD(){
		try{
			tabla.close();            
		}
		catch (SQLException ex){
			JOptionPane.showMessageDialog(this,
					ex.getMessage() + "\n", 
					"Error al desconectarse de la base de datos.",
					JOptionPane.ERROR_MESSAGE);
		}      
	}

	private void btnEjecutarActionPerformed(ActionEvent evt) {
		String consulta = txtConsulta.getText().trim();
		String consultaMayu = consulta.toUpperCase();
		if(consultaMayu.contains("SELECT")){
			refrescarTabla();
		}
		else{
			//La sentencia SQL es de modificacion
			if(l.modificacionSQL(conexion, consulta)){
				JOptionPane.showMessageDialog(this,
						"Sentencia exitosa",
						"",
						JOptionPane.INFORMATION_MESSAGE);
			}

		}
	}

	private void refrescarTabla(){
		try{    
			// seteamos la consulta a partir de la cual se obtendrán los datos para llenar la tabla
			tabla.setSelectSql(this.txtConsulta.getText().trim());

			// obtenemos el modelo de la tabla a partir de la consulta para 
			// modificar la forma en que se muestran de algunas columnas  
			tabla.createColumnModelFromQuery();    	    
			for (int i = 0; i < tabla.getColumnCount(); i++)
			{ // para que muestre correctamente los valores de tipo TIME (hora)  		   		  
				if	 (tabla.getColumn(i).getType()==Types.TIME)  
				{    		 
					tabla.getColumn(i).setType(Types.CHAR);  
				}
				// cambiar el formato en que se muestran los valores de tipo DATE
				if	 (tabla.getColumn(i).getType()==Types.DATE)
				{
					tabla.getColumn(i).setDateFormat("dd/MM/YYYY");
				}
			}  
			// actualizamos el contenido de la tabla.   	     	  
			tabla.refresh();
			// No es necesario establecer  una conexión, crear una sentencia y recuperar el 
			// resultado en un resultSet, esto lo hace automáticamente la tabla (DBTable) a 
			// patir  de  la conexión y la consulta seteadas con connectDatabase() y setSelectSql() respectivamente.
			
		}catch (SQLException ex){
			JOptionPane.showMessageDialog(this,
					ex.getMessage() + "\n", 
					"Error al ejecutar la consulta.",
					JOptionPane.ERROR_MESSAGE);

		}

	}
}
