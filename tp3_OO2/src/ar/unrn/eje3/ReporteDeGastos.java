package ar.unrn.eje3;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

public class ReporteDeGastos {

	List<Gasto> gastos;
	LocalDate fecha;
	int totalMontoGastos;

	public ReporteDeGastos(List<Gasto> gastos, LocalDate fecha) {
		this.gastos = Objects.requireNonNull(gastos);
		this.fecha = Objects.requireNonNull(fecha);
		this.totalMontoGastos = 0;
	}

	public String imprimirReporte() {
		int total = 0;
		int gastosDeComida = 0;
		String texto = "Expenses " + fecha;
		for (Gasto gasto : gastos) {
			String marcaExceso = "";
			gastosDeComida += gasto.devolverMontoSiSosComida();
			marcaExceso = gasto.esExcesoDeGasto() ? "X" : " ";
			String textoCentrado = (centrarTexto(gasto.getNombre()) + gasto.getMonto()
					+ (gasto.getMonto() > 10000 ? "\t" : "\t\t") + marcaExceso);
			texto += (System.lineSeparator() + gasto.getNombre() + textoCentrado);
			total += gasto.getMonto();
		}
		totalMontoGastos = total;
		texto += (System.lineSeparator() + "Gastos de comida: " + gastosDeComida + System.lineSeparator()
				+ "Total de gastos: " + total);
		return texto;
	}

	public int montoTotalGastos() {
		return this.totalMontoGastos;
	}

	String centrarTexto(String texto) {
		int longTexto = texto.length();
		String newTexto = "";
		for (int i = 0; i < 35 - longTexto; i++) {
			newTexto += " ";
		}
		return newTexto;
	}
}
