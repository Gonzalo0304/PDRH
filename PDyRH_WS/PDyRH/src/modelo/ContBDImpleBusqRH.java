package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import controlador.interfaces.ContDatosBusqRH;
import modelo.clases.RestoHumano;

public class ContBDImpleBusqRH implements ContDatosBusqRH {
	// <--- Sentencias --->
	final String SELECTidentificado = "SELECT dni FROM identifica WHERE codResto = ?";
	final String SELECTrh = "SELECT * FROM restohumano WHERE codResto = ?";

	// <--- Conexión --->
	private PreparedStatement stmnt;
	private Connection con;

	ResourceBundle bundle = ResourceBundle.getBundle("modelo.config");

	private String url = bundle.getString("URL");
	private String user = bundle.getString("USER");
	private String pass = bundle.getString("PASS");

	public void openConnection()  {
		try {
			con = DriverManager.getConnection(url, user, pass);
		} catch (SQLException e) {
			
		}
	}

	public void closeConnection()  {
		if (con != null) {
			try {
				con.close();
			} catch (SQLException e) {
				
			}
		}
		if (stmnt != null) {
			try {
				stmnt.close();
			} catch (SQLException e) {
				
			}
		}
	}

	@Override
	public String obtenerIdentificado(String codResto)  {
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
			
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					
				}
			}
			this.closeConnection();
		}

		return dni;
	}

	@Override
	public RestoHumano obtenerRH(String codResto)  {
		ResultSet rs = null;
		RestoHumano resto = null;

		this.openConnection();

		try {
			stmnt = con.prepareStatement(SELECTrh);
			stmnt.setString(1, codResto);

			rs = stmnt.executeQuery();

			if (rs.next()) {
				resto = new RestoHumano();

				resto.setCodResto(codResto);
				resto.setCausa(rs.getString("causa"));
				resto.setUbicacion(rs.getString("ubicacion"));
				resto.setGenero(rs.getString("genero"));
				resto.setTipoPelo(rs.getString("tipoPelo"));
				resto.setColorPelo(rs.getString("colorPelo"));
				resto.setColorOjos(rs.getString("colorOjos"));
				resto.setAltura(rs.getInt("altura"));
				resto.setEspecificaciones(rs.getString("especificaciones"));
				resto.setCodCaso(rs.getString("codCaso"));
				if (rs.getDate("fechaMuerte") != null) {
					resto.setFechaMuerte(rs.getDate("fechaMuerte").toLocalDate());
				}
			}
		} catch (SQLException e) {
			
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					
				}
			}
			this.closeConnection();
		}

		return resto;
	}

}
