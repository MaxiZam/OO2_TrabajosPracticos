package main.java.aop.infraestructure.data;

import java.util.List;

import org.springframework.stereotype.Component;

import main.java.aop.domain.portsin.User;
import main.java.aop.domain.portsout.GuardarUsers;

@Component
public class AgregarUserFake implements GuardarUsers {

	List<User> users;

	public void agregarUser(User usuario) {
		users.add(usuario);
	}
}
