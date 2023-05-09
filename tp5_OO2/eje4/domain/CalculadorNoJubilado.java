package domain;

public class CalculadorNoJubilado extends Calculador {

	public CalculadorNoJubilado(int mes) {
		super(mes);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected double mesSinPromocion(double precio) {
		return (precio * 0.21) + precio;
	}

	@Override
	protected double mesEnPromocion(double precio) {
		return (precio * 0.15) + precio;
	}

//	public double calcularPrecio(double precioProducto) {
//		double precioTotal = precioProducto;
//		if (of(mesEnPromocion).equals(now().getMonth())) {
//			precioTotal += precioProducto * 0.15;
//		} else {
//			precioTotal += precioProducto * 0.21;
//		}
//		log.log(CalculadorNoJubilado.class.getName());
//		return precioTotal;
//	}
}
