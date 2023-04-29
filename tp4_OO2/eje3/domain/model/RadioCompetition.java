package domain.model;

import java.util.List;

import domain.portsin.AgregarPersonaAConcurso;
import domain.portsin.ConcursoRecord;
import domain.portsin.VerConcursos;
import domain.portsout.GuardarInscriptos;
import domain.portsout.InscriptoRecord;

public class RadioCompetition implements AgregarPersonaAConcurso, VerConcursos {

	private GuardarInscriptos data;

	public RadioCompetition(GuardarInscriptos data) {
		this.data = data;
	}

	public List<ConcursoRecord> todosLosConcursos() {
		return null;
		// carga del archivo de texto concursos.txt los concursos
	}

	public void saveInscription(InscriptoRecord persona) {
		// if (/*validations()*/) {
		// Guarda en inscriptos.txt los datos de la persona y el concurso elegido

		data.guardarInscripto(persona);
		// }
	}
}
