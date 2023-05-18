package main;

import java.util.List;

import model.GuardarEnTXT;
import model.ImprimirPorPantalla;
import model.Medidor;
import model.Observador;
import model.WeatherChannelService;

public class Main {

	public static void main(String[] args) {
		Medidor medidor = new Medidor(new WeatherChannelService("fc56a099767a1a9f7227758ffeb08d4a"),
				new Observador(List.of(new GuardarEnTXT("Temperatura_Dia"), new ImprimirPorPantalla())));
		medidor.leerTemperatura();
	}

}
