package domain;

import java.util.Map;

import infraestructure.ServicioDistancia;

public abstract class EmpresaEnvio {

	ServicioDistancia servicio;

	EmpresaEnvio(ServicioDistancia servicio) {
		this.servicio = servicio;
	}

	public abstract double calcularMontoTotal(Map<Double, Double> compras, String direccion, String destino);

	protected abstract double montoFijo(String direccion, String destino);
}
