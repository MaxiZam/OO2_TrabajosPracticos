package modelo;

import java.util.List;

public class Observador {

	private List<Observador> listaObservers;

	public Observador(List<Observador> list) {
		this.listaObservers = list;
	}

	public void actualizar(String bebida, String plato, int precio) {
		for (Observador ob : listaObservers) {
			ob.actualizar(bebida, plato, precio);
		}
	}
}
