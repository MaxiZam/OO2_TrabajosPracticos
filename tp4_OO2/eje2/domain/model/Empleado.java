package domain.model;

import java.time.LocalDate;

class Empleado {

	private String apellido;
	private String nombre;
	private LocalDate fechaNacimiento;
	private String mail;

	public Empleado(String apellido, String nombre, LocalDate fecha, String mail) {
		this.apellido = apellido;
		this.nombre = nombre;
		this.fechaNacimiento = fecha;
		this.mail = mail;
	}

	public boolean esCumple(LocalDate fecha) {
		return (fechaNacimiento.getMonth() == fecha.getMonth()
				&& fechaNacimiento.getDayOfMonth() == fecha.getDayOfMonth()) ? true : false;
	}

	public String apellido() {
		return this.apellido;
	}

	public String nombre() {
		return this.nombre;
	}

}
