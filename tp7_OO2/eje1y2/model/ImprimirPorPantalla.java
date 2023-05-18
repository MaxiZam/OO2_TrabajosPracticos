package model;

import java.io.IOException;
import java.time.LocalDate;

public class ImprimirPorPantalla implements ActualizarDecorator {

	public ImprimirPorPantalla() {
	}

	public void actualizar(int temp, LocalDate dia) throws IOException {
		System.out.println("Temperatura: " + temp + " | " + "Fecha: " + dia + "\n");
		if (temp < 12) {
			System.out.println("Hace frio, se encenderá la caldera\n");
		}
		if (temp > 17) {
			System.out.println("Hace calor, se encenderá el aire acondicionado\n");
		}
	}

}
