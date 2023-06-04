package model;

import java.util.Map;

import infraestructure.ServicioDistancia;

public abstract class EmpresaEnvio {

	ServicioDistancia servicio;

	EmpresaEnvio(ServicioDistancia servicio) {
		this.servicio = servicio;
	}

	public abstract double calcularMontoEnvio(Map<Double, Double> compras, String direccion, String destino);

	protected abstract double montoFijo(String direccion, String destino);
}
