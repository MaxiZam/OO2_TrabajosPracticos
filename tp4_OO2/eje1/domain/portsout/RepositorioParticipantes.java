package domain.portsout;

import java.sql.SQLException;

public interface RepositorioParticipantes {

	public String[] recuperarParticipantes();

	public void guardarParticipante(String nombre, String telefono, String region) throws SQLException;
}
