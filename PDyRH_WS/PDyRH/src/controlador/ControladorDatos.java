package controlador;

import java.util.Map;

import modelo.clases.Agente;
import modelo.clases.Banda;
import modelo.clases.Caso;
import modelo.clases.Criminal;
import modelo.clases.Desaparecida;
import modelo.clases.Persona;
import modelo.clases.RestoHumano;

public interface ControladorDatos {
	// <--- Persona --->
	public void altaPersona(Persona per);
	public void modificarPersona(Persona per);
	public void eliminarPersona(Persona per);
	public Persona buscarPersona(String dni);
	public Map<String, Persona> listarPersonas();
	
	// <--- Agente --->
	public void altaAgente(Agente age);
	public void modificarAgente(Agente age);
	public void eliminarAgente(Agente age);
	
	// <--- Criminal --->
	public void altaCriminal(Criminal crim);
	public void modificarCriminal(Criminal crim);
	public void eliminarCriminal(Criminal crim);
	
	// <--- Desaparecida --->
	public void altaDesaparecida(Desaparecida des);
	public void modificarDesaparecida(Desaparecida des);
	public void eliminarDesaparecida(Desaparecida des);
	
	// <--- Resto Humano --->
	public void altaRH(RestoHumano rh);
	public void modificarRH(RestoHumano rh);
	public void eliminarRH(RestoHumano rh);
	public RestoHumano buscarRH(String codResto);
	public Map<String, RestoHumano> listarRestos();
	
	// <--- Banda ---->
	public void altaBanda(Banda banda);
	public void modificarBanda(Banda banda);
	public void eliminarBanda(Banda banda);
	public Banda buscarBanda(String codBanda);
	public Map<String, Banda> listarBandas();
	
	// <--- Caso --->
	public void altaCaso(Caso caso);
	public void modificarCaso(Caso caso);
	public void eliminarCaso(Caso caso);
	public Caso buscarCaso(String codCaso);
	public Map<String, Caso> listarCasos();

	// <--- Involucrado --->
	public void agregarInvolucrado(String codBanda, Caso caso);
	public Map<String,Banda> listarInvolucrados(String codCaso);
	
	// <--- Participa --->
	public void agregarParticipante(String dni, Caso caso, String implicacion);
	public Map<String,Persona> listarParticipantes(String codCaso);
	
	// <--- Identifica --->
	public void agregarIdentificado(RestoHumano resto, Persona per);
	public Persona buscarIdentificado(String codResto);
	
	// <--- Conoce --->
	public void agregarConocido(Persona per, String dni2, String relacion);
	public Map<String,Persona> listarConocidos(String dni1);
	
	// <--- Pertenece --->
	public void agregarPerteneciente(Banda banda, String dni, String rol);
	public Map<String,Persona> listarMiembros(String codBanda);
	
	// <--- Trabaja --->
	public void agregarRelacion(Banda banda, String codBanda2);
	public Map<String,Banda> listarRelaciones(String codBanda);
 }
