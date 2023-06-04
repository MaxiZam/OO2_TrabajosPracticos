package domain.model;

import java.sql.SQLException;
import java.util.Objects;

class Participante {

	// private Connection dbConn;
	private String nombre;
	private String mail;
	private String region;

	public Participante(String nombre, String mail, String region) throws SQLException {
		this.nombre = Objects.requireNonNull(nombre);
		this.mail = Objects.requireNonNull(mail);
		this.region = Objects.requireNonNull(region);
	}

}
