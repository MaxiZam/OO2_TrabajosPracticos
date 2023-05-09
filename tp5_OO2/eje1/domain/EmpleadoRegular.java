package domain;

import java.util.List;

public class EmpleadoRegular extends Empleado {

	public EmpleadoRegular(int salario) {
		super(salario);
		// TODO Auto-generated constructor stub
	}

	protected int calcularMontoSalarial() {
		return this.salario;
	}

	public void agregarEmpleado(Empleado nuevoEmpleado) {
	}

	public void eliminarEmpleado(Empleado empleado) {
	}

	public List<Empleado> verEmpleados() {
		return null;
	}
}
