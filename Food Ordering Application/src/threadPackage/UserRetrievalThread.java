package threadPackage;

import customExceptionPackage.InvalidThreadException;
import dataPackage.UserAccountData;
import databasePackage.DatabaseHandler;
import inputOutputPackage.Output;

public class UserRetrievalThread implements Runnable {
	public static UserAccountData currentUser;
	private String userName, password;
	DatabaseHandler db = DatabaseHandler.getInstance();
	
	public UserRetrievalThread(String userName, String password) {
		this.userName = userName;
		this.password = password;
	} 
	

	@Override
	public void run() {
		try {
			currentUser = db.getUser(userName, password);
		} catch (InvalidThreadException e) {
			Output.printInConsole(e + "");
		}
	}

}
