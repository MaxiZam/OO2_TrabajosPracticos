package domain;

public abstract class Seguro extends Paquete {

	protected int precioSeguro;

	public Seguro(int precio) {
		this.precioSeguro = precio;
	}

	public int acumularDescuento() {
		return this.porcentaje_descuento;
	}

	protected int calcularPrecio() {
		return this.precioSeguro;
	}
}
