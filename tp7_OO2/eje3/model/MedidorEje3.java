package model;

import java.io.IOException;
import java.time.LocalDate;

public class MedidorEje3 {

	private int temperatura;
	private ClimaOnline clima;
	private ActualizarDecorator actualizar;

	public MedidorEje3(ClimaOnline clima, ActualizarDecorator actualizar) {
		this.clima = clima;
		this.actualizar = actualizar;
	}

	public void leerTemperatura() {
		// leo la temperatura del servicio web
		this.temperatura = this.clima.temperatura();
		try {
			this.actualizar.actualizar(temperatura, LocalDate.now());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
