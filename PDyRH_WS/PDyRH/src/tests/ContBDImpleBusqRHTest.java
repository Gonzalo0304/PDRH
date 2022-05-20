package tests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import modelo.ContBDImpleBusqRH;
import modelo.clases.RestoHumano;

public class ContBDImpleBusqRHTest {

	ContBDImpleBusqRH imple;
	
	@Before
	public void setUp() throws Exception {
		imple = new ContBDImpleBusqRH();
		imple.openConnection();
	}

	@After
	public void tearDown() throws Exception {
		imple.closeConnection();
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

	@Test
	public void testObtenerRH() {
		RestoHumano env1 = imple.obtenerRH("r01");
		RestoHumano env2 = imple.obtenerRH("r99");
		RestoHumano env3 = imple.obtenerRH(null);
		
		assertEquals(env1.getCausa(),"Sobredosis");
		assertNotEquals(env1.getCausa(),"Asfixia");
		assertNull(env2);
		assertNull(env3);
	}

}
