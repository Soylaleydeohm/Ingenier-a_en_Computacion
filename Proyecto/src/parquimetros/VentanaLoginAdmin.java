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

public class VentanaLoginAdmin extends JFrame {

	private JPanel contentPane;
	private JPasswordField jPasswordFieldAdmin;
	private Logica l;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaLoginAdmin frame = new VentanaLoginAdmin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public VentanaLoginAdmin() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				new VentanaInicio().setVisible(true);
			}
		});
		l = new Logica();
		
		setTitle("Login Admin");
		armarGUI();	
	}

	private void armarGUI() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 256, 105);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Contrase\u00F1a :");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setBounds(10, 14, 77, 14);
		contentPane.add(lblNewLabel);
		
		JButton JButtonAdmin = new JButton("Ingresar");
		JButtonAdmin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				botonAdmin();
			}
		});
		JButtonAdmin.setBounds(97, 38, 89, 23);
		contentPane.add(JButtonAdmin);
		
		jPasswordFieldAdmin = new JPasswordField();
		jPasswordFieldAdmin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				botonAdmin();
			}
		});
		jPasswordFieldAdmin.setEchoChar('*');
		jPasswordFieldAdmin.setBounds(97, 11, 140, 20);
		contentPane.add(jPasswordFieldAdmin);
		
		setLocationRelativeTo(null);
		
	}
	
	private void botonAdmin(){
		if(jPasswordFieldAdmin.getPassword().length >0){
			char[] psw= jPasswordFieldAdmin.getPassword();
			String s = "";
			for(int i=0; i<psw.length; i++){
				s += psw[i];
			}
			try{
				Connection c = l.conectarBD("admin",s);
				VentanaAdmin ventAd = new VentanaAdmin(c);
				setVisible(false);
				ventAd.setVisible(true);

			}catch (SQLException ex){
				if(ex.getErrorCode() == 1045){
					JOptionPane.showMessageDialog(this,
							"Contraseña incorrecta.\n",
							"",
							JOptionPane.INFORMATION_MESSAGE);
				}
				else{
					JOptionPane.showMessageDialog(this,
							"Se produjo un error al intentar conectarse a la base de datos.\n" + ex.getMessage(),
							"Error de conexion",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		}else{
			JOptionPane.showMessageDialog(this,
					"Ingrese la contraseña.\n",
					"",
					JOptionPane.INFORMATION_MESSAGE);
		}
	}
	
}
