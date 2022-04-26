package threadPackage;

import customExceptionPackage.InvalidThreadException;
import dataPackage.HotelMenuData;
import databasePackage.DatabaseHandler;
import inputOutputPackage.Output;

public class MenuInsertionThread implements Runnable {
	private HotelMenuData newMenu;
	DatabaseHandler db = DatabaseHandler.getInstance();
	
	public MenuInsertionThread (HotelMenuData newMenu) {
		this.newMenu = newMenu;
	}

	@Override
	public void run() {
		try {
			db.addHotelMenu(newMenu);
		} catch (InvalidThreadException e) {
			Output.printInConsole(e + "");
		}
	}

}
