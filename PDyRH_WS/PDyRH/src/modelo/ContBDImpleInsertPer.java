package modelo;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import controlador.interfaces.ContDatosInsertPer;
import excepciones.Excepciones;
import modelo.clases.Agente;
import modelo.clases.Criminal;
import modelo.clases.Desaparecida;
import modelo.clases.Persona;

/**
 * Esta clase representa la ventana de Implementacion de insercion de Personas. Las sentencias sirven para llamar insertar Persona.
 * @author Gonzalo
 */
public class ContBDImpleInsertPer implements ContDatosInsertPer {
	// <--- Sentencias --->
	final String INSERTper = "INSERT INTO persona(dni,nombre,apellido,telf1,localidad,fechaNac,fechaFal,telf2) VALUES(?,?,?,?,?,?,?,?)";
	final String SELECTpers = "SELECT * FROM persona";
	final String INSERTage = "INSERT INTO agente(dni,rango,inicioServ,finServ) VALUES(?,?,?,?)";
	final String INSERTcrim = "INSERT INTO criminal(dni,prisionero) VALUES(?,?)";
	final String INSERTdes = "INSERT INTO desaparecida(dni,fechaDes,ultimaUbi,genero,tipoPelo,colorPelo,colorOjos,altura,especificaciones) VALUES(?,?,?,?,?,?,?,?,?)";
	final String CALLcomprobarDNI = "{CALL comprobarDNI(?)}";

	// <--- Conexión --->
	private PreparedStatement stmnt;
	private Connection con;

	ResourceBundle bundle = ResourceBundle.getBundle("modelo.config");

	private String url = bundle.getString("URL");
	private String user = bundle.getString("USER");
	private String pass = bundle.getString("PASS");

	/**
	 * Abre la conexion con la base de datos.
	 */
	public void openConnection() {
		try {
			con = DriverManager.getConnection(url, user, pass);
			con.setAutoCommit(false);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Cierra la conexion con la base de datos
	 */
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
	/**
	 * Llama al proceso de INSERTper para insertar personas. Con la fecha de nacimiento y fallecimiento se comprueba si estan vacias si no lo estan se insertan los datos y si esta vacio se
	 *  dejan a null. Luego se comprueba el tipo, si es agente se llama al proceso INSERTage para añadir agentes Con las fechas de inicio y fin de servicio se comprueba si estan vacias si 
	 *  no lo estan se insertan los datos y si esta vacio se dejan a null, si es criminal se llama al proceso INSERTcrim para insertar criminales y si es desparecida se llama al proceso al
	 *  INSERTdes se comprueba la fecha de desaparicion si estan vacias si no lo estan se insertan los datos y si esta vacio se dejan a null. Si te pasas de cracteres al introducirse te 
	 *  avisara con un JOptionPane.
	 */
	public void altaPersona(Persona per) throws Excepciones {
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
			String msg = "Los campos no pueden exceder los 50 carácteres.";
			Excepciones exc = new Excepciones(msg);
			throw exc;
		} finally {
			this.closeConnection();
		}
	}

	@Override
	/**
	 * Llama al proceso CALLcomprobarDNI para comprobar que el dni esta bien introducido. Si esta bien introducido se devuelve esta en true.s
	 */
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
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		this.closeConnection();

		return esta;
	}
}
