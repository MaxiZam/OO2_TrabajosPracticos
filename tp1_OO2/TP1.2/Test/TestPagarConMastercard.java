package Test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import modelo.Bebida;
import modelo.Pedido;
import modelo.Plato;
import modeloTarjetas.Mastercard;
import modeloTarjetas.Tarjeta;

public class TestPagarConMastercard {
	@Test
	public void pagarConMasterCard() {
		Plato plato1 = new Plato("Fideos con tuco", 500);
		Plato plato2 = new Plato("Milanesas con pure", 700);
		Plato plato3 = new Plato("Pizza napolitana", 800);
		Bebida bebida1 = new Bebida("Coca Cola", 150);
		Bebida bebida2 = new Bebida("Sprite", 150);
		Bebida bebida3 = new Bebida("Aquarius", 140);

		List<Plato> pedidosComida = new ArrayList<>();
		pedidosComida.add(plato1);
		pedidosComida.add(plato2);
		pedidosComida.add(plato3);
		List<Bebida> pedidosBebida = new ArrayList<>();
		pedidosBebida.add(bebida1);
		pedidosBebida.add(bebida2);
		pedidosBebida.add(bebida3);

		Pedido nuevoPago = new Pedido(pedidosComida, pedidosBebida);

		Tarjeta tarjeta = new Mastercard();

		float resultado = (float) 2448.8;

		assertEquals(resultado, nuevoPago.pedirCuenta(tarjeta, 2), 0.01);
	}

}
