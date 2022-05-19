package tests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import modelo.ContBDImpleBusq;
import modelo.clases.Caso;

public class ContBDImpleBusqTest {
	
	private ContBDImpleBusq imple;
	
	@Before
	public void setUp() throws Exception {
		imple = new ContBDImpleBusq();
		imple.openConnection();
	}

	@After
	public void tearDown() throws Exception {
		imple.closeConnection();
	}

	@Test
	public void testObtenerCaso() {
		Caso env1 = imple.obtenerCaso("c01");
		Caso env2 = imple.obtenerCaso("c99");
		Caso env3 = imple.obtenerCaso(null);
		
		assertEquals(env1.getNombre(),"El impostor");
		assertNotEquals(env1.getNombre(),"Unowen was her");
		assertNull(env2);
		assertNull(env3);
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
	public void testComprobarCodResto() {
		boolean esta1 = imple.comprobarCodResto("r01");
		boolean esta2 = imple.comprobarCodResto("r99");
		boolean esta3 = imple.comprobarCodResto(null);
		
		assertTrue(esta1);
		assertFalse(esta2);
		assertFalse(esta3);
	}

}
