package ar.unrn.eje3;

public class Cena extends Comida {

	public Cena(String nombre, int monto) {
		super(nombre, monto);
	}

	public boolean esExcesoDeGasto() {
		return this.getMonto() > 5000;
	}
}
