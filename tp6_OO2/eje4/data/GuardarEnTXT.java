package data;

import java.io.FileWriter;
import java.io.IOException;

import model.Guardar;
import okhttp3.Response;

public class GuardarEnTXT implements Guardar {

	private String nombreArch;
	private Guardar guardar;

	public GuardarEnTXT(String ruta, Guardar guardar) {
		this.nombreArch = ruta;
		this.guardar = guardar;
	}

	public GuardarEnTXT(String ruta) {
		this.nombreArch = ruta;
	}

	@Override
	public void guardarItems(Response item) {
		try {
			FileWriter fw = new FileWriter(nombreArch, true);
			String lineaNueva = item.toString();
			fw.write(lineaNueva + "\n");
			fw.close();
		} catch (IOException e) {
			System.out.println("Error: archivo no encontrado");
		}
		if (guardar != null)
			guardar.guardarItems(item);
	}

}
