package threadPackage;

import customExceptionPackage.InvalidThreadException;
import dataPackage.UserAccountData;
import databasePackage.DatabaseHandler;
import inputOutputPackage.Output;

public class UserInsertionThread implements Runnable{
	private UserAccountData userData ;
	DatabaseHandler db = DatabaseHandler.getInstance();
	
	public UserInsertionThread (UserAccountData newUser){
		this.userData = newUser;
	}

	@Override
	public void run() {
		try {
			db.addUserAccount(userData);
		} catch (InvalidThreadException e) {
			Output.printInConsole(e + "");
		}	
	}

}
