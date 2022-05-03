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

public class ContBDImpleComp implements ContDatosComp {
	// <--- Sentencias --->
	final String SELECTrhs = "SELECT * FROM restohumano";
	final String SELECTdesaparecidas = "SELECT * FROM desaparecidas";
	
	// <--- Conexión --->
	private PreparedStatement stmnt;
	private Connection con;

	ResourceBundle bundle = ResourceBundle.getBundle("modelo.config");

	private String url = bundle.getString("URL");
	private String user = bundle.getString("USER");
	private String pass = bundle.getString("PASS");

	public void openConnection() {
		try {
			con = DriverManager.getConnection(url, user, pass);
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
	public Map<String, RestoHumano> obtenerRHs() {
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
				resto.setFechaMuerte(rs.getDate("fechaMuerte").toLocalDate());
				restos.put(resto.getCodResto(), resto);
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
	public Map<String, Persona> obtenerDesaparecidas() {
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
				((Desaparecida) des).setFechaDes(rs.getDate("fechaDes").toLocalDate());
				((Desaparecida) des).setFechaDes(rs.getDate("fechaDes").toLocalDate());
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

}
