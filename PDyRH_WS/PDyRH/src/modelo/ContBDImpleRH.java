package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Map;
import java.util.ResourceBundle;

import controlador.ContDatosRH;
import modelo.clases.Persona;
import modelo.clases.RestoHumano;

public class ContBDImpleRH implements ContDatosRH {
	// <--- Sentencias --->
	
	
	final String INSERTidentifica = "INSERT INTO identifica(dni,codResto) VALUES(?,?)";
	final String SELECTidentifica = "SELECT * FROM persona WHERE dni IN (SELECT dni FROM identifica WHERE codResto = ?)";
	
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
	public void altaRH(RestoHumano rh) {
		// TODO Auto-generated method stub

	}

	@Override
	public void modificarRH(RestoHumano rh) {
		// TODO Auto-generated method stub

	}

	@Override
	public void eliminarRH(RestoHumano rh) {
		// TODO Auto-generated method stub

	}

	@Override
	public Map<String, RestoHumano> listarRestos() {
		// TODO Auto-generated method stub
		return null;
	}
	
	// <--- Identifica --->
	@Override
	public void agregarIdentificado(RestoHumano resto, Persona per) {
		this.openConnection();
		
		try {
			stmnt = con.prepareStatement(INSERTidentifica);
			
			stmnt.setString(1, resto.getCodResto());
			stmnt.setString(2, per.getDni());
			
			stmnt.executeUpdate();
			con.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.closeConnection();
		}	
	}
}
