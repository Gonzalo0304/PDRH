package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.TreeMap;

import controlador.ContDatosBusqCaso;
import modelo.clases.Participante;
import modelo.clases.RestoHumano;

public class ContBDImpleBusqCaso implements ContDatosBusqCaso {
	// <--- Sentencias -->
	final String SELECTimp = "SELECT dni, implicacion FROM participa WHERE dni = ?";
	final String SELECTrh = "SELECT codResto FROM restohumano WHERE codCaso = ?";
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
	public Map<String, Participante> participantes(String codCaso) {
		// TODO Auto-generated method stub
		ResultSet rs = null;
		Participante part;
		Map<String, Participante> participantes = new TreeMap<>();
		
		this.openConnection();
		
		try {
			stmnt = con.prepareStatement(SELECTimp);
			rs = stmnt.executeQuery();
			
			while(rs.next()) {
				part = new Participante();
				part.setDni(rs.getString("dni"));
				part.setImplicacion(rs.getString("implicacion"));
				participantes.put(part.getDni(), part);
			}
			
		} catch (SQLException e) {
			// TODO: handle exception
			System.out.println("Error de SQL");
			e.printStackTrace();
		}
		
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		this.closeConnection();
		
		return participantes;
	}

	@Override
	public Map<String, RestoHumano> restos(String codCaso) {
		// TODO Auto-generated method stub
		ResultSet rs = null;
		RestoHumano restH;
		Map<String, RestoHumano> restos = new TreeMap<>();
		
		this.openConnection();
		
		try {
			stmnt = con.prepareStatement(SELECTrh);
			rs = stmnt.executeQuery();
			
			while(rs.next()) {
				restH = new RestoHumano();
				restH.setCodResto(rs.getString("codResto"));
				restos.put(restH.getCodResto(), restH);
			}
			
		} catch (SQLException e) {
			System.out.println("Error de SQL");
			e.printStackTrace();
		}
		
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		this.closeConnection();
		
		return null;
	}

}
