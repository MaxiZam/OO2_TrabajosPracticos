package domain;

import java.util.ArrayList;
import java.util.List;

public abstract class Empleado {

	protected int salario;
	protected List<Empleado> empleados;

	public Empleado(int salario) {
		this.salario = salario;
		this.empleados = new ArrayList<>();
	}

	protected int calcularMontoSalarial() {
		int monto = this.salario;
		for (Empleado empleado : empleados) {
			monto += empleado.calcularMontoSalarial();
		}
		return monto;
	}

	public void agregarEmpleado(Empleado nuevoEmpleado) {
		empleados.add(nuevoEmpleado);
	}

	public void eliminarEmpleado(Empleado empleado) {
		empleados.remove(empleado);
	}

	public List<Empleado> verEmpleados() {
		return empleados;
	}
}
