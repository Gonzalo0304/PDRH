package tests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import modelo.ContBDImpleCompEsp;
import modelo.clases.Desaparecida;
import modelo.clases.Persona;
import modelo.clases.RestoHumano;

public class ContBDImpleCompEspTest {
	
	ContBDImpleCompEsp imple;
	
	@Before
	public void setUp() throws Exception {
		imple = new ContBDImpleCompEsp();
		imple.openConnection();
	}

	@After
	public void tearDown() throws Exception {
		imple.closeConnection();
	}

	@Test
	public void testAgregarIdentificado() {
		Comprobador comprobar = new Comprobador();
		comprobar.openConnection();
		
		imple.agregarIdentificado("r01", "99999999R");
		assertEquals(comprobar.obtenerIdentificado("r01"),"99999999R");
		comprobar.borrarIdentificado("r01");
		
		imple.agregarIdentificado("r99", "12345678a");
		assertNull(comprobar.obtenerIdentificado("r99"));
		
		comprobar.closeConnection();
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

	@Test
	public void testObtenerPersona() {
		Persona env1 = imple.obtenerPersona("99999999R");
		Persona env2 = imple.obtenerPersona("12345678a");
		Persona env3 = imple.obtenerPersona(null);
		
		assertEquals(((Desaparecida) env1).getAltura(),177);
		assertNotEquals(((Desaparecida) env1).getAltura(),173);
		assertNull(env2);
		assertNull(env3);
	}

}
