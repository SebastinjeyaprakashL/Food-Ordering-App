package foodOrder;

import java.util.ArrayList;

import consoleInputOutput.UserInputs;
import consoleInputOutput.UserOutput;

public class HotelHandler {
	public void addHotel (int hotelId, String hotelName) {
		Hotel newHotel = new Hotel(hotelId, hotelName);
	}
	
	public Hotel chooseHotelToOrder () {
		ArrayList <Hotel> hotelList = getAvailableHotel();
		Hotel choosenHotel = null;
		do {
				
				UserOutput.consoleStringPrinter("Enter the hotel name, from where you wish to order : ");
				for(Hotel hotel : hotelList) {
					UserOutput.consoleStringPrinter(hotel.hotelName);
				}
				String choosenHotelName = UserInputs.getStringUserInput();
				for (Hotel hotel : hotelList) {
					if(hotel.hotelName.equalsIgnoreCase(choosenHotelName)) {
						choosenHotel = hotel;
					}
				}
				if(choosenHotel == null) {
					UserOutput.consoleStringPrinter("Please enter correct hotel name !");
				}
		}while (choosenHotel == null);
		return choosenHotel;
	}
	
	public ArrayList<Hotel> getAvailableHotel() {
		return Hotel.hotels;
	}
}
