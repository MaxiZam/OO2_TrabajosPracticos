package model;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;

public class GuardarEnTXT implements ActualizarDecorator {

	private String ruta;

	public GuardarEnTXT(String ruta) {
		this.ruta = ruta;
	}

	public void actualizar(int temp, LocalDate dia) throws IOException {
		try {
			File file = new File(this.ruta);
			if (!file.exists()) {
				file.createNewFile();
			}
			FileWriter fw = new FileWriter(file, true);
			fw.write(temp + " | " + dia + "\n");
			fw.close();
		} catch (IOException e) {
			throw new RuntimeException("Hubo un error, no se puede actualizar...");
		}
	}

}
