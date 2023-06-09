package aop.domain;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import aop.domain.portsin.User;
import aop.domain.portsout.GuardarUsers;

@Component
public class LoggingUser {

	private GuardarUsers guardar;

	public LoggingUser(GuardarUsers guardar) {
		this.guardar = guardar;
	}

	@Time
	public void loginUser(int cantDeUsuarios) {
		int id = 1;
		List<User> users = new ArrayList<>();
		for (int i = 0; i < cantDeUsuarios; i++) {
			User nuevoUser = new User(id, "pedrito");
			users.add(nuevoUser);
			id++;
			guardar.agregarUser(nuevoUser);
		}

	}
}
