package main;

import java.awt.EventQueue;
import java.util.List;

import domain.model.AdministrarParticipantes;
import domain.model.Observador;
import infraestructure.data.BaseDeDatos;
import infraestructure.notificar.MailTrap;
import infraestructure.ui.RegistrarParticipanteView;

public class MainEje4 {

	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
			try {
				new RegistrarParticipanteView(new AdministrarParticipantes(
						new BaseDeDatos("jdbc:derby://localhost:1527/participantes", "app", "app"),
						new Observador(List.of(new MailTrap("0629ca38e50b34", "280a680c090589")))));
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}
}
