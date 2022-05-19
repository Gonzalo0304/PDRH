package controlador.interfaces;

import java.util.Map;

import excepciones.Excepciones;
import modelo.clases.Caso;
import modelo.clases.Participante;
import modelo.clases.RestoHumano;

/**
 * Esta interfaz representa el control de gestion de los casos
 * @author Elias
 * Contiene metodos para modificar, eliminar, insertar participantes e involucrados, 
 * listarlos, comprobar el dni y el codigo del resto.
 */
public interface ContDatosGestCaso {
	public void modificarCaso(Caso caso) throws Excepciones;
	public void eliminarCaso(String codCaso);
	public void insertarParticipante(Participante par) throws Excepciones;
	public void insertarInvolucrado(String codResto, String codCaso);
	public Map<String,Participante> listarParticipantes(String codCaso);
	public boolean comprobarDNI(String dni);
	public boolean comprobarCodResto(String codResto);
	public Map<String,RestoHumano> listarInvolucrados(String codCaso);
}
