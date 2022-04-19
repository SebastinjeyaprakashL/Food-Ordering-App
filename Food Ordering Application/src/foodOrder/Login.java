package foodOrder;

import consoleInputOutput.Input;
import consoleInputOutput.Output;
import interfacePackage.AccountControllerInterface;

public class Login {
	public String username;
	public String password;
	public UserAccount currentUser;
	public UserAccount loginMenu() {
		try {
			do {
				Output.printInConsole("Welcome To Food Ordering Console App");
				Output.printInConsole("\nEnter your email to login :");
				username = Input.getString();
				Output.printInConsole("\nEnter your password :");
				password = Input.getString();
				currentUser = verifyUser(username, password);
				if (currentUser == null) {
					Output.printInConsole("Incorrect Username / Password ! Please try again");
				}
			}while (currentUser == null);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return currentUser;
		
	}
	
	public UserAccount verifyUser(String username, String password) {
		try {
			AccountControllerInterface accountHandler = new UserAccount();
			for(UserAccount account : accountHandler.getUserAccounts()) {
				if(account.getEmail().equalsIgnoreCase(username) && account.getPassword().equalsIgnoreCase(password)) {
					return account;
				}
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
