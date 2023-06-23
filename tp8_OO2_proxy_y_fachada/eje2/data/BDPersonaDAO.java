package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

import domain.Persona;
import domain.PersonaDAO;
import domain.Telefono;

public class BDPersonaDAO implements PersonaDAO {

	private String url;
	private String user;
	private String password;

	private Connection conexión;

	public BDPersonaDAO(String url, String usuario, String contrasena) {
		this.url = url;
		this.user = usuario;
		this.password = contrasena;
	}

	private Connection obtenerConexion() {
		try {
			return conexión = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

//	public void cerrarConexion() {
//		try {
//			if (conexión != null && !conexión.isClosed()) {
//				conexión.close();
//				System.out.println("Conexión cerrada");
//			}
//		} catch (SQLException e) {
//			System.err.println("Error al cerrar la conexión: " + e.getMessage());
//		}
//	}

	public Persona personaPorId(int id) {
		String sql = "select p.nombre,t.numero " + "from persona p, telefono t "
				+ "where p.id_persona = t.id_persona and p.id = ?";
		try (Connection conn = obtenerConexion(); PreparedStatement statement = conn.prepareStatement(sql);) {
			statement.setInt(1, id);
			ResultSet result = statement.executeQuery();
			Set<Telefono> telefonos = new HashSet<Telefono>();
			String nombrePersona = null;
			while (result.next()) {
				nombrePersona = result.getString(1);
				telefonos.add(new Telefono(result.getString(2)));
			}
			conexión.close();
			return new Persona(id, nombrePersona, telefonos);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
