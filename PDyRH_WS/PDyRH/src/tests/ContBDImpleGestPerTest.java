package tests;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.util.Map;
import java.util.TreeMap;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import excepciones.Excepciones;
import modelo.ContBDImpleGestPer;
import modelo.clases.Agente;
import modelo.clases.Conocido;
import modelo.clases.Criminal;
import modelo.clases.Desaparecida;
import modelo.clases.Persona;

public class ContBDImpleGestPerTest {

	ContBDImpleGestPer imple;
	Comprobador comprobar;
	
	@Before
	public void setUp() throws Exception {
		imple = new ContBDImpleGestPer();
		imple.openConnection();
		comprobar = new Comprobador();
		comprobar.closeConnection();
	}

	@After
	public void tearDown() throws Exception {
		imple.closeConnection();
		comprobar.closeConnection();
	}

	@Test
	public void testModificarPersona() throws Excepciones {
		int[] telfs = {123456789,999999999};
		Persona per = new Desaparecida("13497517J","Prueba",null,telfs,null,null,null,null,null,null,null,null,160,null);
		comprobar.altaPersona(per);
		assertEquals(imple.obtenerPersona("13497517J").getNombre(),"Prueba");
		per.setNombre("Pru");
		imple.modificarPersona(per);
		assertEquals(imple.obtenerPersona("13497517J").getNombre(),"Pru");
		imple.eliminarPersona("13497517J");
		
		per = new Criminal("13497517J","Prueba",null,telfs,null,null,null,true,null);
		comprobar.altaPersona(per);
		assertTrue(((Criminal) imple.obtenerPersona("13497517J")).isPrisionero());
		((Criminal) per).setPrisionero(false);
		imple.modificarPersona(per);
		assertFalse(((Criminal) imple.obtenerPersona("13497517J")).isPrisionero());
		imple.eliminarPersona("13497517J");
		
		per = new Agente("13497517J","Prueba",null,telfs,null,null,null,2,null,null);
		comprobar.altaPersona(per);
		assertEquals(((Agente) imple.obtenerPersona("13497517J")).getRango(),2);
		((Agente) per).setRango(3);
		imple.modificarPersona(per);
		assertEquals(((Agente) imple.obtenerPersona("13497517J")).getRango(),3);
		imple.eliminarPersona("13497517J");
	}

	@Test
	public void testListarConocidos() {
		Map<String,Conocido> env1 = imple.listarConocidos("21210032x");
		Map<String,Conocido> env2 = imple.listarConocidos("22759999g");
		Map<String,Conocido> env3 = imple.listarConocidos("79431583w");
		Map<String,Conocido> env4 = imple.listarConocidos(null);
		
		String res1 = "22759999g";
		String res1_1 = "57346611k";
	
		assertNotNull(env1.get(res1));
		assertNull(env2.get(res1_1));
		assertEquals(env3,new TreeMap<>());
		assertEquals(env4, new TreeMap<>());
	}

	@Test
	public void testAgregarFechaArresto() throws Excepciones {
		int[] telfs = {123456789,999999999};
		Persona per = new Criminal("13497517J","Prueba",null,telfs,null,null,null,true,null);
		comprobar.altaPersona(per);
		imple.agregarFechaArresto("13497517J", LocalDate.parse("2020-02-01"));
		assertEquals(comprobar.listarFechas("13497517J").get(0),LocalDate.parse("2020-02-01"));
		comprobar.borrarFechaArresto("13497517J", LocalDate.parse("2020-02-01"));
		imple.eliminarPersona("13497517J");
	}

	@Test
	public void testObtenerPersona() {
		Persona env1 = imple.obtenerPersona("79431583w");
		Persona env2 = imple.obtenerPersona("12345678a");
		Persona env3 = imple.obtenerPersona(null);
		Persona env4 = imple.obtenerPersona("82284506m");
		Persona env5 = imple.obtenerPersona("00132577m");
		Persona env6 = imple.obtenerPersona("28517946q");
		
		assertEquals(env1.getNombre(),"Haizea");
		assertNotEquals(env1.getNombre(),"Larry");
		assertNull(env2);
		assertNull(env3);
		assertFalse(((Criminal) env4).isPrisionero());
		assertEquals(((Agente) env5).getRango(),3);
		assertEquals(((Desaparecida) env6).getEspecificaciones(),"Gafas");
	}

	@Test
	public void testEliminarPersona() {
		int[] telfs = {123456789,999999999};
		Persona per = new Desaparecida("13497517J","Prueba",null,telfs,null,null,null,null,null,null,null,null,160,null);
		comprobar.altaPersona(per);
		assertNotNull(imple.obtenerPersona("13497517J"));
		imple.eliminarPersona("13497517J");
		assertNull(imple.obtenerPersona("13497517J"));
	}

	@Test
	public void testComprobarDNI() {
		boolean esta1 = imple.comprobarDNI("79431583w");
		boolean esta2 = imple.comprobarDNI("15173290Y");
		boolean esta3 = imple.comprobarDNI(null);
		
		assertTrue(esta1);
		assertFalse(esta2);
		assertFalse(esta3);
	}

	@Test
	public void testAgregarConocido() throws Excepciones {
		Conocido con = new Conocido("Haizea Franco","58034374s","79431583w","Amigos");
		imple.agregarConocido(con);
		assertNotNull(imple.listarConocidos("58034374s").get("79431583w"));
		comprobar.borrarConocido("58034374s", "79431583w");
		comprobar.borrarConocido("79431583w", "58034374s");
	}

}
