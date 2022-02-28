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

public class VentanaCiudadano extends JFrame {

	private JPanel contentPane;
	private JComboBox comboBoxParquimetro;
	private JComboBox comboBoxAltura;
	private JComboBox comboBoxCalle;
	private JComboBox comboBoxTarjeta;
	private JButton btnRegistrar;
	private Connection conexion;
	private Logica l;


	public VentanaCiudadano() {
		l= new Logica();
		try {
			conexion = l.conectarBD("parquimetro", "parq");
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
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
		setTitle("Parquimetro");
		armarGUI();
	}

	private void armarGUI(){
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 209, 346);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		setLocationRelativeTo(null);

		comboBoxParquimetro = new JComboBox();
		comboBoxParquimetro.setMaximumRowCount(5);
		comboBoxParquimetro.setEnabled(false);
		comboBoxParquimetro.setBounds(10, 152, 159, 26);
		contentPane.add(comboBoxParquimetro);

		comboBoxAltura = new JComboBox();
		comboBoxAltura.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				OyenteAltura(e);
			}
		});
		comboBoxAltura.setMaximumRowCount(5);
		comboBoxAltura.setEnabled(false);
		comboBoxAltura.setBounds(10, 98, 159, 26);
		contentPane.add(comboBoxAltura);

		btnRegistrar = new JButton("Conectar");
		btnRegistrar.setEnabled(false);
		btnRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				OyenteConectar();
			}
		});
		btnRegistrar.setBounds(10, 262, 159, 35);
		contentPane.add(btnRegistrar);

		JLabel lblUbicacion = new JLabel("Altura");
		lblUbicacion.setBounds(10, 73, 159, 14);
		contentPane.add(lblUbicacion);

		JLabel lblParquimetro = new JLabel("Parquimetro");
		lblParquimetro.setBounds(10, 135, 159, 14);
		contentPane.add(lblParquimetro);

		JLabel lblUbicacionCalle = new JLabel("Calle");
		lblUbicacionCalle.setBounds(10, 11, 159, 14);
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
		comboBoxCalle.setBounds(10, 36, 159, 26);
		contentPane.add(comboBoxCalle);
		
		JLabel lblTarjeta = new JLabel("Tarjeta");
		lblTarjeta.setBounds(10, 198, 159, 14);
		contentPane.add(lblTarjeta);
		
		comboBoxTarjeta = new JComboBox();
		Tarjetas();
		comboBoxTarjeta.setMaximumRowCount(5);
		comboBoxTarjeta.setBounds(10, 215, 159, 26);
		contentPane.add(comboBoxTarjeta);

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
		if(!comboBoxParquimetro.isEnabled()){
			comboBoxParquimetro.setEnabled(true);
			btnRegistrar.setEnabled(true);
		}else
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

	private void Tarjetas(){
		try{ 
			Statement stmt = conexion.createStatement();

			//string SQL
			String sql = "SELECT id_tarjeta " + 
					"FROM Tarjetas ";

			// se ejecuta la sentencia 
			ResultSet r = stmt.executeQuery(sql);
			while (r.next()){
				comboBoxTarjeta.addItem(r.getString(1));
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
	

	private void OyenteConectar(){
				int tarjeta = Integer.parseInt(comboBoxTarjeta.getSelectedItem().toString());
				int parq = Integer.parseInt(comboBoxParquimetro.getSelectedItem().toString());
				//System.out.println("tarj: "+tarjeta+", parq: "+parq);
				VentanaTablaSim v = new VentanaTablaSim(conexion,tarjeta,parq);
				v.setVisible(true);
		
	}
}
