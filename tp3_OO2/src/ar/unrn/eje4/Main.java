package ar.unrn.eje4;

import java.util.Optional;

import org.jdbi.v3.core.Jdbi;

public class Main {

	public static void main(String[] args) {

		Jdbi jdbi = Jdbi.create("jdbc:hsqldb:mem;create=true");

		new SetUpDatabase(jdbi).setUp();

		var repo = new PersonaRepository(jdbi);
		var personas = repo.buscarPorNombre("Vlad");

		for (Persona persona : personas) {
			System.out.println(persona.verNombreYApellido());
		}

		Optional<Persona> persona = repo.buscarId(5L);
		if (persona.isPresent()) {
			Persona personaPresente = persona.get();
			System.out.println(personaPresente.verNombreYApellido());
		}
	}
}
