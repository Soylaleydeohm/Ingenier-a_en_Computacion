package parquimetros;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
//import com.mysql.jdbc.Driver;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


public class Logica {

	public Logica (){

	}

	public Connection conectarBD(String usr, String psw) throws SQLException{
		try{
			Class.forName("com.mysql.jdbc.Driver").newInstance();
		}
		catch (Exception ex){
			throw new SQLException();
		}
		String servidor = "localhost:3306";
		String baseDatos = "parquimetros";
		String usuario = usr;
		String clave = psw;
		String uriConexion = "jdbc:mysql://" + servidor + "/" + baseDatos;

		return DriverManager.getConnection(uriConexion, usuario, clave);
	}

	public void desconectarBD(Connection c) throws SQLException{
		if (c != null){
			c.close();
			c = null;
		}
	}

	public static String cryptMD5(String textoPlano){
		try{
			final char[] HEXADECIMALES = { '0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f' };

			MessageDigest msgdgt = MessageDigest.getInstance("MD5");
			byte[] bytes = msgdgt.digest(textoPlano.getBytes());
			StringBuilder strCryptMD5 = new StringBuilder(2 * bytes.length);
			for (int i = 0; i < bytes.length; i++)
			{
				int low = (int)(bytes[i] & 0x0f);
				int high = (int)((bytes[i] & 0xf0) >> 4);
				strCryptMD5.append(HEXADECIMALES[high]);
				strCryptMD5.append(HEXADECIMALES[low]);
			}
			return strCryptMD5.toString();
		} catch (NoSuchAlgorithmException e) {
			return null;
		}
	}

	
	public boolean modificacionSQL(Connection c, String sql){
		boolean exito= false;
		try{
			Statement st = c.createStatement();
			st.execute(sql);
			st.close();
			exito = true;
		}catch(SQLException ex){
			JOptionPane.showMessageDialog(null,
					ex.getMessage()+"\n",
					"Error en sentencia SQL",
					JOptionPane.ERROR_MESSAGE);
		}
		return exito;
	}
	
}