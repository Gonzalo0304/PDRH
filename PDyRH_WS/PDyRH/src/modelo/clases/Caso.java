package modelo.clases;

import java.time.LocalDate;
import java.util.Map;
import java.util.TreeMap;

/**
 * Esta clase representa los casos policiales.
 * @author Equipo5
 *
 */
public class Caso {
	// <--- Atributos --->
	/**
	 * El codigo de caso para identificar.
	 */
	private String codCaso;
	/**
	 * El estado del caso que puede estar cerrado, abierto o sin resolver
	 */
	private String estado;
	/**
	 * El nombre del caso policial
	 */
	private String nombre;
	/**
	 * La fecha que inicio el caso
	 */
	private LocalDate fechaIni;
	/**
	 * La fecha que finalizo el caso
	 */
	private LocalDate fechaFin;
	/**
	 * los participantes que se encuentran en el caso en una coleccion
	 */
	private Map<String,Participante> participantes;
	
	// <--- Constructores --->
	/**
	 * Constructor vacio
	 */
	public Caso() {
		super();
		participantes = new TreeMap<>();
	}
	
	/**
	 * Constructor con parametros
	 * @param codCaso
	 * @param estado
	 * @param nombre
	 * @param fechaIni
	 * @param fechaFin
	 * @param participantes
	 */
	public Caso(String codCaso, String estado, String nombre, LocalDate fechaIni, LocalDate fechaFin, Map<String,Participante> participantes) {
		super();
		this.codCaso = codCaso;
		this.estado = estado;
		this.nombre = nombre;
		this.fechaIni = fechaIni;
		this.fechaFin = fechaFin;
		this.participantes = participantes;
	}
	
	// <--- Getters y Setters --->
	public String getCodCaso() {
		return codCaso;
	}

	public void setCodCaso(String codCaso) {
		this.codCaso = codCaso;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public LocalDate getFechaIni() {
		return fechaIni;
	}

	public void setFechaIni(LocalDate fechaIni) {
		this.fechaIni = fechaIni;
	}

	public LocalDate getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(LocalDate fechaFin) {
		this.fechaFin = fechaFin;
	}

	public Map<String, Participante> getParticipantes() {
		return participantes;
	}

	public void setParticipantes(Map<String, Participante> participantes) {
		this.participantes = participantes;
	}
}
