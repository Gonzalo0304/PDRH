package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.TreeMap;

import controlador.interfaces.ContDatosBusqCaso;
import modelo.clases.Participante;
import modelo.clases.RestoHumano;

/**
 * Esta clase representa el controlador de la base de datos de la ventana de busqueda de caso
 * @autor Elías
 * Utiliza sentencias SQL para seleccionar los datos de los casos.
 *
 */
public class ContBDImpleBusqCaso implements ContDatosBusqCaso {
	// <--- Sentencias --->
	final String SELECTparticipantes = "SELECT * FROM participa WHERE codCaso = ?";
	final String SELECTnomCom = "SELECT nombre,apellido FROM persona WHERE dni = ?";
	final String SELECTrestos = "SELECT * FROM restohumano WHERE codCaso = ?";
	
	// <--- Conexión --->
	/**
	 * <li>PreparedStatement: Sirve para ejecutar la sentencia SQL en los métodos.
	 */
	private PreparedStatement stmnt;
	/**
	 * <li>Connectión: Es la conexión de la base de dato
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
	 * Metodo para listar a los participantes de los casos mediante el codigo del caso.
	 * <li> ResultSet rs: Contiene el resultado de la consulta ejecutada
	 * <li> ResultSet rs2: Contiene el resultado de la consulta ejecutada
	 * <li> Participante par: Contiene los datos de los participantes
	 * <li> Map<String, Participante> participantes: Se utiliza para introducir los datos dentro del Map.
	 * 
	 * Primeramente se abre la conexion y se ejecuta la sentencia que selecciona los participantes, 
	 * guardara los resultados en los atributos de la clase  y finalmente se cierra el resultado y la conexion.
	 * 
	 * @return Devuelve el los ressultados que se encuentran en el Map.
	 */
	@Override
	public Map<String, Participante> listarParticipantes(String codCaso) {
		ResultSet rs = null;
		ResultSet rs2 = null;
		PreparedStatement stmnt2;
		Participante par = null;
		Map<String, Participante> participantes =  new TreeMap<>();
		
		this.openConnection();
		
		try {
			stmnt = con.prepareStatement(SELECTparticipantes);
			stmnt.setString(1, codCaso);
			
			rs = stmnt.executeQuery();
			
			while (rs.next()) {
				par = new Participante();
				
				par.setCodCaso(codCaso);
				par.setDni(rs.getString("dni"));
				par.setImplicacion(rs.getString("implicacion"));
				
				stmnt2 = con.prepareStatement(SELECTnomCom);
				stmnt2.setString(1, par.getDni());
				
				rs2 = stmnt2.executeQuery();
				if (rs2.next()) {
					par.setNomComp(rs2.getString("nombre") + " " + rs2.getString("apellido"));
				}
				
				participantes.put(par.getDni(), par);
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
		return participantes;
	}

	/**
	 *  Metodo para listar a los involucrados de los casos mediante el codigo del caso.
	 * <li> ResultSet rs: Contiene el resultado de la consulta ejecutada
	 * <li> RestoHumano resto: Contiene los datos de los participantes
	 * <li> Map<String, RestoHumano> restos: Se utiliza para introducir los datos dentro del Map.
	 * 
	 * Primeramente se abre la conexion y se ejecuta la sentencia que selecciona los restos humanos, 
	 * guarda los resultados en los atributos de la clase  y finalmente se cierra el resultado y la conexion.
	 * 
	 * @return Devuelve los resultados que se encuentran en el Map.
	 */
	@Override
	public Map<String, RestoHumano> listarInvolucrados(String codCaso) {
		ResultSet rs = null;
		RestoHumano resto = null;
		Map<String, RestoHumano> restos = new TreeMap<>();;
		
		this.openConnection();
		
		try {
			stmnt = con.prepareStatement(SELECTrestos);
			stmnt.setString(1, codCaso);
			
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
				resto.setCodCaso(codCaso);
				resto.setFechaMuerte(rs.getDate("fechaMuerte").toLocalDate());
				
				restos.put(resto.getCodResto(),resto);
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

}
