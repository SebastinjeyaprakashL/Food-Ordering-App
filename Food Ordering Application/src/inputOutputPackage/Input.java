package inputOutputPackage;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Input {
	public static Scanner sc = new Scanner (System.in);
	public static int getInt () {
		try {
			return sc.nextInt();
		}
		catch (InputMismatchException | NullPointerException e) {
			System.out.println("Invalid input for the current action, Please provide input in number format ");
			sc.nextLine();
			getInt();
		}
		catch (Exception e) {
			System.out.println("Something went wrong !" + e );
		}
		finally {
			sc.nextLine();
		}
		return 0;
		
		
	}

	public static String getString ()
	{
		try {
			return sc.nextLine().toUpperCase();
		}
		catch (InputMismatchException | NullPointerException e) {
			System.out.println("Invalid input for the current action, Please provide valid input ");
			getString();
		}
		catch (Exception e) {
			System.out.println("Something went wrong !" + e );
		}
		return null;
	}
	
	public static double getDouble() {
		try {

			return sc.nextDouble();
		}
		catch (InputMismatchException | NullPointerException e) {
			System.out.println("Invalid input for the current action, Please enter the valid input in number format ");
			sc.nextLine();
			getDouble();
		}
		catch (Exception e) {
			System.out.println("Something went wrong !" + e );
		}
		finally {
			sc.nextLine();
		}
		return 0;
	}

}
