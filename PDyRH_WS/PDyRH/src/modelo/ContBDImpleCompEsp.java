package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import controlador.interfaces.ContDatosCompEsp;
import modelo.clases.Desaparecida;
import modelo.clases.Persona;
import modelo.clases.RestoHumano;

/**
 * Esta clase representa la implementacion de la ventana de comparación de los restos humanos.
 * @autor Elías
 * Utiliza sentencias SQL para seleccionar datos de los restos humanos y los desaparecidos, además de insertar a los identificadores.
 *
 */
public class ContBDImpleCompEsp implements ContDatosCompEsp {
	// <--- Sentencias --->
	final String INSERTident = "INSERT INTO identifica(dni,codResto) VALUES(?,?)";
	final String SELECTrh = "SELECT * FROM restohumano WHERE codResto = ?";
	final String SELECTdes = "SELECT * FROM desaparecida WHERE dni = ?";

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
			con.setAutoCommit(false);
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
	 * Metodo para agregar un identificado mediante el codigo del resto humano y el sni de la persona
	 * 
	 * Primeramente se abre la conexion y se ejecuta la sentencia para insertar el identificado, 
	 * guarda el dni y el codigo introducido en la sentencia y finalmente se cierra la conexion.
	 */
	@Override
	public void agregarIdentificado(String codResto, String dni)  {
		this.openConnection();

		try {
			stmnt = con.prepareStatement(INSERTident);

			stmnt.setString(1, dni);
			stmnt.setString(2, codResto);

			stmnt.executeUpdate();

			con.commit();
		} catch (SQLException e) {
			if (con != null) {
				try {
					con.rollback();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		} finally {
			this.closeConnection();
		}
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
	public RestoHumano obtenerRH(String codResto)  {
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
			
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					
				}
			}
			this.closeConnection();
		}

		return resto;
	}

	/**
	 * Metodo para obtener a la persona mediante el DNI.
	 * <li> ResultSet rs: Contiene el resultado de la consulta ejecutada
	 * <li> Persona des: Contiene los datos de la persona desaparecida.
	 * 
	 * Primeramente se abre la conexion y se ejecuta la sentencia para seleccionar a los desaparecidos, 
	 * guarda los resultados en los atributos de la clase y finalmente se cierra el resultado y la conexion.
	 * 
	 * @return Devuelve los datos de la persona desaparecida.
	 */
	@Override
	public Persona obtenerPersona(String dni)  {
		ResultSet rs = null;
		Persona des = null;

		this.openConnection();

		try {
			stmnt = con.prepareStatement(SELECTdes);
			stmnt.setString(1, dni);

			rs = stmnt.executeQuery();

			if (rs.next()) {
				des = new Desaparecida();

				des.setDni(dni);
				((Desaparecida) des).setUltimaUbi(rs.getString("ultimaUbi"));
				((Desaparecida) des).setGenero(rs.getString("genero"));
				((Desaparecida) des).setTipoPelo(rs.getString("tipoPelo"));
				((Desaparecida) des).setColorPelo(rs.getString("colorPelo"));
				((Desaparecida) des).setColorOjos(rs.getString("colorOjos"));
				((Desaparecida) des).setAltura(rs.getInt("altura"));
				((Desaparecida) des).setEspecificaciones(rs.getString("especificaciones"));
				if (rs.getDate("fechaDes") != null) {
					((Desaparecida) des).setFechaDes(rs.getDate("fechaDes").toLocalDate());
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

		return des;
	}

}