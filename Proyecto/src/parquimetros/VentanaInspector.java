package parquimetros;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import quick.dbtable.DBTable;

import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;

import javax.swing.ListSelectionModel;

public class VentanaInspector extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldPatente;
	private DefaultListModel listModel;
	private JList listPatentes;
	private JComboBox comboBoxParquimetro;
	private JComboBox comboBoxAltura;
	private JComboBox comboBoxCalle;
	private JButton btnRegistrar;
	private Connection conexion;
	private String legajo;	

	public VentanaInspector(Connection c, String l) {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				try {
					conexion.close();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				new VentanaInicio().setVisible(true);
			}
		});
		setTitle("Inspector");
		conexion = c;
		legajo = l;

		armarGUI();
	}

	private void armarGUI(){
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 361, 323);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		setLocationRelativeTo(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 92, 159, 182);
		contentPane.add(scrollPane);

		listPatentes = new JList();
		listPatentes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listPatentes.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if(e.getButton() == MouseEvent.BUTTON3){
					if(!listPatentes.isSelectionEmpty()){
						listModel.remove(listPatentes.getSelectedIndex());
					}
				}
			}
		});
		listModel = new DefaultListModel();
		listPatentes.setModel(listModel);
		scrollPane.setViewportView(listPatentes);

		JLabel lblPatente = new JLabel("Patente");
		lblPatente.setBounds(10, 11, 46, 14);
		contentPane.add(lblPatente);

		textFieldPatente = new JTextField();
		textFieldPatente.setBounds(10, 36, 159, 20);
		contentPane.add(textFieldPatente);
		textFieldPatente.setColumns(6);

		JLabel lblPatentesCargadas = new JLabel("Patentes cargadas");
		lblPatentesCargadas.setBounds(10, 67, 152, 14);
		contentPane.add(lblPatentesCargadas);

		comboBoxParquimetro = new JComboBox();
		comboBoxParquimetro.setMaximumRowCount(5);
		comboBoxParquimetro.setEnabled(false);
		comboBoxParquimetro.setBounds(179, 201, 159, 26);
		contentPane.add(comboBoxParquimetro);

		comboBoxAltura = new JComboBox();
		comboBoxAltura.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				OyenteAltura(e);
			}
		});
		comboBoxAltura.setMaximumRowCount(5);
		comboBoxAltura.setEnabled(false);
		comboBoxAltura.setBounds(179, 150, 159, 26);
		contentPane.add(comboBoxAltura);

		btnRegistrar = new JButton("Registrar patentes");
		btnRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				OyenteRegistro();
			}
		});
		btnRegistrar.setBounds(179, 239, 159, 35);
		contentPane.add(btnRegistrar);

		JLabel lblUbicacion = new JLabel("Altura");
		lblUbicacion.setBounds(179, 132, 159, 14);
		contentPane.add(lblUbicacion);

		JLabel lblParquimetro = new JLabel("Parquimetro");
		lblParquimetro.setBounds(179, 187, 159, 14);
		contentPane.add(lblParquimetro);

		JButton btnIngresarPatente = new JButton("Ingresar patente");
		btnIngresarPatente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String pat = textFieldPatente.getText();
				if(!pat.equals("")){
					boolean existe = false;
					for (int i = 0; i < listModel.size() && !existe; i++) {
						if(listModel.getElementAt(i).equals(pat)){
							existe = true;
						}
					}
					if(!existe)
						listModel.addElement(pat);					
				}				
			}
		});

		btnIngresarPatente.setBounds(179, 35, 130, 23);
		contentPane.add(btnIngresarPatente);

		JLabel lblUbicacionCalle = new JLabel("Calle");
		lblUbicacionCalle.setBounds(179, 70, 159, 14);
		contentPane.add(lblUbicacionCalle);

		comboBoxCalle = new JComboBox();
		Calles();
		comboBoxCalle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				OyenteCalle(e);
			}
		});
		comboBoxCalle.setMaximumRowCount(5);
		comboBoxCalle.setEnabled(true);
		comboBoxCalle.setBounds(179, 95, 159, 26);
		contentPane.add(comboBoxCalle);

	}

	private void OyenteCalle (ActionEvent e){
		comboBoxParquimetro.removeAllItems();
		if(!comboBoxAltura.isEnabled())
			comboBoxAltura.setEnabled(true);
		else
			comboBoxAltura.removeAllItems();
		Alturas();
	}

	private void OyenteAltura(ActionEvent e){
		if(!comboBoxParquimetro.isEnabled())
			comboBoxParquimetro.setEnabled(true);
		else
			comboBoxParquimetro.removeAllItems();
		Parquimetro();
	}

	private void Calles(){
		try{ 
			Statement stmt = conexion.createStatement();

			//string SQL
			String sql = "SELECT distinct calle " + 
					"FROM Parquimetros ";

			// se ejecuta la sentencia 
			ResultSet r = stmt.executeQuery(sql);
			while (r.next()){
				comboBoxCalle.addItem(r.getString(1));
			}

			// se cierran los recursos utilizados 
			r.close();
			stmt.close();
		}
		catch (SQLException ex){
			JOptionPane.showMessageDialog(this,
					ex.getMessage() + "\n",
					"Error al consultar BD",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	private void Alturas(){
		try{ 
			Statement stmt = conexion.createStatement();

			//string SQL
			String sql = "SELECT altura " + 
					"FROM Parquimetros AS p " +
					"WHERE p.calle = '" + comboBoxCalle.getSelectedItem().toString()+"'";

			// se ejecuta la sentencia 
			ResultSet r = stmt.executeQuery(sql);
			while (r.next()){
				comboBoxAltura.addItem(r.getString(1));
			}

			// se cierran los recursos utilizados 
			r.close();
			stmt.close();
		}
		catch (SQLException ex){
			JOptionPane.showMessageDialog(this,
					ex.getMessage() + "\n",
					"Error al consultar BD",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	private void Parquimetro(){
		try{ 
			Statement stmt = conexion.createStatement();

			//string SQL
			String sql = "SELECT id_parq " + 
					"FROM Parquimetros AS p " +
					"WHERE p.calle = '" + comboBoxCalle.getSelectedItem().toString()+"' " + 
					"AND p.altura = '" + comboBoxAltura.getSelectedItem()+"' ";

			// se ejecuta la sentencia 
			ResultSet r = stmt.executeQuery(sql);
			while (r.next()){
				comboBoxParquimetro.addItem(r.getString(1));
			}

			// se cierran los recursos utilizados 
			r.close();
			stmt.close();
		}
		catch (SQLException ex){
			JOptionPane.showMessageDialog(this,
					ex.getMessage() + "\n",
					"Error al consular BD",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	

	private void OyenteRegistro(){
		try{ 
			Statement stmt = conexion.createStatement();
			String dia = obtenerDia();
			System.out.println("Dia: "+dia);
			String turno = obtenerTurno();
			System.out.println("Turno: "+turno);
			if (turno == null){
				JOptionPane.showMessageDialog(this,
						"Turno fuera de horario de trabajo");
			}else{
				//string SQL
				String sql = "SELECT id_asociado_con " + 
						"FROM Asociado_con AS a " +
						"WHERE a.calle = '" + comboBoxCalle.getSelectedItem().toString()+"' " + 
						"AND a.altura = '" + comboBoxAltura.getSelectedItem()+"' " + 
						"AND a.legajo = '" + legajo + "' " +
						"AND a.dia = '" + dia + "' " + 
						"AND a.turno = '" + turno + "' ";

				// se ejecuta la sentencia 
				ResultSet r = stmt.executeQuery(sql);
				Statement stmt2 = conexion.createStatement();
				if(r.next()){
					//Inspector esta asociado con ubicacion

					//Registrar acceso del inspector al parq
					sql = "INSERT INTO Accede VALUES('"+legajo+"', '" + 
							comboBoxParquimetro.getSelectedItem()+"', CURDATE(), CURTIME())";
					stmt2.execute(sql);

					//Registrar multas
					
					String id_asoc = r.getString(1);
					System.out.println("id_asoc: "+id_asoc);
					registrarMultas(r.getString(1));
					listModel.clear();

				}else{
					JOptionPane.showMessageDialog(this,
							"No autorizado a realizar esta multa");
				}

				// se cierran los recursos utilizados 
				r.close();
				stmt.close();
				stmt2.close();
			}
		}
		catch (SQLException ex){
			JOptionPane.showMessageDialog(this,
					ex.getMessage() + "\n",
					"Error en la conexión",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	private void registrarMultas(String id_asociado){
		try {
			Statement st = conexion.createStatement();
			ResultSet rs = null;
			String estacionado;
			String patente, insertMulta;
			boolean esPrimerMulta = true;
			int primerMulta = 0;
			
			for (int i = 0; i < listModel.size() ; i++) {
				patente = (String)listModel.getElementAt(i);
				estacionado = 	"SELECT patente "+
								"FROM estacionados "+
								"WHERE patente = '"+patente+"' " + 
								"AND altura = '" + comboBoxAltura.getSelectedItem()+"' "+ 
								"AND calle = '" + comboBoxCalle.getSelectedItem()+"' ";
				rs = st.executeQuery(estacionado); 
				if(!rs.next()){
					//La patente no tiene un estacionamiento abierto en esa ubicación. Se genera la multa.
					insertMulta = 	"INSERT INTO Multa(fecha, hora, patente, id_asociado_con) "+
									"VALUES( CURDATE(), CURTIME(), '"+patente+"' , '"+id_asociado+"') ";
					try{
						st.execute(insertMulta);
						
						if(esPrimerMulta){
							String sql = "SELECT MAX(numero) FROM Multa";
							ResultSet r = conexion.createStatement().executeQuery(sql);
							r.next();
							primerMulta = r.getInt(1);
							r.close();
							esPrimerMulta = false;
						}
						
					}catch(SQLException ex){
						//La patente no se encuentra  registrada en la base de datos
						JOptionPane.showMessageDialog(this,
								"La patente '"+patente+"' no se encuentra registrada en la base de datos.\n"+
								"No se registró la multa",
								"Error al ingresar la patente",
								JOptionPane.INFORMATION_MESSAGE);
					}
				}else //La patente tiene un estacionamiento abierto. No se genera multa
					
				rs.close();
			}
			if(!esPrimerMulta){
				VentanaMultas v = new VentanaMultas(conexion, primerMulta);
				v.setVisible(true);
			}
			else{
				JOptionPane.showMessageDialog(this,
						"No se registraron multas",
						"Multas",
						JOptionPane.INFORMATION_MESSAGE);
			}
			
			
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(this,
					ex.getMessage() + "\n",
					"Error en la conexion con la BD",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	
	private String obtenerDia(){
		try{ 
			Statement stmt = conexion.createStatement();

			//string SQL
			String sql = "SELECT CURDATE() ";
			ResultSet r = stmt.executeQuery(sql);
			r.next();
			String sql2 = "SELECT DAYOFWEEK('"+r.getString(1)+"') ";
			String retorno = "";
			// se ejecuta la sentencia 
			r = stmt.executeQuery(sql2);
			r.next();
			switch (r.getString(1)){
			case "1":  retorno = "Do";
			break;
			case "2":  retorno = "Lu";
			break;
			case "3":  retorno = "Ma";
			break;
			case "4":  retorno = "Mi";
			break;
			case "5":  retorno = "Ju";
			break;
			case "6":  retorno = "Vi";
			break;
			case "7":  retorno = "Sa";
			break;
			}
			// se cierran los recursos utilizados 
			r.close();
			stmt.close();
			return retorno;
		}
		catch (SQLException ex){
			JOptionPane.showMessageDialog(this,
					ex.getMessage() + "\n",
					"Fecha Error en la sentencia SQL ingresada",
					JOptionPane.ERROR_MESSAGE);
			return null;
		}
	}
	
	private String obtenerTurno(){
		try{ 
			Statement stmt = conexion.createStatement();
			String retorno = null;
			//string SQL
			String sql = "SELECT HOUR(CURTIME()) ";
			ResultSet r = stmt.executeQuery(sql);
			r.next();
			String hora = r.getString(1);
			int h = Integer.parseInt(hora);
			if(h>=8 && h<20){
				if(h<14) retorno = "M";
				else retorno = "T";
			}			
			// se cierran los recursos utilizados 
			r.close();
			stmt.close();
			return retorno;
		}
		catch (SQLException ex){
			JOptionPane.showMessageDialog(this,
					ex.getMessage() + "\n",
					"Hora Error en la sentencia SQL ingresada",
					JOptionPane.ERROR_MESSAGE);
			return null;
		}
	}
}
