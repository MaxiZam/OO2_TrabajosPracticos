package tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;

import domain.ColectivosSur;
import domain.CorreoArgentino;
import domain.EmpresaEnvio;
import infraestructure.DistanciaServiceFake;

public class TestEnvioCompra {
	@Test
	public void testColectivosSur() {
		EmpresaEnvio empresa = new ColectivosSur(new DistanciaServiceFake(100));

		Map<Double, Double> carrito = new HashMap<Double, Double>();
		carrito.put(10.0, 2.0);
		carrito.put(500.0, 2.5);
		carrito.put(999.9, 3.2);
		carrito.put(35.0, 0.2);

		double result = 5044.9;
		assertEquals(result, empresa.calcularMontoTotal(carrito, "Alvaro Barros 435", "Belgrano 320"));
	}

	@Test
	public void testCorreoArgentino() {
		EmpresaEnvio empresa = new CorreoArgentino(new DistanciaServiceFake(100));

		Map<Double, Double> carrito = new HashMap<Double, Double>();
		carrito.put(10.0, 2.0);
		carrito.put(500.0, 2.5);
		carrito.put(999.9, 3.2);
		carrito.put(35.0, 0.2);

		double result = 2844.9;
		assertEquals(result, empresa.calcularMontoTotal(carrito, "Alvaro Barros 435", "Belgrano 320"));
	}
}
