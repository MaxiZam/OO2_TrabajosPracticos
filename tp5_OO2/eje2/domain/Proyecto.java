package domain;

import java.util.ArrayList;
import java.util.List;

public class Proyecto {

	List<Item> items;

	public Proyecto() {
		this.items = new ArrayList<>();
	}

	public int calcularTiempoProyecto() {
		int tiempo = 0;
		for (Item item : items) {
			tiempo += item.calcularTiempo();
		}
		return tiempo;
	}

	public void sumarItem(Item nuevoItem) {
		items.add(nuevoItem);
	}
}
