package aop.data;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import aop.domain.portsin.User;
import aop.domain.portsout.GuardarUsers;

@Component
public class AgregarUserFake implements GuardarUsers {

	private List<User> users = new ArrayList<>();

	public void agregarUser(User usuario) {
		users.add(usuario);
	}
}
