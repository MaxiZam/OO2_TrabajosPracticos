package Test;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import modelo.Concurso;
import modelo.Participante;

public class TestInscripcionFueraDeFecha {
	@Test
	public void incribirseElPrimerDiaDeInscripcion() {
		Concurso c = new Concurso("NeuroCiencia", LocalDate.now().plusWeeks(1), LocalDate.now().plusMonths(1));
		Participante persona1 = new Participante("Fernando Gonzalez");
		c.inscribirParticipante(persona1);

		boolean resultado = false;

		assertEquals(resultado, c.seInscribioParticipante(persona1));
	}
}
