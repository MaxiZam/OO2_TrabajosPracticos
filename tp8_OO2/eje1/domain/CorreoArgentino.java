package domain;

import java.util.Map;

import infraestructure.ServicioDistancia;

public class CorreoArgentino extends EmpresaEnvio {

	public CorreoArgentino(ServicioDistancia servicio) {
		super(servicio);
	}

	public double calcularMontoTotal(Map<Double, Double> compras, String direccion, String destino) {
		double monto = 0;
		for (double clave : compras.keySet()) {
			monto += clave;
		}
		monto += adicionalDistancia(direccion, destino) + montoFijo(direccion, destino);
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
