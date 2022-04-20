package validation;
import java.util.regex.Matcher; 
import java.util.regex.Pattern;

class Validation {
	protected boolean isRegexPatternMatch (String regex, String stringToValidate) {
		try {
	        Pattern pattern = Pattern.compile(regex);
	        Matcher matcher = pattern.matcher(stringToValidate);
	        return( matcher.matches());
		}
		catch (Exception e) {
			System.out.println("Something went wrong! Please contact administator" + e);
		}
		return false;
	}

}
