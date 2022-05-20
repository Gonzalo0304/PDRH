package tests;

import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import excepciones.Excepciones;
import modelo.ContBDImpleInsertCaso;
import modelo.clases.Caso;

public class ContBDImpleInsertCasoTest {
	ContBDImpleInsertCaso imple;
	Comprobador comprobar;
	
	@Before
	public void setUp() throws Exception {
		imple = new ContBDImpleInsertCaso();
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
	public void testAltaCaso() throws Excepciones {
		Caso caso = new Caso("c99","Cerrado","prueba",LocalDate.parse("2000-02-01"),LocalDate.parse("2021-03-18"),null);
		imple.altaCaso(caso);
		assertTrue(imple.comprobarCodCaso("c99"));
		comprobar.eliminarCaso("c99");
	}

	@Test
	public void testComprobarCodCaso() {
		boolean esta1 = imple.comprobarCodCaso("c01");
		boolean esta2 = imple.comprobarCodCaso("c99");
		boolean esta3 = imple.comprobarCodCaso(null);
		
		assertTrue(esta1);
		assertFalse(esta2);
		assertFalse(esta3);
	}

}
