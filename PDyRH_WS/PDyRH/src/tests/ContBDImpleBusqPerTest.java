package tests;

import static org.junit.Assert.*;

import java.util.Map;
import java.util.TreeMap;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import modelo.ContBDImpleBusqPer;
import modelo.clases.Agente;
import modelo.clases.Conocido;
import modelo.clases.Criminal;
import modelo.clases.Persona;
import modelo.clases.Desaparecida;

public class ContBDImpleBusqPerTest {
	
	private ContBDImpleBusqPer imple;
	
	@Before
	public void setUp() throws Exception {
		imple = new ContBDImpleBusqPer();
		imple.openConnection();
	}

	@After
	public void tearDown() throws Exception {
		imple.closeConnection();
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

}
