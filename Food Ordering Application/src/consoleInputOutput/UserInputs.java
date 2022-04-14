package consoleInputOutput;

import java.util.Scanner;

public class UserInputs {
	public static Scanner sc = new Scanner (System.in);
	public static int getIntUserInput () {
		try {
			int input = sc.nextInt();
			return input;
		}
		catch (Exception e) {
			System.out.println("Invalid input for the current action ");
			return 0;
		}
		finally {
			sc.nextLine();
		}
		
		
	}
	public static float getFloatUserInput () {
		try {
			float input = sc.nextFloat();
			return input;
		}
		catch (Exception e) {
			System.out.println("Invalid input for the current action ");
			return 0;
		}
		finally {
			sc.nextLine();
		}
		
		
	}
	public static String getStringUserInput ()
	{
		try {
			String input = sc.nextLine().toUpperCase();
			return input;
		}
		catch (Exception e) {
			System.out.println("Invalid input for the current action ");;
			return null;
		}
	}
	
	public static long getLongUserInput ()
	{
		try {
			long input = sc.nextLong();
			return input;
		}
		catch (Exception e) {
			System.out.println("Invalid input for the current action ");
			return 0;
		}	
		finally {
			sc.nextLine();
		}
	}
	public static double getDoubleUserInput() {
		try {
			double input = sc.nextDouble();
			return input;
		}
		catch (Exception e) {
			System.out.println("Invalid input for the current action ");
			return 0;
		}
		finally {
			sc.nextLine();
		}
	}
}
