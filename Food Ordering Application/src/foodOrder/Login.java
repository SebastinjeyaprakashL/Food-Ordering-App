package foodOrder;

import consoleInputOutput.UserInputs;
import consoleInputOutput.UserOutput;

public class Login {
	public String username;
	public String password;
	public UserAccount currentUser;
	public UserAccount loginMenu() {
		try {
			do {
				UserOutput.consoleStringPrinter("Welcome To Food Ordering Console App");
				UserOutput.consoleStringPrinter("\nEnter your email to login :");
				username = UserInputs.getStringUserInput();
				UserOutput.consoleStringPrinter("\nEnter your password :");
				password = UserInputs.getStringUserInput();
				currentUser = verifyUser(username, password);
				if (currentUser == null) {
					UserOutput.consoleStringPrinter("Incorrect Username / Password ! Please try again");
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
			AccountController accountHandler = new UserAccount();
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
