package zambrana.framework;

public class Start {

	private Menu menu;

	public Start(String arch) {
		this.menu = new Menu(arch);
	}

	public void init() {
		this.menu.mostrarMenu();
	}
}
