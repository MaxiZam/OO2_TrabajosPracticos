package domain.model;

import domain.portsin.AgregarPersonaAConcurso;
import domain.portsout.GuardarInscriptos;
import domain.portsout.InscriptoRecord;

public class RadioCompetition implements AgregarPersonaAConcurso {

	private GuardarInscriptos data;

	public RadioCompetition(GuardarInscriptos data) {
		this.data = data;
	}

	private void todosLosConcursos() {
		// carga del archivo de texto concursos.txt los concursos
	}

	public void saveInscription(InscriptoRecord persona) {
		// if (/*validations()*/) {
		// Guarda en inscriptos.txt los datos de la persona y el concurso elegido

		data.guardarInscripto(persona);
		// }
	}
}
