package ar.unrn.eje3;

public class Cena extends Gasto {

	public Cena(String nombre, int monto) {
		super(nombre, monto);
	}

	public boolean esExcesoDeGasto() {
		return this.getMonto() > 5000;
	}

	public int devolverMontoSiSosComida() {
		return this.getMonto();
	}
}
