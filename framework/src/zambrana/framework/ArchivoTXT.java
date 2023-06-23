package zambrana.framework;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.googlecode.lanterna.gui2.BasicWindow;
import com.googlecode.lanterna.gui2.Button;
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

public class ArchivoTXT implements ConfiguracionFramework {

	public List<Accion> accionesConfig(String arch) {
		Properties properties = new Properties();
		try {
			FileInputStream file = new FileInputStream(arch);
			properties.load(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
		FileInputStream archivoPropiedades = null;
		List<Accion> accionesC = new ArrayList<>();
		try {
			String cadena = properties.getProperty("acciones");
			String[] acciones = cadena.split(";");
			for (String a : acciones) {
				Class<?> clase = Class.forName(a);
				try {
					Accion accion = (Accion) clase.getDeclaredConstructor().newInstance();
					accionesC.add(accion);
				} catch (InstantiationException | IllegalAccessException | IllegalArgumentException
						| InvocationTargetException | NoSuchMethodException | SecurityException e) {
					e.printStackTrace();
				}
			}
		} catch (ClassNotFoundException e) {
			System.out.println("Error al cargar el archivo de propiedades: " + e.getMessage());
		} finally {
			if (archivoPropiedades != null) {
				try {
					archivoPropiedades.close();
				} catch (IOException e) {
					System.out.println("Error al cerrar el archivo de propiedades: " + e.getMessage());
				}
			}
		}
		return accionesC;
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
			panel.addComponent(new Button(
					i + ". " + accion.nombreItemMenu() + " (" + accion.descripcionItemMenu() + ")", new Runnable() {
						public void run() {
							accion.ejecutar();
						}
					}));
			i++;
		}
		panel.addComponent(new Button(i + ". Salir", new Runnable() {
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
