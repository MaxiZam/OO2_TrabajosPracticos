import java.time.LocalDate;

public class TiempoAnemico {

	LocalDate tiempo = LocalDate.now();

	public LocalDate getTiempo() {
		return tiempo;
	}

	public void setTiempo(LocalDate tiempo) {
		this.tiempo = tiempo;
	}
}
