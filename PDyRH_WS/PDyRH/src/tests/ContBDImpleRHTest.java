package tests;

import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import excepciones.Excepciones;
import modelo.ContBDImpleRH;
import modelo.clases.RestoHumano;

public class ContBDImpleRHTest {
	
	ContBDImpleRH imple;
	
	@Before
	public void setUp() throws Exception {
		imple = new ContBDImpleRH();
		imple.openConnection();
	}

	@After
	public void tearDown() throws Exception {
		imple.closeConnection();
	}

	@Test
	public void testAltaRH() throws Excepciones {
		RestoHumano res = new RestoHumano("r99","Causa",LocalDate.parse("2015-07-23"),"Ult","H","Pelo","Pelo","Ojos",160,"Esp","c01");
		imple.altaRH(res);
		assertEquals(imple.obtenerRH("r99").getCausa(),"Causa");
		imple.eliminarRH("r99");
	}

	@Test
	public void testModificarRH() throws Excepciones {
		RestoHumano res = new RestoHumano("r99","Causa",LocalDate.parse("2015-07-23"),"Ult","H","Pelo","Pelo","Ojos",160,"Esp","c01");
		imple.altaRH(res);
		assertEquals(imple.obtenerRH("r99").getCausa(),"Causa");
		res.setCausa("Cau");
		imple.modificarRH(res);
		assertEquals(imple.obtenerRH("r99").getCausa(),"Cau");
		imple.eliminarRH("r99");
	}

	@Test
	public void testEliminarRH() throws Excepciones {
		RestoHumano res = new RestoHumano("r99","Causa",LocalDate.parse("2015-07-23"),"Ult","H","Pelo","Pelo","Ojos",160,"Esp","c01");
		imple.altaRH(res);
		assertNotNull(imple.obtenerRH("r99"));
		imple.eliminarRH("r99");
		assertNull(imple.obtenerRH("r99"));
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
