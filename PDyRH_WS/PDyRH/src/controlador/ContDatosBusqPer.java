package controlador;

import java.util.Map;

import modelo.clases.Conocido;

public interface ContDatosBusqPer {
	public Map<String,Conocido> conocidos(String dni1);
}
