package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import controlador.ControladorDatosIS;

public class ContBDImpleIS implements ControladorDatosIS {
	// <--- Sentencias --->
	final String SELECTusuario = "SELECT contra,rango FROM usuario WHERE usuario = ?";
		
	// <--- Conexi�n --->
		private PreparedStatement stmnt;
		private Connection con;

		ResourceBundle bundle = ResourceBundle.getBundle("modelo.config");

		String url = bundle.getString("URL");
		String user = bundle.getString("USER");
		String pass = bundle.getString("PASS");

		public void openConnection() {
			try {
				con = DriverManager.getConnection(url, user, pass);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		public void closeConnection() {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (stmnt != null) {
				try {
					stmnt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
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
				datos = new String[2];
				
				datos[0] = rs.getString("contra");
				datos[1] = rs.getString("rango");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		this.closeConnection();
		return datos;
	}

}
