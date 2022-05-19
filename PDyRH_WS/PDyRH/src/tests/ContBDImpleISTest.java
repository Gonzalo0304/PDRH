package tests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import modelo.ContBDImpleIS;

public class ContBDImpleISTest {
	
	ContBDImpleIS imple;
	
	@Before
	public void setUp() throws Exception {
		imple = new ContBDImpleIS();
		imple.openConnection();
	}

	@After
	public void tearDown() throws Exception {
		imple.closeConnection();
	}

	@Test
	public void testComprobarCredenciales() {
		assertEquals(imple.comprobarCredenciales("o595")[1],"isa5knmn");
		assertNotEquals(imple.comprobarCredenciales("o595")[1],"contrasenia");
		assertNull(imple.comprobarCredenciales("aaaa"));
		assertNull(imple.comprobarCredenciales(null));
	}

}
