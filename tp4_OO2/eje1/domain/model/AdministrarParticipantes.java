package domain.model;

import java.sql.SQLException;

import domain.portsout.RepositorioParticipantes;

public class AdministrarParticipantes {

	private RepositorioParticipantes almacenDeDatos;

	public AdministrarParticipantes(RepositorioParticipantes data) {
		this.almacenDeDatos = data;
	}

	public void agregarParticipante(String nombre, String telefono, String region) throws SQLException {
		if (nombre.isBlank()) {
			throw new IllegalArgumentException("El nombre no puede estar vacío");
		}

		if (telefono.isBlank()) {
			throw new IllegalArgumentException("El teléfono no puede estar vacío");
		}

		if (!validarTelefono(telefono)) {
			throw new IllegalArgumentException("El teléfono debe ingresarse de la siguiente forma: NNNN-NNNNNN");
		}

		region.toLowerCase();
		if (!region.equals("china") && !region.equals("us") && !region.equals("europa")) {
			throw new IllegalArgumentException("Región desconocida. Las conocidas son: China, US, Europa");
		}

		// Participante participante = new Participante(nombre, telefono, region);
		almacenDeDatos.guardarParticipante(nombre, telefono, region);
	}

	private boolean validarTelefono(String telefono) {
		String regex = "\\d{4}-\\d{6}";
		return telefono.matches(regex);
	}
}
