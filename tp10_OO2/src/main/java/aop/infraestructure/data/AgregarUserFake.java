package main.java.aop.infraestructure.data;

import java.util.List;

import main.java.aop.domain.portsin.User;
import main.java.aop.domain.portsout.GuardarUsers;

public class AgregarUserFake implements GuardarUsers {

	List<User> users;

	public void agregarUser(User usuario) {
		users.add(usuario);
	}
}
