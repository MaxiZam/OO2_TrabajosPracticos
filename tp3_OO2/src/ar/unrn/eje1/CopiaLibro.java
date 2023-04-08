package ar.unrn.eje1;

import ar.unrn.eje1.libro.Libro;

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
}