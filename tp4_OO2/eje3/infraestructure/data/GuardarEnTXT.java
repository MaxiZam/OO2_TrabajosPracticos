package infraestructure.data;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import domain.portsout.GuardarInscriptos;
import domain.portsout.InscriptoRecord;
import domain.portsout.ObtenerInscriptos;

public class GuardarEnTXT implements GuardarInscriptos, ObtenerInscriptos {

	private String nombreArch;
	
	public GuardarEnTXT(String nombreArch) {
		this.nombreArch = nombreArch;
	}

	public List<InscriptoRecord> devolverInscriptos() {
		List<InscriptoRecord> inscriptos = new ArrayList<>();
		try {
			BufferedReader scanner = new BufferedReader(new FileReader(nombreArch));
			String cadena;
			while ((cadena = scanner.readLine()) != null) {
				String[] nuevoInscripto = cadena.split(",");
				inscriptos.add(new InscriptoRecord(nuevoInscripto[0], nuevoInscripto[1], nuevoInscripto[2], nuevoInscripto[3]));
			}
			scanner.close();
		} catch (IOException e) {
			System.out.println("Error: archivo no encontrado");
		}
		return inscriptos;
	}

	@Override
	public void guardarInscripto(InscriptoRecord nuevoInscripto) {
		try {
			FileWriter fw = new FileWriter(nombreArch, true);
			String lineaNueva = nuevoInscripto.apellido()+","+nuevoInscripto.nombre()+","+nuevoInscripto.mail()+","+nuevoInscripto.idConcurso();
			fw.write(lineaNueva + "\n");
			fw.close();
		} catch (IOException e) {
			System.out.println("Error: archivo no encontrado");
		}
	}
}
