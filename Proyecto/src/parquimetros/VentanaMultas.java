package parquimetros;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import quick.dbtable.DBTable;

public class VentanaMultas extends JFrame {

	private JPanel contentPane;
	private DBTable tabla;
	
	
	public VentanaMultas(Connection c, int numeroMulta) {
		setTitle("Multas");
		
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 583, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		setLocationRelativeTo(null);
		tabla = new DBTable();
		tabla.setConnection(c);
		
		// Agrega la tabla al frame (no necesita JScrollPane como Jtable)
		getContentPane().add(tabla, BorderLayout.CENTER);           

		// setea la tabla para sólo lectura (no se puede editar su contenido)  
		tabla.setEditable(false); 
		
		armarTabla(numeroMulta);
	}
	
	private void armarTabla(int m){
		
		String sql = 	"SELECT numero AS 'número de multa', fecha, hora, calle, altura, "+
						"patente AS 'patente del auto', legajo AS 'legajo del inspector' "+
						"FROM multa NATURAL JOIN asociado_con "+
						"WHERE numero >= "+m;
		tabla.setSelectSql(sql);
		
		try {
			tabla.createColumnModelFromQuery();
		  	    
		for (int i = 0; i < tabla.getColumnCount(); i++){ // para que muestre correctamente los valores de tipo TIME (hora)  		   		  
			if	 (tabla.getColumn(i).getType()==Types.TIME)  {    		 
				tabla.getColumn(i).setType(Types.CHAR);  
			}
			// cambiar el formato en que se muestran los valores de tipo DATE
			if	 (tabla.getColumn(i).getType()==Types.DATE){
				tabla.getColumn(i).setDateFormat("dd/MM/YYYY");
			}
		}  
		// actualizamos el contenido de la tabla.   	     	  
		tabla.refresh();
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(this,
					ex.getMessage() + "\n",
					"Error al mostrar multas",
					JOptionPane.ERROR_MESSAGE);
		} 
	}

}
