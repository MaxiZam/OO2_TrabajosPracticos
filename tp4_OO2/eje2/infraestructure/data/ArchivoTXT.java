package infraestructure.data;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import domain.portsout.RecuperarListaEmpleados;

public class ArchivoTXT implements RecuperarListaEmpleados {

	private String nombreArch;
	public File arch;

	public ArchivoTXT(String nombreArch) {
		this.nombreArch = nombreArch;
	}

	@Override
	public String[] devolverListaEmpleados() {
		String[] listaEmpleados = null;
		try {
			Scanner scanner = new Scanner(new File(nombreArch));
			int x = 0;
			while (scanner.hasNextLine()) {
				listaEmpleados[x] = scanner.nextLine();
				x += 1;
			}

			scanner.close();

		} catch (FileNotFoundException e) {
			System.out.println("Error: archivo no encontrado");
		}
		return listaEmpleados;
	}

}
