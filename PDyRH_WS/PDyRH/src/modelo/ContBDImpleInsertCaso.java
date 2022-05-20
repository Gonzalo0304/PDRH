package modelo;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import controlador.interfaces.ContDatosInsertCaso;
import excepciones.Excepciones;
import modelo.clases.Caso;

public class ContBDImpleInsertCaso implements ContDatosInsertCaso {
	// <--- Sentencias --->
	final String INSERTcaso = "INSERT INTO caso(codCaso,estado,nombre,fechaIni,fechaFin) VALUES(?,?,?,?,?)";
	final String CALLcompCodCaso = "{CALL comprobarCodigoCaso(?)}";
	
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
			con.setAutoCommit(false);
		} catch (SQLException e) {
			
		}
	}

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
	public void altaCaso(Caso caso) throws Excepciones {
		this.openConnection();
		
		try {
			stmnt = con.prepareStatement(INSERTcaso);
			
			stmnt.setString(1, caso.getCodCaso());
			stmnt.setString(2, caso.getEstado());
			stmnt.setString(3, caso.getNombre());
			
			if(caso.getFechaIni() != null) {
				stmnt.setDate(4, Date.valueOf(caso.getFechaIni()));
			}else {
				stmnt.setDate(4, null);
			}
			
			if(caso.getFechaFin() != null) {
				stmnt.setDate(5, Date.valueOf(caso.getFechaFin()));
			}else {
				stmnt.setDate(5, null);
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
	public boolean comprobarCodCaso(String codCaso) {
		ResultSet rs = null;
		boolean esta = false;
		
		this.openConnection();
		
		try {
			stmnt = con.prepareCall(CALLcompCodCaso);
			stmnt.setString(1, codCaso);
			
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

}
