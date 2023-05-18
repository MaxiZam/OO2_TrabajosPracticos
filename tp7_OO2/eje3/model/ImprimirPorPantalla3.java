package model;

import java.io.IOException;
import java.time.LocalDate;

public class ImprimirPorPantalla3 implements ActualizarDecorator {

	private ActualizarDecorator actualizar;

	public ImprimirPorPantalla3(ActualizarDecorator actualizar) {
		this.actualizar = actualizar;
	}

	public ImprimirPorPantalla3() {
	}

	public void actualizar(int temp, LocalDate dia) throws IOException {
		System.out.println("Temperatura: " + temp + " | " + "Fecha: " + dia + "\n");
		if (temp < 12) {
			System.out.println("Hace frio, se encenderá la caldera\n");
		}
		if (temp > 17) {
			System.out.println("Hace calor, se encenderá el aire acondicionado\n");
		}
		if (actualizar != null)
			actualizar.actualizar(temp, dia);
	}

}
