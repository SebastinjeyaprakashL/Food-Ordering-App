package validation;

public class PasswordValidation extends Validation {
	public boolean passwordValidation(String password) {
		try {
			if (password.length() >= 8) {
				String regex = "^(?=.*[0-9])"
	                       + "(?=.*[a-zA-Z])"
	                       + "(?=.*[@#$%^&+=])"
	                       + "(?=\\S+$).{8,20}$";
				return isRegexPatternMatch(regex,password);
			}
		}
		catch (Exception e) {
			System.out.println("Something went wrong!" + e);
		}
		return false;
	}
}
