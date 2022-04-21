package databasePackage;

import inputOutputPackage.Output;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnect {

	private static final DbConnect db = new DbConnect();
	private Connection connection = null;
	
	private DbConnect() {
			try {
				String url = "jdbc:mysql://localhost:3306/Console Application";
				String user = "root";
				String password = "root";
				Class.forName("com.mysql.cj.jdbc.Driver");
				connection = DriverManager.getConnection(url, user, password);

			} catch (ClassNotFoundException | SQLException e) {
				Output.printInConsole("Unable to connect database ! " + e);
			}
	}
	
	public static Connection getConnection() {
		return db.connection;
	}
}