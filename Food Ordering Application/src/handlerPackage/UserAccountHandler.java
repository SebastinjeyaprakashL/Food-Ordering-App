package handlerPackage;

import inputOutputPackage.Output;
import dataPackage.UserAccountData;
import databasePackage.DatabaseHandler;
import interfacePackage.AccountControllerInterface;
import validation.EmailValidation;
import validation.PasswordValidation;

public class UserAccountHandler implements AccountControllerInterface {
	public DatabaseHandler db = DatabaseHandler.getInstance();
	
	@Override
	public void addUser (String name, String email, String mobileNumber, String password) {
		try {
			UserAccountData newUser = new UserAccountData();
			newUser.setName(name);
			EmailValidation validateEmail = new EmailValidation();
			if (validateEmail.emailValidation(email)) {
				newUser.setEmail(email);
			}
			else {
				Output.printInConsole("Given email is invalid! Please enter valid email."
						+ "Account creation failed for user : "+name);
				return;
			}
			newUser.setMobileNum(mobileNumber);
			PasswordValidation validatePassword = new PasswordValidation();
			if (validatePassword.passwordValidation(password)) {
				newUser.setPassword(password);
			}
			else {
				Output.printInConsole("Entered password is Invalid! Please make sure your password meets all the following criteria "
						+ "\nNOTE : "
						+ "\n1. Password length must be greater than 8  "
						+ "\n2. Password must contain at-least one alphabet"
						+ "\n3. Password must contain at-least one number"
						+ "\n4. Password must contain at-least one special character"
						+ "\nAccount creation failed for user : "+name);
				return;
			}
			
			db.addUserAccount(newUser);
		}
		catch (Exception e) {
			Output.printInConsole("Something went wrong! Unable to create user account! Please try again later" + e);
		}
		
	}
	
	@Override
	public UserAccountData getCurrentUser(String username, String password) {
		try {
			return db.getUser(username, password);
		}
		catch (Exception e) {
			Output.printInConsole("Unable to verify user. Login failed ! Try again later" + e);
		}
		return null;
	}
	
	
}
