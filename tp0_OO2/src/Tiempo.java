import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Locale;

public class Tiempo {

	LocalDate tiempo = LocalDate.now();

	public void mostrarFechaCorto() {
		System.out.print("Formato corto: ");
		SimpleDateFormat mostrarTiempo = new SimpleDateFormat("dd/MM/YY");
		System.out.print(mostrarTiempo.format(tiempo) + "\n");
	}

	public void mostrarFechaLargo() {
		System.out.print("Formato largo: ");
		SimpleDateFormat mostrarTiempo = new SimpleDateFormat("EEEE dd 'de' MMMM 'de' YYYY", Locale.getDefault());
		System.out.print(mostrarTiempo.format(tiempo) + "\n");
	}

	public LocalDate getTiempo() {
		return tiempo;
	}

	public void setTiempo(LocalDate tiempo) {
		this.tiempo = tiempo;
	}
}
