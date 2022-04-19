package consoleInputOutput;

import java.util.Scanner;


public class Input {
	public static Scanner sc = new Scanner (System.in);
	public static int getInt () {
		try {
			return sc.nextInt();
		}
		catch (Exception e) {
			System.out.println("Invalid input for the current action ");
			getInt();
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
		catch (Exception e) {
			System.out.println("Invalid input for the current action ");
			getString();
		}
		return null;
	}
	

	public static double getDouble() {
		try {
			 
			return sc.nextDouble();
		}
		catch (Exception e) {
			System.out.println("Invalid input. Please give number values.");
			getDouble();
		}
		finally {
			sc.nextLine();
		}
		return 0;
	}
}