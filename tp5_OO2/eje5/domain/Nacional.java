package domain;

public class Nacional extends Remera {

	public Nacional(int precio) {
		super(precio);
	}

	@Override
	protected double recargo() {
		return 1.5 + this.bonificacion();
	}

	private double bonificacion() {
		return 20;
	}

	@Override
	protected double extraFinal() {
		return 15;
	}

}
