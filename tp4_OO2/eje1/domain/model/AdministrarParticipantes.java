package domain.model;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import domain.portsin.Vista;
import domain.portsout.ObtenerParticipantes;

public class AdministrarParticipantes {

	private Vista interfazUsuario;
	private ObtenerParticipantes almacenDeDatos;
	private List<Participante> participantes;

	public AdministrarParticipantes(Vista ui, ObtenerParticipantes data) {
		this.interfazUsuario = ui;
		this.almacenDeDatos = data;
		this.participantes = new ArrayList<>();
		setupUI();
	}

	public void setupUI() {
		interfazUsuario.setupUIComponents(this);
	}

	public void agregarParticipante() {
		String[] datos = interfazUsuario.obtenerDatosParticipante();
		try {
			Participante nuevoParticipante = new Participante(datos[0], datos[1], datos[2]);
			participantes.add(nuevoParticipante);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public boolean validarRegion(String region) {
		region.toLowerCase();
		if (region == "china" || region == "us" || region == "europa") {
			return true;
		}
		return false;
	}
}
