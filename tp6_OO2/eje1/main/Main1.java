package main;

import model.Adaptador;
import model.Cliente;
import model.MotorEconomico;
import model.MotorElectronico;

public class Main1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Cliente cliente = new Cliente(new MotorEconomico());
		Cliente cliente2 = new Cliente(new Adaptador(new MotorElectronico()));

		String progreso1 = cliente.encenderCoche() + cliente.acelerar() + cliente.frenarYapagar();
		String progreso2 = cliente2.encenderCoche() + cliente2.acelerar() + cliente2.frenarYapagar();

		System.out.println(progreso1);
		System.out.println(progreso2);
	}

}
