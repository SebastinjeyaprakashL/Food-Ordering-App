package handlerPackage;

import java.util.ArrayList;
import inputOutputPackage.Input;
import inputOutputPackage.Output;
import dataPackage.HotelData;
import interfacePackage.HotelControllerInterface;
import threadPackage.HotelInsertionThread;
import threadPackage.HotelRetrievalThread;

public class HotelHandler implements HotelControllerInterface {
	
	@Override
	public void addHotel (int hotelId, String hotelName) {
		try {
			HotelData newHotel = new HotelData();
			newHotel.hotelId = hotelId;
			newHotel.hotelName = hotelName;
			
			Runnable hotelData = new HotelInsertionThread(newHotel);
			Thread hotelInsertionThread = new Thread(hotelData);
			hotelInsertionThread.start();
		}
		catch (Exception e) {
			Output.printInConsole("Something went wrong! Unable to add new Hotel. Please contact admin \n" + e );
		}		
	}

	@Override
	public ArrayList<HotelData> getHotels() {
		try {
			Runnable hotelList = new HotelRetrievalThread();
			Thread hotelRetrievalThread = new Thread(hotelList);
			hotelRetrievalThread.start();
			hotelRetrievalThread.join();
			return HotelRetrievalThread.hotelList;
		}
		catch (Exception e) {
			Output.printInConsole("Error occurred while fetching available hotels");
		}
		return null;		
	}
	
	@Override
	public HotelData chooseHotelToOrder () {
		try {
			ArrayList <HotelData> hotelList = getHotels();
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
