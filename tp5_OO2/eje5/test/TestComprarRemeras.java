package test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import domain.Importado;
import domain.Nacional;
import domain.Remera;

public class TestComprarRemeras {
	@Test
	void TestComprarRemerasNacionales() {
		Remera remera = new Nacional(1000);
		int result = 1365;
		assertEquals(result, remera.calcularPrecio());
	}

	@Test
	void TestComprarRemerasImportadas() {
		Remera remera = new Importado(2000);
		int result = 2660;
		assertEquals(result, remera.calcularPrecio());
	}
}
