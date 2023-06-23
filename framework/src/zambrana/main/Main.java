package zambrana.main;

import zambrana.framework.Start;

public class Main {

	public static void main(String[] args) {
		Start run = new Start("config_properties.json");// Implementacion de Acciones
		run.init();
	}
}
