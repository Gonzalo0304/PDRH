package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.TreeMap;

import controlador.interfaces.ContDatosBusqRap;
import modelo.clases.Persona;

public class ContBDImpleBusqRap implements ContDatosBusqRap {
	// <--- Sentencias --->
	final String SELECTpers = "SELECT * FROM persona WHERE UPPER(nombre) LIKE UPPER('%?%')";
	
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
	public Map<String, Persona> obtenerPersonas(String nombre) {
		ResultSet rs = null;
		Persona per = null;
		Map<String, Persona> personas = new TreeMap<>();

		this.openConnection();

		try {
			stmnt = con.prepareStatement(SELECTpers);
			stmnt.setString(1, nombre);
			
			rs = stmnt.executeQuery();

			while (rs.next()) {
				per = new Persona();

				per.setDni(rs.getString("dni"));
				per.setNombre(rs.getString("nombre"));
				personas.put(per.getDni(), per);
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
		return personas;
	}

}
