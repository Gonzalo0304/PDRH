package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import controlador.interfaces.ContDatosBusq;
import modelo.clases.Caso;

/**
 * Esta clase representa el controlador de la base de datos de la ventana de busqueda
 * @author Elias
 * Utiliza sentencias SQL para seleccionar datos, ademas utiliza metodos de la interfaz para comprobar los codigos o dni de las clases.
 */
public class ContBDImpleBusq implements ContDatosBusq {
	// <--- Sentencias -->
	final String SELECTcaso = "SELECT * FROM caso WHERE codCaso = ?";
	final String CALLcomprobarDNI = "{CALL comprobarDNI(?)}";
	final String CALLbuscarRH = "{CALL buscarRH(?)}";
	
	// <--- Conexión --->
	/**
	 * <li>PreparedStatement: Sirve para ejecutar la sentencia SQL en los metodos.
	 */
	private PreparedStatement stmnt;
	/**
	 * <li>Connection: Es la conexion de la base de datos
	 */
	private Connection con;

	ResourceBundle bundle = ResourceBundle.getBundle("modelo.config");

	/**
	 * <li> url: Es el enlace donde se encuentra la base de datos.
	 */
	private String url = bundle.getString("URL");
	/**
	 * <li> user: Es el usuario para iniciar sesion.
	 */
	private String user = bundle.getString("USER");
	/**
	 * <li> pass: Es la contraseña del usuarios
	 */
	private String pass = bundle.getString("PASS");

	/**
	 * Metodo para abrir la conexion de la base de datos con la URL, el usuario y la contraseña.
	 */
	public void openConnection() {
		try {
			con = DriverManager.getConnection(url, user, pass);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Metodo para cerrar la conexion de la base de datos y cerrar la sentencia SQL.
	 */
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
	public Caso obtenerCaso(String codCaso) {
		ResultSet rs = null;
		Caso caso = null;
		
		this.openConnection();
		try {
			stmnt = con.prepareStatement(SELECTcaso);
			stmnt.setString(1, codCaso);
			
			rs = stmnt.executeQuery();
			
			if (rs.next()) {
				caso = new Caso();
				caso.setCodCaso(codCaso);
				caso.setEstado(rs.getString("estado"));
				caso.setNombre(rs.getString("nombre"));
				if (rs.getDate("fechaIni") != null) {
					caso.setFechaIni(rs.getDate("fechaIni").toLocalDate());
				}
				if (rs.getDate("fechaFin") != null) {
					caso.setFechaFin(rs.getDate("fechaFin").toLocalDate());
				}
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
		return caso;
	}

	@Override
	public boolean comprobarDNI(String dni) {
		ResultSet rs = null;
		boolean esta = false;
		
		this.openConnection();
		
		try {
			stmnt = con.prepareCall(CALLcomprobarDNI);
			stmnt.setString(1, dni);
			
			rs = stmnt.executeQuery();
			
			if (rs.next()) {
				esta = rs.getBoolean("esta");
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
		return esta;
	}

	@Override
	public boolean comprobarCodResto(String codResto) {
		ResultSet rs = null;
		boolean esta = false;
		
		this.openConnection();
		try {
			stmnt = con.prepareCall(CALLbuscarRH);
			stmnt.setString(1, codResto);
			
			rs = stmnt.executeQuery();
			
			if (rs.next()) {
				esta = rs.getBoolean("esta");
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
		return esta;
	}

}
