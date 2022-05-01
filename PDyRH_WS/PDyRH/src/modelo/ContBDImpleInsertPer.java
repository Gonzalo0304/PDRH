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

import controlador.ContDatosInsertPer;
import modelo.clases.Agente;
import modelo.clases.Criminal;
import modelo.clases.Desaparecida;
import modelo.clases.Persona;

public class ContBDImpleInsertPer implements ContDatosInsertPer {
	// <--- Sentencias --->
	final String INSERTper = "INSERT INTO persona(dni,nombre,apellido,telf1,localidad,fechaNac,fechaFal,telf2) VALUES(?,?,?,?,?,?,?,?)";
	final String SELECTpers = "SELECT * FROM persona";
	final String INSERTage = "INSERT INTO agente(dni,rango,inicioServ,finServ) VALUES(?,?,?,?)";
	final String INSERTcrim = "INSERT INTO criminal(dni,prisionero) VALUES(?,?)";
	final String INSERTdes = "INSERT INTO desaparecido(dni,fechaDes,ultimaUbi,genero,tipoPelo,colorPelo,colorOjos,altura,especificaciones) VALUES(?,?,?,?,?,?,?,?,?)";
	
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
	public void altaPersona(Persona per) {
		this.openConnection();
		
		try {
			if (per instanceof Agente) {
				stmnt = con.prepareStatement(INSERTage);

				stmnt.setString(1, per.getDni());
				stmnt.setString(2, ((Agente) per).getRango());
				stmnt.setDate(3, Date.valueOf(((Agente) per).getInicioServ()));
				stmnt.setDate(4, Date.valueOf(((Agente) per).getFinServ()));

				stmnt.executeUpdate();
			} else if (per instanceof Criminal) {
				stmnt = con.prepareStatement(INSERTcrim);

				stmnt.setString(1, per.getDni());
				stmnt.setBoolean(2, ((Criminal) per).isPrisionero());

				stmnt.executeUpdate();
			} else if (per instanceof Desaparecida) {
				stmnt = con.prepareStatement(INSERTdes);

				stmnt.setString(1, per.getDni());
				stmnt.setDate(2, Date.valueOf(((Desaparecida) per).getFechaDes().toLocalDate()));
				stmnt.setString(3, ((Desaparecida) per).getUltimaUbi());
				stmnt.setString(4, ((Desaparecida) per).getGenero());
				stmnt.setString(5, ((Desaparecida) per).getTipoPelo());
				stmnt.setString(6, ((Desaparecida) per).getColorPelo());
				stmnt.setFloat(7, ((Desaparecida) per).getAltura());
				stmnt.setString(8, ((Desaparecida) per).getEspecificaciones());

				stmnt.executeUpdate();
			}
			// Comprobar si stmnt funciona o habria que utilizar stmnt2
			stmnt = con.prepareStatement(INSERTper);

			stmnt.setString(1, per.getDni());
			stmnt.setString(2, per.getNombre());
			stmnt.setString(3, per.getApellido());
			stmnt.setInt(4, per.getTelefonos()[0]);
			stmnt.setString(5, per.getLocalidad());
			stmnt.setDate(6, Date.valueOf(per.getFechaNac()));
			stmnt.setDate(7, Date.valueOf(per.getFechaFal()));
			stmnt.setInt(8, per.getTelefonos()[1]);

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

}
