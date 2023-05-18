package model;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;

public class GuardarEnTXT extends Observador {

	private String ruta;

	public GuardarEnTXT(String ruta) {
		super(null);
	}

	public void actualizar(int temp, LocalDate dia) throws IOException {
		FileWriter fw = new FileWriter(this.ruta);
		fw.write(temp + "|" + dia + "\n");
		fw.close();
	}

}
