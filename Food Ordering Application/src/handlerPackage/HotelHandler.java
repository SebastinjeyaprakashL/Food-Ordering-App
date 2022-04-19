package handlerPackage;

import java.util.ArrayList;

import consoleInputOutput.Input;
import consoleInputOutput.Output;
import dataPackage.HotelData;

public class HotelHandler {
	public void addHotel (int hotelId, String hotelName) {
		try {
			new HotelData(hotelId, hotelName);
		}
		catch (Exception e) {
		e.printStackTrace();	
		}
		
	}
	
	public HotelData chooseHotelToOrder () {
		try {
			ArrayList <HotelData> hotelList = getAvailableHotel();
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
			e.printStackTrace();
		}
		return null;
		
	}
	
	public ArrayList<HotelData> getAvailableHotel() {
		return HotelData.hotels;
	}
}
