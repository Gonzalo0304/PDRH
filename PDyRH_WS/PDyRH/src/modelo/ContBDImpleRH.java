package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.TreeMap;

import controlador.ContDatosRH;
import modelo.clases.Persona;
import modelo.clases.RestoHumano;

public class ContBDImpleRH implements ContDatosRH {
	// <--- Sentencias --->
	final String SELECTrhs = "SELECT * FROM restohumano";
	
	final String INSERTidentifica = "INSERT INTO identifica(dni,codResto) VALUES(?,?)";
	final String SELECTidentifica = "SELECT * FROM persona WHERE dni IN (SELECT dni FROM identifica WHERE codResto = ?)";
	
	// <--- Conexión --->
	private PreparedStatement stmnt;
	private Connection con;

	ResourceBundle bundle = ResourceBundle.getBundle("modelo.config");

	String url = bundle.getString("URL");
	String user = bundle.getString("USER");
	String pass = bundle.getString("PASS");

	public void openConnection() {
		try {
			con = DriverManager.getConnection(url, user, pass);
			con.setAutoCommit(false);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void closeConnection() {
		if (con != null) {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (stmnt != null) {
			try {
				stmnt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@Override
	public void altaRH(RestoHumano rh) {
		// TODO Auto-generated method stub

	}

	@Override
	public void modificarRH(RestoHumano rh) {
		// TODO Auto-generated method stub

	}

	@Override
	public void eliminarRH(RestoHumano rh) {
		// TODO Auto-generated method stub

	}

	@Override
	public Map<String, RestoHumano> listarRestos() {
		// TODO Auto-generated method stub
		ResultSet rs = null;
		RestoHumano rest;
		Map<String, RestoHumano> restos = new TreeMap<>();
		
		this.openConnection();
		
		try {
			stmnt = con.prepareStatement(SELECTrhs);
			rs = stmnt.executeQuery();
			
			while(rs.next()) {
				rest = new RestoHumano();
				rest.setCodResto(rs.getString("codResto"));
				rest.setCausa(rs.getString("causa"));
				rest.setFechaMuerte(rs.getDate("fechaMuerte").toLocalDate().atStartOfDay());
				rest.setUbicacion(rs.getString("ubicacion"));
				rest.setGenero(rs.getString("genero"));
				rest.setTipoPelo(rs.getString("tipoPelo"));
				rest.setColorPelo(rs.getString("colorPelo"));
				rest.setColorOjos(rs.getString("colorOjos"));
				rest.setAltura(rs.getFloat("altura"));
				rest.setEspecificaciones(rs.getString("especificaciones"));
				rest.setCodCaso(rs.getString("codCaso"));
				restos.put(rest.getCodResto(), rest);
			}
			
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException ex) {
				System.out.println("Error en cierre del ResultSet");
			} catch (Exception ex) {
				System.out.println("error consulta props");

			}
		}
		try {
			this.closeConnection();
		} catch (Exception ex) {
			System.out.println("error consulta cerrar");
		}
		
		return restos;
	}
	
	// <--- Identifica --->
	@Override
	public void agregarIdentificado(RestoHumano resto, Persona per) {
		this.openConnection();
		
		try {
			stmnt = con.prepareStatement(INSERTidentifica);
			
			stmnt.setString(1, resto.getCodResto());
			stmnt.setString(2, per.getDni());
			
			stmnt.executeUpdate();
			con.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.closeConnection();
		}	
	}
}

