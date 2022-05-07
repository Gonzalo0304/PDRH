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
import modelo.clases.Caso;
import modelo.clases.Participante;
import modelo.clases.RestoHumano;

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
	public void modificarCaso(Caso caso) {
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
	public void eliminarCaso(String codCaso) {
		this.openConnection();
		
		try {
			stmnt = con.prepareStatement(DELETEcaso);
			
			stmnt.setString(1, codCaso);
			
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
	public void insertarParticipante(Participante par) {
		this.openConnection();

		try {
			stmnt = con.prepareStatement(INSERTparticipa);

			stmnt.setString(1, par.getCodCaso());
			stmnt.setString(2, par.getDni());
			stmnt.setString(3, par.getImplicacion());

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
	public void insertarInvolucrado(String codResto, String codCaso) {
		this.openConnection();
		
		try {
			stmnt = con.prepareStatement(INSERTinvolucrado);
			
			stmnt.setString(1, codCaso);
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
		}
		return esta;
	}

	@Override
	public Map<String, RestoHumano> listarInvolucrados(String codCaso) {
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
				resto.setCodCaso(codCaso);
				if (rs.getDate("fechaMuerte") != null) {
					resto.setFechaMuerte(rs.getDate("fechaMuerte").toLocalDate());
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
