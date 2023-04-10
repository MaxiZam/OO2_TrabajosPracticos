package ar.unrn.eje1;

import java.util.ArrayList;
import java.util.List;

public class Cliente {
	private List<Alquiler> alquileres = new ArrayList<Alquiler>();
	private String nombre;

	public Cliente(String nombre) {
		this.nombre = nombre;
	}

	public double calcularDeudaDeAlquileres() {
		double monto = 0;
		for (Alquiler alquiler : alquileres) {
			monto += alquiler.precioCopia(alquiler);
		}
		return monto;
	}

	public int calcularPuntosObtenidos() {
		int puntosAlquilerFrecuente = 0;
		for (Alquiler alquiler : alquileres) {
			puntosAlquilerFrecuente += alquiler.puntosAlquilerFrecuente() + 1;
		}
		return puntosAlquilerFrecuente;
	}

	public void alquilar(CopiaLibro copiaLibro, int diasAlquiler) {
		Alquiler nuevoAlquiler = new Alquiler(copiaLibro, diasAlquiler);
		alquileres.add(nuevoAlquiler);
	}
}