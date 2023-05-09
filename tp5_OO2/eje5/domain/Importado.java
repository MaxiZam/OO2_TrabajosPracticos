package domain;

public class Importado extends Remera {

	public Importado(int precio) {
		super(precio);
	}

	@Override
	protected double recargo() {
		return 3 + this.aduana();
	}

	private double aduana() {
		return 5;
	}

	@Override
	protected double extraFinal() {
		return 25;
	}

}
