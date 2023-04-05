package Test;

import static org.junit.Assert.assertEquals;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import modelo.*;
import modeloTarjetas.ComarcaPlus;
import modeloTarjetas.Tarjeta;
import modeloTarjetas.Viedma;
import modeloTarjetas.Visa;

public class TestTP2_conFakeObject {
	// Punto 5
	@Test
	public void archivarParticipanteEnFakeObject() {
		Guardar_Fake guardar = new Guardar_Fake();
		Notificar_Fake notificar = new Notificar_Fake();
		
		Concurso c = new Concurso("Arte conceptual", LocalDate.now().minusDays(1), LocalDate.now().plusWeeks(1), guardar,notificar);
		Concurso c2 = new Concurso("Peso muerto", LocalDate.now().minusDays(1), LocalDate.now().plusWeeks(1),guardar, notificar);

		Participante persona1 = new Participante("Fernando Gonzalez");
		Participante persona2 = new Participante("Mariano Flores");

		c.inscribirParticipante(persona1);
		c2.inscribirParticipante(persona2);

		boolean resultado = true;

		assertEquals(resultado, c.seInscribioParticipante(persona1));
	}

	@Test
	public void archivarPagosEnFakeObject() {
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

		Guardar_Fake guardar = new Guardar_Fake();
		
		Pedido nuevoPago = new Pedido(pedidosComida, pedidosBebida,guardar);
		
		Tarjeta tarjeta = new ComarcaPlus();
		Tarjeta tarjeta2 = new Viedma();
		Tarjeta tarjeta3 = new Visa();

		float resultado = 2440;

		assertEquals(resultado, nuevoPago.pedirCuenta(tarjeta, 2), 0.01);

		nuevoPago.pedirCuenta(tarjeta2, 2);
		nuevoPago.pedirCuenta(tarjeta3, 2);
	}
}
