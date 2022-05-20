package controlador.interfaces;

import java.util.Map;

import excepciones.Excepciones;
import modelo.clases.Caso;
import modelo.clases.Participante;
import modelo.clases.RestoHumano;

/**
 * Esta interfaz representa el control de gestion de los casos
 * @author Equipo5
 * Contiene metodos para modificar, eliminar, insertar participantes e involucrados, 
 * listarlos, comprobar el dni y el codigo del resto.
 */
public interface ContDatosGestCaso {
	/**
	 * Este metodo modifica los datos del caso
	 * @param caso
	 * @throws Excepciones: La excepcion lanza un mensaje de aviso.
	 */
	public void modificarCaso(Caso caso) throws Excepciones;
	/**
	 * Este metodo elimina los datos del caso.
	 * @param codCaso
	 */
	public void eliminarCaso(String codCaso);
	/**
	 * Este metodo inserta al participante del caso
	 * @param par
	 * @throws Excepciones: La excepcion lanza un mensaje de aviso.
	 */
	public void insertarParticipante(Participante par) throws Excepciones;
	/**
	 * Este metodo inserta a un involucrado del caso
	 * @param codResto
	 * @param codCaso
	 */
	public void insertarInvolucrado(String codResto, String codCaso);
	/**
	 * Este metodo lista los participantes del caso
	 * @param codCaso
	 * @return Devuelve los datos del participante
	 */
	public Map<String,Participante> listarParticipantes(String codCaso);
	/**
	 * Este metodo comprueba que si el dni existe
	 * @param dni
	 * @return <true>El dni existe</true> <false>El dni no existe</false> 
	 */
	public boolean comprobarDNI(String dni);
	/**
	 * Este metodo comprueba que el codigo del caso existe
	 * @param codResto
	 * @return <true>El codigo existe</true> <false>El codigo no existe</false> 
	 */
	public boolean comprobarCodResto(String codResto);
	/**
	 * Esta metodo lista los involucrados del caso
	 * @param codCaso
	 * @return Devuelve los datos del Resto Humano que se encuentra en el caso.
	 */
	public Map<String,RestoHumano> listarInvolucrados();
}
