package tests;

import static org.junit.Assert.*;

import java.util.Map;
import java.util.TreeMap;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import modelo.ContBDImpleBusqCaso;
import modelo.clases.Participante;
import modelo.clases.RestoHumano;

public class ContBDImpleBusqCasoTest {

	private ContBDImpleBusqCaso imple;
	
	@Before
	public void setUp() throws Exception {
		imple = new ContBDImpleBusqCaso();
		imple.openConnection();
	}

	@After
	public void tearDown() throws Exception {
		imple.closeConnection();
	}

	@Test
	public void testListarParticipantes() {
		Map<String,Participante> env1 = imple.listarParticipantes("c01");
		Map<String,Participante> env2 = imple.listarParticipantes("c02");
		Map<String,Participante> env3 = imple.listarParticipantes("c05");
		Map<String,Participante> env4 = imple.listarParticipantes(null);
		
		String res1 = "21210032x";
		String res1_1 = "58009770k";
	
		assertNotNull(env1.get(res1));
		assertNotNull(env1.get(res1_1));
		assertNull(env2.get(res1_1));
		assertEquals(env3,new TreeMap<>());
		assertEquals(env4, new TreeMap<>());
	}

	@Test
	public void testListarInvolucrados() {
		Map<String,RestoHumano> env1 = imple.listarInvolucrados("c01");
		Map<String,RestoHumano> env3 = imple.listarInvolucrados("c05");
		Map<String,RestoHumano> env4 = imple.listarInvolucrados(null);
		
		String res1 = "r01";
		String res1_1 = "r02";
	
		assertNotNull(env1.get(res1));
		assertNotNull(env1.get(res1_1));
		assertEquals(env3,new TreeMap<>());
		assertEquals(env4, new TreeMap<>());
	}
}
