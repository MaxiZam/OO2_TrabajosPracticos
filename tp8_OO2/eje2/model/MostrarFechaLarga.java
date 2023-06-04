package model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class MostrarFechaLarga implements MostrarFecha {

	@Override
	public String mostrarFecha(LocalDate fecha) {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("EEE, dd MMM yyyy");
		return fecha.format(dtf);
	}

}
