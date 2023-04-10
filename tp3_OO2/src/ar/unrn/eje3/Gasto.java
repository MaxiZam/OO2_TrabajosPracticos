package ar.unrn.eje3;

import java.util.Objects;

public abstract class Gasto {

	private String nombre;
	private int monto;

	public Gasto(String nombre, int monto) {
		this.nombre = Objects.requireNonNull(nombre);
		this.monto = Objects.requireNonNull(monto);
	}

	public boolean esExcesoDeGasto() {
		return false;
	}

	public String getNombre() {
		return this.nombre;
	}

	public int getMonto() {
		return this.monto;
	}
}
