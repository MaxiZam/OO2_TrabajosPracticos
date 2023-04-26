package infraestructure.notification;

import domain.portsout.Notificar;

public class NotificarFacke implements Notificar {

	@Override
	public void enviarMensaje(String destinatario, String mensaje) {
		System.out.println(destinatario+" -> "+mensaje);
	}

}
