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

public class TestTP2 {
	@Test
	// Punto 1
	public void archivarParticipanteEnTXT() {
		ArchivarTXT guardarTXT = new ArchivarTXT("inscripcion_participantes.txt");
		Notificar_Fake notificar = new Notificar_Fake();
		
		Concurso c = new Concurso("Arte conceptual", LocalDate.now().minusDays(1), LocalDate.now().plusWeeks(1), guardarTXT, notificar);
		Concurso c2 = new Concurso("Peso muerto", LocalDate.now().minusDays(1), LocalDate.now().plusWeeks(1), guardarTXT, notificar);

		Participante persona1 = new Participante("Fernando Gonzalez");
		Participante persona2 = new Participante("Mariano Flores");

		c.inscribirParticipante(persona1);
		c2.inscribirParticipante(persona2);

		boolean resultado = true;

		assertEquals(resultado, c.seInscribioParticipante(persona1));
	}

	// -----------------------------------------------------------------------------------------------------------------------//
	@Test
	// Punto 2
	public void archivarPagosEnTXT() {
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
		
		ArchivarTXT guardarTXT = new ArchivarTXT("cuentas_pedidos.txt");
		
		Pedido nuevoPago = new Pedido(pedidosComida, pedidosBebida, guardarTXT);

		Tarjeta tarjeta = new ComarcaPlus();
		Tarjeta tarjeta2 = new Viedma();
		Tarjeta tarjeta3 = new Visa();

		float resultado = 2440;

		assertEquals(resultado, nuevoPago.pedirCuenta(tarjeta, 2), 0.01);

		nuevoPago.pedirCuenta(tarjeta2, 2);
		nuevoPago.pedirCuenta(tarjeta3, 2);

	}

	// -----------------------------------------------------------------------------------------------------------------------//
	// Punto 3
	@Test
	public void archivarParticipantesEnBD() {
		ArchivarBD guardarBD = new ArchivarBD("jdbc:mysql://127.0.0.1/oo2_tp2", "root", "");
		Notificar_Fake notificar = new Notificar_Fake();
		
		Concurso c = new Concurso("Arte conceptual", LocalDate.now().minusDays(1), LocalDate.now().plusWeeks(1), guardarBD, notificar);
		Concurso c2 = new Concurso("Peso muerto", LocalDate.now().minusDays(1), LocalDate.now().plusWeeks(1), guardarBD, notificar);

		Participante persona1 = new Participante("Fernando Gonzalez");
		Participante persona2 = new Participante("Mariano Flores");

		c.inscribirParticipante(persona1);
		c2.inscribirParticipante(persona2);

		boolean resultado = true;

		assertEquals(resultado, c.seInscribioParticipante(persona1));
	}

	@Test
	public void archivarPagosEnBD() {
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

		ArchivarBD guardarBD = new ArchivarBD("jdbc:mysql://127.0.0.1/oo2_tp2", "root", "");
		
		Pedido nuevoPago = new Pedido(pedidosComida, pedidosBebida, guardarBD);

		Tarjeta tarjeta = new ComarcaPlus();

		float resultado = 2440;

		assertEquals(resultado, nuevoPago.pedirCuenta(tarjeta, 2), 0.01);
	}

	// -----------------------------------------------------------------------------------------------------------------------//
	// Punto 4
	@Test
	public void enviarMailAParticipante() {
		String mailPrueba = "maxizambrana14@gmail.com";
		ArchivarTXT guardarTXT = new ArchivarTXT("inscripcion_participantes.txt");
		Mail notificar = new Mail("HA INGRESADO AL CONCURSO","Le informamos que ha ingresado correctamente al concurso correspondiente al seleccionado por usted.");
		
		Concurso c = new Concurso("Arte conceptual", LocalDate.now().minusDays(1), LocalDate.now().plusWeeks(1),guardarTXT, notificar);
		Concurso c2 = new Concurso("Peso muerto", LocalDate.now().minusDays(1), LocalDate.now().plusWeeks(1),guardarTXT, notificar);

		Participante persona1 = new Participante("Fernando Gonzalez", mailPrueba);
		Participante persona2 = new Participante("Mariano Flores", mailPrueba);

		c.inscribirParticipante(persona1);
		c2.inscribirParticipante(persona2);

		boolean resultado = true;

		assertEquals(resultado, c.seInscribioParticipante(persona1));
	}

}
