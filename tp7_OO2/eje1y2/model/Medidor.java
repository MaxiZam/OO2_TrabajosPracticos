package model;

import java.io.IOException;
import java.time.LocalDate;

public class Medidor {

	private int temperatura;
	private OnlineClima clima;
	private Observador ob;

	public Medidor(OnlineClima clima, Observador ob) {
		this.clima = clima;
		this.ob = ob;
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
