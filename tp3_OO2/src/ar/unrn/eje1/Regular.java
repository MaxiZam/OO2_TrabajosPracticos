package ar.unrn.eje1;

public class Regular extends Libro{

	public Regular(String nombre) {
		super(nombre);
		
	}

	public double precioAlquiler(Alquiler alquiler) {
		double monto = 2;
		if (alquiler.diasAlquilados() > 2) {
			monto += ((alquiler.diasAlquilados() - 2) * 1.5);
        }
		return monto;
	}
}
