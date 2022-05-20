package modelo;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import controlador.interfaces.ContDatosRH;
import excepciones.Excepciones;
import modelo.clases.RestoHumano;

/**
 * Esta clase representa la ventana de Implementacion de gestion e insercion de restos humanos. Las sentencias sirven para insertar, actualizar y borrar los restos humanos.
 * @author Gonzalo
 */
public class ContBDImpleRH implements ContDatosRH {
	// <--- Sentencias --->	
	final String INSERTrh = "INSERT INTO restohumano(codResto,causa,ubicacion,genero,tipoPelo,colorPelo,colorOjos,altura,especificaciones,fechaMuerte) VALUES(?,?,?,?,?,?,?,?,?,?)";
	final String DELETErh = "DELETE FROM restohumano WHERE codResto = ?";
	final String UPDATErh = "UPDATE restohumano SET causa = ?,ubicacion = ?,genero = ?,tipoPelo = ?,colorPelo = ?,colorOjos = ?,altura = ?,especificaciones = ?,fechaMuerte = ? WHERE codResto = ?";
	final String SELECTrh = "SELECT * FROM restohumano WHERE codResto = ?";
	
	// <--- Conexión --->
	private PreparedStatement stmnt;
	private Connection con;

	ResourceBundle bundle = ResourceBundle.getBundle("modelo.config");

	private String url = bundle.getString("URL");
	private String user = bundle.getString("USER");
	private String pass = bundle.getString("PASS");

	/**
	 * Abre la conexion con la base de datos
	 */
	public void openConnection() {
		try {
			con = DriverManager.getConnection(url, user, pass);
			con.setAutoCommit(false);
		} catch (SQLException e) {
			
		}
	}

	/**
	 * Cierra la conexion con la base de datos
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

	@Override
	/**
	 * Llama al proceso INSERTrh para insertar restos humanos en la base de datos. Comprueba si las fecha de muerte esta vacia si no es asi se introduce la fecha si no se deja a null y 
	 * controla si se exceden los caracteres maximos.
	 */
	public void altaRH(RestoHumano rh) throws Excepciones {
		this.openConnection();
		
		try {
			stmnt = con.prepareStatement(INSERTrh);
			
			stmnt.setString(1, rh.getCodResto());
			stmnt.setString(2, rh.getCausa());
			stmnt.setString(3, rh.getUbicacion());
			stmnt.setString(4, rh.getGenero());
			stmnt.setString(5, rh.getTipoPelo());
			stmnt.setString(6, rh.getColorPelo());
			stmnt.setString(7, rh.getColorOjos());
			stmnt.setInt(8, rh.getAltura());
			stmnt.setString(9, rh.getEspecificaciones());
			if (rh.getFechaMuerte() != null) {
			stmnt.setDate(10, Date.valueOf(rh.getFechaMuerte()));
			}else {
				stmnt.setDate(10, null);
			}
			
			stmnt.executeUpdate();
			con.commit();
		} catch (SQLException e) {
			String msg = "Los campos no pueden exceder los 50 carácteres.";
			Excepciones exc = new Excepciones(msg);
			throw exc;
		} finally {
			this.closeConnection();
		}
		
	}

	@Override
	/**
	 * Llama a la sentcia UDATErh para actualizar los datos de retsio humano en la base de datos. Con las especificaciones se comprueba si estan vacias si no es asi se insertan si esta 
	 * vacio se dejan a null y controla si se exceden los caracteres maximos.
	 */
	public void modificarRH(RestoHumano rh) throws Excepciones {
		this.openConnection();
		
		try {
			stmnt = con.prepareStatement(UPDATErh);
			
			stmnt.setString(1, rh.getCausa());
			stmnt.setString(2, rh.getUbicacion());
			stmnt.setString(3, rh.getGenero());
			stmnt.setString(4, rh.getTipoPelo());
			stmnt.setString(5, rh.getColorPelo());
			stmnt.setString(6, rh.getColorOjos());
			stmnt.setInt(7, rh.getAltura());
			stmnt.setString(8, rh.getEspecificaciones());
			if (rh.getEspecificaciones() != null) {
				stmnt.setDate(9, Date.valueOf(rh.getFechaMuerte()));
			} else {
				stmnt.setString(9, null);
			}
			stmnt.setString(10, rh.getCodResto());
			
			stmnt.executeUpdate();
			
			con.commit();
		} catch (SQLException e) {
			String msg = "Los campos no pueden exceder los 50 carácteres.";
			Excepciones exc = new Excepciones(msg);
			throw exc;
		} finally {
			this.closeConnection();
		}
	}
	
	@Override
	/**
	 * Llama ala sentencia DELETErh para borrar restos humanos.
	 */
	public void eliminarRH(String codResto) {
		this.openConnection();
		
		try {
			stmnt = con.prepareStatement(DELETErh);
			
			stmnt.setString(1, codResto);
			
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

	@Override
	/**
	 * Llama a la sentencia SELECTrh para recibir los restos humanos buscados para modificar.
	 */
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
}
