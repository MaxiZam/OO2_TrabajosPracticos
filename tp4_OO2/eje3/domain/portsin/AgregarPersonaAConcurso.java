package domain.portsin;

import domain.portsout.InscriptoRecord;

public interface AgregarPersonaAConcurso {

	void saveInscription(InscriptoRecord nuevaPersona);
}
