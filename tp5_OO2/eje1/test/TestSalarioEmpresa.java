package test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import domain.Director;
import domain.EmpleadoRegular;
import domain.Gerente;
import domain.GerenteMedio;
import domain.LiderProyecto;

public class TestSalarioEmpresa {
	@Test
	public void TestMontoSalarial() {
		Director director = new Director(10000);
		Gerente gerente = new Gerente(5000);
		GerenteMedio gerenteM = new GerenteMedio(3000);
		LiderProyecto lider = new LiderProyecto(2000);
		EmpleadoRegular empleado = new EmpleadoRegular(1000);

		director.agregarEmpleado(gerente);
		gerente.agregarEmpleado(gerenteM);
		gerenteM.agregarEmpleado(lider);
		lider.agregarEmpleado(empleado);

		int result = 21000;
		assertEquals(result, director.calcularMontoSalarial());
	}

	@Test
	public void TestMontoSalarial2() {
		Director director = new Director(10000);
		Gerente gerente = new Gerente(5000);
		GerenteMedio gerenteM = new GerenteMedio(3000);
		GerenteMedio gerenteM2 = new GerenteMedio(3500);
		LiderProyecto lider = new LiderProyecto(2000);
		LiderProyecto lider2 = new LiderProyecto(2000);
		LiderProyecto lider3 = new LiderProyecto(2400);
		EmpleadoRegular empleado = new EmpleadoRegular(1000);
		EmpleadoRegular empleado2 = new EmpleadoRegular(1000);
		EmpleadoRegular empleado3 = new EmpleadoRegular(1000);
		EmpleadoRegular empleado4 = new EmpleadoRegular(1000);
		EmpleadoRegular empleado5 = new EmpleadoRegular(1000);
		EmpleadoRegular empleado6 = new EmpleadoRegular(1000);
		EmpleadoRegular empleado7 = new EmpleadoRegular(1000);

		director.agregarEmpleado(gerente);
		gerente.agregarEmpleado(gerenteM);
		gerente.agregarEmpleado(gerenteM2);
		gerenteM.agregarEmpleado(lider);
		gerenteM.agregarEmpleado(lider2);
		gerenteM2.agregarEmpleado(lider3);
		lider.agregarEmpleado(empleado);
		lider.agregarEmpleado(empleado2);
		lider2.agregarEmpleado(empleado3);
		lider2.agregarEmpleado(empleado4);
		lider3.agregarEmpleado(empleado5);
		lider3.agregarEmpleado(empleado6);
		lider3.agregarEmpleado(empleado7);

		int result = 34900;
		assertEquals(result, director.calcularMontoSalarial());
	}
}
