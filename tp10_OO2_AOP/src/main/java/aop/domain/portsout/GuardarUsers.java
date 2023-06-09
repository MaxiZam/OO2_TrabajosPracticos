package aop.domain.portsout;

import org.springframework.stereotype.Component;

import aop.domain.portsin.User;

@Component
public interface GuardarUsers {

	void agregarUser(User nuevoUser);

}
