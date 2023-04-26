package infraestructure.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import domain.portsout.RepositorioParticipantes;

public class BaseDeDatos implements RepositorioParticipantes {

	private Connection dbConn;

	public BaseDeDatos(String url, String user, String password) throws SQLException {
		this.dbConn = DriverManager.getConnection(url, user, password);
	}

	public void setupBaseDeDatos() throws SQLException {
		String url = "jdbc:derby://localhost:1527/participantes";
		String user = "app";
		String password = "app";
		this.dbConn = DriverManager.getConnection(url, user, password);
	}

	public void guardarParticipante(String nombre, String telefono, String region) throws SQLException {
		PreparedStatement st = dbConn
				.prepareStatement("INSERT into participantes(nombre, telefono, region) values(?,?,?)");
		try {
			st.setString(1, nombre);
			st.setString(2, telefono);
			st.setString(3, region);
			st.executeUpdate();
		} finally {
			st.close();
		}
	}

	@Override
	public String[] recuperarParticipantes() {
		String[] participantes = null;
		try (java.sql.Statement sent = dbConn.createStatement();
				ResultSet resul = sent.executeQuery("SELECT nombre, telefono, region FROM participantes")) {
			while (resul.next()) {
				participantes[0] = resul.getString("nombre");
				participantes[1] = resul.getString("telefono");
				participantes[2] = resul.getString("region");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return participantes;
	}

}
