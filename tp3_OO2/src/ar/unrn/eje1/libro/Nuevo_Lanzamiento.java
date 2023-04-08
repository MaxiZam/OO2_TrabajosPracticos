package ar.unrn.eje1.libro;

import ar.unrn.eje1.Alquiler;

public class Nuevo_Lanzamiento extends Libro{

	public Nuevo_Lanzamiento(String nombre) {
		super(nombre);
	}
	
	public double precioAlquiler(Alquiler alquiler) {
		  return alquiler.diasAlquilados() * 3;
	}
	
	public int puntosAlquilerFrecuente(Alquiler alquiler) {
		if(alquiler.diasAlquilados()>1) {
			return 1;}
		return 0;
	}

}
