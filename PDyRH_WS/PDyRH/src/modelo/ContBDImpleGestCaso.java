package modelo;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.TreeMap;

import controlador.interfaces.ContDatosGestCaso;
import excepciones.Excepciones;
import modelo.clases.Caso;
import modelo.clases.Participante;
import modelo.clases.RestoHumano;

/**
 * Esta clase representa la implementacion de  la ventana de gestion de casos.
 * @author Elias
 * Utiliza sentencias SQL para insertar los participantes, borrar casos, actualizar la tabla de casos y de resto humano,
 * seleccionar los datos(participantes y resto humanos) y procedimientos para comprobar el DNI de la persona y buscar el resto.
 */
public class ContBDImpleGestCaso implements ContDatosGestCaso {
	
	// <--- Sentencias --->
	final String INSERTparticipa = "INSERT INTO participa(codCaso,dni,implicacion) VALUES(?,?,?)";
	final String SELECTparticipantes = "SELECT * FROM participa WHERE codCaso = ?";
	final String DELETEcaso = "DELETE FROM caso WHERE codCaso = ?";
	final String CALLcomprobarDNI = "{CALL comprobarDNI(?)}";
	final String INSERTinvolucrado = "UPDATE restohumano SET codCaso = ? WHERE codResto = ?";
	final String UPDATEcaso = "UPDATE caso SET estado = ?, nombre = ?, fechaIni = ?, fechaFin = ? WHERE codCaso = ?";
	final String CALLbuscarRH = "{CALL buscarRH(?)}";
	final String SELECTinvolucrados = "SELECT * FROM restohumano WHERE codCaso IS NOT NULL";
	
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
	 * Metodo para modificar el caso
	 * 
	 * Primeramente se abre la conexion y se ejecuta la sentencia para actualizar los datos del caso, 
	 * la informacion nueva introducida se guarda en la clase y finalmente se cierra la conexion.
	 */
	@Override
	public void modificarCaso(Caso caso) throws Excepciones {
		this.openConnection();

		try {
			stmnt = con.prepareStatement(UPDATEcaso);

			stmnt.setString(1, caso.getEstado());
			stmnt.setString(2, caso.getNombre());
			if (caso.getFechaFin() != null) {
				stmnt.setDate(3, Date.valueOf(caso.getFechaIni()));
			} else {
				stmnt.setDate(3, null);
			}
			if (caso.getFechaIni() != null) {
				stmnt.setDate(4, Date.valueOf(caso.getFechaFin()));
			} else {
				stmnt.setDate(4, null);
			}
			stmnt.setString(5, caso.getCodCaso());

			stmnt.executeUpdate();
			con.commit();
		} catch (SQLException e) {
			if (con != null) {
				try {
					con.rollback();
				} catch (SQLException e2) {
					
				}
			}
			String msg = "Los campos no pueden exceder los 50 carácteres.";
			Excepciones exc = new Excepciones(msg);
			throw exc;
		} finally {
			this.closeConnection();
		}	
	}

	/**
	 * Metodo para lista los participantes mediante el codigo del caso
	 * 
	 * <li> ResultSet rs: Contiene el resultado de la consulta ejecutada
	 * <li> Participante par: Contiene los datos de los participantes
	 * <li> Map<String, Participante> participantes: Se utiliza para introducir los datos dentro del Map.
	 * 
	 * Primeramente se abre la conexion y se ejecuta la sentencia que selecciona los participantes, 
	 * guarda los resultados en los atributos de la clase  y finalmente se cierra el resultado y la conexion.
	 * 
	 * @return Devuelve el los resultados que se encuentran en el Map.
	 * 
	 */
	@Override
	public Map<String, Participante> listarParticipantes(String codCaso) {
		ResultSet rs = null;
		Participante par;
		Map<String, Participante> participantes = new TreeMap<>();

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
				participantes.put(par.getDni(), par);
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
		return participantes;
	}
	
	/**
	 * Metodo para elminar el caso mediante el codigo
	 * 
	 * Primeramente se abre la conexion y se ejecuta la sentencia que borra los datos del caso, 
	 * se escribe el codigo en la sentencia y se elimina y finalmente se cierra la conexion.
	 * 
	 */
	@Override
	public void eliminarCaso(String codCaso) {
		this.openConnection();
		
		try {
			stmnt = con.prepareStatement(DELETEcaso);
			
			stmnt.setString(1, codCaso);
			
			stmnt.executeUpdate();
			con.commit();
		} catch (SQLException e) {
			
			if (con != null) {
				try {
					con.rollback();
				} catch (SQLException e2) {
					
				}
			}
		} finally {
			this.closeConnection();
		}
	}

	/**
	 * Metodo para insertar participantes en el caso
	 * 
	 * Primeramente se abre la conexion y se ejecuta la sentencia para actualizar los datos del caso, 
	 * la informacion introducida se guarda en los atributos de la clase, controla que los campos no puedan 
	 * superar el maximo de caracteres mediante un excepcion y finalmente se cierra la conexion.
	 */
	@Override
	public void insertarParticipante(Participante par) throws Excepciones {
		this.openConnection();

		try {
			stmnt = con.prepareStatement(INSERTparticipa);

			stmnt.setString(1, par.getCodCaso());
			stmnt.setString(2, par.getDni());
			stmnt.setString(3, par.getImplicacion());

			stmnt.executeUpdate();
			con.commit();
		} catch (SQLException e) {
			if (con != null) {
				try {
					con.rollback();
				} catch (SQLException e2) {
					
				}
			}
			if (par.getCodCaso().length() > 50 || par.getImplicacion().length() > 50) {
				String msg = "Los campos no pueden exceder los 50 carácteres.";
				Excepciones exc = new Excepciones(msg);
				throw exc;
			} 
		} finally {
			this.closeConnection();
		}	
	}

	/**
	 * Metodo para insertar los involucrados mediante el codido del resto humano y el codigo del caso
	 * 
	 * Primeramente se abre la conexion y se ejecuta la sentencia para actualizar los datos del caso, 
	 * la informacion introducida se guarda en los atributos de la clase y finalmente se cierra la conexion.
	 */
	@Override
	public void insertarInvolucrado(String codResto, String codCaso) {
		this.openConnection();
		
		try {
			stmnt = con.prepareStatement(INSERTinvolucrado);
			
			stmnt.setString(1, codCaso);
			stmnt.setString(2, codResto);
			
			stmnt.executeUpdate();
			con.commit();
		} catch (SQLException e) {
			
			if (con != null) {
				try {
					con.rollback();
				} catch (SQLException e2) {
					
				}
			}
		} finally {
			this.closeConnection();
		}
	}

	/**
	 * Metodo para comprobar si el DNI de la persona existe.
	 * <li>ResultSet rs: Contiene el resultado de la consulta ejecutada
	 * <li>boolean esta: Esta variable se encarga de encontrar a la persona.
	 * 
	 * Primeramente se abre la conexion y se ejecuta el procedimiento que buscara a la persona con el DNI introducido, 
	 * guardara en la variable 'esta' el resultado del procedimiento  y finalmente se cierra el resultado y la conexion.
	 * 
	 * @return Devuelve si ha encontrado el DNI o no.
	 */
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
	 * Metodo para comprobar si el codigo del caso existe.
	 * <li>ResultSet rs: Contiene el resultado de la consulta ejecutada
	 * <li>boolean esta: Esta variable se encarga de encontrar a la persona.
	 * 
	 * Primeramente se abre la conexion y se ejecuta el procedimiento que buscara al resto humano, 
	 * guardara en la variable 'esta' el resultado del procedimiento  y finalmente se cierra el resultado y la conexion.
	 * 
	 * @return Devuelve si ha encontrado el codigo o no.
	 */
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
	 * Metodo para listar a los involucrados de los casos mediante el codigo del caso.
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
	public Map<String, RestoHumano> listarInvolucrados() {
		ResultSet rs = null;
		RestoHumano resto = null;
		Map<String, RestoHumano> restos = new TreeMap<>();;
		
		this.openConnection();
		
		try {
			stmnt = con.prepareStatement(SELECTinvolucrados);
			
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
				
				restos.put(resto.getCodResto(),resto);
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

}
