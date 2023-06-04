package domain.model;

import java.util.List;

public class Observador {

	private List<Observador> listaObservers;

	public Observador(List<Observador> list) {
		this.listaObservers = list;
	}

	public void actualizar(String nombre, String mail, String region) {
		for (Observador ob : listaObservers) {
			ob.actualizar(nombre, mail, region);
		}
	}
}
