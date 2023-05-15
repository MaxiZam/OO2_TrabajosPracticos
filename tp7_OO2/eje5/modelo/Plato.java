package modelo;

public class Plato {

	String nombrePlato;
	int precio;

	public Plato(String nombrePlato, int precio) {
		this.nombrePlato = nombrePlato;
		this.precio = precio;
	}

	public String getNombrePlato() {
		return nombrePlato;
	}

	public int getPrecio() {
		return precio;
	}

}
