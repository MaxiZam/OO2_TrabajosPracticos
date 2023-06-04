package model;

import java.util.Map;

import infraestructure.ServicioDistancia;

public class CorreoArgentino extends EmpresaEnvio {

	CorreoArgentino(ServicioDistancia servicio) {
		super(servicio);
	}

	public double calcularMontoEnvio(Map<Double, Double> compras, String direccion, String destino) {
		double monto = montoFijo(direccion, destino);
		monto += adicionalDistancia(direccion, destino);
		return monto;
	}

	protected double montoFijo(String direccion, String destino) {
		if (destino.equals("Capital Federal")) {
			return 500;
		}
		return 800;
	}

	private double adicionalDistancia(String direccion, String destino) {
		return 5 * this.servicio.obtenerDistancia(direccion, destino);
	}

}
