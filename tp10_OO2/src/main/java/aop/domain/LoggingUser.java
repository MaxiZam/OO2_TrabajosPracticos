package main.java.aop.domain;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import main.java.aop.domain.portsin.User;
import main.java.aop.domain.portsout.GuardarUsers;

@Component
public class LoggingUser {

	private GuardarUsers guardar;
	private List<User> users;

	public LoggingUser(GuardarUsers guardar) {
		this.guardar = guardar;
		this.users = new ArrayList<>();
	}

	@Time
	public void loginUser(int cantDeUsuarios) {
		int id = 1;
		for (int i = 0; i < cantDeUsuarios; i++) {
			User nuevoUser = new User(id, "pedrito");
			System.out.println(nuevoUser.id());
			users.add(nuevoUser);
			id++;
			guardar.agregarUser(nuevoUser);
		}

	}
}
