package ar.unrn.eje3;

public class Desayuno extends Comida {

	public Desayuno(String nombre, int monto) {
		super(nombre, monto);
	}

	public boolean esExcesoDeGasto() {
		return this.getMonto() > 1000;
	}

}
