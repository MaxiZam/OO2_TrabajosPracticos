package data;

import domain.Persona;
import domain.PersonaDAO;

public class ProxyPersonaDAO implements PersonaDAO {

	private BDPersonaDAO bd;

	public ProxyPersonaDAO(BDPersonaDAO bd) {
		this.bd = bd;
	}

	@Override
	public Persona personaPorId(int id) {
		return null;
	}

}
