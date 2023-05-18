package model;

import java.io.IOException;
import java.time.LocalDate;

public interface ActualizarDecorator {

	void actualizar(int temp, LocalDate dia) throws IOException;
}
