package naturaBd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



public class Conexao {

	private Connection connection;
	private final String URL = "jdbc:oracle:thin:@//localhost:1521/XEPDB1";
	private String USER = "TESTE";
	private String PASSWORD = "TESTE";

	public Connection getConnection() {
		try {
			this.connection = DriverManager.getConnection(URL, USER, PASSWORD);
		} catch (SQLException e) {
			System.out.println("erro ao se conectar");
		}
		return connection;

	}
}
