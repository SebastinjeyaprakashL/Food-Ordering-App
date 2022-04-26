package customExceptionPackage;

public class InvalidThreadException extends Exception {
	public InvalidThreadException() {
		super("Should not access database with main thread");
	}

}
