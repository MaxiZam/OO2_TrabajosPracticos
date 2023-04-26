package main;

import java.awt.EventQueue;

import domain.model.AdministrarParticipantes;
import infraestructure.data.BaseDeDatos;
import infraestructure.ui.RegistrarParticipanteView;

public class Main {

	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
			try {
				new RegistrarParticipanteView(new AdministrarParticipantes(
						new BaseDeDatos("jdbc:derby://localhost:1527/participantes", "app", "app")));
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}
}
