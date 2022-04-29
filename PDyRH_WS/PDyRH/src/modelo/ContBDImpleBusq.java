package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import controlador.ContDatosBusq;
import modelo.clases.Caso;
import modelo.clases.Persona;
import modelo.clases.RestoHumano;

public class ContBDImpleBusq implements ContDatosBusq {
	// <--- Sentencias -->
	final String SELECTper = "SELECT * FROM persona WHERE dni = ?";
	final String SELECTRH = "SELECT * FROM restoHumano WHERE codRH = ?";
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
	public Persona buscarPersona(String dni) {
		ResultSet rs = null;
		Persona per = null;

		this.openConnection();

		try {
			stmnt = con.prepareStatement(SELECTper);
			stmnt.setString(1, dni);

			rs = stmnt.executeQuery();

			if (rs.next()) {
				int[] telfs = { rs.getInt("telf1"), rs.getInt("telf2") };
				per = new Persona();

				per.setDni(dni);
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
		return per;
	}

	@Override
	public RestoHumano buscarRH(String codResto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Persona buscarIdentificado(String codResto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Caso buscarCaso(String codCaso) {
		// TODO Auto-generated method stub
		return null;
	}

}
