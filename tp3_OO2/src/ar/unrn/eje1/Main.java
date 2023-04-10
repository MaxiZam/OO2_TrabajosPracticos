package ar.unrn.eje1;

public class Main {
	public static void main(String args[]) {
		Libro elTunel = new Regular("El Túnel");
		Libro antesDelFin = new Regular("Antes del Fin");
		CopiaLibro elTunelCopia = new CopiaLibro(elTunel);
		CopiaLibro antesDelFinCopia = new CopiaLibro(antesDelFin);
		Cliente yo = new Cliente("Javier");
		yo.alquilar(elTunelCopia, 5);
		yo.alquilar(antesDelFinCopia, 3);
		System.out.println(yo.calcularDeudaDeAlquileres());
		System.out.println(yo.calcularPuntosObtenidos());
	}
}