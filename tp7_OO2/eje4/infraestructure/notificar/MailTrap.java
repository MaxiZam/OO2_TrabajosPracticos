package infraestructure.notificar;

import java.util.Properties;

import domain.model.Observador;
import jakarta.mail.Message;
import jakarta.mail.MessagingException;
import jakarta.mail.PasswordAuthentication;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;

public class MailTrap extends Observador {

	private String user;
	private String password;
	private String asunto;

	public MailTrap(String user, String password) {
		super(null);
		this.user = user;
		this.password = password;
	}

	public void actualizar(String nombre, String mail, String region) {
		// provide recipient's email ID
		// provide sender's email ID
		String destinatario = mail;
		String mensaje = "Te haz unido exitosamente como participante..";
		String from = "jakartafrom@example.com";
		// provide Mailtrap's username = "0629ca38e50b34"
		final String username = this.user;
		// provide Mailtrap's password = "280a680c090589"
		final String password = this.password;
		// provide Mailtrap's host address
		String host = "smtp.mailtrap.io";
		// configure Mailtrap's SMTP server details
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", host);
		props.put("mail.smtp.port", "587");
		// create the Session object
		Session session = Session.getInstance(props, new jakarta.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});
		try {
			// create a MimeMessage object
			Message message = new MimeMessage(session);
			// set From email field
			message.setFrom(new InternetAddress(from));
			// set To email field
			message.setRecipient(Message.RecipientType.TO, new InternetAddress(destinatario));
			// set email subject field
			message.setSubject(asunto);
			// set the content of the email message
			message.setText(mensaje);
			// send the email message
			Transport.send(message);
			System.out.println("Email Message Sent Successfully");
		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}
}
