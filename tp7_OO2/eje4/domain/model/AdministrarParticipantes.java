package domain.model;

import java.sql.SQLException;

import domain.portsin.SumarParticipante;
import domain.portsout.GuardarParticipantes;
import domain.portsout.ParticipanteRecord;

public class AdministrarParticipantes  implements SumarParticipante{

	private GuardarParticipantes almacenDeDatos;

	public AdministrarParticipantes(GuardarParticipantes data) {
		this.almacenDeDatos = data;
	}

	public void agregarParticipante(String nombre, String telefono, String region){
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
		try {
			almacenDeDatos.guardarParticipante(new ParticipanteRecord(nombre, telefono, region));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private boolean validarTelefono(String telefono) {
		String regex = "\\d{4}-\\d{6}";
		return telefono.matches(regex);
	}
}
