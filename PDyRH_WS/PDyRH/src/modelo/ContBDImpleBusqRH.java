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
 * @author Elias
 * Utiliza sentencias SQL para seleccionar los datos de los resto humanos
 * y utiliza metodos de la interfaz para obtener algun identificado y el resto humano mediante el codigo del Resto.
 */
public class ContBDImpleBusqRH implements ContDatosBusqRH {
	// <--- Sentencias --->
	final String SELECTidentificado = "SELECT dni FROM identifica WHERE codResto = ?";
	final String SELECTrh = "SELECT * FROM restohumano WHERE codResto = ?";
	
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
	 * <li> pass: Es la contraseña del usuario
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
