package zambrana.framework;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

import org.json.JSONArray;
import org.json.JSONObject;

import com.googlecode.lanterna.gui2.BasicWindow;
import com.googlecode.lanterna.gui2.Button;
import com.googlecode.lanterna.gui2.CheckBox;
import com.googlecode.lanterna.gui2.Component;
import com.googlecode.lanterna.gui2.Direction;
import com.googlecode.lanterna.gui2.Label;
import com.googlecode.lanterna.gui2.LinearLayout;
import com.googlecode.lanterna.gui2.MultiWindowTextGUI;
import com.googlecode.lanterna.gui2.Panel;
import com.googlecode.lanterna.gui2.Window;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;

public class ArchivoJson implements ConfiguracionFramework {

	private ExecutorService ejecutor;
	private int maxHilos;

	public List<Accion> accionesConfig(String arch) {
		List<Accion> accionesC = new ArrayList<>();
		String contenidoArchivo = null;
		try {
			contenidoArchivo = new String(Files.readAllBytes(Paths.get(arch)));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		JSONObject configObject = new JSONObject(contenidoArchivo);
		try {
			JSONArray opcionesArray = configObject.getJSONArray("acciones");
			for (int i = 0; i < opcionesArray.length(); i++) {
				Class<?> clase = Class.forName((String) opcionesArray.get(i));
				try {
					Accion accion = (Accion) clase.getDeclaredConstructor().newInstance();
					accionesC.add(accion);
				} catch (InstantiationException | IllegalAccessException | IllegalArgumentException
						| InvocationTargetException | NoSuchMethodException | SecurityException e) {
					e.printStackTrace();
				}
			}
			this.maxHilos = configObject.getInt("max-threads");
		} catch (ClassNotFoundException e) {
			System.out.println("Error al cargar el archivo de propiedades: " + e.getMessage());
		}
		return accionesC;
	}

	protected int maxThreads() {
		return maxHilos;
	}

	protected static boolean isJsonFile(String filePath) {
		if (filePath.toLowerCase().endsWith(".json")) {
			return true;
		}
		return false;
	}

	@Override
	public void desplegarMenu(List<Accion> acciones) {
		Window window = new BasicWindow("Bienvenido, estas son sus opciones");
		Panel panel = new Panel();
		panel.setLayoutManager(new LinearLayout(Direction.VERTICAL));

		// Opciones:
		panel.addComponent(new Label("Seleccione una opción:"));
		int i = 1;
		for (Accion accion : acciones) {
			panel.addComponent(new CheckBox(accion.nombreItemMenu() + " (" + accion.descripcionItemMenu() + ")"));
			i++;
		}
		panel.addComponent(new Button(". Confirmar", new Runnable() {
			public void run() {
				Collection<RunnableAdapter> runing = new ArrayList<>();
				List<Component> components = panel.getChildrenList();
				int i = 0;
				for (Component com : components) {
					if (com instanceof CheckBox) {
						CheckBox check = (CheckBox) com;
						if (check.isChecked()) {
							runing.add(new RunnableAdapter(acciones.get(i)));
						}
						i++;
					}
				}
				try {
					List<Future<Object>> futures = ejecutor.invokeAll(runing);
					ejecutor.shutdown();
					ejecutor.awaitTermination(Long.MAX_VALUE, java.util.concurrent.TimeUnit.NANOSECONDS);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}));
		panel.addComponent(new Button(". Salir", new Runnable() {
			public void run() {
				System.out.println("programa finalizado.");
				System.exit(0);
			}
		}));
		window.setComponent(panel);

		Terminal terminal = null;
		Screen screen = null;
		try {
			terminal = new DefaultTerminalFactory().createTerminal();
			screen = new TerminalScreen(terminal);
			screen.startScreen();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		MultiWindowTextGUI gui = new MultiWindowTextGUI(screen);
		gui.addWindowAndWait(window);
	}
}
