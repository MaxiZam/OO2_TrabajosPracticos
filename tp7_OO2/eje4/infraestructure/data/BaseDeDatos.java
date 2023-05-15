package infraestructure.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import domain.portsout.GuardarParticipantes;
import domain.portsout.ObtenerParticipantes;
import domain.portsout.ParticipanteRecord;

public class BaseDeDatos implements GuardarParticipantes, ObtenerParticipantes {

	private Connection dbConn;

	public BaseDeDatos(String url, String user, String password) {
		try {
			this.dbConn = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			Class.forName("org.apache.derby.jdbc.ClientDriver");
		} catch (ClassNotFoundException e) {
			System.out.println("No se encontró el driver de Derby.");
			e.printStackTrace();
		}
	}

	public void setupBaseDeDatos() throws SQLException {
		String url = "jdbc:derby://localhost:1527/participantes";
		String user = "app";
		String password = "app";
		this.dbConn = DriverManager.getConnection(url, user, password);
	}

	public void guardarParticipante(ParticipanteRecord participante) throws SQLException {
		PreparedStatement st = dbConn
				.prepareStatement("INSERT into participantes(nombre, telefono, region) values(?,?,?)");
		st.setString(1, participante.nombre());
		st.setString(2, participante.telefono());
		st.setString(3, participante.region());
		st.executeUpdate();
		st.close();
	}

	@Override
	public List<ParticipanteRecord> recuperarParticipantes() {
		List<ParticipanteRecord> participantes = new ArrayList<>();
		try (java.sql.Statement sent = dbConn.createStatement();
				ResultSet resul = sent.executeQuery("SELECT nombre, telefono, region FROM participantes")) {
			while (resul.next()) {
				participantes.add(new ParticipanteRecord(resul.getString("nombre"), resul.getString("telefono"),
						resul.getString("region")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return participantes;
	}
}
