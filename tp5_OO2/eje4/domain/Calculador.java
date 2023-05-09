package domain;

import static java.time.LocalDate.now;
import static java.time.Month.of;

public abstract class Calculador {

	private LogTransaction log;
	private int mesEnPromocion;

	public Calculador(int mes) {
		this.mesEnPromocion = mes;
		this.log = new LogTransaction();
	}

	public double calcularPrecio(double precioProducto) {
		double precioTotal = precioProducto;
		if (of(mesEnPromocion).equals(now().getMonth())) {
			precioTotal = this.mesEnPromocion(precioProducto);
		} else {
			precioTotal = this.mesSinPromocion(precioProducto);
		}
		log.log(this.getClass().getName());
		return precioTotal;
	}

	protected abstract double mesSinPromocion(double precio);

	protected abstract double mesEnPromocion(double precio);
}
