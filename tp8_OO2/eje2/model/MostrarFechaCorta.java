package model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class MostrarFechaCorta implements MostrarFecha {

	@Override
	public String mostrarFecha(LocalDate fecha) {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		return fecha.format(dtf);
	}

}
