package foodOrder;

import java.util.ArrayList;

import consoleInputOutput.UserInputs;
import consoleInputOutput.UserOutput;

public class Login {
	public String username;
	public String password;
	public UserAccount currentUser;
	public ArrayList <UserAccount> userAccounts ;
	public UserAccount loginMenu() {
		do {
				UserOutput.consoleStringPrinter("Enter your email");
				username = UserInputs.getStringUserInput();
				UserOutput.consoleStringPrinter("Enter your password :");
				password = UserInputs.getStringUserInput();
				currentUser = verifyUser(username, password);
				if (currentUser == null) {
					UserOutput.consoleStringPrinter("Incorrect Username / Password ! Please try again");
				}
		}while (currentUser == null);
		return currentUser;
	}
	
	public UserAccount verifyUser(String username, String password) {
		AccountController accountHandler = new UserAccount();
		for(UserAccount account : accountHandler.getUserAccounts()) {
			if(account.getEmail().equalsIgnoreCase(username) && account.getPassword().equalsIgnoreCase(password)) {
				return account;
			}
		}
		return null;
	}
	
}
