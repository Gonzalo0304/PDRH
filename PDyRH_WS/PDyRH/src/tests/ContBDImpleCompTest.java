package tests;

import static org.junit.Assert.*;

import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import modelo.ContBDImpleComp;
import modelo.clases.Persona;
import modelo.clases.RestoHumano;

public class ContBDImpleCompTest {
	
	ContBDImpleComp imple;

	@Before
	public void setUp() throws Exception {
		imple = new ContBDImpleComp();
		imple.openConnection();
	}

	@After
	public void tearDown() throws Exception {
		imple.closeConnection();
	}

	@Test
	public void testListarRHs() {
		Map<String,RestoHumano> env1 = imple.listarRHs();
		
		assertNotNull(env1.get("r01"));
		assertNull(env1.get("r99"));
	}

	@Test
	public void testListarDesaparecidas() {
		Map<String, Persona> env1 = imple.listarDesaparecidas();
		
		assertNotNull(env1.get("58034374s"));
		assertNull(env1.get("21210032x"));
		assertNull(env1.get("12345678a"));
	}

	@Test
	public void testObtenerIdentificado() {
		String env1 = imple.obtenerIdentificado("r12");
		String env2 = imple.obtenerIdentificado("r99");
		String env3 = imple.obtenerIdentificado(null);
		
		assertEquals(env1,"28517946Q");
		assertNotEquals(env1,"21210032x");
		assertNull(env2);
		assertNull(env3);
	}

}
