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

public class ContBDImpleBusqCaso implements ContDatosBusqCaso {
	// <--- Sentencias --->
	final String SELECTparticipantes = "SELECT dni,implicacion FROM participa WHERE codCaso = ?";
	final String SELECTrestos = "SELECT * FROM restohumano WHERE codCaso = ?";
	
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
	public Map<String, Participante> listarParticipantes(String codCaso) {
		ResultSet rs = null;
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
				if(resto.getFechaMuerte()!=null) {
					resto.setFechaMuerte(rs.getDate("fechaMuerte").toLocalDate());
				}else {
					resto.setFechaMuerte(null);
				}
				
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
