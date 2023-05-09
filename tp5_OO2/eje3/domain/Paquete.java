package domain;

import java.util.ArrayList;
import java.util.List;

public class Paquete {

	protected int precioPaquete;
	protected int porcentaje_descuento = 5;
	protected List<Paquete> paquetes;

	public Paquete() {
		paquetes = new ArrayList<>();
	}

	public void sumarPaquete(Paquete nuevoPaquete) {
		this.precioPaquete = 0;
		paquetes.add(nuevoPaquete);
	}

	protected int acumularDescuento() {
		int descuento = 0;
		for (Paquete item : paquetes) {
			descuento += item.acumularDescuento();
		}
		return descuento;
	}

	public double obtenerPrecioPaquete() {
		int precio = this.calcularPrecio();
		double descuento = (double) acumularDescuento() / 100;
		return (precio * (1 - descuento));
	}

	protected int calcularPrecio() {
		for (Paquete item : paquetes) {
			precioPaquete += item.calcularPrecio();
		}
		return precioPaquete;
	}
}
