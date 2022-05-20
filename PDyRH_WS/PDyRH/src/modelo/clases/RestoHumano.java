package modelo.clases;

import java.time.LocalDate;

/**
 * Esta clase representa al Resto Humano
 * @author Equipo5
 *
 */
public class RestoHumano {
	// <--- Atributos --->
	/**
	 * El codigo del Resto
	 */
	private String codResto;
	/**
	 * La causa de su muerte
	 */
	private String causa;
	/**
	 * La fecha de muerte
	 */
	private LocalDate fechaMuerte;
	/**
	 * La ubicacion del Resto humano
	 */
	private String ubicacion;
	/**
	 * El genero
	 */
	private String genero;
	/**
	 * El tipo de pelo
	 */
	private String tipoPelo;
	/**
	 * El color de pelo
	 */
	private String colorPelo;
	/**
	 * El color de ojos
	 */
	private String colorOjos;
	/**
	 * La altura
	 */
	private int altura;
	/**
	 * La especificaciones del Resto
	 */
	private String especificaciones;
	/**
	 * El codigo del caso
	 */
	private String codCaso;
	
	// <--- Constructores --->
	/**
	 * Constructor vacio
	 */
	public RestoHumano() {
		super();
	}
	/**
	 * Constructor con parametros
	 * @param codResto
	 * @param causa
	 * @param fechaMuerte
	 * @param ubicacion
	 * @param genero
	 * @param tipoPelo
	 * @param colorPelo
	 * @param colorOjos
	 * @param altura
	 * @param especificaciones
	 * @param codCaso
	 */
	public RestoHumano(String codResto, String causa, LocalDate fechaMuerte, String ubicacion, String genero,
			String tipoPelo, String colorPelo, String colorOjos, int altura, String especificaciones, String codCaso) {
		super();
		this.codResto = codResto;
		this.causa = causa;
		this.fechaMuerte = fechaMuerte;
		this.ubicacion = ubicacion;
		this.genero = genero;
		this.tipoPelo = tipoPelo;
		this.colorPelo = colorPelo;
		this.colorOjos = colorOjos;
		this.altura = altura;
		this.especificaciones = especificaciones;
		this.codCaso = codCaso;
	}
	
	// <--- Getters y Setters --->
	public String getCodResto() {
		return codResto;
	}
	public void setCodResto(String codResto) {
		this.codResto = codResto;
	}
	public String getCausa() {
		return causa;
	}
	public void setCausa(String causa) {
		this.causa = causa;
	}
	public LocalDate getFechaMuerte() {
		return fechaMuerte;
	}

	public void setFechaMuerte(LocalDate localDate) {
		this.fechaMuerte = localDate;
	}
	public String getUbicacion() {
		return ubicacion;
	}
	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public String getTipoPelo() {
		return tipoPelo;
	}
	public void setTipoPelo(String tipoPelo) {
		this.tipoPelo = tipoPelo;
	}
	public String getColorPelo() {
		return colorPelo;
	}
	public void setColorPelo(String colorPelo) {
		this.colorPelo = colorPelo;
	}
	public String getColorOjos() {
		return colorOjos;
	}
	public void setColorOjos(String colorOjos) {
		this.colorOjos = colorOjos;
	}
	public int getAltura() {
		return altura;
	}
	public void setAltura(int altura) {
		this.altura = altura;
	}
	public String getEspecificaciones() {
		return especificaciones;
	}
	public void setEspecificaciones(String especificaciones) {
		this.especificaciones = especificaciones;
	}
	public String getCodCaso() {
		return codCaso;
	}
	public void setCodCaso(String codCaso) {
		this.codCaso = codCaso;
	}
}
