package modelo;

public class Bebida {

	String nombreBebida;
	int precio;

	public Bebida(String nombreBebida, int precio) {
		this.nombreBebida = nombreBebida;
		this.precio = precio;
	}

	public String getNombreBebida() {
		return nombreBebida;
	}

	public int getPrecio() {
		return precio;
	}
}
