package threadPackage;

import java.util.ArrayList;

import customExceptionPackage.InvalidThreadException;
import dataPackage.HotelData;
import databasePackage.DatabaseHandler;
import inputOutputPackage.Output;

public class HotelRetrievalThread implements Runnable {
	public static ArrayList <HotelData> hotelList = new ArrayList<>();
	DatabaseHandler db = DatabaseHandler.getInstance();
	
	@Override
	public void run() {
		try {
			hotelList = db.getHotels();
		} catch (InvalidThreadException e) {
			Output.printInConsole(e + "");
		}
	}
	

}
