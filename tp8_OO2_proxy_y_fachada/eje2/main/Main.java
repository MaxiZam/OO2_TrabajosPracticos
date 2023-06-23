package main;

import data.BDPersonaDAO;
import domain.Persona;
import domain.PersonaDAO;
import domain.Telefono;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PersonaDAO dao = new BDPersonaDAO("jdbc:mysql://127.0.0.1/oo2_tp_proxy", "root", "");
		Persona p = dao.personaPorId(1);
		System.out.println(p.nombre());
		for (Telefono telefono : p.telefonos()) {
			System.out.println(telefono);
		}
	}

}
