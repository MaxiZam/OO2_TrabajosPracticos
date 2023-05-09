package test;

import static java.time.LocalDate.now;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import domain.Calculador;
import domain.CalculadorJubilado;
import domain.CalculadorNoJubilado;

public class TestCalculador {

	@Test
	void TestJubiladosSinPromocion() {
		Calculador calculador = new CalculadorJubilado(now().getMonth().getValue() - 1);
		double result = calculador.calcularPrecio(100);
		assertEquals(110d, result, 0.01f);
	}

	@Test
	void TestJubiladosConPromocion() {
		Calculador calculador = new CalculadorJubilado(now().getMonth().getValue());
		double result = calculador.calcularPrecio(100);
		assertEquals(100d, result, 0.01f);
	}

	@Test
	void TestNoJubiladosSinPromocion() {
		Calculador calculador = new CalculadorNoJubilado(now().getMonth().getValue() - 1);
		double result = calculador.calcularPrecio(100);
		assertEquals(121d, result, 0.01f);
	}

	@Test
	void TestNoJubiladosConPromocion() {
		Calculador calculador = new CalculadorNoJubilado(now().getMonth().getValue());
		double result = calculador.calcularPrecio(100);
		assertEquals(115d, result, 0.01f);
	}

}
