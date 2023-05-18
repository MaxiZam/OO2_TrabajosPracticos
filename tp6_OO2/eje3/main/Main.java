package main;

import model.Carne;
import model.Combo;
import model.ComboFamiliar;
import model.Papas;
import model.Queso;
import model.Tomate;

public class Main {

	public static void main(String[] args) {
		Combo comboCompra = new ComboFamiliar("familia feliz", 1000, new Queso(50, new Carne(150, new Papas(100))));
		System.out.println(comboCompra.obtenerPedido());

		Combo comboCompra2 = new ComboFamiliar("familia feliz", 1000, new Carne(150, new Tomate(40, new Queso(50))));
		System.out.println(comboCompra2.obtenerPedido());
	}

}
