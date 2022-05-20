package tests;

import static org.junit.Assert.*;

import java.util.Map;
import java.util.TreeMap;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import excepciones.Excepciones;
import modelo.ContBDImpleGestCaso;
import modelo.clases.Caso;
import modelo.clases.Participante;
import modelo.clases.RestoHumano;

public class ContBDImpleGestCasoTest {

	ContBDImpleGestCaso imple;
	Comprobador comprobar;
	
	@Before
	public void setUp() throws Exception {
		imple = new ContBDImpleGestCaso();
		comprobar = new Comprobador();
		imple.openConnection();
		comprobar.openConnection();
	}

	@After
	public void tearDown() throws Exception {
		imple.closeConnection();
		comprobar.closeConnection();
	}

	@Test
	public void testModificarCaso() throws Excepciones {
		Caso caso = new Caso("c99","Abierto","prueba",null,null,null);
		comprobar.altaCaso(caso);
		assertEquals(comprobar.obtenerCaso("c99").getEstado(),"Abierto");
		caso.setEstado("Cerrado");
		imple.modificarCaso(caso);
		assertEquals(comprobar.obtenerCaso("c99").getEstado(),"Cerrado");
		imple.eliminarCaso("c99");
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
	public void testEliminarCaso() throws Excepciones {
		Caso caso = new Caso("c99","Abierto","prueba",null,null,null);
		comprobar.altaCaso(caso);
		assertEquals(comprobar.obtenerCaso("c99").getNombre(), "prueba");
		imple.eliminarCaso("c99");
		assertNull(comprobar.obtenerCaso("c99"));
	}

	@Test
	public void testInsertarParticipante() throws Excepciones {
		Participante part = new Participante("Haizea Franco","79431583w","c01","prueba");
		imple.insertarParticipante(part);
		assertNotNull(imple.listarParticipantes("c01").get("79431583w"));
		comprobar.borrarParticipante("c01", "79431583w");

		part = new Participante("Sr Prueba","12345678a","prueba2","c99");
		imple.insertarParticipante(part);
		assertNull(imple.listarParticipantes("c99").get("12345678a"));
	}

	@Test
	public void testInsertarInvolucrado() {
		imple.insertarInvolucrado("r15", "c01");
		assertNotNull(imple.listarInvolucrados().get("r15"));
		comprobar.borrarInvolucrado("r15");
		
		imple.insertarInvolucrado("r99", "c99");
		assertNull(imple.listarInvolucrados().get("r99"));
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
		boolean esta2 = imple.comprobarDNI("r99");
		boolean esta3 = imple.comprobarDNI(null);
		
		assertTrue(esta1);
		assertFalse(esta2);
		assertFalse(esta3);
	}

	@Test
	public void testListarInvolucrados() {
		Map<String,RestoHumano> env1 = imple.listarInvolucrados();
	
		assertNotNull(env1.get("r01"));
		assertNotNull(env1.get("r02"));
		assertNull(env1.get("r18"));
		assertNull(env1.get("r99"));
	}

}
