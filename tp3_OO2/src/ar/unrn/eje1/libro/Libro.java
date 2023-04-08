package ar.unrn.eje1.libro;

import ar.unrn.eje1.Alquiler;

public abstract class Libro {
  private String nombre;

  public Libro(String nombre) {
    this.nombre = nombre;
  }
  
  public double precioAlquiler(Alquiler alquiler) {
	  return 0;
  }
  
  public int puntosAlquilerFrecuente(Alquiler alquiler) {
	return 0;
  }

  public String nombre() {
    return nombre;
  }
}