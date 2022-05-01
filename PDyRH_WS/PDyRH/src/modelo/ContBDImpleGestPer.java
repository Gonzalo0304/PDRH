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

import controlador.ContDatosGestPer;
import modelo.clases.Agente;
import modelo.clases.Criminal;
import modelo.clases.Desaparecida;
import modelo.clases.Persona;

public class ContBDImpleGestPer implements ContDatosGestPer {
	// <--- Sentencias --->
	final String UPDATEper = "UPDATE persona SET nombre = ?,apellido = ?,telf1 = ?,localidad = ?,fechaNac = ?,fechaFal = ?,telf2 = ? WHERE dni = ?";
	final String DELETEper = "DELETE persona WHERE dni = ?";
	final String SELECTpers = "SELECT * FROM persona";
	final String INSERTage = "INSERT INTO agente(dni,rango,inicioServ,finServ) VALUES(?,?,?,?)";
	final String UPDATEage = "UPDATE agente SET rango = ?,inicioServ = ?,finServ = ? WHERE dni = ?";
	final String UPDATEcrim = "UPDATE criminal SET prisionero = ? WHERE dni = ?";
	final String INSERTfechaAr = "INSERT INTO fechaarresto(dni,fechaArresto) VALUES(?,?)";
	final String UPDATEdes = "UPDATE criminal SET fechaDes = ?,ultimaUbi = ?,genero = ?,tipoPelo = ?,colorPerlo = ?,colorOjos = ?,altura = ?,especificaciones = ? WHERE dni = ?";
	final String INSERTconoce = "INSERT INTO conoce(dniP1,dniP2,relacion) VALUES(?,?,?)";
	final String SELECTconoce = "SELECT * FROM persona WHERE dni IN(SELECT dniP2 FROM conoce WHERE dniP1 = ?)";
	
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
	public void modificarPersona(Persona per) {
		this.openConnection();

		try {
			if (per instanceof Agente) {
				stmnt = con.prepareStatement(UPDATEage);

				stmnt.setString(1, ((Agente) per).getRango());
				stmnt.setDate(2, Date.valueOf(((Agente) per).getInicioServ()));
				stmnt.setDate(3, Date.valueOf(((Agente) per).getFinServ()));
				stmnt.setString(4, per.getDni());
				
				stmnt.executeUpdate();
			} else if (per instanceof Criminal) {
				stmnt = con.prepareStatement(UPDATEcrim);

				stmnt.setBoolean(1, ((Criminal) per).isPrisionero());
				stmnt.setString(2, per.getDni());
				
				stmnt.executeUpdate();
			} else if (per instanceof Desaparecida) {
				stmnt = con.prepareStatement(UPDATEdes);

				stmnt.setDate(1, Date.valueOf(((Desaparecida) per).getFechaDes().toLocalDate()));
				stmnt.setString(2, ((Desaparecida) per).getUltimaUbi());
				stmnt.setString(3, ((Desaparecida) per).getGenero());
				stmnt.setString(4, ((Desaparecida) per).getTipoPelo());
				stmnt.setString(5, ((Desaparecida) per).getColorPelo());
				stmnt.setFloat(6, ((Desaparecida) per).getAltura());
				stmnt.setString(7, ((Desaparecida) per).getEspecificaciones());
				stmnt.setString(8, per.getDni());
				
				stmnt.executeUpdate();
			}
			// Comprobar si stmnt funciona o habria que utilizar stmnt2
			stmnt = con.prepareStatement(UPDATEper);

			stmnt.setString(1, per.getNombre());
			stmnt.setString(2, per.getApellido());
			stmnt.setInt(3, per.getTelefonos()[0]);
			stmnt.setString(4, per.getLocalidad());
			stmnt.setDate(5, Date.valueOf(per.getFechaNac()));
			stmnt.setDate(6, Date.valueOf(per.getFechaFal()));
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
	public void eliminarPersona(Persona per) {
		this.openConnection();

		try {
			stmnt = con.prepareStatement(DELETEper);

			stmnt.setString(1, per.getDni());

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
	public Map<String, Persona> listarPersonas() {
		ResultSet rs = null;
		Persona per;
		Map<String, Persona> personas = new TreeMap<>();

		this.openConnection();

		try {
			stmnt = con.prepareStatement(SELECTpers);

			rs = stmnt.executeQuery();

			while (rs.next()) {
				int[] telfs = { rs.getInt("telf1"), rs.getInt("telf2") };
				per = new Persona();

				per.setDni(rs.getString("dni"));
				per.setNombre(rs.getString("nombre"));
				per.setApellido(rs.getString("apellido"));
				per.setTelefonos(telfs);
				per.setFechaNac(rs.getDate("fechaNac").toLocalDate());
				per.setFechaFal(rs.getDate("fechaFal").toLocalDate());
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
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
		return personas;
	}

	@Override
	public void agregarConocido(Persona per, String dni2, String relacion) {
		this.openConnection();

		try {
			stmnt = con.prepareStatement(INSERTconoce);

			stmnt.setString(1, per.getDni());
			stmnt.setString(2, dni2);
			stmnt.setString(3, relacion);

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
	public Map<String, Persona> listarConocidos(String dni1) {
		ResultSet rs = null;
		Persona per;
		Map<String, Persona> conocidos = new TreeMap<>();

		this.openConnection();

		try {
			stmnt = con.prepareStatement(SELECTconoce);
			stmnt.setString(1, dni1);

			rs = stmnt.executeQuery();

			while (rs.next()) {
				int[] telfs = { rs.getInt("telf1"), rs.getInt("telf2") };
				per = new Persona();

				per.setDni(rs.getString("dni"));
				per.setNombre(rs.getString("nombre"));
				per.setApellido(rs.getString("apellido"));
				per.setTelefonos(telfs);
				per.setFechaNac(rs.getDate("fechaNac").toLocalDate());
				per.setFechaFal(rs.getDate("fechaFal").toLocalDate());
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
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
		return conocidos;
	}

	@Override
	public void agregarFechaArresto(String dni, LocalDate fecha) {
		this.openConnection();

		try {
			stmnt = con.prepareStatement(INSERTage);

			stmnt.setString(1, dni);
			stmnt.setDate(2, Date.valueOf(fecha));

			stmnt.executeUpdate();
			con.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.closeConnection();
		}
	}

}
