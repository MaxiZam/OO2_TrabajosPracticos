package domain.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import domain.portsout.Notificar;
import domain.portsout.RecuperarListaEmpleados;

public class felizCumpleEmpleado {

	private List<Empleado> empleados;
	private Notificar out;
	private RecuperarListaEmpleados in;

	public felizCumpleEmpleado(RecuperarListaEmpleados in, Notificar out) {
		this.empleados = recuperarEmpleados();
		this.out = out;
	}

	public void enviarMensajeCumpleaneros() {
		LocalDate hoy = LocalDate.now();
		for (Empleado empleado : empleados) {
			if (empleado.esCumple(hoy)) {
				out.enviarMensaje("Feliz cumpleaños " + empleado.nombre() + " " + empleado.apellido()
						+ ", como regalo, la empresa le estará otorgando horas extras de trabajo, saludos cordiales :D");
			}
		}
	}

	public List<Empleado> recuperarEmpleados() {
		String[] empleados = in.devolverListaEmpleados();
		List<Empleado> listaEmpleados = new ArrayList<>();
		for (String atributos : empleados) {
			String[] empleado = atributos.split(",");
			String nombre = empleado[0];
			String apellido = empleado[1];
			LocalDate fechaNacimiento = LocalDate.parse(empleado[2]);
			String mail = empleado[4];
			Empleado nuevoEmpleado = new Empleado(nombre, apellido, fechaNacimiento, mail);
			listaEmpleados.add(nuevoEmpleado);
		}
		return listaEmpleados;
	}
}
