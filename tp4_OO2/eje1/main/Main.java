package main;

import java.sql.SQLException;

import domain.model.AdministrarParticipantes;
import domain.portsin.Vista;
import domain.portsout.ObtenerParticipantes;
import infraestructure.data.BaseDeDatos;
import infraestructure.ui.Vista;

public class Main {

	public static void main(String[] args) throws SQLException {
		Vista interfaz = new Vista();
		ObtenerParticipantes bd = new BaseDeDatos("jdbc:derby://localhost:1527/participantes", "app", "app");
		AdministrarParticipantes admin = new AdministrarParticipantes(interfaz, bd);
	}
}
