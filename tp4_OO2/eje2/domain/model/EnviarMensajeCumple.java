package domain.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import domain.portsout.EmpleadoRecord;
import domain.portsout.Notificar;
import domain.portsout.RecuperarListaEmpleados;

public class EnviarMensajeCumple {

	private List<Empleado> empleados;
	private Notificar out;
	private RecuperarListaEmpleados in;

	public EnviarMensajeCumple(RecuperarListaEmpleados in, Notificar out) {
		this.out = out;
		this.in = in;
	}

	public int enviarMensajeCumpleaneros(String fecha) {
		int contCumpleaneros = 0;
		recuperarEmpleados();
		LocalDate dia = LocalDate.parse(fecha);
		for (Empleado empleado : empleados) {
			if (empleado.esCumple(dia)) {
				out.enviarMensaje(empleado.mail(),"Feliz cumpleaños " + empleado.nombre() + " " + empleado.apellido()
						+ ", como regalo, la empresa le estará otorgando horas extras de trabajo, saludos cordiales :D");
				contCumpleaneros++;
			}
		}
		return contCumpleaneros;
	}

	private void recuperarEmpleados() {
		List<EmpleadoRecord> empleados = in.devolverListaEmpleados();
		List<Empleado> listaEmpleados = new ArrayList<>();
		for (EmpleadoRecord empleado : empleados) {
			Empleado nuevoEmpleado = new Empleado(empleado.apellido(), empleado.nombre(), empleado.fechaNac(), empleado.mail());
			listaEmpleados.add(nuevoEmpleado);
		}
		this.empleados = listaEmpleados;
	}
}
