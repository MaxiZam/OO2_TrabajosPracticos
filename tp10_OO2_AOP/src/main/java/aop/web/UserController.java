package aop.web;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import aop.domain.LoggingUser;
import aop.domain.portsin.User;
import aop.domain.portsin.Users;

@RestController
public class UserController {

	private Users users;
	private LoggingUser login;

	public UserController(Users users, LoggingUser login) {
		this.users = users;
		this.login = login;
	}

	@GetMapping("/users")
	public List<User> allUsers() {
		return this.users.users();
	}

	@GetMapping("/users/{id}")
	public User usersById(@PathVariable int id) {
		return this.users.userById(id);
	}

	@GetMapping("/users/search/{username}")
	public User usersByName(@PathVariable String username) {
		return this.users.usersByName(username);
	}

	@GetMapping("/users/tiempo/10")
	public void calcularTiempo() {
		login.loginUser(10);
	}

	@GetMapping("/users/tiempo/100")
	public void calcularTiempo100() {
		login.loginUser(100);
	}
}
