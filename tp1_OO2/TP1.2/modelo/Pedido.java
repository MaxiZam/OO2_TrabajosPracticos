package modelo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import modeloTarjetas.Tarjeta;

public class Pedido {

	private List<Plato> listaComidas = new ArrayList<>();
	private List<Bebida> listaBebidas = new ArrayList<>();

	public Pedido(List<Plato> listaComidas, List<Bebida> listaBebidas) {
		this.listaComidas = listaComidas;
		this.listaBebidas = listaBebidas;
	}

	public float pedirCuenta(Tarjeta tarjeta, int porcentajePropina) {
		float totalComida = 0;
		float totalBebida = 0;
		for (Plato plato : listaComidas) {
			totalComida += plato.getPrecio();
		}
		for (Bebida bebida : listaBebidas) {
			totalBebida += bebida.getPrecio();
		}
		float cuenta = tarjeta.calcularCosto(totalComida, totalBebida, porcentajePropina);
		String texto = new String(LocalDate.now() + " || " + cuenta);
		return cuenta;
	}
}
