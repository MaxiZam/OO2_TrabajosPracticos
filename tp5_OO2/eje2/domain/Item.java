package domain;

import java.util.ArrayList;
import java.util.List;

public abstract class Item {

	protected int tiempo_horas;
	protected List<Item> items;

	public Item(int tiempo_horas) {
		this.tiempo_horas = tiempo_horas;
		this.items = new ArrayList<>();
	}

	public int calcularTiempo() {
		int tiempo = this.tiempo_horas;
		for (Item item : items) {
			tiempo += item.calcularTiempo();
		}
		return tiempo;
	}

	protected void agregarItem(Item item) {
		items.add(item);
	}
}
