package model;

import java.io.File;
import java.io.IOException;

public class Reporte {

	private String reporte;

	public Reporte(String reporte) {
		this.reporte = reporte;
	}

	void export(File file) throws IOException {
		if (file == null) {
			throw new IllegalArgumentException("File es NULL; no puedo exportar...");
		}
		if (file.exists()) {
			throw new IllegalArgumentException("El archivo ya existe...");
		}
		File archivo = new File("archivo_reporte");

	}

}
