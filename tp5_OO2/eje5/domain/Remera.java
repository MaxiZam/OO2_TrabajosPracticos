package domain;

public abstract class Remera {

	protected int precio;

	protected Remera(int precio) {
		this.precio = precio;
	}

	public double calcularPrecio() {
		return precio + (precio * (this.recargo() / 100)) + (precio * (this.extraFinal() / 100));
	}

	protected abstract double recargo();

	protected abstract double extraFinal();

}
