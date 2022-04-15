package foodOrder;

import java.util.ArrayList;

import consoleInputOutput.UserInputs;
import consoleInputOutput.UserOutput;

public class HotelHandler {
	public void addHotel (int hotelId, String hotelName) {
		try {
			Hotel newHotel = new Hotel(hotelId, hotelName);
		}
		catch (Exception e) {
		e.printStackTrace();	
		}
		
	}
	
	public Hotel chooseHotelToOrder () {
		try {
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
		catch (Exception e) {
			e.printStackTrace();
		}
		return null;
		
	}
	
	public ArrayList<Hotel> getAvailableHotel() {
		return Hotel.hotels;
	}
}
