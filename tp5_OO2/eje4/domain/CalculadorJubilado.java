package domain;

public class CalculadorJubilado extends Calculador {

	public CalculadorJubilado(int mes) {
		super(mes);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected double mesSinPromocion(double precio) {
		return (precio * 0.1) + precio;
	}

	@Override
	protected double mesEnPromocion(double precio) {
		return precio;
	}

//	public double calcularPrecio(double precioProducto) {
//		double precioTotal = precioProducto;
//		if (!of(mesEnPromocion).equals(now().getMonth())) {
//			precioTotal += precioProducto * 0.1;
//		}
//		log.log(CalculadorJubilado.class.getName());
//		return precioTotal;
//	}
}
