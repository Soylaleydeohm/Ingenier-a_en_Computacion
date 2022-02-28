package parquimetros;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class VentanaTablas extends JFrame {

	private JPanel contentPane;
	private Connection conexion;
	private JList jListTablas;
	private JList jListAtrib;
	private DefaultListModel listTablasModel;
	private DefaultListModel listAtribModel;
	private Logica l;


	public VentanaTablas(Connection c) {
		armarGUI();
		l = new Logica();
		conexion = c;
		cargarTablas();
	}



	private void armarGUI(){
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null); //AbsoluteLayout

		listAtribModel = new DefaultListModel();
		listTablasModel = new DefaultListModel();

		JLabel lblTablas = new JLabel("Tablas");
		lblTablas.setBounds(10, 11, 46, 14);
		contentPane.add(lblTablas);

		JLabel lblAtributos = new JLabel("Atributos");
		lblAtributos.setBounds(225, 11, 75, 14);
		contentPane.add(lblAtributos);

		JScrollPane scrollPaneTablas = new JScrollPane();
		scrollPaneTablas.setBounds(10, 31, 205, 219);
		contentPane.add(scrollPaneTablas);

		jListTablas = new JList();
		jListTablas.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if(e.getButton() == MouseEvent.BUTTON1)
					mostrarAtributos();
			}
		});
		scrollPaneTablas.setViewportView(jListTablas);
		jListTablas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		jListTablas.setModel(listTablasModel);

		JScrollPane scrollPaneAtrib = new JScrollPane();
		scrollPaneAtrib.setBounds(225, 31, 205, 219);
		contentPane.add(scrollPaneAtrib);

		jListAtrib = new JList();
		scrollPaneAtrib.setViewportView(jListAtrib);
		jListAtrib.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		jListAtrib.setModel(listAtribModel);
		
		setLocationRelativeTo(null);
	}

	private void cargarTablas(){
		try{ 
			Statement stmt = conexion.createStatement();

			//string SQL de la consulta
			String sql = "SHOW tables";

			// se ejecuta la sentencia y se recibe un resultset
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()){
				listTablasModel.addElement(rs.getString(1));
			}

			// se cierran los recursos utilizados 
			rs.close();
			stmt.close();
		}
		catch (SQLException ex){
			JOptionPane.showMessageDialog(this,
					ex.getMessage() + "\n",
					"Error al obtener tablas",
					JOptionPane.ERROR_MESSAGE);
		}

	}

	private void mostrarAtributos(){
		String tabla = (String)jListTablas.getSelectedValue();
		if(!listAtribModel.isEmpty()){
			listAtribModel.clear();
		}
		try{ 
			Statement stmt = conexion.createStatement();

			//string SQL de la consulta
			String sql = "DESCRIBE "+tabla;

			// se ejecuta la sentencia y se recibe un resultset
			ResultSet rs = stmt.executeQuery(sql);

			while(rs.next()){
				listAtribModel.addElement(rs.getString(1));
			}

			// se cierran los recursos utilizados 
			rs.close();
			stmt.close();
		}
		catch (SQLException ex){
			JOptionPane.showMessageDialog(this,
					ex.getMessage() + "\n",
					"Error al obtener los atributos de una tabla",
					JOptionPane.ERROR_MESSAGE);
		}

	}
}
