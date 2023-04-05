package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ArchivarBD implements GuardarTexto {

	String database_url;
	String database_usuario;
	String database_contraseña;

	public ArchivarBD(String database_url, String database_usuario, String database_contraseña) {
		this.database_url = database_url;
		this.database_usuario = database_usuario;
		this.database_contraseña = database_contraseña;
	}
	
	@Override
	public void guardarTexto(String texto) {
		try (Connection miConexion = DriverManager.getConnection(database_url, database_usuario, database_contraseña);
				java.sql.PreparedStatement state = miConexion
						.prepareStatement("INSERT INTO fichero (texto) VALUES (?)")) {

			state.setString(1, texto);

			state.executeUpdate();

		} catch (SQLException e) {
			e.getMessage();
		}
	}
}
