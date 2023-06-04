package domain.model;

import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import domain.portsin.SumarParticipante;
import domain.portsout.GuardarParticipantes;
import domain.portsout.ParticipanteRecord;

public class AdministrarParticipantes implements SumarParticipante {

	private GuardarParticipantes almacenDeDatos;
	private Observador ob;

	public AdministrarParticipantes(GuardarParticipantes data, Observador ob) {
		this.almacenDeDatos = data;
		this.ob = ob;
	}

	public void agregarParticipante(String nombre, String mail, String region) {
		if (nombre.isBlank()) {
			throw new IllegalArgumentException("El nombre no puede estar vacío");
		}
		if (mail.isBlank()) {
			throw new IllegalArgumentException("El teléfono no puede estar vacío");
		}
		if (!validarMail(mail)) {
			throw new IllegalArgumentException("El teléfono debe ingresarse de la siguiente forma: NNNN-NNNNNN");
		}
		region.toLowerCase();
		if (!region.equals("china") && !region.equals("us") && !region.equals("europa")) {
			throw new IllegalArgumentException("Región desconocida. Las conocidas son: China, US, Europa");
		}
		try {
			almacenDeDatos.guardarParticipante(new ParticipanteRecord(nombre, mail, region));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		ob.actualizar(nombre, mail, region);
	}

	private boolean validarMail(String mail) {
		String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\." + "[a-zA-Z0-9_+&*-]+)*@" + "(?:[a-zA-Z0-9-]+\\.)+[a-z"
				+ "A-Z]{2,7}$";

		Pattern pattern = Pattern.compile(emailRegex);

		Matcher matcher = pattern.matcher(mail);
		return matcher.matches();
	}
}
