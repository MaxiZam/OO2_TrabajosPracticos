package modeloTarjetas;

public class Visa extends Tarjeta {

	public Visa() {
		super(3);
		// TODO Auto-generated constructor stub
	}

	public float aplicarDescuento(float totalComida, float totalBebida) {
		return totalBebida * ((float) porcentajeDescuento / 100);
	}
}
