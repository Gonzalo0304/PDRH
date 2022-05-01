package modelo.clases;

import java.time.LocalDateTime;

public class RestoHumano {
	// <--- Atributos --->
	private String codResto;
	private String causa;
	private LocalDateTime fechaMuerte;
	private String ubicacion;
	private String genero;
	private String tipoPelo;
	private String colorPelo;
	private String colorOjos;
	private int altura;
	private String especificaciones;
	private String codCaso;
	
	// <--- Constructores --->
	public RestoHumano() {
		super();
	}
	public RestoHumano(String codResto, String causa, LocalDateTime fechaMuerte, String ubicacion, String genero,
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
	public LocalDateTime getFechaMuerte() {
		return fechaMuerte;
	}
	public void setFechaMuerte(LocalDateTime fechaMuerte) {
		this.fechaMuerte = fechaMuerte;
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
