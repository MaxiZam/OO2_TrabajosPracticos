package infraestructure.data;

import java.sql.DriverManager;
import java.sql.SQLException;

public class BaseDeDatos {

	 
	 private void setupBaseDeDatos(String url, String user, String password) throws SQLException {
		 String url = "jdbc:derby://localhost:1527/participantes";
		 String user = "app";
		 String password = "app";
		 /*this.dbConn =*/DriverManager.getConnection(url, user, password);
	 }
	 
}
