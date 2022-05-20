package tests;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import excepciones.Excepciones;
import modelo.clases.Agente;
import modelo.clases.Caso;
import modelo.clases.Criminal;
import modelo.clases.Desaparecida;
import modelo.clases.Persona;

public class Comprobador {
	// <--- Sentencias -->
	final String SELECTidentificado = "SELECT dni FROM identifica WHERE codResto = ?";
	final String DELETEidentificado = "DELETE FROM identifica WHERE codResto = ?";
	final String SELECTcaso = "SELECT * FROM caso WHERE codCaso = ?";
	final String INSERTcaso = "INSERT INTO caso(codCaso,estado,nombre,fechaIni,fechaFin) VALUES(?,?,?,?,?)";
	final String DELETEparticipa = "DELETE FROM participa WHERE codCaso = ? AND dni = ?";
	final String UPDATErh = "UPDATE restohumano SET codCaso = NULL WHERE codResto = ?";
	final String INSERTper = "INSERT INTO persona(dni,nombre,apellido,telf1,localidad,fechaNac,fechaFal,telf2) VALUES(?,?,?,?,?,?,?,?)";
	final String INSERTage = "INSERT INTO agente(dni,rango,inicioServ,finServ) VALUES(?,?,?,?)";
	final String INSERTcrim = "INSERT INTO criminal(dni,prisionero) VALUES(?,?)";
	final String INSERTdes = "INSERT INTO desaparecida(dni,fechaDes,ultimaUbi,genero,tipoPelo,colorPelo,colorOjos,altura,especificaciones) VALUES(?,?,?,?,?,?,?,?,?)";
	final String DELETEconocido = "DELETE FROM conoce WHERE dniP1 = ? AND dniP2 = ?";
	final String DELETEfechaArr = "DELETE FROM fechaarresto WHERE dni = ? AND fechaarresto = ?";
	final String SELECTfechas = "SELECT fechaarresto FROM fechaarresto WHERE dni = ?";
	final String DELETEcaso = "DELETE FROM caso WHERE codCaso = ?";
	final String CALLcompPer = "{CALL comprobarPer(?)}";
	final String DELETEper = "DELETE FROM persona WHERE dni = ?";
	
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

	// <--- Métodos --->
	public String obtenerIdentificado(String codResto) {
		ResultSet rs = null;
		String dni = null;

		this.openConnection();

		try {
			stmnt = con.prepareStatement(SELECTidentificado);
			stmnt.setString(1, codResto);

			rs = stmnt.executeQuery();

			if (rs.next()) {
				dni = rs.getString("dni");
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

		return dni;
	}

	public void borrarIdentificado(String codResto) {

		this.openConnection();

		try {
			stmnt = con.prepareStatement(DELETEidentificado);
			stmnt.setString(1, codResto);

			stmnt.executeUpdate();
			con.commit();
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				con.rollback();
			} catch (SQLException e2) {
				e.printStackTrace();
			}
		} finally {
			this.closeConnection();
		}
	}

	public Caso obtenerCaso(String codCaso) {
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
				if (rs.getDate("fechaIni") != null) {
					caso.setFechaIni(rs.getDate("fechaIni").toLocalDate());
				}
				if (rs.getDate("fechaFin") != null) {
					caso.setFechaFin(rs.getDate("fechaFin").toLocalDate());
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

	public void altaCaso(Caso caso) throws Excepciones {
		this.openConnection();

		try {
			stmnt = con.prepareStatement(INSERTcaso);

			stmnt.setString(1, caso.getCodCaso());
			stmnt.setString(2, caso.getEstado());
			stmnt.setString(3, caso.getNombre());

			if (caso.getFechaIni() != null) {
				stmnt.setDate(4, Date.valueOf(caso.getFechaIni()));
			} else {
				stmnt.setDate(4, null);
			}

			if (caso.getFechaFin() != null) {
				stmnt.setDate(5, Date.valueOf(caso.getFechaFin()));
			} else {
				stmnt.setDate(5, null);
			}

			stmnt.executeUpdate();
			con.commit();
		} catch (SQLException e) {
			if (caso.getEstado().length() > 50 || caso.getNombre().length() > 50) {
				String msg = "Los campos no pueden exceder los 50 carácteres.";
				Excepciones exc = new Excepciones(msg);
				throw exc;
			}
		} finally {
			this.closeConnection();
		}
	}

	public void borrarParticipante(String codCaso, String dni) {

		this.openConnection();

		try {
			stmnt = con.prepareStatement(DELETEparticipa);
			stmnt.setString(1, codCaso);
			stmnt.setString(2, dni);

			stmnt.executeUpdate();
			con.commit();
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				con.rollback();
			} catch (SQLException e2) {
				e.printStackTrace();
			}
		} finally {
			this.closeConnection();
		}
	}

	public void borrarInvolucrado(String codResto) {

		this.openConnection();

		try {
			stmnt = con.prepareStatement(UPDATErh);
			stmnt.setString(1, codResto);

			stmnt.executeUpdate();
			con.commit();
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				con.rollback();
			} catch (SQLException e2) {
				e.printStackTrace();
			}
		} finally {
			this.closeConnection();
		}
	}
	
	public void altaPersona(Persona per) {
		this.openConnection();
		
		try {
			stmnt = con.prepareStatement(INSERTper);

			stmnt.setString(1, per.getDni());
			stmnt.setString(2, per.getNombre());
			stmnt.setString(3, per.getApellido());
			stmnt.setInt(4, per.getTelefonos()[0]);
			stmnt.setString(5, per.getLocalidad());
			if(per.getFechaNac() != null) {
				stmnt.setDate(6, Date.valueOf(per.getFechaNac()));
			}else {
				stmnt.setDate(6, null);
			}
			
			if(per.getFechaFal() != null) {
				stmnt.setDate(7, Date.valueOf(per.getFechaFal()));
			}else {
				stmnt.setDate(7, null);
			}
			
			stmnt.setInt(8, per.getTelefonos()[1]);

			stmnt.executeUpdate();
			
			if (per instanceof Agente) {
				stmnt = con.prepareStatement(INSERTage);

				stmnt.setString(1, per.getDni());
				stmnt.setInt(2, ((Agente) per).getRango());
				if(((Agente) per).getInicioServ() != null) {
					stmnt.setDate(3, Date.valueOf(((Agente) per).getInicioServ()));
				}else {
					stmnt.setDate(3, null);
				}
				
				if(((Agente) per).getFinServ() != null) {
					stmnt.setDate(4, Date.valueOf(((Agente) per).getFinServ()));
				}else {
					stmnt.setDate(4, null);
				}
				
				stmnt.executeUpdate();
			} else if (per instanceof Criminal) {
				stmnt = con.prepareStatement(INSERTcrim);

				stmnt.setString(1, per.getDni());
				stmnt.setBoolean(2, ((Criminal) per).isPrisionero());

				stmnt.executeUpdate();
			} else if (per instanceof Desaparecida) {
				stmnt = con.prepareStatement(INSERTdes);

				stmnt.setString(1, per.getDni());
				if(((Desaparecida) per).getFechaDes() !=  null) {
				stmnt.setDate(2, Date.valueOf(((Desaparecida) per).getFechaDes()));
				}else {
					stmnt.setDate(2, null);
				}
				stmnt.setString(3, ((Desaparecida) per).getUltimaUbi());
				stmnt.setString(4, ((Desaparecida) per).getGenero());
				stmnt.setString(5, ((Desaparecida) per).getTipoPelo());
				stmnt.setString(6, ((Desaparecida) per).getColorPelo());
				stmnt.setString(7, ((Desaparecida) per).getColorOjos());
				stmnt.setFloat(8, ((Desaparecida) per).getAltura());
				stmnt.setString(9, ((Desaparecida) per).getEspecificaciones());

				stmnt.executeUpdate();
			}
			con.commit();
		} catch (SQLException e) {
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
	
	public void borrarConocido(String dni1, String dni2) {

		this.openConnection();

		try {
			stmnt = con.prepareStatement(DELETEconocido);
			stmnt.setString(1, dni1);
			stmnt.setString(2, dni2);

			stmnt.executeUpdate();
			con.commit();
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				con.rollback();
			} catch (SQLException e2) {
				e.printStackTrace();
			}
		} finally {
			this.closeConnection();
		}
	}
	
	public void borrarFechaArresto(String dni, LocalDate fecha) {

		this.openConnection();

		try {
			stmnt = con.prepareStatement(DELETEconocido);
			stmnt.setString(1, dni);
			stmnt.setDate(2, Date.valueOf(fecha));

			stmnt.executeUpdate();
			con.commit();
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				con.rollback();
			} catch (SQLException e2) {
				e.printStackTrace();
			}
		} finally {
			this.closeConnection();
		}
	}
	
	public List<LocalDate> listarFechas(String dni) {
		ResultSet rs = null;
		List<LocalDate> fechas = new ArrayList<>();
		this.openConnection();
		
		try {
			stmnt = con.prepareStatement(SELECTfechas);
			stmnt.setString(1, dni);
			rs = stmnt.executeQuery();
			while (rs.next()) {
				fechas.add(rs.getDate("fechaArresto").toLocalDate());
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.closeConnection();
		}
		return fechas;
	}
	
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
	
	public Persona obtenerPersona(String dni)  {
		ResultSet rs = null;
		ResultSet rs2 = null;
		Persona per = null;
		String tipo = null;

		this.openConnection();

		try {
			stmnt = con.prepareCall(CALLcompPer);
			stmnt.setString(1, dni);

			rs = stmnt.executeQuery();

			if (rs.next()) {
				tipo = rs.getString("tipo");
				if (tipo.equalsIgnoreCase("agente")) {
					per = new Agente();
					((Agente) per).setRango(rs.getInt("rango"));
					if (rs.getDate("inicioServ") != null) {
						((Agente) per).setInicioServ(rs.getDate("inicioServ").toLocalDate());
					}
					if (rs.getDate("finServ") != null) {
						((Agente) per).setFinServ(rs.getDate("finServ").toLocalDate());
					}
				} else if (tipo.equalsIgnoreCase("criminal")) {
					per = new Criminal();
					((Criminal) per).setPrisionero(rs.getBoolean("prisionero"));

					PreparedStatement stmnt2 = con.prepareStatement(SELECTfechas);
					stmnt2.setString(1, dni);
					rs2 = stmnt2.executeQuery();
					while (rs2.next()) {
						((Criminal) per).getFechasArresto().add(rs2.getDate("fechaArresto").toLocalDate());
					}

					rs2.close();
				} else if (tipo.equalsIgnoreCase("desaparecida")) {
					per = new Desaparecida();
					if (rs.getDate("fechaDes") != null) {
						((Desaparecida) per).setFechaDes(rs.getDate("fechaDes").toLocalDate());
					}
					((Desaparecida) per).setUltimaUbi(rs.getString("ultimaUbi"));
					((Desaparecida) per).setGenero(rs.getString("genero"));
					((Desaparecida) per).setTipoPelo(rs.getString("tipoPelo"));
					((Desaparecida) per).setColorPelo(rs.getString("colorPelo"));
					((Desaparecida) per).setColorOjos(rs.getString("colorOjos"));
					((Desaparecida) per).setAltura(rs.getInt("altura"));
					((Desaparecida) per).setEspecificaciones(rs.getString("especificaciones"));
				} else {
					per = new Persona();
				}
				int[] telfs = { rs.getInt("telf1"), rs.getInt("telf2") };

				per.setDni(dni);
				per.setNombre(rs.getString("nombre"));
				per.setApellido(rs.getString("apellido"));
				per.setTelefonos(telfs);
				if (rs.getDate("fechaNac") != null) {
					per.setFechaNac(rs.getDate("fechaNac").toLocalDate());
				}
				if (rs.getDate("fechaFal") != null) {
					per.setFechaFal(rs.getDate("fechaFal").toLocalDate());
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
		return per;
	}
	
	public void eliminarPersona(String dni) {
		this.openConnection();

		try {
			stmnt = con.prepareStatement(DELETEper);

			stmnt.setString(1, dni);

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
}
