package threadPackage;

import customExceptionPackage.InvalidThreadException;
import dataPackage.HotelData;
import databasePackage.DatabaseHandler;
import inputOutputPackage.Output;

public class HotelInsertionThread implements Runnable{
	private HotelData newHotel;
	DatabaseHandler db = DatabaseHandler.getInstance();
	
	public HotelInsertionThread (HotelData newHotel) {
		this.newHotel = newHotel;
	}

	@Override
	public void run() {
		try {
			db.addHotel(newHotel);
		} catch (InvalidThreadException e) {
			Output.printInConsole(e + "");
		}
	}

}
