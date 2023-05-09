package domain;

public class Tarea extends Item {

	public Tarea(int tiempo_horas) {
		super(tiempo_horas);
		// TODO Auto-generated constructor stub
	}

	public int calcularTiempo() {
		return this.tiempo_horas;
	}
}
