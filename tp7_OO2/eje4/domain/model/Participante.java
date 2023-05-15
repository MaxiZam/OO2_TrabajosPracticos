package domain.model;

import java.sql.SQLException;
import java.util.Objects;

class Participante {

	// private Connection dbConn;
	private String nombre;
	private String telefono;
	private String region;

	public Participante(String nombre, String telefono, String region) throws SQLException {
		this.nombre = Objects.requireNonNull(nombre);
		this.telefono = Objects.requireNonNull(telefono);
		this.region = Objects.requireNonNull(region);
	}

}
