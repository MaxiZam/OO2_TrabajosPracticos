package modelo;

public class Participante {

	private String nombre;
	private int idParticipante;
	private String mail;
	private int puntos;

	private static int cantParticipantes = 0;

	public Participante(String nombre) {
		cantParticipantes += 1;
		this.nombre = nombre;
		this.idParticipante = cantParticipantes;
		this.puntos = 0;
	}

	public Participante(String nombre, String mail) {
		cantParticipantes += 1;
		this.nombre = nombre;
		this.idParticipante = cantParticipantes;
		this.puntos = 0;
		this.mail = mail;
	}

	String verContacto() {
		return this.mail;
	}

	void sumarPuntos(int puntos) {
		this.puntos += puntos;
	}

	int verIdParticipante() {
		return idParticipante;
	}

	public int verPuntos() {
		return this.puntos;
	}
}
