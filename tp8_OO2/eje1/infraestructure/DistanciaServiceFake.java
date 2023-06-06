package infraestructure;

public class DistanciaServiceFake implements ServicioDistancia {

	private int distancia;

	public DistanciaServiceFake(int distancia) {
		this.distancia = distancia;
	}

	public int obtenerDistancia(String direccion, String destino) {
		return this.distancia;
	}
}
