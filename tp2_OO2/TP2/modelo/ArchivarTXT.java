package modelo;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class ArchivarTXT implements GuardarTexto {

	File archivo;

	public ArchivarTXT(String nombre) {
		archivo = new File(nombre);
	}

	public ArchivarTXT(String ruta, String nombre) {
		archivo = new File(ruta + nombre);
	}

	@Override
	public void guardarTexto(String texto) {
		FileWriter escribir;
		try {
			escribir = new FileWriter(archivo, true);
			escribir.write(texto + "\n");
			escribir.close();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

}
