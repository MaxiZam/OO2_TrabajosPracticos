package modelo.tarjetas;

public abstract class Tarjeta {

	protected int porcentajeDescuento;

	Tarjeta(int porcentajedescuento) {
		this.porcentajeDescuento = porcentajedescuento;
	}

	public Tarjeta() {
		this.porcentajeDescuento = 0;
	}

	public float calcularCosto(float precioPlatos, float precioBebidas, int porcentajePropina) {
		float precioTotal = precioPlatos + precioBebidas;
		float propina = precioTotal * ((float) porcentajePropina / 100);
		float descuento = aplicarDescuento(precioPlatos, precioBebidas);
		precioTotal = precioTotal + propina - descuento;
		return precioTotal;
	}

	public float aplicarDescuento(float totalComida, float totalBebida) {
		return porcentajeDescuento;
	}
}
