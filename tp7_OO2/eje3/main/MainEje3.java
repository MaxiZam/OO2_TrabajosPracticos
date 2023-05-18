package main;

import model.GuardarEnTXT3;
import model.ImprimirPorPantalla3;
import model.MedidorEje3;
import model.WeatherChannelServicio;

public class MainEje3 {

	public static void main(String[] args) {
		MedidorEje3 medidor = new MedidorEje3(new WeatherChannelServicio("fc56a099767a1a9f7227758ffeb08d4a"),
				(new GuardarEnTXT3("Temperatura_Dia", new ImprimirPorPantalla3())));
		medidor.leerTemperatura();
	}

}
