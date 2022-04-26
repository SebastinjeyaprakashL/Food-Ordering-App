package threadPackage;

import java.sql.Connection;

import customExceptionPackage.InvalidThreadException;
import databasePackage.DatabaseHelper;
import databasePackage.DbConnect;
import inputOutputPackage.Output;

public class DbInitializerThread implements Runnable {
	private final Connection dbConnection = DbConnect.getConnection();
	
	@Override
	public void run(){
		try {
			if (! Thread.currentThread().getName().equalsIgnoreCase("main")) {
				DatabaseHelper dbInitializer = new DatabaseHelper();
				dbInitializer.createDbIfNotExists(dbConnection);
			}
			else {
				throw new InvalidThreadException ();
			}
		}
		catch (Exception e) {
			Output.printInConsole("Error occurred while checking for database existence" + e);
		}
		
	}
}