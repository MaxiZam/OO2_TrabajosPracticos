package modelo.tarjetas;

public class ComarcaPlus extends Tarjeta {

	public ComarcaPlus() {
		super(2);
		// TODO Auto-generated constructor stub
	}

	public float aplicarDescuento(float totalComida, float totalBebida) {
		return (totalComida + totalBebida) * ((float) porcentajeDescuento / 100);
	}
}
