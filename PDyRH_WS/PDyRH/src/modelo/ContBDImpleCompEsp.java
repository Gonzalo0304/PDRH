package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;

import controlador.interfaces.ContDatosCompEsp;

public class ContBDImpleCompEsp implements ContDatosCompEsp {
	// <--- Sentencias --->
	final String INSERTident = "INSERT INTO identifica(dni,codResto) VALUES(?,?)";
	
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
			con.setAutoCommit(false);
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
	public void agregarIdentificado(String codResto, String dni) {
		this.openConnection();
		
		try {
			stmnt = con.prepareStatement(INSERTident);
			
			stmnt.setString(1, dni);
			stmnt.setString(2, codResto);
			
			stmnt.executeUpdate();
			
			con.commit();
		} catch (SQLException e) {
			e.printStackTrace();
			if (con != null) {
				try {
					con.rollback();
				} catch (SQLException e2) {
					e.printStackTrace();
				}
			}
		} finally {
			this.closeConnection();
		}
	}

}