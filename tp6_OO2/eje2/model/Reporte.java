package model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Reporte {

	private String reporte;
	private Reporte componente;

	public Reporte(String reporte, Reporte componente) {
		this.reporte = reporte;
		this.componente = componente;
	}

	public Reporte(String reporte) {
		this.reporte = reporte;
	}

	public boolean export(File file) throws IOException {
		boolean v = false;
		if (file == null) {
			throw new IllegalArgumentException("File es NULL; no puedo exportar...");
		}
		if (componente.validacion(file)) {
			throw new IllegalArgumentException("El archivo ya existe...");
		}
		file.createNewFile();
		File report = new File(reporte);
		FileWriter fw = new FileWriter(file.getAbsoluteFile(), true);
		BufferedWriter bw = new BufferedWriter(fw);
		try (BufferedReader reader = new BufferedReader(new FileReader(report))) {
			StringBuilder texto = new StringBuilder();
			String linea;
			while ((linea = reader.readLine()) != null) {
				texto.append(linea);
				texto.append("\n");
				bw.append(linea + "\n");
			}
			v = true;
			System.out.println(texto.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
		bw.close();
		return v;
	}

	protected boolean validacion(File file) {
		return false;
	}

}
