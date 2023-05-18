package model;

import java.util.HashMap;
import java.util.Map;

public class Tomate implements PorcionAdicional {

	private String descripcion;
	private int precio;
	private PorcionAdicional adicional;

	public Tomate(int precio, PorcionAdicional adicional) {
		this.descripcion = "Tomate";
		this.precio = precio;
		this.adicional = adicional;
	}

	public Tomate(int precio) {
		this.descripcion = "Tomate";
		this.precio = precio;
	}

	@Override
	public Map<String, Integer> devolverAdicional() {
		// TODO Auto-generated method stub
		Map<String, Integer> map;
		if (adicional != null) {
			map = adicional.devolverAdicional();
		} else {
			map = new HashMap<>();
		}
		map.put(descripcion, precio);
		return map;
	}
}
