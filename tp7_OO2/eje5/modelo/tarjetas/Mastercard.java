package modelo.tarjetas;

public class Mastercard extends Tarjeta {

	public Mastercard() {
		super(2);
		// TODO Auto-generated constructor stub
	}

	public float aplicarDescuento(float totalComida, float totalBebida) {
		return totalComida * ((float) porcentajeDescuento / 100);
	}
}
