package main;

import data.GuardarEnBD;
import data.GuardarEnTXT;
import model.RestCall;

public class MainEje4 {

	public static void main(String[] args) {
		RestCall rest = new RestCall("https://jsonplaceholder.typicode.com/posts", new GuardarEnTXT("lista_items"));
		System.out.println(rest.run());

		RestCall rest2 = new RestCall("https://jsonplaceholder.typicode.com/posts",
				new GuardarEnBD("url", "user", "password"));

		RestCall rest3 = new RestCall("https://jsonplaceholder.typicode.com/posts",
				new GuardarEnTXT("lista_items", new GuardarEnBD("url", "user", "password")));
	}
}
