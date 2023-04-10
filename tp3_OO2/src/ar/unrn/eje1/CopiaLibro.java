package ar.unrn.eje1;

public class CopiaLibro {
	private Libro libro;

	public CopiaLibro(Libro libro) {
		this.libro = libro;
	}

	public Libro libro() {
		return libro;
	}

	public double precioLibro(Alquiler alquiler) {
		return this.libro.precioAlquiler(alquiler);
	}

	public int puntosAlquilerFrecuente(Alquiler alquiler) {
		return this.libro.puntosAlquilerFrecuente(alquiler);
	}
}