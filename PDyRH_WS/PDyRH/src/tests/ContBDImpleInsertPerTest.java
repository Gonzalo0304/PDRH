package tests;

import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import excepciones.Excepciones;
import modelo.ContBDImpleInsertPer;
import modelo.clases.Agente;
import modelo.clases.Criminal;
import modelo.clases.Desaparecida;
import modelo.clases.Persona;

public class ContBDImpleInsertPerTest {
	
	ContBDImpleInsertPer imple;
	Comprobador comprobar;
	
	@Before
	public void setUp() throws Exception {
		imple = new ContBDImpleInsertPer();
		imple.openConnection();
		comprobar = new Comprobador();
		comprobar.openConnection();
	}

	@After
	public void tearDown() throws Exception {
		imple.closeConnection();
		comprobar.closeConnection();
	}

	@Test
	public void testAltaPersona() throws Excepciones {
		int[] telfs = {123456789,999999999};
		Persona per = new Desaparecida("13497517J","Prueba","AA",telfs,"Loc",LocalDate.parse("1976-02-19"),LocalDate.parse("2015-07-23"),"Ult","H","Pelo","Pelo","Ojos",160,"Esp");
		imple.altaPersona(per);
		assertEquals(comprobar.obtenerPersona("13497517J").getNombre(),"Prueba");
		comprobar.eliminarPersona("13497517J");
		
		per = new Criminal("13497517J","Prueba","AA",telfs,"Loc",LocalDate.parse("1976-02-19"),LocalDate.parse("2020-02-14"),true,null);
		imple.altaPersona(per);
		assertTrue(((Criminal) comprobar.obtenerPersona("13497517J")).isPrisionero());
		comprobar.eliminarPersona("13497517J");
		
		per = new Agente("13497517J","Prueba","AA",telfs,"Loc",LocalDate.parse("1976-02-19"),LocalDate.parse("2020-02-14"),2,LocalDate.parse("2013-11-15"),LocalDate.parse("2018-09-02"));
		imple.altaPersona(per);
		assertEquals(((Agente) comprobar.obtenerPersona("13497517J")).getRango(),2);
		comprobar.eliminarPersona("13497517J");
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

}
