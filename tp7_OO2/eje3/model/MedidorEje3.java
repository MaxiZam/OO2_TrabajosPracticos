package model;

import java.io.IOException;
import java.time.LocalDate;

public class Medidor {

	private int temperatura;
	private ClimaOnline clima;
	private Observador ob;

	public Medidor(ClimaOnline clima, Observador ob) {
		this.clima = clima;
	}

	public void leerTemperatura() {
		// leo la temperatura del servicio web
		this.temperatura = this.clima.temperatura();
		try {
			this.ob.actualizar(temperatura, LocalDate.now());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
