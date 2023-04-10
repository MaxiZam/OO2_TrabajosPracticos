package ar.unrn.eje3;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import ar.unrn.eje3.Alquiler_Auto;
import ar.unrn.eje3.Cena;
import ar.unrn.eje3.Desayuno;
import ar.unrn.eje3.Gasto;
import ar.unrn.eje3.ReporteDeGastos;

public class Test_eje3 {
	@Test
	public void hacerReporteDeGastos() {
		Gasto gasto1 = new Alquiler_Auto("Alquiler de Auto", 6000);
		Gasto gasto2 = new Cena("Cena navideña", 15000);
		Gasto gasto3 = new Desayuno("Desayuno de huevos revueltos", 1500);
		Gasto gasto4 = new Cena("Pancchos", 1000);
		List<Gasto> listaGastos = new ArrayList<Gasto>();
		listaGastos.add(gasto1);
		listaGastos.add(gasto2);
		listaGastos.add(gasto3);
		listaGastos.add(gasto4);
		LocalDate dia = LocalDate.now();
		ReporteDeGastos reporte = new ReporteDeGastos(listaGastos, dia);
		System.out.println(reporte.imprimirReporte());

		int result = 23500;

		assertEquals(result, reporte.montoTotalGastos());
	}
}
