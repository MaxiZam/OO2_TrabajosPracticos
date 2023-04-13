package ar.unrn.eje4;

import java.util.Objects;

public class Persona {

	private String nombre;
	private String apellido;

	public Persona(String nombre, String apellido) {
		this.nombre = Objects.requireNonNull(nombre);
		this.apellido = Objects.requireNonNull(apellido);
	}

	public String verNombre() {
		return this.nombre;
	}

	public String verApellido() {
		return this.apellido;
	}

	public String verNombreYApellido() {
		return this.nombre + " " + this.apellido;
	}

}
