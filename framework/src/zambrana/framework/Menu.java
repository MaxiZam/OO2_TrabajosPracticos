package zambrana.framework;

import java.util.List;

class Menu {

	private List<Accion> acciones;
	private ConfiguracionFramework config;
	// private ExecutorService ejecutor;

	public Menu(String arch) {
		if (ArchivoJson.isJsonFile(arch)) {
			config = new ArchivoJson();
			// ejecutor = Executors.newFixedThreadPool(ArchivoJson.maxThreads());
		} else {
			config = new ArchivoTXT();
		}
		this.acciones = config.accionesConfig(arch);
	}

	public void mostrarMenu() {
		this.config.desplegarMenu(this.acciones);
	}

//	public void mostrarMenuConsola() {
//		boolean salir = false;
//		Scanner scanner = new Scanner(System.in);
//		while (salir == false) {
//			System.out.println("Bienvenido, estas son sus opciones");
//			int i = 1;
//			for (Accion a : acciones) {
//				System.out.println(i + ". " + a.nombreItemMenu() + " (" + a.descripcionItemMenu() + ")");
//				i++;
//			}
//			System.out.println(i + ". Salir\n");
//			System.out.print("Ingrese su opcion: ");
//			int numeroAccion = scanner.nextInt();
//			if (numeroAccion > 0 && numeroAccion <= acciones.size()) {
//				System.out.println("\n");
//				acciones.get(numeroAccion - 1).ejecutar();
//				System.out.println("\n");
//			} else {
//				if (numeroAccion == acciones.size() + 1) {
//					salir = true;
//					System.out.println("\nHasta pronto :)");
//				} else {
//					System.out.println("\nA ingresado un valor erroneo, vuelva a intentar\n");
//				}
//			}
//		}
//		scanner.close();
//	}

//	public static void mostrarMenu() {
//		Window window = new BasicWindow("Bienvenido, estas son sus opciones");
//		Panel panel = new Panel();
//		panel.setLayoutManager(new LinearLayout(Direction.VERTICAL));
//
//		// Opciones:
//		panel.addComponent(new Label("Seleccione una opción:"));
//		int i = 1;
//		for (Accion accion : acciones) {
//			panel.addComponent(new Button(
//					i + ". " + accion.nombreItemMenu() + " (" + accion.descripcionItemMenu() + ")", new Runnable() {
//						public void run() {
//							accion.ejecutar();
//						}
//					}));
//			i++;
//		}
//		panel.addComponent(new Button(i + ". Salir", new Runnable() {
//			public void run() {
//				System.out.println("programa finalizado.");
//				System.exit(0);
//			}
//		}));
//		window.setComponent(panel);
//
//		Terminal terminal = null;
//		Screen screen = null;
//		try {
//			terminal = new DefaultTerminalFactory().createTerminal();
//			screen = new TerminalScreen(terminal);
//			screen.startScreen();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		MultiWindowTextGUI gui = new MultiWindowTextGUI(screen);
//		gui.addWindowAndWait(window);
//	}

//	public static void mostrarMenu() {
//		Window window = new BasicWindow("Bienvenido, estas son sus opciones");
//		Panel panel = new Panel();
//		panel.setLayoutManager(new LinearLayout(Direction.VERTICAL));
//
//		// Opciones:
//		panel.addComponent(new Label("Seleccione una opción:"));
//		int i = 1;
//		for (Accion accion : acciones) {
//			panel.addComponent(new CheckBox(accion.nombreItemMenu() + " (" + accion.descripcionItemMenu() + ")"));
//			i++;
//		}
//		panel.addComponent(new Button(i + ". Confirmar", new Runnable() {
//			public void run() {
//				Collection<RunnableAdapter> runing = new ArrayList<>();
//				List<Component> components = panel.getChildrenList();
//				int i = 0;
//				for (Component com : components) {
//					if (com instanceof CheckBox) {
//						CheckBox check = (CheckBox) com;
//						if (check.isChecked()) {
//							runing.add(new RunnableAdapter(acciones.get(i)));
//						}
//						i++;
//					}
//				}
//				try {
//					List<Future<Object>> futures = ejecutor.invokeAll(runing);
//					ejecutor.shutdown();
//					ejecutor.awaitTermination(Long.MAX_VALUE, java.util.concurrent.TimeUnit.NANOSECONDS);
//				} catch (InterruptedException e) {
//					e.printStackTrace();
//				}
//			}
//		}));
//		panel.addComponent(new Button(i + ". Salir", new Runnable() {
//			public void run() {
//				System.out.println("programa finalizado.");
//				System.exit(0);
//			}
//		}));
//		window.setComponent(panel);
//
//		Terminal terminal = null;
//		Screen screen = null;
//		try {
//			terminal = new DefaultTerminalFactory().createTerminal();
//			screen = new TerminalScreen(terminal);
//			screen.startScreen();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		MultiWindowTextGUI gui = new MultiWindowTextGUI(screen);
//		gui.addWindowAndWait(window);
//	}
}
