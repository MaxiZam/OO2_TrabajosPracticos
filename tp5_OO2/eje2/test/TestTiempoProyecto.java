package test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import domain.HistoriaUsuario;
import domain.Proyecto;
import domain.Spike;
import domain.Tarea;

public class TestTiempoProyecto {
	@Test
	public void TestTiempoDelProyecto() {
		HistoriaUsuario histori = new HistoriaUsuario();
		Tarea tarea = new Tarea(3);
		Tarea tarea2 = new Tarea(3);
		Spike spike = new Spike();
		Proyecto proyect = new Proyecto();
		histori.agregarItem(tarea);
		spike.agregarItem(tarea2);
		proyect.sumarItem(spike);
		proyect.sumarItem(histori);
		int result = 6;
		assertEquals(result, proyect.calcularTiempoProyecto());
	}

	@Test
	public void TestTiempoDelProyecto2() {
		HistoriaUsuario histori = new HistoriaUsuario();
		Spike spike = new Spike();
		Tarea tarea = new Tarea(3);
		Tarea tarea2 = new Tarea(5);
		Tarea tarea3 = new Tarea(6);
		Proyecto proyect = new Proyecto();
		histori.agregarItem(tarea);
		histori.agregarItem(tarea2);
		spike.agregarItem(tarea3);
		proyect.sumarItem(histori);
		proyect.sumarItem(spike);

		int result = 14;
		assertEquals(result, proyect.calcularTiempoProyecto());
	}
}
