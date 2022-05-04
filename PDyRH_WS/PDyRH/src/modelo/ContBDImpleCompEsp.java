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

public class ContBDImpleCompEsp implements ContDatosCompEsp {
	// <--- Sentencias --->
	final String INSERTident = "INSERT INTO identifica(dni,codResto) VALUES(?,?)";
	final String SELECTrh = "SELECT * FROM restohumano WHERE codResto = ?";
	final String SELECTdes = "SELECT * FROM desaparecida WHERE dni = ?";
	
	// <--- Conexi�n --->
	private PreparedStatement stmnt;
	private Connection con;

	ResourceBundle bundle = ResourceBundle.getBundle("modelo.config");

	private String url = bundle.getString("URL");
	private String user = bundle.getString("USER");
	private String pass = bundle.getString("PASS");

	public void openConnection() {
		try {
			con = DriverManager.getConnection(url, user, pass);
			con.setAutoCommit(false);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

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
	public void agregarIdentificado(String codResto, String dni) {
		this.openConnection();
		
		try {
			stmnt = con.prepareStatement(INSERTident);
			
			stmnt.setString(1, dni);
			stmnt.setString(2, codResto);
			
			stmnt.executeUpdate();
			
			con.commit();
		} catch (SQLException e) {
			e.printStackTrace();
			if (con != null) {
				try {
					con.rollback();
				} catch (SQLException e2) {
					e.printStackTrace();
				}
			}
		} finally {
			this.closeConnection();
		}
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
				resto.setFechaMuerte(rs.getDate("fechaMuerte").toLocalDate());
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

	@Override
	public Persona obtenerPersona(String dni) {
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
				((Desaparecida) des).setFechaDes(rs.getDate("fechaDes").toLocalDate());
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
		
		return des;
	}

}