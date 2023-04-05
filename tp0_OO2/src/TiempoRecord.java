import java.time.LocalDate;

public record TiempoRecord(LocalDate tiempo) {

	public LocalDate getTiempo() {
		return tiempo;
	}

}
