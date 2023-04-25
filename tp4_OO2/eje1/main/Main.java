package main;

import java.awt.EventQueue;
import java.sql.SQLException;

import domain.model.AdministrarParticipantes;

public class Main {

	public static void main(String[] args) throws SQLException {

		EventQueue.invokeLater(new Runnable() {

			public void run() {
				try {
					new AdministrarParticipantes(null, null);
				} catch (Exception e) {
					System.out.println(e);
				}
			}
		});
	}
}
