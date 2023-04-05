import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Locale;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		TiempoAnemico time = new TiempoAnemico();
		Tiempo time2 = new Tiempo();
		TiempoRecord time3 = new TiempoRecord(LocalDate.now());

		// Anemico:

		System.out.println("- Anemico: \n");
		SimpleDateFormat mostrarTiempo = new SimpleDateFormat("dd/MM/YY");
		System.out.print("Formato corto: " + mostrarTiempo.format(time.getTiempo()) + "\n");
		SimpleDateFormat mostrarTiempo2 = new SimpleDateFormat("EEEE dd 'de' MMMM 'de' YYYY", Locale.getDefault());
		System.out.print("Formato largo: " + mostrarTiempo2.format(time.getTiempo()) + "\n\n");

		// No anemico:

		System.out.println("- No anemico: \n");
		time2.mostrarFechaCorto();
		time2.mostrarFechaLargo();

		// Record:

		System.out.println("\n- Record: \n");
		System.out.print("Formato corto: " + mostrarTiempo.format(time3.getTiempo()) + "\n");
		System.out.print("Formato largo: " + mostrarTiempo2.format(time3.getTiempo()) + "\n\n");

	}

}
