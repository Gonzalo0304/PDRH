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

import controlador.ControladorDatos;
import modelo.clases.Agente;
import modelo.clases.Banda;
import modelo.clases.Caso;
import modelo.clases.Criminal;
import modelo.clases.Desaparecida;
import modelo.clases.Persona;
import modelo.clases.RestoHumano;

public class ControladorBDImplementacion implements ControladorDatos {
	// <--- Sentencias --->
	final String INSERTper = "INSERT INTO persona(dni,nombre,apellido,telf1,localidad,fechaNac,fechaFal,telf2) VALUES(?,?,?,?,?,?,?,?)";
	final String UPDATEper = "UPDATE persona SET nombre = ?,apellido = ?,telf1 = ?,localidad = ?,fechaNac = ?,fechaFal = ?,telf2 = ? WHERE dni = ?";
	final String DELETEper = "DELETE persona WHERE dni = ?";
	final String SELECTper = "SELECT * FROM persona WHERE dni = ?";
	final String SELECTpers = "SELECT * FROM persona";
	
	final String INSERTconoce = "INSERT INTO conoce(dniP1,dniP2,relacion) VALUES(?,?,?)";
	final String SELECTconoce = "SELECT * FROM persona WHERE dni IN(SELECT dniP2 FROM conoce WHERE dniP1 = ?)";
	final String INSERTinvolucrado = "INSERT INTO involucrado(codCaso,codBanda) VALUES(?,?)";
	final String SELECTbandasCaso = "SELECT * FROM banda WHERE codBanda IN (SELECT codBanda FROM involucrado WHERE codCaso = ?)";
	final String INSERTparticipa = "INSERT INTO participa(codCaso,dni,implicación) VALUES(?,?,?)";
	final String SELECTpersonasCaso = "SELECT * FROM persona WHERE dni IN (SELECT dni FROM participa WHERE codCaso = ?)";
	final String INSERTidentifica = "INSERT INTO identifica(dni,codResto) VALUES(?,?)";
	final String SELECTidentifica = "SELECT * FROM persona WHERE dni IN (SELECT dni FROM identifica WHERE codResto = ?)";
	final String INSERTpertenece = "INSERT INTO pertenece(codBanda,dni,rol) VALUES(?,?,?)";
	final String SELECTpertenece = "SELECT * FROM persona WHERE dni IN (SELECT dni FROM pertenece WHERE codBanda = ?)";
	final String INSERTtrabaja = "INSERT INTO trabaja(codBanda1,codBanda2) VALUES(?,?)";
	final String SELECTtrabaja = "SELECT * FROM banda WHERE codBanda IN (SELECT codBanda1 FROM trabaja WHERE codBanda2 = ?)";
	
	// <--- Conexión --->
	private PreparedStatement stmnt;
	private Connection con;
	
	ResourceBundle bundle = ResourceBundle.getBundle("modelo.config");
	
	String url = bundle.getString("URL");
	String user = bundle.getString("USER");
	String pass = bundle.getString("PASS");
	
	public void openConnection() {
		try {
			con = DriverManager.getConnection(url, user, pass);
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
	
	// <--- Persona --->
	@Override
	public void altaPersona(Persona per) {
		this.openConnection();
		
		try {
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
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		this.closeConnection();
	}

	@Override
	public void modificarPersona(Persona per) {
		this.openConnection();
		
		try {
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
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		this.closeConnection();	
	}

	@Override
	public void eliminarPersona(Persona per) {
		this.openConnection();
		
		try {
			stmnt = con.prepareStatement(DELETEper);
			
			stmnt.setString(1, per.getDni());
			
			stmnt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		this.closeConnection();	
	}

	@Override
	public Persona buscarPersona(String dni) {
		ResultSet rs = null;
		Persona per = null;
		
		this.openConnection();
		
		try {
			stmnt = con.prepareStatement(SELECTper);
			stmnt.setString(1, dni);
			
			rs = stmnt.executeQuery();
			
			if (rs.next()) {
				int[] telfs = {rs.getInt("telf1"),rs.getInt("telf2")};
				per = new Persona();
				
				per.setDni(dni);
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
		return per;
	}

	@Override
	public Map<String, Persona> listarPersonas() {
		ResultSet rs = null;
		Persona per;
		Map<String,Persona> personas = new TreeMap<>();
		
		this.openConnection();
		
		try {
			stmnt = con.prepareStatement(SELECTpers);
			
			rs = stmnt.executeQuery();
			
			while (rs.next()) {
				int[] telfs = {rs.getInt("telf1"),rs.getInt("telf2")};
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
	
	// <--- Agente --->
	@Override
	public void altaAgente(Agente age) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modificarAgente(Agente age) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminarAgente(Agente age) {
		// TODO Auto-generated method stub
		
	}
	
	// <--- Criminal --->
	@Override
	public void altaCriminal(Criminal crim) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modificarCriminal(Criminal crim) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminarCriminal(Criminal crim) {
		// TODO Auto-generated method stub
		
	}
	
	// <--- Desaparecida --->
	@Override
	public void altaDesaparecida(Desaparecida des) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modificarDesaparecida(Desaparecida des) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminarDesaparecida(Desaparecida des) {
		// TODO Auto-generated method stub
		
	}
	
	// <--- Resto Humano --->
	@Override
	public void altaRH(RestoHumano rh) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modificarRH(RestoHumano rh) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminarRH(RestoHumano rh) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public RestoHumano buscarRH(String codResto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, RestoHumano> listarRestos() {
		// TODO Auto-generated method stub
		return null;
	}
	
	// <--- Banda --->
	@Override
	public void altaBanda(Banda banda) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modificarBanda(Banda banda) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminarBanda(Banda banda) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Banda buscarBanda(String codBanda) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, Banda> listarBandas() {
		// TODO Auto-generated method stub
		return null;
	}
	
	// <--- Caso --->
	@Override
	public void altaCaso(Caso caso) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modificarCaso(Caso caso) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminarCaso(Caso caso) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Caso buscarCaso(String codCaso) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public Map<String, Caso> listarCasos() {
		// TODO Auto-generated method stub
		return null;
	}
	
	// <--- Involucrado --->
	@Override
	public void agregarInvolucrado(String codBanda, Caso caso) {
		this.openConnection();
		
		try {
			stmnt = con.prepareStatement(INSERTinvolucrado);
			
			stmnt.setString(1, caso.getCodCaso());
			stmnt.setString(2, codBanda);
			
			stmnt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		this.closeConnection();
	}

	@Override
	public Map<String, Banda> listarInvolucrados(String codCaso) {
		ResultSet rs = null;
		Banda banda;
		Map<String,Banda> involucrados = new TreeMap<>();
		
		this.openConnection();
		
		try {
			stmnt = con.prepareStatement(SELECTbandasCaso);
			stmnt.setString(1, codCaso);
			
			rs = stmnt.executeQuery();
			
			while (rs.next()) {
				banda = new Banda();
				
				banda.setCodBanda(rs.getString("codBanda"));
				banda.setOrganizada(rs.getBoolean("organizada"));
				banda.setNombre(rs.getString("nombre"));
				banda.setAmbito(rs.getString("ambito"));
				banda.setFechaIni(rs.getDate("fechaIni").toLocalDate());
				banda.setFechaFin(rs.getDate("fechaFin").toLocalDate());
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
		return involucrados;
	}
	
	// <--- Participa --->
	@Override
	public void agregarParticipante(String dni, Caso caso, String implicacion) {
		this.openConnection();
		
		try {
			stmnt = con.prepareStatement(INSERTparticipa);
			
			stmnt.setString(1, caso.getCodCaso());
			stmnt.setString(2, dni);
			stmnt.setString(3, implicacion);
			
			stmnt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		this.closeConnection();
	}

	@Override
	public Map<String, Persona> listarParticipantes(String codCaso) {
		ResultSet rs = null;
		Persona per;
		Map<String,Persona> participantes = new TreeMap<>();
		
		this.openConnection();
		
		try {
			stmnt = con.prepareStatement(SELECTpersonasCaso);
			stmnt.setString(1, codCaso);
			
			rs = stmnt.executeQuery();
			
			while (rs.next()) {
				int[] telfs = {rs.getInt("telf1"),rs.getInt("telf2")};
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
		return participantes;
	}
	
	// <--- Identifica --->
	@Override
	public void agregarIdentificado(RestoHumano resto, Persona per) {
		this.openConnection();
		
		try {
			stmnt = con.prepareStatement(INSERTparticipa);
			
			stmnt.setString(1, resto.getCodResto());
			stmnt.setString(2, per.getDni());
			
			stmnt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		this.closeConnection();
	}

	@Override
	public Persona buscarIdentificado(String codResto) {
		ResultSet rs = null;
		Persona per = null;
		
		this.openConnection();
		
		try {
			stmnt = con.prepareStatement(SELECTidentifica);
			stmnt.setString(1, codResto);
			
			rs = stmnt.executeQuery();
			
			if (rs.next()) {
				int[] telfs = {rs.getInt("telf1"),rs.getInt("telf2")};
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
		return per;
	}
	
	// <--- Conoce --->
	@Override
	public void agregarConocido(Persona per, String dni2, String relacion) {
		this.openConnection();
		
		try {
			stmnt = con.prepareStatement(INSERTconoce);
			
			stmnt.setString(1, per.getDni());
			stmnt.setString(2, dni2);
			stmnt.setString(3, relacion);
			
			stmnt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		this.closeConnection();
	}

	@Override
	public Map<String, Persona> listarConocidos(String dni1) {
		ResultSet rs = null;
		Persona per;
		Map<String,Persona> conocidos = new TreeMap<>();
		
		this.openConnection();
		
		try {
			stmnt = con.prepareStatement(SELECTconoce);
			stmnt.setString(1, dni1);
			
			rs = stmnt.executeQuery();
			
			while (rs.next()) {
				int[] telfs = {rs.getInt("telf1"),rs.getInt("telf2")};
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
	
	// <--- Pertenece --->
	@Override
	public void agregarPerteneciente(Banda banda, String dni, String rol) {
		this.openConnection();
		
		try {
			stmnt = con.prepareStatement(INSERTpertenece);
			
			stmnt.setString(1, banda.getCodBanda());
			stmnt.setString(2, dni);
			stmnt.setString(3, rol);
			
			stmnt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		this.closeConnection();
	}

	@Override
	public Map<String, Persona> listarMiembros(String codBanda) {
		// TODO Auto-generated method stub
		return null;
	}
	
	// <--- Trabaja --->
	@Override
	public void agregarRelacion(Banda banda, String codBanda2) {
		this.openConnection();
		
		try {
			stmnt = con.prepareStatement(INSERTtrabaja);
			
			stmnt.setString(1, banda.getCodBanda());
			stmnt.setString(2, codBanda2);
			
			stmnt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		this.closeConnection();
	}

	@Override
	public Map<String, Banda> listarRelaciones(String codBanda) {
		ResultSet rs = null;
		Banda banda;
		Map<String,Banda> relaciones = new TreeMap<>();
		
		this.openConnection();
		
		try {
			stmnt = con.prepareStatement(SELECTtrabaja);
			stmnt.setString(1, codBanda);
			
			rs = stmnt.executeQuery();
			
			while (rs.next()) {
				banda = new Banda();
				
				banda.setCodBanda(rs.getString("codBanda"));
				banda.setOrganizada(rs.getBoolean("organizada"));
				banda.setNombre(rs.getString("nombre"));
				banda.setAmbito(rs.getString("ambito"));
				banda.setFechaIni(rs.getDate("fechaIni").toLocalDate());
				banda.setFechaFin(rs.getDate("fechaFin").toLocalDate());
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
		return relaciones;
	}
	
}
