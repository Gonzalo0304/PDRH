package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import controlador.interfaces.ContDatosBusq;
import modelo.clases.Caso;

public class ContBDImpleBusq implements ContDatosBusq {
	// <--- Sentencias -->
	final String SELECTcaso = "SELECT * FROM caso WHERE codCaso = ?";
	final String CALLcomprobarDNI = "{CALL comprobarDNI(?)}";
	final String CALLbuscarRH = "{CALL buscarRH(?)}";
	
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
	public Caso buscarCaso(String codCaso) {
		ResultSet rs = null;
		Caso caso = null;
		
		this.openConnection();
		try {
			stmnt = con.prepareStatement(SELECTcaso);
			stmnt.setString(1, codCaso);
			
			rs = stmnt.executeQuery();
			
			if (rs.next()) {
				caso = new Caso();
				caso.setCodCaso(codCaso);
				caso.setEstado(rs.getString("estado"));
				caso.setNombre(rs.getString("nombre"));
				if(caso.getFechaIni() != null) {
					caso.setFechaIni(rs.getDate("fechaIni").toLocalDate());
				}else {
					caso.setFechaIni(null);
				}
				if(caso.getFechaFin()==null) {
					caso.setFechaFin(rs.getDate("fechaFin").toLocalDate());
				}else {
					caso.setFechaFin(null);
				}
				
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
		return caso;
	}

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
		return esta;
	}

	@Override
	public boolean buscarRH(String codResto) {
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
		return esta;
	}

}
