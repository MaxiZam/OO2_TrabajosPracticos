package modelo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Concurso {

	private String nombreConcurso;
	private int idConcurso;
	private List<Participante> listaDeParticipantes = new ArrayList<>();
	private LocalDate fechaInicioInscripcion;
	private LocalDate fechaFinInscripcion;

	private GuardarTexto guardar;
	private Notificar notificarInscripcion;
	
	public Concurso(String nombre, LocalDate fechaInicioInscripcion, LocalDate fechaFinInscripcion, GuardarTexto guardar, Notificar notificar) {
		this.nombreConcurso = Objects.requireNonNull(nombre);
		this.fechaInicioInscripcion = Objects.requireNonNull(fechaInicioInscripcion);
		this.fechaFinInscripcion = Objects.requireNonNull(fechaFinInscripcion);
		this.guardar = guardar;
		this.notificarInscripcion = notificar;
	}
	
	
	public void inscribirParticipante(Participante participante) {
		LocalDate hoy = LocalDate.now();
		if (isEqualsOrAfter(hoy, fechaInicioInscripcion) && (isEqualsOrBefore(hoy, fechaFinInscripcion))) {
			this.listaDeParticipantes.add(participante);
			String texto = new String(hoy + ", " + participante.verIdParticipante() + ", " + idConcurso);
			guardar.guardarTexto(texto);
			notificarInscripcion.enviarMensaje(participante.verContacto());
			if (hoy.equals(fechaInicioInscripcion)) {
				participante.sumarPuntos(10);
			}
		}
	}

	public boolean seInscribioParticipante(Participante participante) {
		for (Participante p : listaDeParticipantes) {
			if (p.equals(participante)) {
				return true;
			}
		}
		return false;
	}

	private boolean isEqualsOrAfter(LocalDate hoy, LocalDate date) {
		return hoy.equals(date) || hoy.isAfter(date);
	}

	private boolean isEqualsOrBefore(LocalDate hoy, LocalDate date) {
		return hoy.equals(date) || hoy.isBefore(date);
	}

	@Override
	public String toString() {
		return nombreConcurso + "\nfecha inicio de inscripcion = " + fechaInicioInscripcion
				+ "\nfecha fin de inscripcion = " + fechaFinInscripcion + "\n\n";
	}

}
