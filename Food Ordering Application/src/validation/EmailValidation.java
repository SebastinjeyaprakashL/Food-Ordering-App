package validation;

public class EmailValidation extends Validation {
	public boolean emailValidation( String email) {
		try {
		String regex = "^[A-Za-z0-9+_.-]+@(.+)$"; 
		return (isRegexPatternMatch(regex, email));
		}
		catch (Exception e) {
			System.out.println("Something went wrong ! Please contact administrator");
		}
		return false;
	}
}
