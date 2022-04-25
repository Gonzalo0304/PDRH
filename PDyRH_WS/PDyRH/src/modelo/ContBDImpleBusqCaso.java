package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Map;
import java.util.ResourceBundle;

import controlador.ContDatosBusqCaso;
import modelo.clases.Participante;
import modelo.clases.RestoHumano;

public class ContBDImpleBusqCaso implements ContDatosBusqCaso {
	// <--- Conexión --->
	private PreparedStatement stmnt;
	private Connection con;

	ResourceBundle bundle = ResourceBundle.getBundle("modelo.config");

	String url = bundle.getString("URL");
	String user = bundle.getString("USER");
	String pass = bundle.getString("PASS");

	public void openConnection() {
		try {
			con = DriverManager.getConnection(url, user, pass);
			con.setAutoCommit(false);
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
	public Map<String, Participante> participantes(String codCaso) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, RestoHumano> restos(String codCaso) {
		// TODO Auto-generated method stub
		return null;
	}

}
