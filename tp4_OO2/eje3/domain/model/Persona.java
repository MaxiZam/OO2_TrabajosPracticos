package domain.model;

class Persona {

	private String apellido;
	private String nombre;
	private String email;
	private int idConcurso;

	public Persona(String apellido, String nombre, String email, int idConcurso) {
		this.apellido = apellido;
		this.nombre = nombre;
		this.email = email;
		this.idConcurso = idConcurso;
	}
}
