package infraestructure.data;

import java.io.File;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

import domain.portsout.EmpleadoRecord;
import domain.portsout.RecuperarListaEmpleados;

public class ArchivoTXT implements RecuperarListaEmpleados {

	private String nombreArch;
	private File arch;

	public ArchivoTXT(String nombreArch) {
		this.nombreArch = nombreArch;
		this.arch = new File(nombreArch);
	}

	@Override
	public List<EmpleadoRecord> devolverListaEmpleados() {
		List<EmpleadoRecord> listaEmpleados = new ArrayList<>();
		try {
			BufferedReader scanner = new BufferedReader(new FileReader(nombreArch));
			String cadena;
			while ((cadena = scanner.readLine()) != null) {
				String[] empleado = cadena.split(",");
				listaEmpleados.add(new EmpleadoRecord(empleado[0], empleado[1], empleado[2], empleado[3]));
			}
			scanner.close();

		} catch (IOException e) {
			System.out.println("Error: archivo no encontrado");
		}
//		for(Emp lista: listaEmpleados)
//		{
//			System.out.println(lista);
//		}
		return listaEmpleados;
	}

}
