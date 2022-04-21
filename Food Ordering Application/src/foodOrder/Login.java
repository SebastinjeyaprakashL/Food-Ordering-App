package foodOrder;

import inputOutputPackage.Input;
import inputOutputPackage.Output;
import dataPackage.UserAccountData;
import handlerPackage.UserAccountHandler;
import interfacePackage.AccountControllerInterface;

public class Login {
	
	public UserAccountData loginMenu() {
		String username;
		String password;
		UserAccountData currentUser = null;
		try {
			do {			
				Output.printInConsole("\nEnter your email to login :");
				username = Input.getString();
				Output.printInConsole("\nEnter your password :");
				password = Input.getString();
				AccountControllerInterface accountHandler = new UserAccountHandler();
				currentUser = accountHandler.getCurrentUser(username, password);
				if (currentUser == null) {
					Output.printInConsole("Incorrect Username / Password ! Please try again");
				}
			}while (currentUser == null);
		}
		catch (Exception e) {
			Output.printInConsole("Unable to login ! Please try again later "+ e);
		}
		return currentUser;		
	}	
}
