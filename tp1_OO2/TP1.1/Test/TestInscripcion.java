package Test;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import modelo.Concurso;
import modelo.Participante;

public class TestInscripcion {
	@Test
	public void inscribirseAConcurso() {
		Concurso c = new Concurso("Arte conceptual", LocalDate.now().minusDays(1), LocalDate.now().plusWeeks(1));
		Participante persona1 = new Participante("Fernando Gonzalez");
		c.inscribirParticipante(persona1);

		boolean resultado = true;

		assertEquals(resultado, c.seInscribioParticipante(persona1));
	}
}
