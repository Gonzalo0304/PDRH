package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import controlador.interfaces.ContDatosBusqRH;
import modelo.clases.RestoHumano;

/**
 * Esta clase representa el controlador de la base de datos de la ventana de resto humano
 * @autor Elías
 * Utiliza sentencias SQL para seleccionar los datos de la tabla restos humanos y de la tabla identifica.
 *
 */
public class ContBDImpleBusqRH implements ContDatosBusqRH {
	// <--- Sentencias --->
	final String SELECTidentificado = "SELECT dni FROM identifica WHERE codResto = ?";
	final String SELECTrh = "SELECT * FROM restohumano WHERE codResto = ?";
	
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
	 * <li> user: Es el usuario para iniciar sesión.
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
			e.printStackTrace();
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
	
	/**
	 * Metodo para obtener el identificado mediante el codigo del resto humano
	 * <li> ResultSet rs:  Contiene el resultado de la consulta ejecutada
	 * <li> String dni: En esta variable guarda el DNI de la persona.
	 * 
	 * Primeramente se abre la conexion y se ejecuta la sentencia para seleccionar el identificado, 
	 * el dni guarda el resultado y finalmente se cierra el resultado y la conexion.
	 * 
	 * @return Devuelve el DNI de la persona.
	 */
	@Override
	public String obtenerIdentificado(String codResto) {
		ResultSet rs = null;
		String dni = null;
		
		this.openConnection();
		
		try {
			stmnt = con.prepareStatement(SELECTidentificado);
			stmnt.setString(1, codResto);
			
			rs = stmnt.executeQuery();
			
			if (rs.next()) {
				dni = rs.getString("dni");
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
		
		return dni;
	}

	/**
	 * Metodo para obtener el Resto Humano mediante el codigo.
	 * <li> ResultSet rs:  Contiene el resultado de la consulta ejecutada
	 * <li> RestoHumano resto: Contiene los datos de la clase.
	 * 
	 * Primeramente se abre la conexion y se ejecuta la sentencia para seleccionar el resto humano, 
	 * guarda los resultados en los atributos de la clase y finalmente se cierra el resultado y la conexion.
	 * 
	 * @return Devuelve los datos del resto.
	 */
	@Override
	public RestoHumano obtenerRH(String codResto) {
		ResultSet rs = null;
		RestoHumano resto = null;
		
		this.openConnection();
		
		try {
			stmnt = con.prepareStatement(SELECTrh);
			stmnt.setString(1, codResto);
			
			rs = stmnt.executeQuery();
			
			if (rs.next()) {
				resto = new RestoHumano();
				
				resto.setCodResto(codResto);
				resto.setCausa(rs.getString("causa"));
				resto.setUbicacion(rs.getString("ubicacion"));
				resto.setGenero(rs.getString("genero"));
				resto.setTipoPelo(rs.getString("tipoPelo"));
				resto.setColorPelo(rs.getString("colorPelo"));
				resto.setColorOjos(rs.getString("colorOjos"));
				resto.setAltura(rs.getInt("altura"));
				resto.setEspecificaciones(rs.getString("especificaciones"));
				resto.setCodCaso(rs.getString("codCaso"));
				if (rs.getDate("fechaMuerte") != null) {
					resto.setFechaMuerte(rs.getDate("fechaMuerte").toLocalDate());
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
		
		return resto;
	}

}
