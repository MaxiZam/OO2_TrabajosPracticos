package model;

import java.util.Map;

import infraestructure.ServicioDistancia;

public class ColectivosSur extends EmpresaEnvio {

	ColectivosSur(ServicioDistancia servicio) {
		super(servicio);
	}

	public double calcularMontoEnvio(Map<Double, Double> compras, String direccion, String destino) {
		double monto = montoFijo(direccion, destino);
		monto += adicionalPeso(compras);
		return monto;
	}

	protected double montoFijo(String direccion, String destino) {
		if (destino.equals("Capital Federal")) {
			return 1000;
		}
		if (destino.equals("Gran Buenos Aires")) {
			return 500;
		}
		return 3000;
	}

	private double adicionalPeso(Map<Double, Double> compra) {
		double pesoTotal = 0;
		for (Map.Entry<Double, Double> entry : compra.entrySet()) {
			double peso = entry.getValue();
			pesoTotal += peso;
		}
		if (pesoTotal > 30) {
			return 2000;
		}
		if (pesoTotal > 5) {
			return 500;
		}
		return 0;
	}
}
