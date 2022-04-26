package threadPackage;

import java.sql.Connection;

import databasePackage.DatabaseHelper;
import databasePackage.DbConnect;

public class DbInitializerThread implements Runnable {
	private final Connection dbConnection = DbConnect.getConnection();
	
	@Override
	public void run(){
		DatabaseHelper dbInitializer = new DatabaseHelper();
		dbInitializer.createDbIfNotExists(dbConnection);
	}
}