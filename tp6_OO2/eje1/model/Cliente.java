package model;

public class Cliente {

	private Motor motor;

	public Cliente(Motor motor) {
		this.motor = motor;
	}

	public String encenderCoche() {
		return motor.arrancar();
	}

	public String acelerar() {
		return motor.acelerar() + motor.acelerar() + motor.acelerar();
	}

	public String frenarYapagar() {
		return motor.apagar();
	}
}
