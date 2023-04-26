package test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

import domain.model.EnviarMensajeCumple;
import domain.portsout.RecuperarListaEmpleados;
import domain.portsout.Notificar;
import infraestructure.data.ArchivoTXT;
import infraestructure.notification.*;

public class TestMailFelizCumple {
	@Test
	public void testFelizCumpleEmpleado() {
		RecuperarListaEmpleados archivo = new ArchivoTXT("Empleados");
		Notificar notificar = new MailTrap();
		EnviarMensajeCumple cumple = new EnviarMensajeCumple(archivo, notificar);
		
		int result = 3;
		
		assertEquals(result, cumple.enviarMensajeCumpleaneros("2023-12-31"));
	}
}
