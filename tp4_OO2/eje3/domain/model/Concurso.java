package domain.model;

import java.time.LocalDate;

class Concurso {

	private int idConcurso;
	private String nombre;
	private LocalDate fechaInicioInscripcion;
	private LocalDate fechaFinInscripcion;

	public Concurso(int idConcurso, String nombre, LocalDate fechaInicioInscripcion, LocalDate fechaFinInscripcion) {
		this.idConcurso = idConcurso;
		this.nombre = nombre;
		this.fechaInicioInscripcion = fechaInicioInscripcion;
		this.fechaFinInscripcion = fechaFinInscripcion;
	}
}
