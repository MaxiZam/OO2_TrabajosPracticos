package model;

import java.util.Map;
import java.util.Map.Entry;

public abstract class Combo {

	protected String descripcion;
	protected int precio;
	protected PorcionAdicional adicional;

	public Combo(String descripcion, int precio, PorcionAdicional adicional) {
		this.descripcion = descripcion;
		this.precio = precio;
		this.adicional = adicional;
	}

	public String obtenerPedido() {
		Map<String, Integer> map = adicional.devolverAdicional();
		int precioTotal = this.precio;
		String pedido = "\nPedido: \n" + descripcion + "\t" + this.precio + "\n";
		for (Entry<String, Integer> entry : map.entrySet()) {
			pedido += entry.getKey() + "\t" + entry.getValue() + "\n";
			precioTotal += entry.getValue();
		}
		pedido += "\nTotal:  " + precioTotal;
		return pedido;
	}
}
