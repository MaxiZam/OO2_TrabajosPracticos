package modelo;

public class Notificar_Fake implements Notificar{

	@Override
	public void enviarMensaje(String destinatario) {
		
		System.out.println("destinatario: "+destinatario);
	}

	
}
