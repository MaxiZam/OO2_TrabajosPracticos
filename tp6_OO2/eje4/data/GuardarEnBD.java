package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.Guardar;
import okhttp3.Response;

public class GuardarEnBD implements Guardar {

	private Connection dbConn;
	private Guardar guardar;

	public GuardarEnBD(String url, String user, String password) {
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

	public GuardarEnBD(String url, String user, String password, Guardar guardar) {
		this(url, user, password);
		this.guardar = guardar;
	}

	@Override
	public void guardarItems(Response item) {
		PreparedStatement st;
		try {
			st = dbConn.prepareStatement("INSERT into item(contenido) values(?)");
			st.setString(1, item.toString());
			st.executeUpdate();
			st.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (guardar != null)
			guardar.guardarItems(item);
	}

}
