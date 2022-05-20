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
 * Esta clase representa la implementación de la ventana de comparacion
 * @autor Elías
 * Utiliza sentencias SQL para seleccionar datos del resto humano, la persona desaparecida y la persona identificada. 
 *
 */
public class ContBDImpleComp implements ContDatosComp {
	// <--- Sentencias --->
	final String SELECTrhs = "SELECT * FROM restohumano";
	final String SELECTdesaparecidas = "SELECT * FROM desaparecida";
	final String SELECTidentificado = "SELECT dni FROM identifica WHERE codResto = ?";

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
	 * Metodo para listar los Restos Humanos
	 * <li> ResultSet rs: Contiene el resultado de la consulta ejecutada
	 * <li> RestoHumano resto: Contiene los datos de la clase.
	 * <li> Map<String,RestoHumano> restos: Se utiliza para introducir los datos dentro del Map.
	 * 
	 * Primeramente se abre la conexion y se ejecuta la sentencia para seleccionar el resto humano, 
	 * guarda los resultados en los atributos de la clase y finalmente se cierra el resultado y la conexion.
	 * 
	 * @return Devuelve los datos de los restos.
	 */
	@Override
	public Map<String, RestoHumano> listarRHs()  {
		ResultSet rs = null;
		RestoHumano resto = null;
		Map<String, RestoHumano> restos = new TreeMap<>();

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
			
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					
				}
			}
			this.closeConnection();
		}

		return restos;
	}

	/**
	 * Metodo para listar los Restos Humanos
	 * <li> ResultSet rs: Contiene el resultado de la consulta ejecutada
	 * <li> Persona des: Contiene los datos de la clase Desaparecida.
	 * <li> Map<String, Persona> desaparecidas: Se utiliza para introducir los datos dentro del Map.
	 * 
	 * Primeramente se abre la conexion y se ejecuta la sentencia para seleccionar el resto humano, 
	 * guarda los resultados en los atributos de la clase y finalmente se cierra el resultado y la conexion.
	 * 
	 * @return Devuelve los datos de las desaparecidas.
	 */
	@Override
	public Map<String, Persona> listarDesaparecidas()  {
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
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					
				}
			}
			this.closeConnection();
		}
		return desaparecidas;
	}
	
	/**
	 *  Metodo para obtener el identificado mediante el codigo del resto humano
	 * <li> ResultSet rs:  Contiene el resultado de la consulta ejecutada
	 * <li> String dni: En esta variable guarda el DNI de la persona.
	 * 
	 * Primeramente se abre la conexion y se ejecuta la sentencia para seleccionar el identificado, 
	 * el dni guarda el resultado y finalmente se cierra el resultado y la conexion.
	 * 
	 * @return Devuelve el DNI de la persona.
	 */
	@Override
	public String obtenerIdentificado(String codResto)  {
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
			
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					
				}
			}
			this.closeConnection();
		}

		return dni;
	}
}
