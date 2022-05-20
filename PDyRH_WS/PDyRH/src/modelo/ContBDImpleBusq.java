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
 * Esta clase representa la implementacion de la ventana de busqueda
 * @autor Equipo5
 * Utiliza sentencias SQL para seleccionar datos, un procedimiento que combrueba el dni de la persona
 * y otro que buscar al resto humano.
 *
 */
public class ContBDImpleBusq implements ContDatosBusq {
	// <--- Sentencias -->
	final String SELECTcaso = "SELECT * FROM caso WHERE codCaso = ?";
	final String CALLcomprobarDNI = "{CALL comprobarDNI(?)}";
	final String CALLbuscarRH = "{CALL buscarRH(?)}";

	// <--- Conexión --->
	/**
	 * <li>PreparedStatement: Sirve para ejecutar la sentencia SQL en los métodos.
	 */
	private PreparedStatement stmnt;
	/**
	 * <li>Conexión: Es la conexión de la base de dato
	 */
	private Connection con;

	ResourceBundle bundle = ResourceBundle.getBundle("modelo.config");

	/**
	 * <li> url: Es el enlace donde se encuentra la base de datos.
	 */
	private String url = bundle.getString("URL");
	/**
	 * <li> usuario: Es el usuario para iniciar sesión.
	 */
	private String user = bundle.getString("USER");
	/**
	 * <li> pass: Es la contraseña de los usuarios
	 */
	private String pass = bundle.getString("PASS");

	/**
	 * Metodo para abrir la conexion de la base de datos con la URL, el usuario y la contraseña.
	 */
	public void openConnection() {
		try {
			con = DriverManager.getConnection(url, user, pass);
		} catch (SQLException e) {
		}
	}


	/**
	 * Metodo para cerrar la conexion de la base de datos y cerrar la sentencia SQL
	 */
	public void closeConnection() {
		if (con != null) {
			try {
				con.close();
			} catch (SQLException e) {
			}
		}
		if (stmnt != null) {
			try {
				stmnt.close();
			} catch (SQLException e) {
			}
		}
	}

	/**
	 * Metodo para obtener el caso con el codigo del caso.
	 * <li>ResultSet rs: Contiene el resultado de la consulta ejecutada
	 * <li>Caso caso: Contiene los datos de la clase Caso.
	 * 
	 * Primeramente se abre la conexion y se ejecuta la sentencia de seleccion, 
	 * guarda los resultados en los atributos de la clase y finalmente se cierra el resultado y la conexion.
	 * 
	 * @return Devuelve la informacion del caso.
	 * 
	 */
	@Override
	public Caso obtenerCaso(String codCaso)  {
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
			
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					
				}
			}
			this.closeConnection();
		}
		return caso;
	}

	/**
	 * Metodo para comprobar que el DNI de la persona existe.
	 * <li>ResultSet rs: Contiene el resultado de la consulta ejecutada
	 * <li>boolean esta: Esta variable se encarga de encontrar a la persona.
	 * 
	 * Primeramente se abre la conexion y se ejecuta el procedimiento que buscara a la persona con el DNI introducido, 
	 * guardara en la variable 'esta' el resultado del procedimiento  y finalmente se cierra el resultado y la conexion.
	 * 
	 * @return Devuelve si ha encontrado el DNI o no.
	 */
	@Override
	public boolean comprobarDNI(String dni)  {
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
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
				}
			}
			this.closeConnection();
		}
		return esta;
	}

	/**
	 * Metodo para Comprobar el Resto Humano mediante el codigo del resto
	 * <li>ResultSet rs: Contiene el resultado de la consulta ejecutada
	 * <li>boolean esta: Esta variable se encarga de encontrar al Resto Humano.
	 * 
	 * Primeramente se abre la conexion y se ejecuta el procedimiento que buscara al resto humano con el codigo introducido, 
	 * guardara en la variable 'esta' el resultado del procedimiento  y finalmente se cierra el resultado y la conexion. 
	 * 
	 * @return Devuelve si ha encontrado el codigo o no.
	 */
	@Override
	public boolean comprobarCodResto(String codResto)  {
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
			
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					
				}
			}
			this.closeConnection();
		}
		return esta;
	}

}
