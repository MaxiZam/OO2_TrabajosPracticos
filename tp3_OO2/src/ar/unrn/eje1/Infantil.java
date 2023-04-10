package ar.unrn.eje1;

public class Infantil extends Libro{

	public Infantil(String nombre) {
		super(nombre);
	}

	public double precioAlquiler(Alquiler alquiler) {
		double monto = 1.5;
        if (alquiler.diasAlquilados() > 3)
          monto += (alquiler.diasAlquilados() - 3) * 1.5;  
		return monto;
	}
}
