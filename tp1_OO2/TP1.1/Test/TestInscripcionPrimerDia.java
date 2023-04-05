package Test;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import modelo.Concurso;
import modelo.Participante;

public class TestInscripcionPrimerDia {
	@Test
	public void incribirseElPrimerDiaDeInscripcion() {
		Concurso c = new Concurso("Miss America", LocalDate.now(), LocalDate.now().plusWeeks(1));
		Participante persona1 = new Participante("Fernando Gonzalez");
		c.inscribirParticipante(persona1);

		int resultado = 10;

		assertEquals(resultado, persona1.verPuntos());
	}
}
