package parquimetros;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class VentanaLoginIns extends JFrame {

	private JPanel contentPane;
	private JTextField jTextFieldIns;
	private JPasswordField jPasswordFieldIns;
	private Logica l;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaLoginIns frame = new VentanaLoginIns();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public VentanaLoginIns() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				new VentanaInicio().setVisible(true);
			}
		});
		l = new Logica();
		setTitle("Login Inspector");
		armarGUI();	
	}

	private void armarGUI() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 264, 134);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUsuario = new JLabel("Usuario :");
		lblUsuario.setHorizontalAlignment(SwingConstants.RIGHT);
		lblUsuario.setBounds(10, 14, 77, 14);
		contentPane.add(lblUsuario);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a :");
		lblContrasea.setHorizontalAlignment(SwingConstants.RIGHT);
		lblContrasea.setBounds(10, 39, 77, 14);
		contentPane.add(lblContrasea);
		
		jTextFieldIns = new JTextField();
		jTextFieldIns.setBounds(97, 11, 140, 20);
		contentPane.add(jTextFieldIns);
		jTextFieldIns.setColumns(10);
		
		jPasswordFieldIns = new JPasswordField();
		jPasswordFieldIns.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				botonInspector();
			}
		});
		jPasswordFieldIns.setEchoChar('*');
		jPasswordFieldIns.setBounds(97, 36, 140, 20);
		contentPane.add(jPasswordFieldIns);
		
		JButton JButtonIns = new JButton("Ingresar");
		JButtonIns.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				botonInspector();
			}
		});
		JButtonIns.setBounds(97, 67, 89, 23);
		contentPane.add(JButtonIns);
		
		setLocationRelativeTo(null);
		
	}
	
	private void botonInspector(){
		if(jTextFieldIns.getText().length()>0){
			String user = jTextFieldIns.getText();
			if(jPasswordFieldIns.getPassword().length >0){
				char[] psw = jPasswordFieldIns.getPassword();
				String clave = "";
				for(int i=0; i<psw.length; i++){
					clave += psw[i];
				}
				validarInspector(user,clave);									
			}
			else{
				JOptionPane.showMessageDialog(this,
						"Ingrese la contraseña.\n",
						"",
						JOptionPane.INFORMATION_MESSAGE);
			}
		}else{
			JOptionPane.showMessageDialog(this,
					"Ingrese el nombre de usuario.\n",
					"",
					JOptionPane.INFORMATION_MESSAGE);
		}				
	}
	
	private void validarInspector(String legajo, String clave) {
		Connection c = null;
		try {
			c = l.conectarBD("inspector", "inspector");
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(this,
					e.getMessage()+"\n",
					"Error de conexion",
					JOptionPane.ERROR_MESSAGE);
		}
		if(c != null){
			try{
				clave = l.cryptMD5(clave);
				Statement stmt = c.createStatement();
		
				//string SQL de la consulta
				String sql = "SELECT legajo, password " + 
						"FROM inspectores " +
						"WHERE legajo='"+legajo+"'";
		
				// se ejecuta la sentencia y se recibe un resultset
				ResultSet rs = stmt.executeQuery(sql);
		
				if(rs.next()){
					//Al menos el legajo existe.
					if(rs.getString(2).equals(clave)){
						//la contraseña ingresada coincide
						Statement stmt2 = c.createStatement();
						String dia = obtenerDia(c);
						System.out.println("Dia: "+dia);
						String turno = obtenerTurno(c);
						System.out.println("Turno: "+turno);
						if (turno == null){
							JOptionPane.showMessageDialog(this,
									"Turno fuera de horario de trabajo");
						}else{
							//string SQL
							String sql2 = "SELECT id_asociado_con " + 
									"FROM Asociado_con AS a " +
									"WHERE a.legajo = '" + legajo + "' " +
									"AND a.dia = '" + dia + "' " + 
									"AND a.turno = '" + turno + "' ";

							// se ejecuta la sentencia 
							ResultSet r = stmt2.executeQuery(sql2);
							if(r.next()){
								//Inspector esta asociado con ubicacion

								//El inspector está habilitado en este horario
								VentanaInspector v = new VentanaInspector(c,legajo);
								v.setVisible(true);
								this.setVisible(false);
							}else{
								JOptionPane.showMessageDialog(this,
										"No autorizado. Fuera del horario de trabajo");
							}	
						}
					}else{
						JOptionPane.showMessageDialog(this,
								"Contraseña incorrecta.\n",
								"",
								JOptionPane.INFORMATION_MESSAGE);
					}
					
				}
				else{
					JOptionPane.showMessageDialog(this,
							"Usuario no registrado.\n",
							"",
							JOptionPane.INFORMATION_MESSAGE);
				}
		
				// se cierran los recursos utilizados 
				rs.close();
				stmt.close();
			}catch(SQLException e){
				JOptionPane.showMessageDialog(this,
						e.getMessage()+"\n",
						"Error al consultar la BD",
						JOptionPane.ERROR_MESSAGE);
			}
		}
	}
		
		private String obtenerDia(Connection conexion){
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
		
		private String obtenerTurno(Connection conexion){
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
	
