package infraestructure.data;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import domain.portsout.ConcursoDTO;
import domain.portsout.GuardarInscriptos;
import domain.portsout.InscriptoRecord;
import domain.portsout.ObtenerConcursos;
import domain.portsout.ObtenerInscriptos;

public class GuardarEnTXT implements GuardarInscriptos, ObtenerInscriptos, ObtenerConcursos {

	private String archInscriptos;
	private String archConcursos;

	public GuardarEnTXT(String inscriptos, String concursos) {
		this.archInscriptos = inscriptos;
		this.archConcursos = concursos;
	}

	public List<InscriptoRecord> devolverInscriptos() {
		List<InscriptoRecord> inscriptos = new ArrayList<>();
		try {
			BufferedReader scanner = new BufferedReader(new FileReader(archInscriptos));
			String cadena;
			while ((cadena = scanner.readLine()) != null) {
				String[] nuevoInscripto = cadena.split(",");
				inscriptos.add(new InscriptoRecord(nuevoInscripto[0], nuevoInscripto[1], nuevoInscripto[2],
						nuevoInscripto[3]));
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
			FileWriter fw = new FileWriter(archInscriptos, true);
			String lineaNueva = nuevoInscripto.apellido() + "," + nuevoInscripto.nombre() + "," + nuevoInscripto.mail()
					+ "," + nuevoInscripto.idConcurso();
			fw.write(lineaNueva + "\n");
			fw.close();
		} catch (IOException e) {
			System.out.println("Error: archivo no encontrado");
		}
	}

	@Override
	public List<ConcursoDTO> devolverConcursos() {
		List<ConcursoDTO> concursos = new ArrayList<>();
		try {
			BufferedReader scanner = new BufferedReader(new FileReader(archConcursos));
			String cadena;
			while ((cadena = scanner.readLine()) != null) {
				String[] concurso = cadena.split(",");
				concursos.add(new ConcursoDTO(concurso[0], concurso[1], concurso[2], concurso[3]));
			}
			scanner.close();
		} catch (IOException e) {
			System.out.println("Error: archivo no encontrado");
		}
		return concursos;
	}
}
