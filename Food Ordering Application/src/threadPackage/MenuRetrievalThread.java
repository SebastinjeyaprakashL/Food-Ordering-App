package threadPackage;

import java.util.ArrayList;

import customExceptionPackage.InvalidThreadException;
import dataPackage.HotelMenuData;
import databasePackage.DatabaseHandler;
import inputOutputPackage.Output;

public class MenuRetrievalThread implements Runnable {
	public static ArrayList <HotelMenuData> menuList = new ArrayList<>();
	private int hotelId;
	DatabaseHandler db = DatabaseHandler.getInstance();
	
	public MenuRetrievalThread (int hotelId) {
		this.hotelId = hotelId;
	}

	public MenuRetrievalThread() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void run() {
		try {
			menuList = db.getMenuList(hotelId);
		} catch (InvalidThreadException e) {
			Output.printInConsole(e + "");
		}
		
	}

}
