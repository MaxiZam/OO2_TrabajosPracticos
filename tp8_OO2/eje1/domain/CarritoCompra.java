package domain;

import java.util.Map;

public class CarritoCompra {

	private Map<Double, Double> compras; // primer double es precio del elemento y el segundo es el peso.
	private String direccion;
	private String destino;

	public CarritoCompra(Map<Double, Double> compras, String direccion, String destino) {
		this.compras = compras;
		this.direccion = direccion;
		this.destino = destino;
	}

	public double verPrecioEnvio(EmpresaEnvio opcionEnvio) {
		return opcionEnvio.calcularMontoTotal(compras, direccion, destino);
	}
}
