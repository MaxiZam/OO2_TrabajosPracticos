package test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import domain.Automovil;
import domain.Hogar;
import domain.Medico;
import domain.Paquete;
import domain.Seguro;
import domain.Vida;

public class TestPaquetesSeguros {
	@Test
	public void testPaquetesDeSeguros() {
		Seguro hogar = new Hogar(1000);
		Seguro auto = new Automovil(700);
		Seguro vida = new Vida(1200);
		Seguro medico = new Medico(900);
		Paquete paqueteCompleto = new Paquete();
		paqueteCompleto.sumarPaquete(hogar);
		paqueteCompleto.sumarPaquete(auto);
		paqueteCompleto.sumarPaquete(vida);
		paqueteCompleto.sumarPaquete(medico);
		double result = 3800 * 0.8;
		assertEquals(result, paqueteCompleto.obtenerPrecioPaquete());
	}

	@Test
	public void testPaquetesDeSeguros2() {
		Seguro hogar = new Hogar(1000);
		Seguro auto = new Automovil(700);
		Seguro vida = new Vida(1200);
		Seguro medico = new Medico(900);
		Paquete paqueteCompleto = new Paquete();
		Paquete paqueteCompleto2 = new Paquete();
		paqueteCompleto.sumarPaquete(hogar);
		paqueteCompleto.sumarPaquete(auto);
		paqueteCompleto.sumarPaquete(vida);
		paqueteCompleto.sumarPaquete(medico);
		paqueteCompleto2.sumarPaquete(hogar);
		paqueteCompleto2.sumarPaquete(auto);
		paqueteCompleto.sumarPaquete(paqueteCompleto2);
		double result = 5500 * 0.7;
		assertEquals(result, paqueteCompleto.obtenerPrecioPaquete());
	}
}
