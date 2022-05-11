package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.TreeMap;

import controlador.interfaces.ContDatosBusqPer;
import modelo.clases.Agente;
import modelo.clases.Conocido;
import modelo.clases.Criminal;
import modelo.clases.Desaparecida;
import modelo.clases.Persona;

public class ContBDImpleBusqPer implements ContDatosBusqPer {
	// <--- Sentencias --->
	final String CALLcompPer = "{CALL comprobarPer(?)}";
	final String SELECTconoce = "SELECT * FROM conoce WHERE dniP1 = ?";
	final String SELECTfechas = "SELECT fechaArresto FROM fechaarresto WHERE dni = ?";
	final String SELECTnomComp = "SELECT nombre,apellido FROM persona WHERE dni = ?";
	
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
	public Map<String, Conocido> listarConocidos(String dni1) {
		ResultSet rs = null;
		ResultSet rs2 = null;
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
				PreparedStatement stmnt2 = con.prepareStatement(SELECTnomComp);
				stmnt2.setString(1, cono.getDni2());
				rs2 = stmnt2.executeQuery();
				if (rs2.next()) {
					cono.setNomComp(rs2.getString("nombre") + " " + rs2.getString("apellido"));
				}
				rs2.close();
				conocidos.put(cono.getDni2(), cono);
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
		return conocidos;
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
				per.setTelefonos(telfs);		if (rs.getDate("fechaNac") != null) {
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

}
