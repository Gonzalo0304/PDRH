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
	final String SELECTconoce = "SELECT * FROM persona WHERE dni IN(SELECT dniP2 FROM conoce WHERE dniP1 = ?)";
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
				conocidos.put(dni1, cono);
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
					((Agente) per).setRango(rs.getString("rango"));
					if(((Agente) per).getInicioServ()!=null) {
						((Agente) per).setInicioServ(rs.getDate("inicioServ").toLocalDate());
					}else {
						((Agente) per).setInicioServ(null);
					}
					if(((Agente) per).getFinServ()!=null) {
						((Agente) per).setFinServ(rs.getDate("finServ").toLocalDate());
					}else {
						((Agente) per).setFinServ(null);
					}
					
				} else if (tipo.equalsIgnoreCase("criminal")) {
					per = new Criminal();
					((Criminal) per).setPrisionero(rs.getBoolean("prisionero"));
					
					PreparedStatement stmnt2 = con.prepareStatement(SELECTfechas);
					stmnt2.setString(1, dni);
					while (rs.next()) {
						((Criminal) per).getFechasArresto().add(rs.getDate("fechaArresto").toLocalDate());
					}
				} else if (tipo.equalsIgnoreCase("desaparecida")) {
					per = new Desaparecida();
					if(((Desaparecida) per).getFechaDes()!=null) {
						((Desaparecida) per).setFechaDes(rs.getDate("fechaDes").toLocalDate());
					}else {
						((Desaparecida) per).setFechaDes(null);
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
				
				if(per.getFechaNac()!=null) {
					per.setFechaNac(rs.getDate("fechaNac").toLocalDate());
				}else {
					per.setFechaNac(null);
				}
				
				if(per.getFechaFal()!=null) {
					per.setFechaFal(rs.getDate("fechaFal").toLocalDate());
				}else {
					per.setFechaFal(null);
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
