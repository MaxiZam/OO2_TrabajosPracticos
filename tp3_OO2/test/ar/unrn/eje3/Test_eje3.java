package ar.unrn.eje3;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class Test_eje3 {
	@Test
	public void hacerReporteDeGastos() {
		Gasto gasto1 = new Alquiler_Auto("Alquiler de Auto", 6000);
		Gasto gasto2 = new Cena("Cena navidenia", 15000);
		Gasto gasto3 = new Desayuno("Desayuno de huevos revueltos", 1500);
		Gasto gasto4 = new Cena("Panchos", 1000);
		List<Gasto> listaGastos = new ArrayList<Gasto>();
		listaGastos.add(gasto1);
		listaGastos.add(gasto2);
		listaGastos.add(gasto3);
		listaGastos.add(gasto4);
		LocalDate dia = LocalDate.now();
		ReporteDeGastos reporte = new ReporteDeGastos(listaGastos, dia);
		System.out.println(reporte.imprimirReporte());

		String result = "Expenses 2023-04-14\r\n" + "Alquiler de Auto                   6000		\r\n"
				+ "Cena navidenia                      15000	X\r\n"
				+ "Desayuno de huevos revueltos       1500		X\r\n"
				+ "Panchos                            1000		 \r\n" + "Gastos de comida: 17500\r\n"
				+ "Total de gastos: 23500\r\n";

		assertEquals(result, reporte.imprimirReporte());
	}
}
