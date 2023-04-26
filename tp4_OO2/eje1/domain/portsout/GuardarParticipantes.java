package domain.portsout;

import java.sql.SQLException;
import java.util.List;

public interface GuardarParticipantes {

	public void guardarParticipante(ParticipanteRecord nuevoParticipante) throws SQLException;
}
