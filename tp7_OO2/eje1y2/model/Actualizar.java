package model;

import java.io.IOException;
import java.time.LocalDate;

public interface Actualizar {

	void actualizar(int temp, LocalDate dia) throws IOException;
}
