package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import controlador.interfaces.ControladorDatosIS;

public class ContBDImpleIS implements ControladorDatosIS {
	// <--- Sentencias --->
	final String SELECTusuario = "SELECT * FROM usuario WHERE usuario = ?";
		
	// <--- Conexión --->
		private PreparedStatement stmnt;
		private Connection con;

		ResourceBundle bundle = ResourceBundle.getBundle("modelo.config");

		private String url = bundle.getString("URL");
		private String user = bundle.getString("USER");
		private String pass = bundle.getString("PASS");
		
		public void openConnection() {
			try {
				con = DriverManager.getConnection(url, user, pass);
			} catch (SQLException e) {
				e.printStackTrace();
			} 
		}

		public void closeConnection() {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (stmnt != null) {
				try {
					stmnt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
	@Override
	public String[] comprobarCredenciales(String usuario) {
		ResultSet rs = null;
		String[] datos = null;
		
		this.openConnection();
		
		try {
			stmnt = con.prepareStatement(SELECTusuario);
			stmnt.setString(1, usuario);
			
			rs = stmnt.executeQuery();
			
			if (rs.next()) {
				datos = new String[3];
				
				datos[0] = usuario;
				datos[1] = rs.getString("contra");
				datos[2] = rs.getString("rango");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			this.closeConnection();
		}
		return datos;
	}

}
