package parquimetros;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import quick.dbtable.DBTable;

public class VentanaTablaSim extends JFrame {

	private JPanel contentPane;
	private JTable tabla;

	
	
	public VentanaTablaSim(Connection c,int idTarj, int idParq) {

		setTitle("Resultado");
		
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 583, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		setLocationRelativeTo(null);
		
		armarTabla(idTarj, idParq, c);
	}
	
	private void armarTabla(int idTarj,int  idParq, Connection c){
		try {		
		// se crea una sentencia o comando jdbc para realizar la consulta 
   	 // a partir de la coneccion establecida (conexionBD)
        Statement stmt = c.createStatement();

        // se prepara el string SQL de la consulta
        String sql = "call conectar(" + 
				idTarj +"," + idParq + ")";

        // se ejecuta la sentencia y se recibe un resultset
        ResultSet rs = stmt.executeQuery(sql);
        ResultSetMetaData rsmd= rs.getMetaData();
        
        int max =rsmd.getColumnCount();
        String rowData[] = new String[max];
        String columnNames[]= new String[max];
        for(int i = 1; i<=max; i++){
        	columnNames[i-1]=rsmd.getColumnName(i);
        }
        rs.next();
        for(int i = 1; i<=max; i++){
        	rowData[i-1]=rs.getString(i);
        }
		DefaultTableModel Model =  // se crea un modelo de tabla Model 
                new DefaultTableModel();
		Model.setColumnIdentifiers(columnNames);
		tabla = new JTable(Model);
		Model.addRow(rowData);
		tabla.setVisible(true);
		JScrollPane scrollPane = new JScrollPane();
		getContentPane().add(scrollPane);
		scrollPane.setViewportView(tabla);
		tabla.setEnabled(false);
        // se cierran los recursos utilizados 
        rs.close();
        stmt.close();
     }
     catch (SQLException ex)
     {
        // en caso de error, se muestra la causa en la consola
        System.out.println("SQLException: " + ex.getMessage());
        System.out.println("SQLState: " + ex.getSQLState());
        System.out.println("VendorError: " + ex.getErrorCode());
     }

	}

}
