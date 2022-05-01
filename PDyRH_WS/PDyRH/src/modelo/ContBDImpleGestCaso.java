package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.TreeMap;

import controlador.ContDatosGestCaso;
import modelo.clases.Caso;
import modelo.clases.Persona;

public class ContBDImpleGestCaso implements ContDatosGestCaso {
	
	// <--- Sentencias --->
	final String INSERTparticipa = "INSERT INTO participa(codCaso,dni,implicación) VALUES(?,?,?)";
	final String SELECTpersonasCaso = "SELECT * FROM persona WHERE dni IN (SELECT dni FROM participa WHERE codCaso = ?)";
	
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
	public void modificarCaso(Caso caso) {
		// TODO Auto-generated method stub

	}

	@Override
	public void eliminarCaso(Caso caso) {
		// TODO Auto-generated method stub

	}

	@Override
	public void agregarParticipante(String dni, Caso caso, String implicacion) {
		this.openConnection();

		try {
			stmnt = con.prepareStatement(INSERTparticipa);

			stmnt.setString(1, caso.getCodCaso());
			stmnt.setString(2, dni);
			stmnt.setString(3, implicacion);

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

	@Override
	public Map<String, Persona> listarParticipantes(String codCaso) {
		ResultSet rs = null;
		Persona per;
		Map<String, Persona> participantes = new TreeMap<>();

		this.openConnection();

		try {
			stmnt = con.prepareStatement(SELECTpersonasCaso);
			stmnt.setString(1, codCaso);

			rs = stmnt.executeQuery();

			while (rs.next()) {
				int[] telfs = { rs.getInt("telf1"), rs.getInt("telf2") };
				per = new Persona();

				per.setDni(rs.getString("dni"));
				per.setNombre(rs.getString("nombre"));
				per.setApellido(rs.getString("apellido"));
				per.setTelefonos(telfs);
				per.setFechaNac(rs.getDate("fechaNac").toLocalDate());
				per.setFechaFal(rs.getDate("fechaFal").toLocalDate());
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
		return participantes;
	}

	@Override
	public Map<String, Persona> listarPersonas() {
		// TODO Auto-generated method stub
		return null;
	}

}
