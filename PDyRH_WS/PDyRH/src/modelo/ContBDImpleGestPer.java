package modelo;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.TreeMap;

import controlador.interfaces.ContDatosGestPer;
import modelo.clases.Agente;
import modelo.clases.Conocido;
import modelo.clases.Criminal;
import modelo.clases.Desaparecida;
import modelo.clases.Persona;

public class ContBDImpleGestPer implements ContDatosGestPer {
	// <--- Sentencias --->
	final String CALLcompPer = "{CALL comprobarPer(?)}";
	final String CALLcomprobarDNI = "{CALL comprobarDNI(?)}";
	final String UPDATEper = "UPDATE persona SET nombre = ?,apellido = ?,telf1 = ?,localidad = ?,fechaNac = ?,fechaFal = ?,telf2 = ? WHERE dni = ?";
	final String DELETEper = "DELETE FROM persona WHERE dni = ?";
	final String UPDATEage = "UPDATE agente SET rango = ?,inicioServ = ?,finServ = ? WHERE dni = ?";
	final String UPDATEcrim = "UPDATE criminal SET prisionero = ? WHERE dni = ?";
	final String INSERTfechaAr = "INSERT INTO fechaarresto(dni,fechaArresto) VALUES(?,?)";
	final String UPDATEdes = "UPDATE desaparecida SET fechaDes = ?,ultimaUbi = ?,genero = ?,tipoPelo = ?,colorPelo = ?,colorOjos = ?,altura = ?,especificaciones = ? WHERE dni = ?";
	final String INSERTconoce = "INSERT INTO conoce(dniP1,dniP2,relacion) VALUES(?,?,?)";
	final String SELECTconoce = "SELECT * FROM conoce WHERE dniP1 = ?";
	final String SELECTfechas = "SELECT fechaArresto FROM fechaarresto WHERE dni = ?";
	
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
	public void modificarPersona(Persona per) {
		this.openConnection();

		try {
			if (per instanceof Agente) {
				stmnt = con.prepareStatement(UPDATEage);

				stmnt.setInt(1, ((Agente) per).getRango());
				if (((Agente) per).getInicioServ() != null) {
					stmnt.setDate(2, Date.valueOf(((Agente) per).getInicioServ()));
				}else {
					stmnt.setDate(2, null);
				}
				if (((Agente) per).getFinServ() != null) {
					stmnt.setDate(3, Date.valueOf(((Agente) per).getFinServ()));
				} else {
					stmnt.setDate(3, null);
				}
				stmnt.setString(4, per.getDni());
				
				stmnt.executeUpdate();
			} else if (per instanceof Criminal) {
				stmnt = con.prepareStatement(UPDATEcrim);

				stmnt.setBoolean(1, ((Criminal) per).isPrisionero());
				stmnt.setString(2, per.getDni());
				
				stmnt.executeUpdate();
			} else if (per instanceof Desaparecida) {
				stmnt = con.prepareStatement(UPDATEdes);

				if (((Desaparecida) per).getFechaDes() != null) {
					stmnt.setDate(1, Date.valueOf(((Desaparecida) per).getFechaDes()));
				} else {
					stmnt.setDate(1, null);
				}
				stmnt.setString(2, ((Desaparecida) per).getUltimaUbi());
				stmnt.setString(3, ((Desaparecida) per).getGenero());
				stmnt.setString(4, ((Desaparecida) per).getTipoPelo());
				stmnt.setString(5, ((Desaparecida) per).getColorPelo());
				stmnt.setString(6, ((Desaparecida) per).getColorOjos());
				stmnt.setFloat(7, ((Desaparecida) per).getAltura());
				stmnt.setString(8, ((Desaparecida) per).getEspecificaciones());
				stmnt.setString(9, per.getDni());
				
				stmnt.executeUpdate();
			}
			// Comprobar si stmnt funciona o habria que utilizar stmnt2
			stmnt = con.prepareStatement(UPDATEper);

			stmnt.setString(1, per.getNombre());
			stmnt.setString(2, per.getApellido());
			stmnt.setInt(3, per.getTelefonos()[0]);
			stmnt.setString(4, per.getLocalidad());
			if (per.getFechaNac() != null) {
				stmnt.setDate(5, Date.valueOf(per.getFechaNac()));
			} else {
				stmnt.setDate(5, null);
			}
			if (per.getFechaFal() != null) {
				stmnt.setDate(6, Date.valueOf(per.getFechaFal()));
			} else {
				stmnt.setDate(6, null);
			}
			stmnt.setInt(7, per.getTelefonos()[1]);
			stmnt.setString(8, per.getDni());

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
	public Map<String, Conocido> listarConocidos(String dni1) {
		ResultSet rs = null;
		Conocido cono;
		Map<String, Conocido> conocidos = new TreeMap<>();

		this.openConnection();

		try {
			stmnt = con.prepareStatement(SELECTconoce);
			stmnt.setString(1, dni1);

			rs = stmnt.executeQuery();

			while (rs.next()) {
				cono = new Conocido();
				
				cono.setDni1(rs.getString("dniP1"));
				cono.setDni2(rs.getString("dniP2"));
				cono.setRelacion(rs.getString("relacion"));
				conocidos.put(cono.getDni2(), cono);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		this.closeConnection();
		return conocidos;
	}

	@Override
	public void agregarFechaArresto(String dni, LocalDate fecha) {
		this.openConnection();

		try {
			stmnt = con.prepareStatement(INSERTfechaAr);

			stmnt.setString(1, dni);
			stmnt.setDate(2, Date.valueOf(fecha));

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
	public Persona obtenerPersona(String dni) {
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
				switch (tipo) {
				case "agente":
					per = new Agente();
					((Agente) per).setRango(rs.getInt("rango"));
					if (rs.getDate("inicioServ") != null) {
						((Agente) per).setInicioServ(rs.getDate("inicioServ").toLocalDate());
					}
					if (rs.getDate("finServ") != null) {
						((Agente) per).setFinServ(rs.getDate("finServ").toLocalDate());
					}
					break;
				case "criminal":
					per = new Criminal();
					((Criminal) per).setPrisionero(rs.getBoolean("prisionero"));
					
					PreparedStatement stmnt2 = con.prepareStatement(SELECTfechas);
					stmnt2.setString(1, dni);
					
					rs2 = stmnt2.executeQuery();
					while (rs2.next()) {
						((Criminal) per).getFechasArresto().add(rs2.getDate("fechaArresto").toLocalDate());
					}
					break;
				case "desaparecida":
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
					break;

				default:
					per = new Persona();
					break;
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
				per.setLocalidad(rs.getString("localidad"));
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

	@Override
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
	public void agregarConocido(Conocido cono) {
		this.openConnection();

		try {
			stmnt = con.prepareStatement(INSERTconoce);

			stmnt.setString(1, cono.getDni1());
			stmnt.setString(2, cono.getDni2());
			stmnt.setString(3, cono.getRelacion());

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
