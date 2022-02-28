package parquimetros;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaInicio extends JFrame {

	private JPanel contentPane;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaInicio frame = new VentanaInicio();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public VentanaInicio() {
		setTitle("Acceso");
		
		iniciarGUI();
		
	}
	
	private void iniciarGUI(){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 316, 140);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton jButtonAdmin = new JButton("Administrador");
		jButtonAdmin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaLoginAdmin v = new VentanaLoginAdmin();
				v.setVisible(true);
				setVisible(false);
			}
		});
		jButtonAdmin.setBounds(10, 11, 133, 38);
		contentPane.add(jButtonAdmin);
		
		JButton jButtonIns = new JButton("Inspector");
		jButtonIns.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaLoginIns v = new VentanaLoginIns();
				v.setVisible(true);
				setVisible(false);
			}
		});
		jButtonIns.setBounds(153, 11, 133, 38);
		contentPane.add(jButtonIns);
		
		JButton btnCiudadanoKane = new JButton("Parquimetro");
		btnCiudadanoKane.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				VentanaCiudadano v = new VentanaCiudadano();
				v.setVisible(true);
				setVisible(false);
			}
		});
		btnCiudadanoKane.setBounds(81, 60, 133, 38);
		contentPane.add(btnCiudadanoKane);
		
		setLocationRelativeTo(null);
	}
}
