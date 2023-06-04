package domain.portsout;

import java.sql.SQLException;

public interface GuardarParticipantes {

	public void guardarParticipante(ParticipanteRecord nuevoParticipante) throws SQLException;
}
