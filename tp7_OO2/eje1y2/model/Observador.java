package model;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

public class Observador {

	private List<Observador> listaObservers;

	public Observador(List<Observador> observers) {
		this.listaObservers = observers;
	}

	public void actualizar(int temp, LocalDate dia) throws IOException {
		for (Observador ob : listaObservers) {
			ob.actualizar(temp, dia);
		}
	}

}
