package model;

import java.time.LocalDate;

public class Persona {

	private LocalDate fechaNacimiento;
	private MostrarFecha tipo;

	public Persona(String fecha, MostrarFecha tipo) {
		this.fechaNacimiento = LocalDate.parse(fecha);
		this.tipo = tipo;
	}

	public String fechaNacimiento() {
		return tipo.mostrarFecha(fechaNacimiento);
	}
}
