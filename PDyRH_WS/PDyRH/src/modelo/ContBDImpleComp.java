package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.TreeMap;

import controlador.interfaces.ContDatosComp;
import modelo.clases.Desaparecida;
import modelo.clases.Persona;
import modelo.clases.RestoHumano;

/**
 * Esta clase representa el controlador de la base de datos de la ventana de comparacion
 * @author Elias
 * Utiliza sentencias SQL para seleccionar datos. Ademas utiliza metodos de la interfaz para listar a los restos humanos y las desaparecidas, 
 * y obtener el identificado mediante el codigo del resto.
 */
public class ContBDImpleComp implements ContDatosComp {
	// <--- Sentencias --->
	final String SELECTrhs = "SELECT * FROM restohumano";
	final String SELECTdesaparecidas = "SELECT * FROM desaparecida";
	final String SELECTidentificado = "SELECT dni FROM identifica WHERE codResto = ?";
	
	// <--- Conexi�n --->
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
	 * <li> pass: Es la contrase�a del usuario
	 */
	private String pass = bundle.getString("PASS");

	/**
	 * Metodo para abrir la conexion de la base de datos con la URL, el usuario y la contrase�a.
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
	public Map<String, RestoHumano> listarRHs() {
		ResultSet rs = null;
		RestoHumano resto = null;
		Map<String,RestoHumano> restos = new TreeMap<>();
		
		this.openConnection();
		
		try {
			stmnt = con.prepareStatement(SELECTrhs);
			
			rs = stmnt.executeQuery();
			
			while (rs.next()) {
				resto = new RestoHumano();

				resto.setCodResto(rs.getString("codResto"));
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
				if (obtenerIdentificado(resto.getCodResto()) == null) {
					restos.put(resto.getCodResto(), resto);
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
		
		return restos;
	}

	@Override
	public Map<String, Persona> listarDesaparecidas() {
		ResultSet rs = null;
		Persona des = null;
		Map<String, Persona> desaparecidas = new TreeMap<>();
		
		this.openConnection();
		
		try {
			stmnt = con.prepareStatement(SELECTdesaparecidas);
			
			rs = stmnt.executeQuery();
			
			while (rs.next()) {
				des = new Desaparecida();
				
				des.setDni(rs.getString("dni"));
				if (rs.getDate("fechaDes") != null) {
					((Desaparecida) des).setFechaDes(rs.getDate("fechaDes").toLocalDate());
				}
				((Desaparecida) des).setUltimaUbi(rs.getString("ultimaUbi"));
				((Desaparecida) des).setGenero(rs.getString("genero"));
				((Desaparecida) des).setTipoPelo(rs.getString("tipoPelo"));
				((Desaparecida) des).setColorPelo(rs.getString("colorPelo"));
				((Desaparecida) des).setColorOjos(rs.getString("colorOjos"));
				((Desaparecida) des).setAltura(rs.getInt("altura"));
				((Desaparecida) des).setEspecificaciones(rs.getString("especificaciones"));
				
				desaparecidas.put(des.getDni(), des);
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
		return desaparecidas;
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
}
