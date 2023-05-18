package model;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

public class Observador {

	private List<ActualizarDecorator> listaObservers;

	public Observador(List<ActualizarDecorator> list) {
		this.listaObservers = list;
	}

	public void actualizar(int temp, LocalDate dia) throws IOException {
		for (ActualizarDecorator ob : listaObservers) {
			ob.actualizar(temp, dia);
		}
	}

}
