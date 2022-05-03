package modelo;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import controlador.ContDatosBusq;
import modelo.clases.*;

public class ContBDImpleBusq implements ContDatosBusq {
	// <--- Sentencias -->
	final String SELECTper = "SELECT * FROM persona WHERE dni = ?";
	final String SELECTag = "SELECT * FROM agente WHERE dni = ?";
	final String SELECTcr = "SELECT * FROM criminal WHERE dni = ?";
	final String SELECTds = "SELECT * FROM desaparecido WHERE dni = ?";
	final String SELECTRH = "SELECT * FROM restoHumano WHERE codRH = ?";
	final String SELECTcaso = "SELECT * FROM caso WHERE codCaso = ?";
	final String SELECTidnt = "SELECT dni FROM identifica WHERE codResto = ?";
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
	public Persona buscarPersona(String dni) {
		ResultSet rs = null;
		Persona per = null;

		this.openConnection();

		try {
			per = new Persona();
			if(per instanceof Agente) {
				stmnt = con.prepareStatement(SELECTag);
				stmnt.setString(1, dni);
				rs = stmnt.executeQuery();
				
				per.setDni(dni);
				per.setNombre(rs.getString("nombre"));
				per.setApellido(rs.getString("apellido"));
				((Agente) per).setRango(rs.getString("rango"));
				per.setLocalidad(rs.getString("localidad"));
				((Agente) per).setInicioServ(rs.getDate("inicioServ").toLocalDate());
				((Agente) per).setFinServ(rs.getDate("finServ").toLocalDate());
			}else if(per instanceof Criminal) {
				stmnt = con.prepareStatement(SELECTcr);
				stmnt.setString(1, dni);
				rs = stmnt.executeQuery();
				
				per.setDni(dni);
				per.setNombre(rs.getString("nombre"));
				per.setApellido(rs.getString("apellido"));
				((Criminal) per).setPrisionero(rs.getBoolean("prisionero"));
			}else if(per instanceof Desaparecida) {
				stmnt = con.prepareStatement(SELECTds);
				stmnt.setString(1, dni);
				rs = stmnt.executeQuery();
				
				per.setDni(dni);
				per.setNombre(rs.getString("nombre"));
				per.setApellido(rs.getString("apellido"));
				((Desaparecida) per).setUltimaUbi(rs.getString("ultimaUbi"));
				((Desaparecida) per).setGenero(rs.getString("genero"));
				((Desaparecida) per).setTipoPelo(rs.getString("tipoPelo"));
				((Desaparecida) per).setColorPelo(rs.getString("colorPelo"));
				((Desaparecida) per).setColorOjos(rs.getString("colorOjos"));
				((Desaparecida) per).setAltura(rs.getFloat("altura"));
				((Desaparecida) per).setEspecificaciones(rs.getString("especificaciones"));
			}
			
			stmnt = con.prepareStatement(SELECTper);
			stmnt.setString(1, dni);

			rs = stmnt.executeQuery();

			if (rs.next()) {
				int[] telfs = { rs.getInt("telf1"), rs.getInt("telf2") };
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
	public RestoHumano buscarRH(String codResto) {
		// TODO Auto-generated method stub
		ResultSet rs = null;
		RestoHumano resto = null;
		
		this.openConnection();
		
		try {
			stmnt = con.prepareStatement(SELECTRH);
			stmnt.setString(1, codResto);
			
			rs = stmnt.executeQuery();
			
			if(rs.next()) {
				resto = new RestoHumano();
				
				resto.setCodResto(codResto);
				resto.setCausa(rs.getString("causa"));
				resto.setFechaMuerte(rs.getDate("fechaMuerte").toLocalDate().atStartOfDay());
				resto.setUbicacion(rs.getString("ubicacion"));
				resto.setGenero(rs.getString("genero"));
				resto.setTipoPelo(rs.getString("tipoPelo"));
				resto.setColorPelo(rs.getString("colorPelo"));
				resto.setColorOjos(rs.getString("colorOjos"));
				resto.setAltura(rs.getFloat("altura"));
				resto.setEspecificaciones(rs.getString("especificaciones"));
				resto.setCodCaso(rs.getString("codCaso"));
			}
		} catch (SQLException e) {
			// TODO: handle exception
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
		return resto;
	}

	@Override
	public Persona buscarIdentificado(String codResto) {
		// TODO Auto-generated method stub
		ResultSet rs = null;
		Persona per = null;
		
		this.openConnection();
		
		try {
			stmnt = con.prepareStatement(SELECTidnt);
			stmnt.setString(1, codResto);
			
			rs = stmnt.executeQuery();
			
			if (rs.next()) {
				per = new Persona();
				per.setDni(rs.getString("dni"));
			}
		
		} catch (SQLException e) {
			// TODO: handle exception
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
	public Caso buscarCaso(String codCaso) {
		// TODO Auto-generated method stub
		ResultSet rs = null;
		Caso caso = null;
		
		this.openConnection();
		
		try {
			stmnt = con.prepareStatement(SELECTcaso);
			stmnt.setString(1, codCaso);
			
			rs = stmnt.executeQuery();
			
			if(rs.next()) {
				caso = new Caso();
				
				caso.setCodCaso(codCaso);
				caso.setEstado(rs.getString("estado"));
				caso.setNombre(rs.getString("nombre"));
				caso.setFechaIni(rs.getDate("fechaIni").toLocalDate());
				caso.setFechaFin(rs.getDate("fechaFin").toLocalDate());
			}
			
		} catch (SQLException e) {
			// TODO: handle exception
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
		return caso;
	}

}
