package data;

import java.util.ArrayList;
import java.util.List;

import domain.Persona;
import domain.PersonaDAO;

public class ProxyPersonaDAO implements PersonaDAO {

	private BDPersonaDAO bd;
	private List<Persona> personas;

	public ProxyPersonaDAO(String url, String user, String password) {
		this.bd = new BDPersonaDAO(url, user, password);
		this.personas = new ArrayList<>();
	}

	@Override
	public Persona personaPorId(int id) {
		Persona persona = bd.personaPorId(id);
		for(Persona p : personas) {
			if()) {
				
			}
		}
		return null;
	}

}
