package handlerPackage;

import java.util.ArrayList;
import inputOutputPackage.Input;
import inputOutputPackage.Output;
import dataPackage.HotelData;
import databasePackage.DatabaseHandler;
import interfacePackage.HotelControllerInterface;

public class HotelHandler implements HotelControllerInterface {
	public DatabaseHandler db = DatabaseHandler.getInstance();
	
	@Override
	public void addHotel (int hotelId, String hotelName) {
		try {
			HotelData newHotel = new HotelData();
			newHotel.hotelId = hotelId;
			newHotel.hotelName = hotelName;
			db.addHotel(newHotel);
		}
		catch (Exception e) {
			Output.printInConsole("Something went wrong! Unable to add new Hotel. Please contact admin \n" + e );
		}		
	}

	@Override
	public ArrayList<HotelData> getHotels() {
		return db.getHotels();
	}
	
	@Override
	public HotelData chooseHotelToOrder () {
		try {
			ArrayList <HotelData> hotelList = db.getHotels();
			HotelData chosenHotel = null;
			do {					
				Output.printInConsole("Enter the hotel name, from where you wish to order : ");
				for(HotelData hotel : hotelList) {
					Output.printInConsole(hotel.hotelName);
				}
				String chosenHotelName = Input.getString();
				for (HotelData hotel : hotelList) {
					if(hotel.hotelName.equalsIgnoreCase(chosenHotelName)) {
						chosenHotel = hotel;
					}
				}
				if(chosenHotel == null) {
					Output.printInConsole("Please enter correct hotel name !");
				}
			}while (chosenHotel == null);
			return chosenHotel;
		}
		catch (Exception e) {
			Output.printInConsole("Problem in fetching available hotels ! Please try again later \n" + e);
		}
		return null;		
	}	
}
